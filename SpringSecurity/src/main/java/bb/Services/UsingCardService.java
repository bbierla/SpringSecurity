package bb.Services;

import bb.DTO.CardDTO;
import bb.DTO.PersonDTO;
import bb.model.Card;
import bb.repository.CardRepository;
import bb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bartosz on 08.07.16.
 */
@Service
public class UsingCardService {

    @Autowired(required = false)
    CardRepository cardRepository;

    public boolean addCardOwner(PersonDTO personDTO, CardDTO cardDTO) {
        if (checkOwnerCard(personDTO, cardDTO)) {
            return false;
        } else {
            Card card = new Card();
            card.setId(cardDTO.getId());
            card.setName(cardDTO.getName());
            card.setAccessTo(cardDTO.getAccessTo());
            card.setValue(cardDTO.getValue());
            card.setAccess(true);
            return true;
        }
    }

    public boolean checkOwnerCard(PersonDTO personDTO, CardDTO cardDTO) {// Any Person and Card have the same id (without betweenes classes)

        if (cardRepository.findById(cardDTO.getId()).getId() == personDTO.getId())
            return true;
        else
            return false;
    }

}
