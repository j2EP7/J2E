package dao;

import dao.hibernate.HibernateWordDAO;
import dao.mysql.MySQLWordDAO;

public class FactoryDAO {

    final static int IMP_MYSQL = 1;
    final static int IMP_HIBERNATE = 2;
    private static int implementacion = IMP_MYSQL;

    public static WordDAO getWordDAO(){
        WordDAO word = null;

        if(implementacion == FactoryDAO.IMP_MYSQL){
            word = new MySQLWordDAO();
        }else if(implementacion == FactoryDAO.IMP_HIBERNATE){
            word = new HibernateWordDAO();
        }else{
            // error
        }
        return word;
    }

}