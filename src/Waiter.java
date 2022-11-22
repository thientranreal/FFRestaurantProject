public class Waiter extends Employee {
    private static int soluong = 0;

    public Waiter() {
        ++soluong;
    }

    @Override
    public int calSalary() {
        int salary = getWage() * getWorkingdays();
        if (getType().compareToIgnoreCase("full-time") == 0) {
            return salary + getWage();
        }
        if (getType().compareToIgnoreCase("part-time") == 0) {
            return salary;
        }
        return 0;
    }
    public static int getSoLuong() {
        return soluong;
    }
    public static void setSoLuong(int sl) {
        if (sl < 0) {
            soluong = 0;
        }
        else {
            soluong = sl;
        }
    }
}
