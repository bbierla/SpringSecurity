package bb.Services;

import bb.DTO.DeviceDTO;
import bb.DTO.PersonDTO;
import bb.model.Device;
import bb.model.Person;
import bb.repository.DeviceRepository;
import bb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bartosz on 08.07.16.
 */
@Service
public class FixDeviceService {


    @Autowired(required = false)
    private PersonRepository personRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public boolean fixDevice(DeviceDTO deviceDTO) {
        if (checkDeviceBroken(deviceDTO.getName())) {

            Device device1 = new Device();
            device1.setId(deviceDTO.getId());
            device1.setName(deviceDTO.getName());
            device1.setCost(deviceDTO.getCost());
            device1.setBroken(false);

            deviceRepository.save(device1);
            return true;
        } else return false;
    }

    public boolean fixDeviceByPerson(DeviceDTO deviceDTO, PersonDTO personDTO) {
        if(checkDeviceBroken(deviceDTO.getName())){

            Device device1 = new Device();
            device1.setId(deviceDTO.getId());
            device1.setName(deviceDTO.getName());
            device1.setCost(deviceDTO.getCost());
            device1.setBroken(false);

            Person person = new Person();
            person.setId(personDTO.getId());
            person.setName(personDTO.getName());
            person.setAdress(personDTO.getAdress());
            person.setLogin(personDTO.getLogin());
            person.setPassword(personDTO.getPassword());

            deviceRepository.save(device1);
            return true;
        }else return false;
    }

    public boolean checkDeviceBroken(String name) {
        if (deviceRepository.findByName(name).isBroken()) {
            return true;
        } else return false;
    }
}
