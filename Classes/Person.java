
import java.util.ArrayList;
import java.util.HashMap;

public class Person {

    private final byte ID;
    private String _name;
    private short _age;
    private char _gender;
    public ArrayList<Byte> loanedBookIds;

    private static HashMap<Byte, Person> _persons = new HashMap<>();
    private static byte _count;

    public byte getID() {
        return ID;
    }

    public Person(){
        this.ID = 0;

    }
    public Person(String name, short age, char gender) {
        _count++;
        this.ID = _count;
        this._name = name;
        this._age = age;
        this._gender = gender;
        loanedBookIds = new ArrayList<>();
    }
   

    public static Person createPerson() {
        System.out.println("Enter name of  person:");
        String name = System.console().readLine();

        System.out.println("Enter Age of Person:");
        short age = Short.parseShort(System.console().readLine());

        System.out.println("Enter Gander of Person:");
        char gender = System.console().readLine().charAt(0);

        return new Person(name, age, gender);
    }

    public static void addPersonById(Byte id, Person person) {
        _persons.put(id, person);
    }

    public void readPersonById(byte personId) {

        Person person = _persons.get(personId);
        if (person != null) {
            System.out.println("Name Person : " + person._name);
            System.out.println("Age Person : " + person._age);
            System.out.println("Gender Person : " + person._gender);
        } else {
            System.out.println("Not Found");
        }
        for (byte bookid : loanedBookIds) {
            System.out.println("book id: " + bookid);
        }

    }

    public static Person setPersonById(byte personId) {

        Person person = _persons.get(personId);
        if (person == null) {
            System.out.println("Enter correct number.");
        }
        return person;

    }

    public void updatePersonById() {
        System.out.println("Enter Id of Person: ");
        byte personId = Byte.parseByte(System.console().readLine());

        Person person = _persons.get(personId);
        if (person != null) {
            System.out.println("Name Person : ");
            person._name = System.console().readLine();
            System.out.println("Age Person : ");
            person._age = Short.parseShort(System.console().readLine());
            System.out.println("Gender Person : ");
            person._gender = System.console().readLine().charAt(0);
            System.out.println("Updated.!!!");
        } else {
            System.out.println("Not Found");
        }
    }

    public void removePersonById() {
        System.out.println("Enter Id of Person: ");
        byte personId = Byte.parseByte(System.console().readLine());
        boolean isExist = false;
        isExist = _persons.containsKey(personId);
        if (isExist) {
            _persons.remove(personId);
        } else {
            System.out.println("Not Found");
        }

    }
}
