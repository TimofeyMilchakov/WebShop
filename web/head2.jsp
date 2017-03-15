<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: tttt
  Date: 14.11.2016
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="newcss1.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");
    String lang = request.getParameter("lang");
    Cookie[] cookies = request.getCookies();

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
    %>


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
            <a href="initial.jsp"><fmt:message key="page.menu"/></a>
        </div>
        <ul class="f-nav">
            <c:if test="${not empty sessionScope.user}">
                <li><a onclick="logOff()" href="exet1?page=initial"><fmt:message key="exet"/></a></li>
            </c:if>
            <li><a href="cabinet.jsp?lang=${lang}">
                <c:if test="${not empty sessionScope.user}">
                    <fmt:message key="cabinet"/>${sessionScope.user}}
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <fmt:message key="enter"/>
                </c:if>
            </a></li>

            <li><a href="#"><fmt:message key="history"/></a></li>
            <li><a href="basket.jsp?lang=${lang}"><fmt:message key="basket"/></a></li>


        </ul><!-- f-nav -->
    </div><!-- f-nav-bar-body -->
</div><!-- f-nav-bar -->



</body>
</html>
