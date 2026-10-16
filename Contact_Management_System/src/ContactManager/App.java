package ContactManager;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactManager c = new ContactManager(50);
        String option;

        while(true){
            System.out.println("1. Add Contact");
            System.out.println("2. Contact Lists");
            System.out.println("3. Search Contact");
            System.out.println("4. Edit Contact");
            System.out.println("5. Delete Contact");
            System.out.println("0. Exit");
            System.out.print("Enter Option : ");
            option = input.nextLine();
            switch (option){
                case "1":
                    c.addContact();
                    break;
                case "2":
                    c.contactList();
                    break;
                case "3":
                    c.search();
                    break;
                case "4":
                    c.edit();
                    break;
                case "5":
                    c.delete();
                    break;
                case "0":
                    System.out.println("Exit....!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Option!");
            }
        }

    }
}
