package dao;

import dao.hibernate.HibernateGameDAO;
import dao.hibernate.HibernateWordDAO;
import dao.mysql.MySQLGameDAO;
import dao.mysql.MySQLWordDAO;

// Abstract class DAO Factory
public abstract class FactoryDAO {

    // List of DAO types supported by the factory
    final static int IMP_MYSQL = 1;
    final static int IMP_HIBERNATE = 2;
    private static int implementacion = IMP_HIBERNATE;

    // There will be a method for each DAO that can be
    // created. The concrete factories will have to
    // implement these methods.
    public static WordDAO getWordDAO(){
        switch (implementacion) {
            case IMP_MYSQL:
                return new MySQLWordDAO();
            case IMP_HIBERNATE    :
                return new HibernateWordDAO();
            default           :
                return null;
        }
    }

    public static GameDao getGameDAO(){
        switch (implementacion) {
            case IMP_MYSQL:
                return new MySQLGameDAO();
            case IMP_HIBERNATE    :
                return new HibernateGameDAO();
            default           :
                return null;
        }
    }

}