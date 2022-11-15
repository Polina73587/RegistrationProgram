import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main implements Serializable {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello! It's a registration. Please, enter your data (id, firstname, lastname,  birthday, number) comma-separated, if you want to follow our website!");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String replaceSpaces = input.replaceAll(" ", "");
        String[] dataWords = replaceSpaces.split(",");

        String id = dataWords[0];
        String firstname = dataWords[1];
        String lastname = dataWords[2];
        String birthday = dataWords[3];
        String number = dataWords[4];

        Pattern patternForId = Pattern.compile("\\d{8}");
        Matcher matcherId = patternForId.matcher(id);
        Pattern patternForFirstnameAndForLastname = Pattern.compile("[A-Z][a-z]{2,}");
        Matcher matcherFirstname = patternForFirstnameAndForLastname.matcher(firstname);
        Matcher matcherLastname = patternForFirstnameAndForLastname.matcher(lastname);
        Pattern patternForBirthday = Pattern.compile("\\d{2}[\\/\\.]\\d{2}[\\/\\.]\\d{4}");
        Matcher matcherBirthday = patternForBirthday.matcher(birthday);
        Pattern patternForNumber = Pattern.compile("8\\d{10}");
        Matcher matcherNumber = patternForNumber.matcher(number);
        String[] DayMonthYearOfBirth = birthday.split("\\/|\\.|\\-");

        LocalDate today = LocalDate.now();
        LocalDate age1 = LocalDate.of(Integer.parseInt(DayMonthYearOfBirth[2]), Month.values()[Integer.parseInt(DayMonthYearOfBirth[1]) - 1], Integer.parseInt(DayMonthYearOfBirth[0]));
        Period age = Period.between(age1, today);
        String age2 = age.toString();
        String age22 = age2.replaceAll("P", "");
        int ageFinal = Integer.parseInt(age22.substring(0, age22.indexOf("Y")));
        Person person = new Person(id, firstname, lastname, age , birthday, number);
        Set people = new HashSet();
        people.add(person);
        if (!(ageFinal >= 18 && ageFinal < 100 && matcherId.find() && matcherFirstname.find() && matcherLastname.find() && matcherBirthday.find() && matcherNumber.find()
        ))
            throw new Exception("try again :(");

        FileOutputStream fileOutputStream = new FileOutputStream("people.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(people + "\n");
        objectOutputStream.close();
        System.out.println("Your data has been successfully recorded!");
    }


}