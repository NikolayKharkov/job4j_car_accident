package ru.job4j.repositories.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.job4j.models.Rule;
import java.util.List;
import java.util.function.Function;

@Repository
public class RuleHibernate {

    @Autowired
    private SessionFactory sf;

    public List<Rule> getRules() {
        return this.tx(
                session -> session.createQuery("select r from Rule r").list()
        );
    }

    public Rule findRuleById(int id) {
        return tx(session -> session.get(Rule.class, id));
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
