package Services;

import bb.DTO.CardDTO;
import bb.DTO.PersonDTO;
import bb.Services.UsingCardService;
import bb.model.Card;
import bb.model.Person;
import bb.repository.CardRepository;
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
@ContextConfiguration(classes = UsingCardService.class)
public class UsingCardTest {

    @InjectMocks
    UsingCardService usingCardService;

    @Mock
    CardRepository cardRepository;

    @Mock
    PersonRepository personRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void checkOwnerCardShouldReturnTrue() {
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

        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(1);
        cardDTO.setName("KartaPierwsza");
        cardDTO.setValue("123423");
        cardDTO.setAccessTo("Firm");
        cardDTO.setAccess(true);

        Card card = new Card();
        card.setId(1);
        card.setName("KartaPierwsza");
        card.setValue("123423");
        card.setAccessTo("Firm");
        card.setAccess(true);


        when(cardRepository.findById(cardDTO.getId())).thenReturn(card);
        when(personRepository.findByLogin(personDTO.getLogin())).thenReturn(person);

        assertTrue(usingCardService.checkOwnerCard(personDTO, cardDTO));
        //assertTrue(usingCardService.addCardOwner(personDTO, cardDTO));
    }

    @Test
    public void checkCardAndNewNewTest() {
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

        CardDTO cardDTO = new CardDTO();
        cardDTO.setId(1);
        cardDTO.setName("KartaPierwsza");
        cardDTO.setValue("123423");
        cardDTO.setAccessTo("Firm");
        cardDTO.setAccess(true);

        Card card = new Card();
        card.setId(1);
        card.setName("KartaPierwsza");
        card.setValue("123423");
        card.setAccessTo("Firm");
        card.setAccess(true);


        when(cardRepository.findById(cardDTO.getId())).thenReturn(card);
        when(personRepository.findByLogin(personDTO.getLogin())).thenReturn(person);

        assertTrue(usingCardService.addCardOwner(personDTO, cardDTO));
    }
}
