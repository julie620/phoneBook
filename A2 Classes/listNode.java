public class listNode {

    String firstName;
    String lastName;
    String address;
    String city;
    String phoneNumber;
    //int data;
    listNode next;

    public listNode(String firstName, String lastName, String address, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        //this.data = data;
        this.next = null;
    } // end of ListNode constructor

    public listNode(String firstName, String lastName, String address, String city, String phoneNumber, listNode next) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        //this.data = data;
        this.next = next;
    } // end of ListNode constructor

    public int lastNameRank() {
        lastName = lastName.toUpperCase().trim();
        char firstLetter = lastName.charAt(0);
        int rank = (int)firstLetter;
        return rank;
    }

    public String toString() {
        return "Entry: " + firstName + ", " + lastName + ", " + address + ", " + city + ", " + 
                phoneNumber;
    }

} // end of listNode class
