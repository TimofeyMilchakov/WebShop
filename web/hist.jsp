<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: tttt
  Date: 22.11.2016
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri= "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="f" uri="/WEB-INF/tld/tag1.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="newcss1.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <jsp:useBean id="prodId" class="JSP.NewBean" scope="page"/>
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
    <jsp:useBean id="basket" class="JSP.BasketList" scope="session"/>

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
<div>
    <c:forEach var="order" items="${sessionScope.orders}">
        <div class="item">
            <div>
                <h3><fmt:message key="Purchases"/>: </h3>
                <ul>

                        <li>${order.userName}</li>
                        <%--<script>qwe(${order.purchases})</script>--%>
                        <%--<%--%>
                            <%--String s = null;--%>
                           <%--Cookie[] cookies = request.getCookies();--%>
                            <%--for(Cookie c:cookies)--%>
                            <%--{--%>
                                <%--if(c.getName().equals("qwe"))--%>
                                <%--{--%>
                                    <%--s=c.getValue();--%>
                                    <%--break;--%>
                                <%--}--%>
                            <%--}--%>
                            <%--int k=0;--%>
                            <%--for(int i=0; i<s.length();i++)--%>
                            <%--{--%>
                                <%--String val = s.substring(i,i+1);--%>
                                <%--if(val.equals("-"))--%>
                                <%--{--%>
                                    <%--for (int j=i+1;j<s.length();j++)--%>
                                    <%--{--%>
                                        <%--String val2=s.substring(j,j+1);--%>
                                        <%--if(val2.equals(";"))--%>
                                        <%--{--%>
                                            <%--out.println("<li>");--%>
                                            <%--out.println(s.substring(k,i));--%>
                                            <%--out.println("</li>");--%>
                                            <%--out.println("<li>");--%>
                                            <%--out.println(s.substring(i+1,j));--%>
                                            <%--out.println("</li>");--%>
                                            <%--k=j+1;--%>
                                            <%--break;--%>

                                        <%--}--%>
                                    <%--}--%>
                                <%--}--%>
                            <%--}--%>

                        <%--%>--%>
                        <li>${order.purchases}</li>
                        <li>${order.orderDate}</li>
                        <c:if test="${order.curier==0}"><span><fmt:message key="sam"/> <fmt:message key="${order.shopId}"/> </span></c:if>
                        <c:if test="${order.curier==1}"><span><fmt:message key="kyr"/> ${order.addresses}</span></c:if>

                </ul>
            </div>

        </div><hr>
    </c:forEach>
</div>



</body>
</html>
