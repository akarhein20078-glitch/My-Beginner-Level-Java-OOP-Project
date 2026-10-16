package ContactManager;

public class Business extends Contact{
    private String email;

    public Business(String name, String email) {
        super(name, ContactType.BUSINESS);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void displayContact() {
        System.out.println("==============================");
        System.out.println("Name : "+getName());
        System.out.println("Email : "+getEmail());
        System.out.println("Contact type : "+getType());
        System.out.println("==============================");
    }
}
