package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findPersonByIdWithLanguages", query = "select p from Person p left join fetch p.languages where p.id = :personId")
@NamedQuery(name = "Person.findPersonByName", query = "select p from Person p where p.name = :personName")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FIND_PERSON_BY_NAME = "Person.findPersonByName";
	public static final String FIND_PERSON_BY_ID_WITH_LANGUAGES = "Person.findPersonByIdWithLanguages";
	public static final String FIND_PERSON_BY_ID_WITH_COLOUR = "Person.findPersonByIdWithColour";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

	private String password;

	@ManyToMany
	private List<Language> languages;

	@ManyToOne
	@JoinColumn (name = "colour", foreignKey = @javax.persistence.ForeignKey(name = "colourKey"))
	private Colour favColour;

	public Person() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) { this.age = age;}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return person.getId() == id;
		}

		return false;
	}

	public Colour getFavColour() {
		return favColour;
	}

	public void setFavColour(Colour favColour) {
		this.favColour = favColour;
	}
}