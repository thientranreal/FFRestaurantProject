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
        for (Employee em : employeeArray) {
            System.out.println(em.toString());
        }
    }
    public void sortSalary() {
        Arrays.sort(employeeArray, (Employee a, Employee b) -> {
            return a.calSalary() - b.calSalary();
        });
    }
}
