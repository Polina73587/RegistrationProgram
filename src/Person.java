import java.io.Serializable;
import java.time.Period;

public class Person implements Serializable {
    public static void main(String[] args) {

    }
    private String id;
    private String firstname;
    private String lastname;
    private String age;
    private String birthday;
    private String number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Person(String id, String firstname, String lastname, Period age, String birthday, String number) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = String.valueOf(age);
        this.birthday = birthday;
        this.number = number;
    }

    @Override
    public String toString() {

        return "[" + id + "-" + firstname + "-" + lastname + "-" + age  + "-" + birthday + "-" + number + "]";
    }



}
