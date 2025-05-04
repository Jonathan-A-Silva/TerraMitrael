package util;

import org.hibernate.Session;

public class DAOUtil {

    public static void rollBack(Session sessao) {
        if (sessao.getTransaction() != null) {
            sessao.getTransaction().rollback();
        }
    }

    public static void closeSession(Session sessao) {
        if (sessao != null) {
            sessao.close();
        }
    }

}
