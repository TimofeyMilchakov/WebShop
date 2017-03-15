<%-- 
    Document   : list
    Created on : 30.10.2016, 21:15:22
    Author     : tttt
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="newcss1.css">
        <script>
            function buy()
            {
                    
            }
        </script>
           
    </head>
    <body>
        <div class="f-bwi" > 
            <a href="<jsp:getProperty name="prodId" property="servlet"/>?prod=<jsp:getProperty name="prodId" property="type"/>">
                    <img class="f-bwi-pic" src="<jsp:getProperty name="prodId" property="img"/>" width="200" height="150" />
                    <div class="f-bwi-text">
                        <h1><br><jsp:getProperty name="prodId" property="name"/><br></h1>
                        <br><jsp:getProperty name="prodId" property="dis"/><br>
                     </div><!-- f-bwi-text -->
                     <h4><%=myres.getString("ccc")%> 
                     <jsp:getProperty name="prodId" property="buy"/> 
                         <%=myres.getString("rub")%></h4>
            </a>
                    <form action="s1?lang=<%=lang%>&page=initial.jsp" method='post'>
                    <button type='submit'  name = 'id' value='<jsp:getProperty name="prodId" property="type"/>' class='langbutton'><img alt="ba" src="img/basket.jpg" width="30" height="15" ></button>
                    </form>
                    
        </div><!-- f-bwi -->
    </body>
</html>
