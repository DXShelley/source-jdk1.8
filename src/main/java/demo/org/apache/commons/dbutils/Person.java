package demo.org.apache.commons.dbutils;

import java.time.LocalDate;

public class Person {
    String name;
    Long age;
    String sex;
    LocalDate birthdaty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthdaty() {
        return birthdaty;
    }

    public void setBirthdaty(LocalDate birthdaty) {
        this.birthdaty = birthdaty;
    }
}
