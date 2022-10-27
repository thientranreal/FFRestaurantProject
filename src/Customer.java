public class Customer extends Person{
    private String id;
    private String customer_type;

    public Customer() {
        id = "";
        customer_type = "normal";
    }

    public Customer(String name, int birthyear, String gender, String address, String phonenumber, String email, String id, String customer_type) {
        super(name, birthyear, gender, address, phonenumber, email);
        this.id = id;
        this.customer_type = customer_type;
    }

    public String getId() {
        return id;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setId(String id) {
        while (id.isBlank()) {
            System.out.print("Mã khách hàng không hợp lệ. Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        this.id = id.trim();
    }

    public void setCustomer_type(String customer_type) {
        System.out.println("Loại KH: normal, bronze, gold, diamond");
        while (customer_type.compareToIgnoreCase("normal") != 0
                && customer_type.compareToIgnoreCase("bronze") != 0
                && customer_type.compareToIgnoreCase("gold") != 0
                && customer_type.compareToIgnoreCase("diamond") != 0) {
            System.out.print("Loại khách hàng không hợp lệ. Vui lòng nhập lại: ");
            customer_type = sc.nextLine();
        }
        this.customer_type = customer_type;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-10s|%s", id, customer_type, super.toString());
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Hãy nhập mã khách hàng: ");
        setId(sc.nextLine());
        System.out.print("Hãy nhập loại khách hàng: ");
        setCustomer_type(sc.nextLine());
    }
}
