package Services;

import bb.DTO.PersonDTO;
import bb.Services.RegisterPersonService;
import bb.model.Person;
import bb.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by bartosz on 08.07.16.
 */
@ContextConfiguration(classes = RegisterPersonService.class)
public class RegisterPersonServiceTest {

    @InjectMocks
    private RegisterPersonService registerPersonService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUserShouldReturnFalse() {
        PersonDTO personDTO = new PersonDTO();
        //personDTO.setId(1);
        personDTO.setName("Bartek");
        personDTO.setAdress("Poznan");
        personDTO.setTel("123412341");
        personDTO.setLogin("BBlogin");
        personDTO.setPassword("PPPassword");

        Person person = new Person();
        person.setId(1);
        person.setName(personDTO.getName());
        person.setAdress(personDTO.getAdress());
        person.setTel(personDTO.getTel());
        person.setLogin(personDTO.getLogin());
        person.setPassword(personDTO.getPassword());

        when(personRepository.findByLogin(personDTO.getLogin())).thenReturn(person);

        assertFalse(registerPersonService.RegisterPerson(personDTO));

    }

    @Test
    public void registerUserShouldReturnTrue() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1);
        personDTO.setName("Bartek");
        personDTO.setAdress("Poznan");
        personDTO.setTel("123412341");
        personDTO.setLogin("BBlogin");
        personDTO.setPassword("PPPassword");

        Person person = new Person();
        person.setId(1);
        person.setName(personDTO.getName());
        person.setAdress(personDTO.getAdress());
        person.setTel(personDTO.getTel());
        person.setLogin(personDTO.getLogin());
        person.setPassword(personDTO.getPassword());

        when(personRepository.findByLogin(personDTO.getLogin())).thenReturn(null);

        assertTrue(registerPersonService.RegisterPerson(personDTO));

    }
}
