package ch.bbzbl.dao;

import java.util.HashMap;
import java.util.Map;

import ch.bbzbl.entity.Person;

public class PersonDAO extends GenericDAO<Person> {

	private static final long serialVersionUID = 1L;

	public PersonDAO() {
		super(Person.class);
	}

	public Person findPersonWithAllLanguages(int personId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("personId", personId);

		return super.findOneResult(Person.FIND_PERSON_BY_ID_WITH_LANGUAGES, parameters);
	}

	public Person findPersonByName(String personName) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("personName", personName);

		return super.findOneResult(Person.FIND_PERSON_BY_NAME, parameters);
	}

	public void delete(Person person) {
        	super.delete(person.getId());
	}

	public Person findPersonWithColour(int personId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("personId", personId);

		return super.findOneResult(Person.FIND_PERSON_BY_ID_WITH_COLOUR, parameters);
	}

}
