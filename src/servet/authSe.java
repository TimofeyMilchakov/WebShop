package servet;

import JSP.NewBean;
import bd.MyArr;
import bd.OrderEntity;
import bd.OrderService;
import bd.Shit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tttt on 15.11.2016.
 */
@WebServlet(name = "authSe")
public class authSe extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.addCookie(new Cookie("land",request.getParameter("lang")));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        String parameter = getInitParameter("SelectedPage");
        session.setAttribute("choice",parameter);

        String page = request.getParameter("page");
        response.addCookie(new Cookie("land",request.getParameter("lang")));
        try{
            String user = request.getUserPrincipal().getName();
            session.setAttribute("user",user);
        }
        catch (Exception ex){}
        if(page.equals(null))
        {
            page="initial";
        }

        ArrayList<OrderEntity> orders = OrderService.getUserAllPurchases((String)session.getAttribute("user"));
        ArrayList<MyArr> arr = new ArrayList<>();
//        for (OrderEntity order: orders)
//        {
//            arr.add(returnArr(order.getPurchases(),order.getOrderDate(),order.getCurier()));
//            order.setArr(arr);
//        }
        session.setAttribute("orders",orders);
        response.sendRedirect(page+".jsp?lang="+request.getParameter("lang"));

    }

    private MyArr returnArr(String s,String d,Byte c)
    {
        MyArr arr = new MyArr();
        if(s.length()==0)
        {
            return null;
        }
        int k=0;
        for(int i=0; i<s.length();i++)
        {
            String val = s.substring(i,i+1);
            if(val.equals("-"))
            {
               for (int j=i+1;j<s.length();j++)
               {
                   String val2=s.substring(j,j+1);
                   if(val2.equals(";"))
                   {
                       arr.addShit(new Shit(s.substring(k,i),Integer.parseInt(s.substring(i+1,j))));
                       k=j+1;
                       break;
                   }
               }
            }
        }
        return arr;
    }


}
