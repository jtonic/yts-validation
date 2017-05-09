package ro.jtonic.isr.yts.validation.model.dto;

import com.google.common.base.MoreObjects;

import java.util.UUID;

/**
 * Created by Antonel Ernest Pazargic on 09/05/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public class PersonDto {
    private String id;
    private String name;
    private Integer age;

    public PersonDto() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("id", id)
                          .add("name", name)
                          .add("age", age)
                          .toString();
    }
}
