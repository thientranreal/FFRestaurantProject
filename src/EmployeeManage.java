import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManage {
    private int amount;
    private Employee[] employeeArray;
    private static Scanner sc = new Scanner(System.in);
    public EmployeeManage() {
    }

    public EmployeeManage(int amount) {
        if (amount > 0) {
            this.amount = amount;
            employeeArray = new Employee[amount];
        }
    }

    public EmployeeManage(int amount, Employee[] employeeArray) {
        this.amount = amount;
        this.employeeArray = employeeArray;
    }
    public void input() {
        for (int i=0; i < amount; i++) {
            System.out.print("Bạn muốn thêm nhân viên gì (waiter, guard, cleaning staff): ");
            String typeEm = sc.nextLine();
            if (typeEm.compareToIgnoreCase("waiter") == 0) {
                employeeArray[i] = new Waiter();
                employeeArray[i].input();
            }
            else if (typeEm.compareToIgnoreCase("guard") == 0) {
                employeeArray[i] = new Guard();
                employeeArray[i].input();
            }
            else if (typeEm.compareToIgnoreCase("cleaning staff") == 0) {
                employeeArray[i] = new CleaningStaff();
                employeeArray[i].input();
            }
        }
    }
    public void show() {
        System.out.printf("%-10s|%-10s|%-10s|%-13s|%-25s|%-6s|%-8s|%-50s|%-15s|%-20s|%-10s|%-11s\n", "MaNV", "LuongNgay", "LoaiNV", "KVLamViec", "Ho Ten", "NS", "GT", "Dia Chi", "SDT", "Email", "Ma CN", "So Ngay LV");
        for (Employee em : employeeArray) {
            System.out.println(em.toString());
        }
    }
    public void sortSalary() {
        Arrays.sort(employeeArray, (Employee a, Employee b) -> {
            return a.calSalary() - b.calSalary();
        });
    }
    public Employee findEmployee(String id) {
        for (Employee em : employeeArray) {
            if (em.getId().compareToIgnoreCase(id) == 0) { return em; }
        }
        return new Employee();
    }
    public void findEmployeeByName(String name) {
        for (Employee em : employeeArray) {
            if (em.getName().compareToIgnoreCase(name) == 0) {
                System.out.println(em.toString());
            }
        }
    }
    public void remove(String id) {
        // kiem tra pt muon xoa co ton tai trong mang thay khong
        for (int i = 0; i < amount; i++) {
            if (employeeArray[i].getId().compareToIgnoreCase(id) == 0) { break; }
            if (i == amount - 1) { return; } // neu toi pt cuoi cung ma chua thoat khoi vong lap thi return khong remove
        }
        int j = 0;
        amount = amount - 1;
        Employee[] copy = new Employee[amount];
        // kiểm tra những phần tử trong array nếu là pt không muốn xóa thì sẽ copy vào mảng copy
        for (int i = 0; i < employeeArray.length; i++) {
            if (employeeArray[i].getId().compareToIgnoreCase(id) != 0) {
                copy[j++] = employeeArray[i];
            }
        }
        employeeArray = copy;
    }
    public void add(Employee em) {
        // tăng số lượng lên 1 và copy các pt trong mảng sang mảng mới
        amount = amount + 1;
        employeeArray = Arrays.copyOf(employeeArray, amount);
        // pt cuối cùng là employee muốn thêm vào mảng
        employeeArray[amount - 1] = em;
    }
    public void edit(String id) {
        // lấy vị trí pt muốn sửa trong mảng gán vị trí vào i
        int i, chon;
        for (i = 0; i < amount; i++) {
            if (employeeArray[i].getId().compareToIgnoreCase(id) == 0) {
                break;
            }
            if (i == amount - 1) { return; }
        }
        while (true) {
            System.out.printf("1. Sửa mã NV.\n");
            System.out.printf("2. Sửa họ tên.\n");
            System.out.printf("3. Sửa năm sinh.\n");
            System.out.printf("4. Sửa giới tính.\n");
            System.out.printf("5. Sửa địa chỉ.\n");
            System.out.printf("6. Sửa điện thoại.\n");
            System.out.printf("7. Sửa email.\n");
            System.out.printf("8. Sửa lương theo ngày.\n");
            System.out.printf("9. Sửa loại NV.\n");
            System.out.printf("10. Sửa khu vực làm việc.\n");
            System.out.printf("11. Sửa số ngày làm việc.\n");
            System.out.printf("Hãy chọn thông tin muốn sửa.\n");
            chon = Integer.parseInt(sc.nextLine());
            if (chon <= 0 || chon > 11) { break; }
            switch (chon) {
                case 1:
                    System.out.print("Hãy nhập mã nhân viên: ");
                    employeeArray[i].setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Hãy nhập họ và tên: ");
                    employeeArray[i].setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Hãy nhập năm sinh: ");
                    employeeArray[i].setBirthyear(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Hãy nhập giới tính: ");
                    employeeArray[i].setGender(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Hãy nhập địa chỉ: ");
                    employeeArray[i].setAddress(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Hãy nhập số điện thoại: ");
                    employeeArray[i].setPhonenumber(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Hãy nhập email: ");
                    employeeArray[i].setEmail(sc.nextLine());
                    break;
                case 8:
                    System.out.print("Hãy nhập lương một ngày: ");
                    employeeArray[i].setWage(Integer.parseInt(sc.nextLine()));
                    break;
                case 9:
                    System.out.print("Hãy nhập loại nhân viên: ");
                    employeeArray[i].setType(sc.nextLine());
                    break;
                case 10:
                    System.out.print("Hãy nhập khu vực làm việc: ");
                    employeeArray[i].setWorkingarea(sc.nextLine());
                    break;
                case 11:
                    System.out.print("Hãy nhập số ngày làm việc: ");
                    employeeArray[i].setWorkingdays(Integer.parseInt(sc.nextLine()));
                    break;
            }
        }
    }
}
