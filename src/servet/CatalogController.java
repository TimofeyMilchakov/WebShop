package servet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by tttt on 15.11.2016.
 */
@WebServlet(name = "CatalogController")
public class CatalogController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
//        int parameter = Integer.parseInt(getInitParameter("SelectedPage"));
//        session.setAttribute("choice",parameter);
        String page = request.getParameter("page");
        response.addCookie(new Cookie("land",request.getParameter("lang")));

            try
            {
                session.invalidate();
            }
            catch (Exception ex)
            {
                String log = ex.getMessage();
            }
            if(page.equals(null))
            {
                page="initial";
            }
        response.sendRedirect(page+".jsp");
    }
}
