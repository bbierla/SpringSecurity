package bb.Services;

import bb.DTO.PersonDTO;
import bb.model.Person;
import bb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bartosz on 08.07.16.
 */
@Service
public class RegisterPersonService {


    @Autowired(required = false)
    private PersonRepository personRepository;

    public boolean RegisterPerson(PersonDTO personDTO) {
        if (checkIfUserExit(personDTO.getLogin())) {
            return false;
        } else {
            Person person = new Person();
            person.setName("NewSomebody");
            person.setAdress("NewPoznan");
            person.setTel("123123123");
            person.setLogin("NewLogin");
            person.setPassword("NewPassword");

            personRepository.save(person); //add to personRepo
            return true;
        }
    }

    public boolean checkIfUserExit(String login) {
        if (personRepository.findByLogin(login) != null) {
            return true;
        } else return false;
    }

}
