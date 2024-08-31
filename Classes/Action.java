
public class Action {

    private Person person;
    private Book book;

    public Action(Person person, Book book) {
        this.person = person;
        this.book = book;
    }

    public void mainMenuAction(byte choice) {
        byte option;
        while (true) {

            switch (choice) {
                case 1:
                    option = Menu.managePersonsMenu();
                    managePersonsAction(option);
                    break;

                case 2:
                    option = Menu.manageBooksMenu();
                    manageBooksAction(option);
                    break;
                case 3:
                    option = Menu.bookLeadingMenu();
                    bookLeadingAction(option);
                    break;

                case 4:
                    System.exit(0);
                    break;
                default:
            }
        }
    }

    public void managePersonsAction(byte choice) {
        byte option;

        switch (choice) {
            case 1:
                person = Person.createPerson();
                Person.addPersonById(person.getID(), person);
                System.out.println("Person's Id : " + person.getID());

                break;
            case 2:
                System.out.println("Enter Id of Person: ");
                byte personId = Byte.parseByte(System.console().readLine());
                person = Person.setPersonById(personId);
                if (person != null) {
                    person.readPersonById(personId);
                } else {
                    System.out.println("there is no user!!!");

                }
                break;
            case 3:
                if (person != null) {
                    person.updatePersonById();

                } else {
                    System.out.println("there is no user!!!");
                }
                break;
            case 4:
                if (person != null) {
                    person.removePersonById();

                } else {
                    System.out.println("there is no user!!!");
                }
            case 5:
                option = Menu.mainMenu();
                mainMenuAction(option);
                break;
            case 6:
                System.exit(0);
                break;

            default:
                System.out.println("Select a sutibale choice.");
        }
    }

    public void manageBooksAction(byte choice) {
        byte option;
        switch (choice) {
            case 1:
                book = Book.createBook();
                Book.addBookById(book.getID(), book);
                System.out.println("Book's Id : " + book.getID());
                break;
            case 2:
                if (book != null) {
                    book.readBookById();

                } else {
                    System.out.println("there is no book!!!");
                }
                break;
            case 3:
                if (book != null) {
                    book.updateBookById();

                } else {
                    System.out.println("there is no book!!!");
                }
                break;
            case 4:
                if (book != null) {
                    book.removeBookById();

                } else {
                    System.out.println("there is no book!!!");
                }
                break;
            case 5:
                option = Menu.mainMenu();
                mainMenuAction(option);
                break;
            case 6:
                System.exit(0);

                break;
            default:
                System.out.println("Select suitable number");

        }
    }

    public void bookLeadingAction(byte choice) {
        byte option;
        byte personId;
        switch (choice) {
            case 1:
                System.out.println("Enter Id of Person: ");
                personId = Byte.parseByte(System.console().readLine());
                person = Person.setPersonById(personId);
                if (person == null) {
                    break;
                }
                System.out.println("Enter Id of Book: ");
                byte bookId = Byte.parseByte(System.console().readLine());
                boolean isExist = Book.checkExist(bookId);
                book = Book.setBookById(bookId);
                if (isExist) {
                    if (person != null) {
                        person.loanedBookIds.add(bookId);
                        person.loanedBooks.add(book);
                        
                    } else {
                        System.out.println("Problem");

                    }
                }
                break;
            case 2:
                System.out.println("Enter Id of Person: ");
                personId = Byte.parseByte(System.console().readLine());
                person = Person.setPersonById(personId);
                System.out.println("Enter Id of Book: ");
                bookId = Byte.parseByte(System.console().readLine());
                boolean isNotExist = Book.checkNotExist(bookId);
                if (isNotExist) {
                    if (person != null) {
                        person.loanedBookIds.remove(((Byte) bookId));

                    } else {
                        System.out.println("Problem");

                    }
                }
                break;
            case 3:
                option = Menu.mainMenu();
                mainMenuAction(option);
                break;
            case 4:
                System.exit(0);
                break;

            default:
                System.out.println("Select suitable number");

        }
    }

}
