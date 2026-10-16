package ContactManager;

import java.util.Scanner;

public class ContactManager {
    private Array arr;
    private Assets assets;
    private Scanner input;
    private int size;

    public ContactManager(int size){
        this.size = size;
        arr = new Array(size);
        assets = new Assets();
        input = new Scanner(System.in);
    }

    public void addContact(){
        assets.banner("Add Contact");
        String name;
        String option;
        System.out.print("Enter name : ");
        name = input.nextLine();
        while (true) {
            System.out.println("1. Personal Contact");
            System.out.println("2. Business Contact");
            System.out.print("Enter option : ");
            option = input.nextLine();
            if (option.equals("1") || option.equals("2")) {
                break;
            }else {
                System.out.println("Invalid Option!");
            }
        }
        Contact c;
        if(option.equals("1")){
            String phone;
            System.out.print("Enter Phone : ");
            phone = input.nextLine();
            c = new Personal(name, phone);
        }else {
            String email;
            System.out.print("Enter Email : ");
            email = input.nextLine();
            c = new Business(name, email);
        }
        arr.add(c);
        System.out.println("Contact add success!");
        System.out.println();
    }
    public void contactList(){
        assets.banner("Contact Lists");
        if(arr.isEmpty()){
            System.out.println("No contact list!");
        }else {
            for(int i=0; i<arr.getCount(); i++){
                Contact show = (Contact) arr.get(i);
                show.displayContact();
            }
        }
    }
    public void search(){
        assets.banner("Search Contact");
        String name;
        Array matchContacts = new Array(size);
        System.out.print("Enter name to search : ");
        name = input.nextLine();
        for(int i=0; i<arr.getCount(); i++){
            Contact search = (Contact) arr.get(i);
            if(search.getName().toLowerCase().contains(name.toLowerCase())){
                matchContacts.add(search);
            }
        }
        if(matchContacts.isEmpty()){
            System.out.println("No contact list!");
        }else {
            for(int i=0; i<matchContacts.getCount(); i++){
                Contact show = (Contact) matchContacts.get(i);
                show.displayContact();
            }
        }
    }
    public void edit(){
        String name;
        assets.banner("Edit Contact");
        System.out.print("Enter name to edit : ");
        name = input.nextLine();

        int index = searchContactByName(name);

        if(index == -1){
            System.out.println("Contact not found to edit!");
        }else {
            Contact contact = (Contact) arr.get(index);
            contact.displayContact();

            System.out.print("Enter new name : ");
            String editName = input.nextLine();

            Contact editContact;

            if(contact.getType() == ContactType.PERSONAL){
                System.out.print("Enter phone to edit : ");
                String phone = input.nextLine();
                editContact = new Personal(editName, phone);
            }else{
                System.out.print("Enter email to edit : ");
                String email = input.nextLine();
                editContact = new Business(editName, email);
            }

            arr.edit(index, editContact);

            System.out.println("Contact edited successfully!");
        }
    }
    public void delete(){
        assets.banner("Delete Contact");
        String name;
        System.out.print("Enter name to delete : ");
        name = input.nextLine();

        int index = searchContactByName(name);

        if(index == -1){
            System.out.println("Contact not found to delete!");
        }else {
            arr.delete(index);
            System.out.println("Contact delete success....");
        }
    }

    private int searchContactByName(String name) {
        int index = -1;
        for (int i = 0; i < arr.getCount(); i++) {
            Contact contact = (Contact) arr.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
