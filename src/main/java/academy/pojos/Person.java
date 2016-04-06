package academy.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Person implements Serializable {

private static final long serialVersionUID = 1L;
	private int id;
	private int age;
	private String name;
	private String surname;
	private Role role;
	private Set<Document> documents = new HashSet<Document>();

	public Person() {
	}

	public Person(final int age, final String name, final String surname) {
		this.age = age;
		this.name = name;
		this.surname = surname;
	}

	public Person(final int id, final int age, final String name, final String surname, Role role,
			Set<Document> documents) {
		this.id = id;
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.role = role;
		this.documents = documents;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

}
