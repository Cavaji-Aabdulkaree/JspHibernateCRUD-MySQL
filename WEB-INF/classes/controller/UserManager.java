/* 
    Document   : index
    Created on : Mar 20, 2016, 2:03:43 PM
    Author     : cavaji
    
    follow     :    https://twitter.com/Cavaji
                    https://plus.google.com/u/0/109777059100477708540
                    http://cavaji.blogspot.com/
                    https://www.facebook.com/Cavaji-Soft-292268400944940/
*/
package controller;

import java.util.List;
import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author cavaji
 */
public class UserManager {

    private List<User> users;

    public void insert(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void update(User user) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void delete(Integer intId) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setId(intId);
        session.delete(user);
        session.getTransaction().commit();
    }

    public List<User> read() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        users = session.createQuery("FROM User").list();
        session.getTransaction().commit();
        return users;

    }
}
