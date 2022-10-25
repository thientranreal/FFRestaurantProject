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
            if (sc.nextLine().compareToIgnoreCase("waiter") == 0) {
                employeeArray[i] = new Waiter();
                employeeArray[i].input();
            }
            else if (sc.nextLine().compareToIgnoreCase("guard") == 0) {
                employeeArray[i] = new Guard();
                employeeArray[i].input();
            }
            else if (sc.nextLine().compareToIgnoreCase("cleaning staff") == 0) {
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

}
