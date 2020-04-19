package one;

public class Test {
    public static void main(String[] args){
        PersonInput personInput = new PersonInput();
        Person person = new Person();
        Person person1 = personInput.process(person);
        PersonDisplay personDisplay = new PersonDisplay();
        personDisplay.process(person1);
    }
}
