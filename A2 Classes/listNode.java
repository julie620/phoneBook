//Name: Juliana Serrano
//Date: 10/29/2024
//Assignment: 2 - Phone Book
// strutures nodes for list; 5 data fields for phone book entry information (Class 1 of 3)
public class listNode {

    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;
    listNode next;

    public listNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    } // end of ListNode constructor

    public listNode(String firstName, String lastName, String address, String city, String phoneNumber, listNode next) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = next;
    } // end of ListNode constructor

    //returns node in phone book format
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + 
        "\nCity: " + city + "\nPhone Number: " + phoneNumber;
    } // end of toString method
} // end of listNode class
