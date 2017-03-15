/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.ResourceBundle;

/**
 *
 * @author tttt
 */
public class Product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String lang = request.getParameter("lang");
        Cookie[] cookies = request.getCookies();
        if(lang==null)
        {
            for(Cookie c:cookies)
            {
                if("lang".equals(c.getName()))
                {
                    lang=c.getValue();
                }
            }
        }
        else
        {
            response.addCookie(new Cookie("lang",lang));
        }
        Locale locale;
        if ("_en".equals(lang)) {
            locale = new Locale("en", "GB");
        } else if ("_ru".equals(lang)) {
            locale = Locale.getDefault();
        } else if ("_bu".equals(lang)) {
            locale = new Locale("bu", "BY");
        } else {
            locale = Locale.getDefault();
        }
        Cookie cookie1 = new Cookie("lang", lang);
        response.addCookie(cookie1);
        String prod = request.getParameter("prod");
        if(prod==null)
        {
            for(Cookie c:cookies)
            {
                if("prod".equals(c.getName()))
                {
                    prod=c.getValue();
                }
            }
        }
        response.addCookie(new Cookie("prod",prod));
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        
           
            
           ResourceBundle myres = ResourceBundle.getBundle("lang/message", locale);
            
            String el1 = getInitParameter("el1");
//            String el2 = getInitParameter("el2");
//        out.println("<%@ page contentType=\"text/html;charset=UTF-8\" language=\"java\" isELIgnored=\"false\" %>");
//        out.println("<%@ taglib uri= \"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %>");
//        out.println("<%@ taglib  uri=\"http://java.sun.com/jsp/jstl/fmt\" prefix=\"fmt\"%>");
//        out.println("<%@ taglib prefix=\"f\" uri=\"/WEB-INF/tld/tag1.tld\" %>");
            out.println("<!DOCTYPE html>");

            out.println("<html>");
            out.println("<head>");
//            out.println("<script src='setLanguage.js'></script>");
            out.println("<script src='getOps.js'></script>");
            out.println("<link rel='stylesheet' href='newcss1.css'>");
            out.println("<title>"  + myres.getString("page.title"));
            out.println("</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='g'>");
            out.println("<div class='g-row'>");
            out.println("<img class='f-bwi-pic' alt='log' src='img/log.jpg'>");
            out.println("<div>");
            out.println("");
            out.println("<form method='GET', action='Product'>");
                     out.println("<button type='submit' name = 'lang' value='_ru' class='langbutton'><img alt=\"ru\" src=\"img/ru.jpg\" width=\"30\" height=\"15\"></button>");
                     out.println("<button type='submit' name = 'lang' value='_en' class='langbutton'><img alt=\"en\" src=\"img/en.jpg\" width=\"30\" height=\"15\"></button>");
                     out.println("<button type='submit' name = 'lang' value='_bu' class='langbutton'><img alt=\"be\" src=\"img/be.jpg\" width=\"30\" height=\"15\"></button>");
                     out.println("</form>");
