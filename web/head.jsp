
<%--
    Document   : head
    Created on : 31.10.2016, 19:59:59
    Author     : tttt
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="f" uri="/WEB-INF/tld/tag1.tld" %>

<!DOCTYPE html>
<html>
    <head>
<script>
    function setCookie(name, value, options) {
        options = options || {};

        var expires = options.expires;

        if (typeof expires == "number" && expires) {
            var d = new Date();
            d.setTime(d.getTime() + expires * 1000);
            expires = options.expires = d;
        }
        if (expires && expires.toUTCString) {
            options.expires = expires.toUTCString();
        }

        value = encodeURIComponent(value);

        var updatedCookie = name + "=" + value;

        for (var propName in options) {
            updatedCookie += "; " + propName;
            var propValue = options[propName];
            if (propValue !== true) {
                updatedCookie += "=" + propValue;
            }
        }

        document.cookie = updatedCookie;
    }
</script>
        
            
    </head>
    <body>
         <div class="g">
            <div class="g-row">
                 <img class="f-bwi-pic" alt="log" src="img/log.jpg">
                 <div>
                     <form method='GET' >
                         <button onclick="setCookie('lang','_ru','100')" type='submit' name = 'lang' value='_ru' class='langbutton'><img alt="ru" src="img/ru.jpg" width="30" height="15"></button>
                         <button onclick="setCookie('lang','_en','100')"type='submit' name = 'lang' value='_en' class='langbutton'><img alt="en" src="img/en.jpg" width="30" height="15"></button>
                         <button onclick="setCookie('lang','_bu','100')"type='submit' name = 'lang' value='_bu' class='langbutton'><img alt="be" src="img/be.jpg" width="30" height="15"></button>
                     </form>
                 </div>
            </div>
        </div>
        <div class="f-nav-bar">
            <div class="f-nav-bar-body">
                    <div class="f-nav-bar-title">
                        <a href="initial.jsp"><%=myres.getString("page.menu")%></a>
                    </div>
                    <ul class="f-nav">
                        <c:if test="${not empty sessionScope.user}">
                            <li><a onclick="logOff()" href="exet1?page=initial&lang=${lang}"><%=myres.getString("exet")%></a></li>
                        </c:if>
                            <c:if test="${not empty sessionScope.user}"><li><a href="cabinet.jsp?lang=${lang}">
                                <%=myres.getString("cabinet")%>${sessionScope.user}</a></li>
                            </c:if>
                            <c:if test="${empty sessionScope.user}">
                                <li><a href="au?lang=${lang}&page=initial">
                                    <%=myres.getString("enter")%></a></li>
                            </c:if>
                        <c:if test="${f:check()}">
                            <c:if test="${not empty sessionScope.user}">
                                <li><a href="order.jsp?lang=${lang}">
                                    <%=myres.getString("order")%></a></li>
                            </c:if>
                        </c:if>
                            <li><a href="hist.jsp"><%=myres.getString("history")%></a></li>
                            <li><a href="au?page=basket&lang=${lang}"><%=myres.getString("basket")%></a></li>

                    </ul><!-- f-nav -->
            </div><!-- f-nav-bar-body -->
        </div><!-- f-nav-bar -->
    </body>
</html>
