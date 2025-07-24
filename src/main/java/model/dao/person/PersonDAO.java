package model.dao.person;

import java.util.List;

import model.entities.persistence.person.Person;

public interface PersonDAO {

    void savePerson(Person person);

    void deletePerson(Person person);

    void updatePerson(Person person);

    List<Person> getPersonForUserId(long id);

}
