package model.dao.person;

import model.entities.persistence.person.Person;

public interface PersonDAO {

    void savePerson(Person person);

    void deletePerson(Person person);

    void updatePerson(Person person);
    
}
