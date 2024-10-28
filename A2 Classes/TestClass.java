import java.util.Scanner;

public class TestClass {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        phonebookManager myPhoneBook = new phonebookManager();
        System.out.println("Welcome to your Phone Book!");
        
        Boolean editing = true;

        do {
            editing = choice(myPhoneBook.getSize(), myPhoneBook);
        }
        while(editing);
    } // end of main method

    public static void menuOpt() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) Add Entry");
        System.out.println("2) Delete Entry");
        System.out.println("3) Modify Entry");
        System.out.println("4) Display Entries");
        System.out.println("5) Quit"); 
    } // end fo intro method

    public static Boolean choice(int size, phonebookManager myPhoneBook) {
        menuOpt();
        int response = input.nextInt();
        input.nextLine();
        switch (response) {
            case 1: // Add Entry
                addOpt(size, myPhoneBook);
                System.out.println(myPhoneBook.getSize());
                break;
            case 2: // Delete Entry
                removeOpt(myPhoneBook);
                break;
            case 3:// Modify Entry
                modifyOpt(myPhoneBook);
                System.out.println(myPhoneBook.getSize());
                break;
            case 4: // Display Entries
                System.out.println(myPhoneBook.printList());
                break;
            case 5: // exit the program
                return false;
            default:
                System.out.println("That is not a valid option. Try again.");
        } // end of swtich statement
        return true;
    } // end of menu method

    public static void addOpt(int size, phonebookManager myPhoneBook) {
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Address: ");
        String address = input.nextLine();
        System.out.println("City: ");
        String city = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        myPhoneBook.add(firstName, lastName, address, city, phoneNumber);
    } // end of addOpt menu

    public static void removeOpt(phonebookManager myPhoneBook) {
        System.out.println(myPhoneBook.printList());
        System.out.println("\nWhich entry would you like to remove?");
        int entryNum = input.nextInt();
        input.nextLine();
        myPhoneBook.removeAtIndex(entryNum - 1);
    }

    public static void modifyOpt(phonebookManager myPhoneBook) {
        System.out.println("\n" + myPhoneBook.printList());
        System.out.println("\nWhich entry would you like to modify?");
        int entryNum = input.nextInt();
        input.nextLine();
        int index = entryNum - 1;
        //myPhoneBook.removeAtIndex(entryNum - 1);
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Address: ");
        String address = input.nextLine();
        System.out.println("City: ");
        String city = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        myPhoneBook.addAtIndex(index, firstName, lastName, address, city, phoneNumber);
    }
} // end of TestClass Class