//            out.println("<a href=\"#\", onclick=\"setLanguage(1);\"><img src='img/ru.jpg' width='30' height='15' ></a>");
//            out.println("<a href=\"#\",  onclick=\"setLanguage(2);\";><img src='img/en.jpg' width='30' height='15'></a>");
//            out.println("<a href=\"#\", onclick=\"setLanguage(3);\";><img src='img/be.jpg' width='30' height='15'></a>");
            out.println("</div>");
            out.println(" </div>");
            out.println("</div>");
            out.println("<div class='f-nav-bar'>");
            out.println("  <div class='f-nav-bar-body'>");
            out.println("<div class='f-nav-bar-title'>");
            out.println("<a href='initial.jsp'>" + myres.getString("page.menu")+ "</a>");
            out.println("</div>");
            out.println("<ul class='f-nav'>");
        if(user!=null)
        {
            out.println("<li><a onclick=\"logOff()\" href=\"exet1?page=basket\">"+myres.getString("exet")+"</a></li>");
        }
        if(user!=null)
        {
            out.println("<li><a href=\"cabinet.jsp\">"+myres.getString("cabinet")+user+"</a></li>");
        }
        if(user==null)
        {
            out.println("<li><a href=\"au?page=basket\">"+myres.getString("enter")+"</a></li>");
        }

            out.println("<li><a href='hist.jsp'>" + myres.getString("history")+ "</a></li>");
            out.println("<li><a href='au?page=basket'>" + myres.getString("basket")+ "</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
//        out.println(" <%@include file =\"head.jsp\" %>");
            // отображение товара
            out.println("<ul class=\"f-nav f-nav-tabs\">");
            out.println("<li id=\"buyLi\"><a  onclick=\"getOps(\'buy\');\">" + myres.getString("page.buy")+ "</a></li>");
            out.println("<li id=\"opsLi\"><a  onclick=\"getOps(\'ops\');\">" + myres.getString("page.product")+ "</a></li>");
            out.println("<li id=\"otsLi\"><a onclick=\"getOps(\'ots\');\">" + myres.getString("page.ots")+ " </a></li>");
            out.println("</ul>");
            
//            out.println("<script>s1 = documents.getElementsById(\""+ el1 +"\");s1.display= 'block'; </script>");
//            out.println("<script> s2 = documents.getElementsById(\""+ el2 +"\");s2.display= 'none'; </script>");
//            out.println("<script> s1.");
            
            
            out.println("<div  id=\"opsAndImj\" style=\"display: none;\">");
            out.println("<img class=\"f-bwi-pic\" width=\"400\" height=\"400\" src=\"img/"+prod+".jpg\" alt=\""+prod+"\" />");
            out.println("<div  id=\"ops\" style=\"display: none;\" >");
            out.println("<p>  " + myres.getString("page.inf1." + prod )+ "</p>");
            out.println("<p>  " + myres.getString("page.inf2."+prod)+ "</p>");
            out.println("<p>  " + myres.getString("page.inf3."+prod)+ "</p>");
            out.println("<p>  " + myres.getString("page.inf4."+prod)+ ".</p>");
            out.println("<p>  " + myres.getString("page.inf5."+prod)+ "</p>");
            out.println("<p>  " + myres.getString("page.inf6."+prod)+ "</p>");
            out.println("<p>  " + myres.getString("page.inf7."+prod)+ " </p>");
            out.println("<p>  " + myres.getString("page.inf8."+prod)+ "</p>");
            out.println("<p>  " + myres.getString("page.inf9."+prod)+ "</p>");
            out.println(" </div>");
            
            out.println(" <div class=\"f-bwi-text\" id=\"buy\" style=\"display: none;\"> ");
            out.println("     <p>" + myres.getString("page."+prod+".inf1")+ "</p>");
            out.println("     <p>" + myres.getString("page."+prod+".inf2")+ "</p>");
            out.println("     <p>" + myres.getString("page."+prod+".inf3")+ "</p>");
            out.println("     <p>" + myres.getString("page."+prod+".inf4")+ "</p>");

            out.println(" <form action=\"s1?page=Product\" method='post'>");
            out.println("<button type='submit'  name = 'id' value='"+prod+ "' class='langbutton'><img alt=\"ba\" src=\"img/basket.jpg\" width=\"30\" height=\"15\" ></button>");
            out.println("  </form>");
            out.println(" </div>");
            
            
             
            
        out.println("</div>");
           out.println(" <div id=\"ots\" style=\"display: none;\">");
              out.println("  <img class=\"f-bwi-pic\" width=\"400\" height=\"400\" src=\"img/gr.jpg\" alt=\""+prod+"\" />");
              out.println("  <div>" + myres.getString("page.mes")+ "</div>");
           out.println(" </div>");
        
            
            
            
            out.println("<script>getOps(\'buy\');</script>");
            out.println("</body>");
            out.println("</html>");
        }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String lang = request.getParameter("lang");
        response.addCookie(new Cookie("lang",lang));
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
