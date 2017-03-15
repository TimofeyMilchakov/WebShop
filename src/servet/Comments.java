package servet;

import bd.CommentService;
import bd.UserComment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tttt on 21.11.2016.
 */
@WebServlet(name = "Comments")
public class Comments extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String userName = request.getUserPrincipal().getName();
        UserComment comment = new UserComment(text, userName);
        CommentService.saveComment(comment);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder allCommentsHtml = new StringBuilder();
        allCommentsHtml.append("<ul>");
        String userName = request.getUserPrincipal().getName();
        ArrayList<UserComment> comments = CommentService.getUserAllComments(userName);
        for (UserComment comment: comments)
        {
            if(comment.getText()!="" && comment.getText()!=null) {
                allCommentsHtml.append("<li>");
                allCommentsHtml.append("<span>");
                allCommentsHtml.append(comment.getText());
                allCommentsHtml.append("<span>");
                allCommentsHtml.append("<br><span>");
                allCommentsHtml.append(comment.getCommentDate());
                allCommentsHtml.append("<span>");
                allCommentsHtml.append("</li>");
            }
        }

        allCommentsHtml.append("</ul>");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(allCommentsHtml.toString());
    }
}
