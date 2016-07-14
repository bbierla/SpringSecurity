package bb.DTO;

import bb.model.Card;

/**
 * Created by bartosz on 08.07.16.
 */
public class PersonDTO {
    private int id;
    private String name;
    private String adress;
    private String tel;
    private String login;
    private String password;
    private Card card;

    public PersonDTO() {
    }

    public PersonDTO(String name, String adress, String tel, String login, String password) {
        this.name = name;
        this.adress = adress;
        this.tel = tel;
        this.login = login;
        this.password = password;
    }

    public PersonDTO(String name, String adress, String tel, String login, String password, Card card) {
        this.name = name;
        this.adress = adress;
        this.tel = tel;
        this.login = login;
        this.password = password;
        this.card = card;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s', adress='%s', tel='%s']", id, name, adress, tel);
    }
}
