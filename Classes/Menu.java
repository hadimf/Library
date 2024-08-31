
public class Menu {

    public static byte mainMenu() {
        System.out.println("Welcome to Library :)");
        System.out.println("1.Manage Persons");
        System.out.println("2.Manage Books");
        System.out.println("3.Books Lending Management");
        System.out.println("4.Exit");
        System.out.println("Enter a Number :");
        return Byte.parseByte(System.console().readLine());

    }

    public static byte managePersonsMenu() {
        System.out.println("1.Create Person");
        System.out.println("2.Read Person");
        System.out.println("3.Edit Person");
        System.out.println("4.Delete Person");
        System.out.println("5.Back to Menu");
        System.out.println("6.Exit");
        System.out.println("Enter a Number :");

        return Byte.parseByte(System.console().readLine());
    }

    public static byte manageBooksMenu() {
        System.out.println("1.Create Book");
        System.out.println("2.Read Book");
        System.out.println("3.Edit Book");
        System.out.println("4.Delete Book");
        System.out.println("5.Back to Menu");
        System.out.println("6.Exit");
        System.out.println("Enter a Number :");

        return Byte.parseByte(System.console().readLine());
    }

    public static byte bookLeadingMenu() {
        System.out.println("1.Loan Book");
        System.out.println("2.Return Book");
        System.out.println("3.Back to Menu");
        System.out.println("4.Exit");
        System.out.println("Enter a Number :");

        return Byte.parseByte(System.console().readLine());
    }
}
