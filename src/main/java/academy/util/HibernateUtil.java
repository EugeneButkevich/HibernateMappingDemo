package academy.util;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import academy.pojos.Person;

public class HibernateUtil {

	private static Logger log = Logger.getLogger(HibernateUtil.class);
	/*
	 * private final SessionFactory sessionFactory = new
	 * Configuration().configure().buildSessionFactory();
	 */
	private SessionFactory sessionFactory;

	public HibernateUtil() {

		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			log.error("Initial SessionFactory creation failed." + e);
		}

	}

	public int addPerson(Person person) {
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		int id = 0;
		try {
			id = (Integer) session.save(person);
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			session.flush();
			transaction.commit();
			session.close();
		}
		return id;
	}

	public Collection<Person> getAllPersons() {
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Collection<Person> personList = null;
		try {
			personList = session.createCriteria(Person.class).list();
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			transaction.commit();
			session.close();
		}
		return personList;
	}

	public void deletePerson(int idPerson) {
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			System.out.println("Удаляем поцыка с id=" + idPerson);
			Person person = session.get(Person.class, idPerson);
			session.delete(person);
			System.out.println("удалили вродь как");
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			transaction.commit();
			session.close();
		}
	}

	public void updatePerson(Person person) {
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			/* Person person = session.load(Person.class, idPerson); */
			session.update(person);
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			transaction.commit();
			session.close();
		}
	}

	public void saveOrUpdatePerson(Person person) {
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			/* session.merge(person); */
			session.saveOrUpdate(person);
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			session.flush();
			transaction.commit();
			session.close();
		}
	}

	public Person getPerson(int id) {
		Person person = null;
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			person = session.get(Person.class, id);
		} catch (HibernateException e) {
			log.error("Error was thrown in DAO: " + e);
			transaction.rollback();
		} finally {
			session.flush();
			transaction.commit();
			session.close();
		}
		return person;
	}

	public void close() {
		this.sessionFactory.close();
	}
}
