import JSP.BasketList;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter {
    private ServletContext conteхt;
    private static Logger logger = Logger.getLogger(LogFilter.class);

    public LogFilter() {}
    public void destroy() {}
    public void doFilter(ServletRequest request, ServletResponse
            response, FilterChain chаin) throws IOException,
            ServletException {
        HttpServletRequest httpReq = (HttpServletRequest)request;
        String uri = httpReq.getRequestURI();
        Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        String prod = new String();
        String type = new String();
        if(cookies!=null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("prod")) {
                    prod = c.getValue();
                }
                if(c.getName().equals("type"))
                {
                    type = c.getValue();
                }
            }
        }
        switch (uri){
            case "/initial.jsp":
//                String filter = request.getParameter("type");
//                if(filter == null) logger.info(uri+". Запрос всех товаров магазина.");
                logger.info(uri+". Запрос товаров типа "+type);
                break;
            case "/order.jsp":
                String s="";
                for (String key : BasketList.getBasketList().keySet()) {
                    s=s+" "+key;
                }



                logger.info("Пользователь " + s    +" оформил товар");
                break;
            case "/Product":

                logger.info("Просмотр товара " +prod);
                break;

            case "/basket.jsp":

                logger.info("Просмотр корзины");
                break;


            case "/comment":

                logger.info("посмотрел или оставил комментарий");
                break;

            case "/hist.jsp":

                logger.info("посмотрел историю");
                break;
            case "/cabinet.jsp":
                logger.info("Пользователь "+((HttpServletRequest) request).getUserPrincipal().getName()
                        +" решил посмотреть личный кабинет");
                break;
            default:
                logger.info("Пользователь зачем-то посетил "+uri);
                break;


        }
        chаin.doFilter(request, response);
    }
    public void init(FilterConfig сonfig) throws ServletException
    {
        conteхt = сonfig.getServletContext();
    }
}
