package Maids.cc.example.Hussein.Yousef.dto.requests;

import javax.persistence.Column;
import java.io.Serializable;

public class addClientRequest implements Serializable {


    String firstName;

    String lastName;

    Long mobilePhone;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(Long mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
