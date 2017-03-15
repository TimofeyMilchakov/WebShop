<%--
    Document   : auth
    Created on : 13.11.2016, 14:59:22
    Author     : tttt
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="f" uri="/WEB-INF/tld/tag1.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="newcss1.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <script src="map.js"></script>
        <c:if test="${empty sessionScope.locale}">
            <fmt:setLocale value="ru"/>
        </c:if>
        <c:if test="${cookie.lang.value eq '_ru'}">
            <fmt:setLocale value="ru"/>
        </c:if>
        <c:if test="${cookie.lang.value eq '_en'}">
            <fmt:setLocale value="en"/>
        </c:if>
        <c:if test="${cookie.lang.value eq '_bu'}">
            <fmt:setLocale value="bu"/>
        </c:if>
        <c:if test="${!empty param.lang}">
            <c:if test="${paramValues.lang[0] eq '_ru'}">
                <fmt:setLocale value="ru"/>
            </c:if>
            <c:if test="${paramValues.lang[0] eq '_en'}">
                <fmt:setLocale value="en"/>
            </c:if>
            <c:if test="${paramValues.lang[0] eq '_bu'}">
                <fmt:setLocale value="bu"/>
            </c:if>
        </c:if>
        <fmt:setBundle basename="lang/message"/>
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
                <a href="initial.jsp?lang=${lang}"><fmt:message key="page.menu"/></a>
            </div>
            <ul class="f-nav">
                <c:if test="${not empty sessionScope.user}">
                    <li><a onclick="logOff()" href="exet1?page=basket"><fmt:message key="exet"/></a></li>
                </c:if>

                <c:if test="${not empty sessionScope.user}"><li><a href="cabinet.jsp?lang=${lang}">
                    <fmt:message key="cabinet"/>${sessionScope.user}</a></li>
                </c:if>
                <c:if test="${empty sessionScope.user}">
                    <li><a href="au?lang=${lang}&page=basket">
                        <fmt:message key="enter"/></a></li>
                </c:if>

                <c:if test="${f:check()}">
                    <c:if test="${not empty sessionScope.user}">
                        <li><a href="order.jsp?lang=${lang}">
                            <fmt:message key="order"/></a></li>
                    </c:if>
                </c:if>
                <li><a href="au?lang=${lang}&page=hist"><fmt:message key="history"/></a></li>
                <li><a href="basket.jsp?lang=${lang}"><fmt:message key="basket"/></a></li>


            </ul><!-- f-nav -->
        </div><!-- f-nav-bar-body -->
    </div><!-- f-nav-bar -->

    <form action="j_security_check" method="post" name="loginForm">
            <label><fmt:message key="name" /></label><br>
            <input type="text" name="j_username" placeholder="<fmt:message key="name"/>" size="20"/><br>
            <label><fmt:message key="txtPassword" /></label><br>
            <input type="password" name="j_password" size="20"/><br>
            <input type="submit" value="<fmt:message key="input"/>"/>
        </form>
    </body>
</html>
