<%-- 
    Document   : initial
    Created on : 31.10.2016, 0:41:08
    Author     : tttt
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<%@page import="JSP.List" %>
<%@page import="JSP.NewBean" %>
<html>
    <head>
        <link rel="stylesheet" href="newcss1.css">
        <script>
            function itemsChanged() {
            var value = document.getElementsByTagName('select')[0].value;
            window.location='?type=' + value;
}
        </script>
        <jsp:useBean id="prodId" class="JSP.NewBean" scope="page"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String lang = request.getParameter("lang");
        Cookie[] cookies = request.getCookies();
        String type = request.getParameter("type");

        if(lang==null && cookies!=null)
        {
            for(Cookie c:cookies)
            {
                if("lang".equals(c.getName()))
                {
                    lang=c.getValue();
                }
            }
        }
        
        if(type==null&& cookies!=null)
        {
            for(Cookie c:cookies)
            {
                if("type".equals(c.getName()))
                {
                    type=c.getValue();
                    
                }
            }
        }
        if(type==null)
        {
            type="all";
        }
        Locale locale;
        if ("_en".equals(lang)) {
            locale = new Locale("en", "GB");
        } else if ("_ru".equals(lang)) {
            locale = new Locale("ru","RU");
        } else if ("_bu".equals(lang)) {
            locale = new Locale("bu", "BY");
        } else {
            locale = Locale.getDefault();
        }
        Cookie cookie1 = new Cookie("lang", lang);
        response.addCookie(cookie1);
        
        
        
           
            
           ResourceBundle myres = ResourceBundle.getBundle("lang/message", locale);
           List.deleteList();
           List.addElem(new NewBean("milk","img/milk.jpg","milk","Product",50));
           List.addElem(new NewBean("bread","img/bread.jpg","bread","Product",20));
           List.addElem(new NewBean("cheese","img/cheese.jpg","cheese","Product",300));
           ArrayList<NewBean> list = List.getList();
           
        %>
        
    </head>
    <body>
        <%@include file ="head.jsp" %>
        
        
        <select name="selectName" onchange="itemsChanged();">
            <option value='all'><%=myres.getString(type)%>
                    </option>         
           <option value='all'><%=myres.getString("all")%>
                    </option>
                    <option value='milk'><%=myres.getString("milk")%>
                    </option>
                    <option value='bread'><%=myres.getString("bread")%>
                    </option>
                    <option value='cheese'><%=myres.getString("cheese")%>
                    </option>
                </select>
        <%
           if(type == null)
           {
               if(cookies==null)
               {
                   type="all";
                   Cookie cookie = new Cookie("type",type);
                   response.addCookie(cookie);
               }
               else{
                   for (int i = 0; i < cookies.length; i++) {
                            if ("type".equals(cookies[i].getName())) {
                                type = cookies[i].getValue();
                                break;
                            }
                        }
                        if (type == null) {
                            type = "all";
                            Cookie cookie = new Cookie("type", type);
                            response.addCookie(cookie);
                        }
               }
           }
           else
           {
               Cookie cookie = new Cookie("type", type);
               response.addCookie(cookie);
           }
        %>
        <h1><%=myres.getString(type)%></h1>
        <%      
                if(type.equals("all"))
                {
                    for(int j=0;j<list.size();j++)
                    {
                        prodId.setName(myres.getString(list.get(j).getName()));
                        prodId.setImg(list.get(j).getImg());
                        prodId.setType(list.get(j).getName());
                        prodId.setServlet(list.get(j).getServlet());
                        prodId.setBuy(list.get(j).getBuy());
                        prodId.setDis(myres.getString("page."+list.get(j).getDis()+".inf1")+"\n"+
                                      myres.getString("page."+list.get(j).getDis()+".inf2")+"\n"+
                                      myres.getString("page."+list.get(j).getDis()+".inf3")+"\n"+
                                      myres.getString("page."+list.get(j).getDis()+".inf4"));
                        prodId.setId(list.get(j).getId());
                    %>
                    <%@include file="list.jsp" %>
                    <%
                    }
                   
                    
                }
                else
                {
                   for(int i = 0;i<list.size();i++)
                   {
                       if(list.get(i).getName().equals(type))
                       {
                           prodId.setId(list.get(i).getId());
                           prodId.setName(myres.getString(list.get(i).getName()));
                        prodId.setImg(list.get(i).getImg());
                        prodId.setType(list.get(i).getName());
                        prodId.setServlet(list.get(i).getServlet());
                        prodId.setBuy(list.get(i).getBuy());
                        prodId.setDis(myres.getString("page."+list.get(i).getDis()+".inf1")+"\n"+
                                      myres.getString("page."+list.get(i).getDis()+".inf2")+"\n"+
                                      myres.getString("page."+list.get(i).getDis()+".inf3")+"\n"+
                                      myres.getString("page."+list.get(i).getDis()+".inf4"));
                    %>
                    <%@include file="list.jsp" %>
                    <% 
                       }
                   }
                }
        
        %>
        
        
        
       
       
    </body>
</html>
