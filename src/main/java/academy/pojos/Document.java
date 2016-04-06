package academy.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private Set<Person> persons = new HashSet<Person>();

	public Document() {
	}

	public Document(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
