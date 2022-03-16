package ru.job4j.repositories.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.models.Accident;
import java.util.List;
import java.util.function.Function;

@Repository
public class AccidentHibernate {

    @Autowired
    private SessionFactory sf;

    public Accident create(Accident accident) {
        if (accident.getId() == 0) {
            int id = (int) this.tx(session -> session.save(accident));
            accident.setId(id);
        } else {
            updateAccident(accident);
        }
        return accident;
    }

    public void updateAccident(Accident accident) {
        this.tx(session -> {
            session.update(accident);
            return true;
        });
    }

    public List<Accident> getAccidents() {
        return this.tx(
                session -> session.createQuery("select distinct a from Accident a join fetch a.rules").list()
        );
    }

    public Accident findAccidentById(int id) {
        return tx(session -> {
            Query<Accident> query =
                    session.createQuery("select distinct a from Accident a join fetch a.rules where a.id = :id");
            query.setParameter("id", id);
            return query.uniqueResult();
        });
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
