//Name: Juliana Serrano
//Date: 10/29/2024
//Assignment: 2 - Phone Book
// Description: allows a user to add, remove, modify, and display entries in a phone book (Class 3 of 3)

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

    // displays menu options
    public static void menuOpt() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) Add Entry");
        System.out.println("2) Delete Entry");
        System.out.println("3) Modify Entry");
        System.out.println("4) Display Entries");
        System.out.println("5) Quit"); 
    } // end of intro method

    // keeps program running and options shown until user quits
    public static Boolean choice(int size, phonebookManager myPhoneBook) {
        menuOpt();
        int response = input.nextInt();
        input.nextLine();
        switch (response) {
            case 1: // Add Entry
                addOpt(size, myPhoneBook);
                break;
            case 2: // Delete Entry
                removeOpt(myPhoneBook);
                break;
            case 3:// Modify Entry
                modifyOpt(myPhoneBook);
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

    // adds entries to the phone book
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

    // removes entries from the phone book
    public static void removeOpt(phonebookManager myPhoneBook) {
        System.out.println(myPhoneBook.printList());
        System.out.println("\nWhich entry would you like to remove?");
        int entryNum = input.nextInt();
        input.nextLine();
        myPhoneBook.removeIndex(entryNum - 1);
    } // end of removeOpt method

    // gets the index for modify entry option
    public static int entryIndex(phonebookManager myPhoneBook) {
        System.out.println("\n" + myPhoneBook.printList());
        System.out.println("\nWhich entry would you like to modify?");
        int entryNum = input.nextInt();
        input.nextLine();
        int index = entryNum - 1;
        return index;
    } // end of entryIndex method

    // gets field for modify entry option
    public static int fieldOpt(phonebookManager myPhoneBook) {
        System.out.println("Which field would you like to modify?");
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Address");
        System.out.println("4) City");
        System.out.println("5) Phone Number");
        int field = input.nextInt();
        input.nextLine();
        return field;
    } // end of fieldOpt mehtod

    // modifies entries in phone book
    public static void modifyOpt(phonebookManager myPhoneBook) {
        int index = entryIndex(myPhoneBook);
        int field = fieldOpt(myPhoneBook);
        System.out.print("Enter new information: ");
        switch(field) {
            case 1:
                modFirst(myPhoneBook, index);
                break;
            case 2:
                modLast(myPhoneBook, index);
                break;
            case 3:
                modAddress(myPhoneBook, index);
                break;
            case 4:
                modCity(myPhoneBook, index);
                break;
            case 5:
                modPhone(myPhoneBook, index);
                break;
        }   
    } // end of moidfyOpt method

    // modifies first name field of an entry
    public static void modFirst(phonebookManager myPhoneBook, int index) {
        String newFirst = input.nextLine();
        myPhoneBook.addIndex(index, newFirst, myPhoneBook.getLast(index), 
                myPhoneBook.getAddress(index), myPhoneBook.getCity(index), 
                myPhoneBook.getPhone(index));
    } // end of modFirst method

    // modifies last name field of an entry
    public static void modLast(phonebookManager myPhoneBook, int index) {
        String newLast = input.nextLine();
        myPhoneBook.addIndex(index, myPhoneBook.getFirst(index), newLast, 
                myPhoneBook.getAddress(index), myPhoneBook.getCity(index), 
                myPhoneBook.getPhone(index));
    } // end of modLast method

    // modifies address field of an entry
    public static void modAddress(phonebookManager myPhoneBook, int index) {
        String newAddress = input.nextLine();
        myPhoneBook.addIndex(index, myPhoneBook.getFirst(index), myPhoneBook.getLast(index),
                newAddress, myPhoneBook.getCity(index), myPhoneBook.getPhone(index));
    } // end of modAddress method

    // modifies city field of an entry
    public static void modCity(phonebookManager myPhoneBook, int index) {
        String newCity = input.nextLine();
        myPhoneBook.addIndex(index, myPhoneBook.getFirst(index), myPhoneBook.getLast(index),
                myPhoneBook.getAddress(index), newCity, myPhoneBook.getPhone(index));
    } // end of modCity method

    // modifies phone number field of an entry
    public static void modPhone(phonebookManager myPhoneBook, int index) {
        String newPhoneNum = input.nextLine();
        myPhoneBook.addIndex(index, myPhoneBook.getFirst(index), myPhoneBook.getLast(index),
                myPhoneBook.getAddress(index), myPhoneBook.getCity(index), newPhoneNum);
    } // end of modPhone method
} // end of TestClass Class