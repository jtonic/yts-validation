package ro.jtonic.isr.yts.validation.model;

import com.google.common.base.MoreObjects;
import org.hibernate.validator.constraints.NotBlank;
import ro.jtonic.isr.yts.validation.validators.PhoneNumberConstraint;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public class PersonQuery {
    @NotBlank(message = "username cannot be empty!")
    private String name;
    private Integer age;
    @PhoneNumberConstraint
    private String phoneNumber;

    public PersonQuery(String name, Integer age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public PersonQuery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("name", name)
                          .add("age", age)
                          .add("phone", phoneNumber)
                          .toString();
    }
}
