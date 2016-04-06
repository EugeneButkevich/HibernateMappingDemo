package academy.util;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import academy.pojos.Document;
import academy.pojos.Person;
import academy.pojos.Role;

public class HibernateUtilTest {

	@Test
	public void testCreate() throws Exception {
		final HibernateUtil util = new HibernateUtil();
		System.out.println("nachali test");
		Role role = new Role(6, "I am your second role");
		Person person = new Person(18, 15, "вмвм", "ааааа", role, null);
		final int id = util.addPerson(person);
		System.out.println("Добавили персон. id=" + id);
		
		Document document1 = new Document(9,"passport");
		Document document2 = new Document(3,"driver license");
		Set<Document> documents = new HashSet<Document>();
		documents.add(document1);
		documents.add(document2);
		person.setDocuments(documents);
		util.updatePerson(person);

		/*
		 * for (Person p : util.getAllPersons()) { System.out.println(p.getId()
		 * + " " + p.getName() + " " + p.getSurname()); }
		 */

		/* util.deletePerson(16); */

		/* util.updatePerson(new Person(20,29,"thdf","puk")); */

		/* util.saveOrUpdatePerson(new Person(55,13, "up", "upda")); */

		assertEquals(id, 18);

		/*
		 * Person person = util.getPerson(2); System.out.println("id = "
		 * +person.getId()); System.out.println("age = "+person.getAge());
		 * System.out.println("name = "+person.getName()); System.out.println(
		 * "surname = "+person.getSurname());
		 */

		util.close();
	}
}
