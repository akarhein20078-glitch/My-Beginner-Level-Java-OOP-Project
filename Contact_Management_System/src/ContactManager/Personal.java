package ContactManager;

public class Personal extends Contact{
    private String phone;

    public Personal(String name, String phone) {
        super(name, ContactType.PERSONAL);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public void displayContact() {
        System.out.println("==============================");
        System.out.println("Name : "+getName());
        System.out.println("Phone : "+getPhone());
        System.out.println("Contact type : "+getType());
        System.out.println("==============================");
    }
}
