public class Employee extends Person implements ICalculateSalary {
    private String id;
    private int wage;
    private String type;
    private String workingarea;
    private String branchID;
    private int workingdays;

    public Employee() {
        id = "";
        wage = 0;
        type = "";
        workingarea = "";
        branchID = "";
        workingdays = 0;
    }

    public Employee(String name, int birthyear, String gender, String address, String phonenumber, String email, String id, int wage, String type, String workingarea, String branchID, int workingdays) {
        super(name, birthyear, gender, address, phonenumber, email);
        this.id = id;
        this.wage = wage;
        this.type = type;
        this.workingarea = workingarea;
        this.branchID = branchID;
        this.workingdays = workingdays;
    }

    public String getId() {
        return id;
    }

    public int getWage() {
        return wage;
    }

    public String getType() {
        return type;
    }

    public String getWorkingarea() {
        return workingarea;
    }

    public String getBranchID() {
        return branchID;
    }

    public int getWorkingdays() {
        return workingdays;
    }

    public void setId(String id) {
        while (id.isBlank()) {
            System.out.print("Mã nhân viên không hợp lệ. Vui lòng nhập lại: ");
            id = sc.nextLine();
        }
        this.id = id.trim();
    }

    public void setWage(int wage) {
        while (wage <= 0) {
            System.out.print("Lương không hợp lệ. Vui lòng nhập lại: ");
            wage = Integer.parseInt(sc.nextLine());
        }
        this.wage = wage;
    }

    public void setType(String type) {
        System.out.println("Loại NV: full-time và part-time");
        while (type.compareToIgnoreCase("full-time") != 0 && type.compareToIgnoreCase("part-time") != 0) {
            System.out.print("Loại nhân viên không hợp lệ. Vui lòng nhập lại: ");
            type = sc.nextLine();
        }
        this.type = type;
    }

    public void setWorkingarea(String workingarea) {
        System.out.println("Khu vực làm việc: kitchen, counter, toilet, parking lot");
        while (workingarea.compareToIgnoreCase("kitchen") != 0
                && workingarea.compareToIgnoreCase("counter") != 0
                && workingarea.compareToIgnoreCase("toilet") != 0
                && workingarea.compareToIgnoreCase("parking lot") != 0) {
            System.out.print("Khu vực làm việc không hợp lệ. Vui lòng nhập lại: ");
            workingarea = sc.nextLine();
        }
        this.workingarea = workingarea;
    }

    public void setBranchID(String branchID) {
        while (branchID.isBlank()) {
            System.out.print("Mã chi nhánh không hợp lệ. Vui lòng nhập lại: ");
            branchID = sc.nextLine();
        }
        this.branchID = branchID;
    }

    public void setWorkingdays(int workingdays) {
        while (workingdays < 0 || workingdays > 31) {
            System.out.print("Số ngày làm việc không hợp lệ. Vui lòng nhập lại: ");
            workingdays = Integer.parseInt(sc.nextLine());
        }
        this.workingdays = workingdays;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-10d|%-10s|%-13s|%s|%-10s|%-11d", id, wage, type, workingarea, super.toString(), branchID, workingdays);
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Hãy nhập mã nhân viên: ");
        setId(sc.nextLine());
        System.out.print("Hãy nhập lương một ngày: ");
        setWage(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy nhập loại nhân viên: ");
        setType(sc.nextLine());
        System.out.print("Hãy nhập khu vực làm việc: ");
        setWorkingarea(sc.nextLine());
        System.out.print("Hãy nhập số ngày làm việc: ");
        setWorkingdays(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy nhập mã chi nhánh làm việc: ");
        setBranchID(sc.nextLine());
    }

    @Override
    public int calSalary() {
        return 0;
    }
}
