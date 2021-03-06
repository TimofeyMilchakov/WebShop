package bd;


import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tttt on 21.11.2016.
 */
public class CommentService
{
    public static ArrayList<UserComment> getUserAllComments(String userName)
    {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List purchases = session.createQuery("FROM UserComment").list();
        ArrayList<UserComment> orders = new ArrayList<UserComment>();
        for(Iterator iterator = purchases.iterator(); iterator.hasNext();)
        {
            UserComment order = (UserComment)iterator.next();
            if(order.getUserName().equals(userName)) orders.add(order);
        }

        session.getTransaction().commit();
        session.close();
        return orders;
    }

    public static void saveComment(UserComment comment)
    {
        Session session =  HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
        session.close();
    }
}
