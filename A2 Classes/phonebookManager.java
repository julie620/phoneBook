import java.util.NoSuchElementException;

public class phonebookManager {
    private listNode front;
    private static int size;
    

    public phonebookManager () {
        front = null;
        size = 0;
    } // end of phonebookManager constructor

    // Adds the given value to the end of the list
    public void add(String firstName, String lastName, String address, String city, String phoneNumber) {
        if (front == null) {
            //adding to an empty list
            front = new listNode(firstName, lastName, address, city, phoneNumber);
        }
        else {
            //adding to the end of an existing list
            listNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new listNode (firstName, lastName, address, city, phoneNumber);
        }
        size++;
    } // end of add method


    // Returns value in list at given index
    // Precondition: 0 <= index < size ()
    public String get(int index) {
        listNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.toString();
    } // end of get method

    // Inserts the given value at the given index
    // Precondition: 0 <= index <= size ()
    public void addAtIndex(int index, String firstName, String lastName, String address, String city, String phoneNumber) {
        listNode current = front;
        if (index == 0) {
            // adding to an empty list
            front = new listNode(firstName, lastName, address, city, phoneNumber, current.next);
        }
        else {
            //inserting into an existing list
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new listNode(firstName, lastName, address, city, phoneNumber, current.next);
        }
    } // end of addAtIndex method

    // Removes and returns the first value
    // Throws a NoSuchElementException on empty list
    public String remove() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        else {
            String result = front.firstName;
            front = front.next;
            size--;
            return result;
        }
    } // end of remove method

    public void removeAtIndex(int index) {
        if (index == 0) {
            // special case: removing first element
            front = front.next;
        }
        else {
            //removing from elsewhere in the list
            listNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    } // end of removeAtIndex method

    //Adds given value to list in sorted order
    //Precondition: Existing elements are sorted
    public void addSorted(String firstName, String lastName, String address, String city, String phoneNumber) {
        String checkRank = lastName.toUpperCase().trim();
        char firstLetter = checkRank.charAt(0);
        int rank = (int)firstLetter;
        if (front == null || rank <= front.lastNameRank()) {
            //insert at front of list
            front = new listNode(firstName, lastName, address, city, phoneNumber, front);
        }
        else {
            //insert in middle of list
            listNode current = front;
            while(current.next != null &&
                  current.next.lastNameRank() < rank) {
                current = current.next;
            }
            //current = new listNode(firstName, lastName, address, city, phoneNumber);
        }
        size++;
    }

    public String printList() {
        listNode current = front;
        String list = "Your Phone Book";
        for (int i = 0; i < size; i++) {
            int entryNum = i + 1;
            list = list.concat("\n\n" + "Entry " + entryNum + "\n" + current.toString());
            current = current.next;
        }
        return list;
    }

    public int getSize() {
        return size;
    }

} // end of phonebookManager class
