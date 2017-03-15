
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib prefix="f" uri="/WEB-INF/tld/tag1.tld" %>
<html>
<head>
    <title>Заказ</title>
    <link rel="stylesheet" href="newcss1.css">
    <link rel="stylesheet" href="/maps/documentation/javascript/demos/demos.css">
    <style type="text/css">
        html, body { height: 100%; margin: 0; padding: 0; }
        #map { height: 50%; width: 50%;  }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="map.js"/>

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
    <script>initMap()</script>

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
<%--<jsp:include page="head2.jsp"></jsp:include>--%>

        <div>
            <div id="map"></div>
            <form method="post" action="order">
                <div id="order-settings">
                    <label for="type-choice"><fmt:message key="DeliveryType" /></label>
                    <input name="type-choice" id="type-choice" type="checkbox" onchange="changeType()">
                    <div id="shop">
                        <fmt:message key="ShopChoice" />
                        <select name="shop-choice" id="shop-choice" onchange="changeShop()">
                            <option value="1"> <fmt:message key="1"/> </option>
                            <option value="2" selected> <fmt:message key="2"/></option>
                            <option value="3"> <fmt:message key="3"/></option>
                        </select>
                    </div>
                    <div id="courier" style="display:none">
                        <fmt:message key="Addresse" />
                        <textarea name="addressee" id="addressee" ></textarea>
                    </div>
                    <c:if test="${f:check()}">
                    <input type="submit" value="<fmt:message key="HandleOrder" />">
                    </c:if>
                </div>
            </form>
        </div>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhYPcqjwdS5ZgbdTcloDK-9zShNCUzKKk&callback=initMap">
    </script>


</body>
</html>
