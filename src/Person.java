import java.util.Scanner;

public class Person {
    private String name;
    private int birthyear;
    private String gender;
    private String address;
    private String phonenumber;
    private String email;
    protected static Scanner sc = new Scanner(System.in);

    public Person() {
        name = "";
        birthyear = 2004;
        gender = "Male";
        address = "";
        phonenumber = "";
        email = "";
    }

    public Person(String name, int birthyear, String gender, String address, String phonenumber, String email) {
        this.name = name;
        this.birthyear = birthyear;
        this.gender = gender;
        this.address = address;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        while (name.isBlank() || !name.matches("^[a-zA-Z \\-\\.\\']*$")) {
            System.out.print("Họ tên không hợp lệ. Vui lòng nhập lại: ");
            name = sc.nextLine();
        }
        this.name = name.trim();
    }

    public void setBirthyear(int birthyear) {
        while (2022 - birthyear < 18 || 2022 - birthyear > 65) {
            System.out.print("Tuổi không phù hợp. Vui lòng nhập lại: ");
            birthyear = Integer.parseInt(sc.nextLine());
        }
        this.birthyear = birthyear;
    }

    public void setGender(String gender) {
        while (gender.compareToIgnoreCase("male") != 0 && gender.compareToIgnoreCase("female") != 0) {
            System.out.print("Giới tính không hợp lệ. Vui lòng nhập lại: ");
            gender = sc.nextLine();
        }
        this.gender = gender;
    }

    public void setAddress(String address) {
        while (address.isBlank()) {
            System.out.print("Địa chỉ không hợp lệ. Vui lòng nhập lại: ");
            address = sc.nextLine();
        }
        this.address = address.trim();
    }

    public void setPhonenumber(String phonenumber) {
        while (!phonenumber.matches("^0[9837]{1}\\d{8}$")) {
            System.out.print("Số điện thoại không hợp lệ. Vui lòng nhập lại: ");
            phonenumber = sc.nextLine();
        }
        this.phonenumber = phonenumber;
    }

    public void setEmail(String email) {
        while (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            System.out.print("Email không hợp lệ. Vui lòng nhập lại: ");
            email = sc.nextLine();
        }
        this.email = email.trim();
    }

    @Override
    public String toString() {
        return String.format("%-25s|%-6d|%-8s|%-50s|%-15s|%-20s",name,birthyear,gender,address,phonenumber,email);
    }

    public int calculateAge() {
        return 2022 - birthyear;
    }
    public void input() {
        System.out.print("Hãy nhập họ và tên: ");
        setName(sc.nextLine());
        System.out.print("Hãy nhập năm sinh: ");
        setBirthyear(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy nhập giới tính (male, female): ");
        setGender(sc.nextLine());
        System.out.print("Hãy nhập địa chỉ: ");
        setAddress(sc.nextLine());
        System.out.print("Hãy nhập số điện thoại: ");
        setPhonenumber(sc.nextLine());
        System.out.print("Hãy nhập email: ");
        setEmail(sc.nextLine());
    }
}
