package bb.controllers;

import bb.model.Person;
import bb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * Created by bartosz on 08.07.16.
 */
@RestController
public class PersonController {


    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity<?> hello() {

        return new ResponseEntity<>("Hello Hello Hello!!!", HttpStatus.OK);
    }
    @RequestMapping(value = "/baza", method = RequestMethod.GET)
    public Person baza() {

        Person person = new Person();
        person.setId(1);
        person.setName("Somebody");
        person.setAdress("Poznan");
        person.setTel("123123123");
        person.setLogin("login");
        person.setPassword("password");

        personRepository.save(person);
        return personRepository.findByLogin("login");
    }


    @RequestMapping(value = "/getAllPerson", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<List<Person>> getAllPerson(){

        List<Person> list = new ArrayList<Person>();

        Person person = new Person();
        person.setId(1);
        person.setName("Somebody");
        person.setAdress("Poznan");
        person.setTel("123123123");
        person.setLogin("login");
        person.setPassword("password");


        Person person2 = new Person();
        person2.setId(1);
        person2.setName("Somebody2");
        person2.setAdress("Poznan2");
        person2.setTel("123123123");
        person2.setLogin("login2");
        person2.setPassword("password2");

        Person person3 = new Person();
        person3.setId(1);
        person3.setName("Somebody3");
        person3.setAdress("Poznan3");
        person3.setTel("123123123");
        person3.setLogin("login3");
        person3.setPassword("password3");

        list.add(person);
        list.add(person2);
        list.add(person3);

        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }
}