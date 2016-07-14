package Controllers;

import bb.DTO.PersonDTO;
import bb.model.Person;
import bb.repository.PersonRepository;
import bb.rest.Application;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Profile;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by bartosz on 11.07.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
@Profile("dev")
public class PersonControllerTest {

    @Autowired(required = false)
    private PersonRepository personRepository;

    private PersonDTO personDTO;

    private String JSonToSend;

    @Before
    public void setUp() throws JsonProcessingException {

        personDTO = new PersonDTO();
        personDTO.setId(1);
        personDTO.setName("Bartek");
        personDTO.setAdress("Poznan");
        personDTO.setTel("45763476");
        personDTO.setLogin("BB");
        personDTO.setPassword("BB");

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        JSonToSend = objectWriter.writeValueAsString(personDTO);

    }

    @Test
    public void helloShouldReportStatusOK() {
        when()
                .get("/hello")
                .then()
                .statusCode(200);
    }

    @Test
    public void bazaShouldReturnBody() {

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1);
        personDTO.setName("Somebody");
        personDTO.setAdress("Poznan");
        personDTO.setTel("123123123");
        personDTO.setLogin("login");
        personDTO.setPassword("password");

        Response response = get("/baza");

        assertEquals(200, response.getStatusCode());
        
        String json = response.asString();
        JsonPath jsonPath = new JsonPath(json);
        //assertTrue("1", jsonPath.get("id" ));
        assertEquals(personDTO.getName(), jsonPath.get("name"));
        assertEquals(personDTO.getAdress(), jsonPath.get("adress"));
        assertEquals(personDTO.getTel(), jsonPath.get("tel"));
        assertEquals(personDTO.getLogin(), jsonPath.get("login"));
        assertEquals(personDTO.getPassword(), jsonPath.get("password"));

    }

    @Test
    public void bazaShouldReturnBody2(){

        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1);
        personDTO.setName("Somebody");
        personDTO.setAdress("Poznan");
        personDTO.setTel("123123123");
        personDTO.setLogin("login");
        personDTO.setPassword("password");

        expect().
                statusCode(200).
                body("name", equalTo(personDTO.getName()),
                     "adress",equalTo(personDTO.getAdress())).
                when().
                get("/baza");
    }


}
