package servet;

import JSP.BasketList;
import bd.OrderEntity;
import bd.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tttt on 20.11.2016.
 */
@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String userName = request.getUserPrincipal().getName();
//        PurchaseList purchasesList = (PurchaseList)session.getAttribute("purchases");
//        String purchases = DataTools.ConvertPurchaseListToString(purchasesList);
        OrderEntity order;
        HashMap<String,Integer> list = (HashMap<String, Integer>) BasketList.getBasketList();
        String purchases="";
        for (Map.Entry entry : list.entrySet()) {
            purchases=purchases+entry.getKey()+"-"+entry.getValue()+";";
        }
        String withCurier = request.getParameter("type-choice");
        if(withCurier!=null && withCurier.equals("on")){
            String addressee = request.getParameter("addressee");
            String add="";
          for(int i = 0;i<addressee.length();i++ )
          {
              if(addressee.codePointAt(i)>207&&addressee.codePointAt(i)<210)
              {
                  int cod=0;
                  if(addressee.codePointAt(i)==208)
                  {
                      cod= addressee.codePointAt(i)*1000+addressee.codePointAt(i+1)-207104;
                  }
                  if(addressee.codePointAt(i)==209)
                  {
                      cod= addressee.codePointAt(i)*1000+addressee.codePointAt(i+1)-208040;
                  }
                  add=add+getSt(cod-1040);
                  i++;
              }
              else
              {
                  add=add+addressee.substring(i,i+1);
              }
          }
            order = new OrderEntity(userName,purchases,(byte)1,add);
        } else {
            int shopId = Integer.parseInt(request.getParameter("shop-choice"));
            order = new OrderEntity(userName,purchases,(byte)0,shopId);
        }

        OrderService.saveOrder(order);

        BasketList.clearBasket();
        String path = "/success.jsp";
        getServletContext().getRequestDispatcher(path).forward(request,response);

    }

    private String getSt(int ind)
    {
        String txt = "АБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдежзийклмнопрстуфхцчшщъыьэюя";
        return txt.substring(ind,ind+1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
