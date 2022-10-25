import java.util.Arrays;
import java.util.Scanner;

public class EmployeeManage {
    private int amount;
    private Employee[] employeeArray;
    private static Scanner sc = new Scanner(System.in);
    public EmployeeManage() {
    }

    public EmployeeManage(int amount) {
        this.amount = amount;
        employeeArray = new Employee[amount];
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
}
