package util.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {

    
    private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";

    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    private static final ThreadLocal<Transaction> trThreadLocal = new ThreadLocal<Transaction>();

    private static Configuration configuration = new Configuration();

    private static org.hibernate.SessionFactory sessionFactory;

    private static String configFile = CONFIG_FILE_LOCATION;

    static {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
           System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {
    }

    /** *//**
     * Returns the ThreadLocal Session instance. Lazy initialize the
     * <code>SessionFactory</code> if needed.
     * 
     * @return Session
     * @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
               rebuildSessionFactory();
            }
           session = (sessionFactory != null) ? sessionFactory.openSession()
                   : null;
            threadLocal.set(session);
        }

        return session;
    }

    /** *//**
    * Rebuild hibernate session factory
     * 
     */
    public static void rebuildSessionFactory() {
        try {
            configuration.configure(configFile);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    /** *//**
     * Close the single hibernate session instance.
    * 
     * @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);

        if (session != null) {
            session.close();
        }
    }

   /** *//**
    * return session factory
     * 
    */
    public static org.hibernate.SessionFactory getSessionFactory() {
       return sessionFactory;
    }

   /** *//**
    * return session factory
     * 
     * session factory will be rebuilded in the next call
    */
   public static void setConfigFile(String configFile) {
        HibernateSessionFactory.configFile = configFile;
       sessionFactory = null;
    }

   /** *//**
    * return hibernate configuration
     * 
     */
    public static Configuration getConfiguration() {
        return configuration;
    }

   public static void openTransaction() {
       Transaction tr = trThreadLocal.get();
        if (tr == null) {
            tr = getSession().beginTransaction();
            //System.out.println("BeginTransaction");
            trThreadLocal.set(tr);
        }
    }

    public static void commitTransaction() {
        Transaction tr = trThreadLocal.get();
        if (tr != null && !tr.wasCommitted() && !tr.wasRolledBack()) {
            //System.out.println("Commit !");
            tr.commit();
            trThreadLocal.set(null);
        }
    }

    public static void RollbackTransaction() {
        Transaction tr = trThreadLocal.get();
        if (tr != null && !tr.wasCommitted() && !tr.wasRolledBack()) {
            tr.rollback();
            //System.out.println("Rollback!");
            trThreadLocal.set(null);
        }
    }

}