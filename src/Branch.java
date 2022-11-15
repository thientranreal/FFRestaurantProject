import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Branch {
    private String id;
    private String name;
    private String address;
    private String openningdate;
    protected static Scanner sc = new Scanner(System.in);

    public Branch() {
        id = "";
        name = "";
        address = "";
        openningdate = "";
    }

    public Branch(String id, String name, String address, String openningdate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.openningdate = openningdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getOpenningdate() {
        return openningdate;
    }

    public void setId(String id) {
        while (id.isBlank()) {
            System.out.print("Mã chi nhánh không hợp lệ. Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        this.id = id.trim();
    }

    public void setName(String name) {
        while (name.isBlank()) {
            System.out.print("Tên chi nhánh không hợp lệ. Vui lòng nhập lại: ");
            name = sc.nextLine();
        }
        this.name = name.trim();
    }

    public void setAddress(String address) {
        while (address.isBlank()) {
            System.out.print("Địa chỉ chi nhánh không hợp lệ. Vui lòng nhập lại: ");
            address = sc.nextLine();
        }
        this.address = address.trim();
    }

    public void setOpenningdate(String openningdate) {
        while (!openningdate.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$") || !checkDate(openningdate)) {
            System.out.print("Ngày khai trương chi nhánh không hợp lệ. Vui lòng nhập lại: ");
            openningdate = sc.nextLine();
        }
        this.openningdate = openningdate;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-20s|%-50s|%-12s",id,name,address,openningdate);
    }
    public void input() {
        System.out.print("Hãy nhập id chi nhánh: ");
        setId(sc.nextLine());
        System.out.print("Hãy nhập tên chi nhánh: ");
        setName(sc.nextLine());
        System.out.print("Hãy nhập địa chỉ chi nhánh: ");
        setAddress(sc.nextLine());
        System.out.print("Hãy nhập ngày khai trương (dd/mm/yyyy): ");
        setOpenningdate(sc.nextLine());
    }
    private boolean checkDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try
        {
            Date d = format.parse(date);
        }
        catch (ParseException e)
        {
            return false;
        }
        return true;
    }
}
