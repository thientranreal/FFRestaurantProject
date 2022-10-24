public class Employee extends Person{
    private String id;
    private int wage;
    private String type;
    private String workingarea;
    private Branch workingbranch;

    public Employee() {
        id = "";
        wage = 0;
        type = "";
        workingarea = "";
        workingbranch = new Branch();
    }

    public Employee(String name, int birthyear, String gender, String address, String phonenumber, String email, String id, int wage, String type, String workingarea, Branch workingbranch) {
        super(name, birthyear, gender, address, phonenumber, email);
        this.id = id;
        this.wage = wage;
        this.type = type;
        this.workingarea = workingarea;
        this.workingbranch = workingbranch;
    }

    public Employee(Branch workingbranch) {
        id = "";
        wage = 0;
        type = "";
        workingarea = "";
        this.workingbranch = workingbranch;
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

    public Branch getWorkingbranch() {
        return workingbranch;
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
        while (type.compareToIgnoreCase("full-time") != 0 && type.compareToIgnoreCase("part-time") != 0) {
            System.out.print("Loại nhân viên không hợp lệ. Vui lòng nhập lại: ");
            type = sc.nextLine();
        }
        this.type = type;
    }

    public void setWorkingarea(String workingarea) {
        while (workingarea.compareToIgnoreCase("kitchen") != 0
                && workingarea.compareToIgnoreCase("counter") != 0
                && workingarea.compareToIgnoreCase("toilet") != 0
                && workingarea.compareToIgnoreCase("parking lot") != 0) {
            System.out.print("Khu vực làm việc không hợp lệ. Vui lòng nhập lại: ");
            workingarea = sc.nextLine();
        }
        this.workingarea = workingarea;
    }

    public void setWorkingbranch(Branch workingbranch) {
        this.workingbranch = workingbranch;
    }

    @Override
    public String toString() {
        return String.format("%-10s|%-10d|%-10s|%-13s|%s|%-10s", id, wage, type, workingarea, super.toString(), workingbranch.getId());
    }

    @Override
    public void input() {
        super.input();
        System.out.print("Hãy nhập mã nhân viên: ");
        setId(sc.nextLine());
        System.out.print("Hãy nhập lương theo giờ: ");
        setWage(Integer.parseInt(sc.nextLine()));
        System.out.print("Hãy nhập loại nhân viên: ");
        setType(sc.nextLine());
        System.out.print("Hãy nhập khu vực làm việc: ");
        setWorkingarea(sc.nextLine());
    }
}
