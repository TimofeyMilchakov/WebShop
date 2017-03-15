/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servet;

import JSP.BasketList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tttt
 */
public class BasketServlet extends HttpServlet {

     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        BasketList bean = BasketList.get(session);
        String value = request.getParameter("id");
        String lang = request.getParameter("lang");
        String page = request.getParameter("page");
         if(lang!=null) {
             response.addCookie(new Cookie("lang", lang));
         }
         else
         {
             Cookie[] cookie = request.getCookies();
             for(Cookie c:cookie)
             {
                 if(c.getName().equals("lang"))
                 {
                     lang=c.getValue();
                 }
             }
         }
        if (value == null) 
        {
            value = request.getParameter("idP");
            if (value == null) 
            {
                value = request.getParameter("idM");
                if (value == null) 
                {
                    value = request.getParameter("idServlet");
                    if (value == null) 
                    {
                        bean.clearBasket();
                        response.sendRedirect(""+"?lang="+lang);
                    } 
                    else 
                    {
                        bean.addItem(value);
                        response.sendRedirect("s?id="+value+"&lang="+lang);
                    }
                } 
                else 
                {
                    bean.deleteItem(value);
                    response.sendRedirect("basket.jsp?lang="+lang);
                }
            } 
            else 
            {
                bean.addItem(value);
                response.sendRedirect("basket.jsp?lang="+lang);
            }
        }
        else 
        {
            bean.addItem2(value);
            response.sendRedirect(page+"?lang="+lang);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "GET requests are not supported");
    }
}
