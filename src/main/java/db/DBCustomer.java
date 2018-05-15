package db;

import models.Customer;
import models.Order;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBCustomer {

    private static Session session;
    private static Transaction transaction;

    public static List<Customer> getCustomers(){
        session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> results = null;
        try {
            String hql = "from Customer";
            results = session.createQuery(hql).list();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static void delete(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static Customer find(int id){
        session = HibernateUtil.getSessionFactory().openSession();
        Customer result = null;
        try{
            String hql = "from Customer where id = :id";
            Query query = session.createQuery(hql);
            query.setInteger("id", id);
            result = (Customer) query.uniqueResult();
        } catch (HibernateException e ){
            e.printStackTrace();
        } finally {
            session.close();
        } return result;

    }

    public static void update(Customer customer){
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        } catch (HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static List<Order> getOrdersForCustomer(Customer customer) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Order> resutls = null;
        try {
            Criteria cr = session.createCriteria(Order.class);
            cr.add(Restrictions.eq("customer", customer));
            resutls = cr.list();
        }catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return resutls;
    }
}
