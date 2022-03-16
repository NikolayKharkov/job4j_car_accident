package ru.job4j.repositories.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.models.AccidentType;

import java.util.List;
import java.util.function.Function;

@Repository
public class TypeHibernate {

    @Autowired
    private SessionFactory sf;

    public AccidentType findAccidentTypeById(int id) {
        return tx(session -> session.get(AccidentType.class, id));
    }

    public List<AccidentType> getAccidentTypes() {
        return this.tx(
                session -> session.createQuery("select at from AccidentType at").list()
        );
    }

    private <T> T tx(Function<Session, T> query) {
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            T result = query.apply(session);
            transaction.commit();
            return result;
        } catch (Exception e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
