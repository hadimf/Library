public class App {
    public static void main(String[] args) {
        byte choice;
        Book book = new Book();
        Person person = new Person();
        Action action = new Action(person, book);
        do {
            choice = Menu.mainMenu();
            action.mainMenuAction(choice);

        } while (choice > 4);
    }
}
