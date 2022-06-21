package ch.bbzbl.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Person.findPersonByIdWithLanguages", query = "select p from Person p left join fetch p.languages where p.id = :personId")
@NamedQuery(name = "Person.findPersonByIdWithColour", query = "select p from  Person  p left join fetch p.favColour where p.id = :personId")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_PERSON_BY_ID_WITH_LANGUAGES = "Person.findPersonByIdWithLanguages";
	public static final String FIND_PERSON_BY_ID_WITH_COLOUR = "Person.findPersonByIdWithColour";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

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

	public Colour getColour() {
		return favColour;
	}


	public List<Colour> getColourList() {
		List<Colour> pipikacka = new ArrayList<>();
		pipikacka.add(favColour);
		return pipikacka;
	}

	public void setColour(Colour favColour) {
		this.favColour = favColour;
	}
}