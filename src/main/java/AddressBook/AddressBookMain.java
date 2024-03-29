package AddressBook;
import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome to the Multi-Address Book Program!");

        Scanner sc = new Scanner(System.in);
        AddressBookManager manager = new AddressBookManager();

        while(true){
            System.out.println("\nChoose an option:");
            System.out.println("1. Add New Address Book");
            System.out.println("2. Access Address Book");
            System.out.println("3. List Address Books");
            System.out.println("4. Quit");

            String option = sc.nextLine();

            switch(option){
                case "1":
                    System.out.print("Enter name for new address book: ");
                    String bookName = sc.nextLine();
                    manager.addAddressBook(bookName);
                    break;
                case "2":
                    System.out.print("Enter name of address book to access: ");
                    String name = sc.nextLine();
                    if (manager.addressBookExists(name)) {
                        accessAddressBook(manager.getAddressBook(name), sc);
                    } else {
                        System.out.println("Address book not found.");
                    }
                    break;
                case "3":
                    manager.listAddressBooks();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option! Please enter a valid number.");
            }
        }
    }

    private static void accessAddressBook(AddressBook addressBook, Scanner sc) {
        while(true){
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Return to Main Menu");

            String option = sc.nextLine();

            switch(option){
                case "1":
                    addressBook.addContact(sc);
                    break;
                case "2":
                    addressBook.editContact(sc);
                    break;
                case "3":
                    addressBook.deleteContact(sc);
                    break;
                case "4":
                    addressBook.displayAllContacts();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid option! Please enter a number between 1 and 5.");
            }
        }
    }
}
