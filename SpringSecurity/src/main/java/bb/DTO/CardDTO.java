package bb.DTO;

/**
 * Created by bartosz on 08.07.16.
 */
public class CardDTO {
    private int id;
    private String name;
    private String value;
    private String accessTo;
    private Boolean access;

    public CardDTO() {
    }

    public CardDTO(String name, String value, String accessTo, Boolean access) {
        this.name = name;
        this.value = value;
        this.accessTo = accessTo;
        this.access = access;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAccessTo() {
        return accessTo;
    }

    public void setAccessTo(String accessTo) {
        this.accessTo = accessTo;
    }

    public Boolean getAccess() {
        return access;
    }

    public void setAccess(Boolean access) {
        this.access = access;
    }
}
