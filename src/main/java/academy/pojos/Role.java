package academy.pojos;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	/* private Set<Person> persons; */

	public Role() {
	}

	public Role(int id, String name) {
		this.id = id;
		this.name = name;
		/* this.persons = persons; */
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Set<Person> getPersons() { return persons; }
	 * 
	 * public void setPersons(Set<Person> persons) { this.persons = persons; }
	 */
}
