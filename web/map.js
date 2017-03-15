var map;
var first;
var second;
var third;
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat:59.881452,lng:30.315930},
        zoom: 14,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });
    first = new google.maps.Marker({
        position: {lat:59.871830,lng:30.303876},
        label: "Четверочка",
        map: map
    });
    first.addListener('click', function() {
        map.setCenter(first.position);
        document.getElementById("shop-choice").value = 1;
        map.setZoom(14);
    });

    second = new google.maps.Marker({
        position: {lat:59.881452,lng:30.315930},
        label: "Четверочка",
        map: map
    });
    second.addListener('click', function() {
        map.setCenter(second.position);
        document.getElementById("shop-choice").value = 2;
        map.setZoom(14);
    });

    third = new google.maps.Marker({
        position: {lat:59.875224,lng:30.335922},
        label: "Четверочка",
        map: map
    });
    third.addListener('click', function() {
        map.setCenter(third.position);
        document.getElementById("shop-choice").value = 3;
        map.setZoom(14);
    });
    map.setCenter(second.position);
}

function changeShop() {
    var shop = document.getElementById("shop-choice").value;
    switch (shop){
        case '1':map.setCenter(first.position);break;
        case '2':map.setCenter(second.position);break;
        case '3':map.setCenter(third.position);break;
    }
}

function changeType() {
    if(document.getElementById("type-choice").checked){
        document.getElementById("shop").style.display = "none";
        document.getElementById("courier").style.display = "block";
    }
    else {
        document.getElementById("shop").style.display = "block";
        document.getElementById("courier").style.display = "none";
    }
}
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

function addAdr()
{
    var addressee = document.getElementById("addressee").value;
    $.post("au",{text:addressee});
    document.getElementById("addressee").value="";
}
