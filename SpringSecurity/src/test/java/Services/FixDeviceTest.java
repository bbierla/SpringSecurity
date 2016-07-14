package Services;

import bb.DTO.DeviceDTO;
import bb.DTO.PersonDTO;

import bb.Services.FixDeviceService;
import bb.model.Device;
import bb.model.Person;
import bb.repository.DeviceRepository;
import bb.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Created by bartosz on 08.07.16.
 */
@ContextConfiguration(classes = FixDeviceTest.class)
public class FixDeviceTest {


    @InjectMocks
    private FixDeviceService fixDeviceService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private DeviceRepository deviceRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void ShouldFixDevice(){
        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(1);
        deviceDTO.setName("Laptop");
        deviceDTO.setCost("2000");
        deviceDTO.setBroken(true);

        Device device = new Device();
        device.setId(1);
        device.setName("Laptop");
        device.setCost("2000");
        device.setBroken(true);

        when(deviceRepository.findByName(deviceDTO.getName())).thenReturn(device);
        assertTrue(fixDeviceService.fixDevice(deviceDTO));
    }

    @Test
    public void PersonShouldFixDevice(){
        PersonDTO personDTO = new PersonDTO();
        //personDTO.setId(1);
        personDTO.setName("Bartek");
        personDTO.setAdress("Poznan");
        personDTO.setTel("123412341");
        personDTO.setLogin("BBlogin");
        personDTO.setPassword("PPPassword");

        Person person = new Person();
        person.setId(1);
        person.setName("Bartek");
        person.setAdress("Poznan");
        person.setTel("123412341");
        person.setLogin("BBlogin");
        person.setPassword("PPPassword");

        DeviceDTO deviceDTO = new DeviceDTO();
        deviceDTO.setId(1);
        deviceDTO.setName("Laptop");
        deviceDTO.setCost("2000");
        deviceDTO.setBroken(true);

        Device device = new Device();
        device.setId(1);
        device.setName("Laptop");
        device.setCost("2000");
        device.setBroken(true);

        when(deviceRepository.findByName(deviceDTO.getName())).thenReturn(device);
        when(personRepository.findByLogin(personDTO.getLogin())).thenReturn(person);


    }

}
