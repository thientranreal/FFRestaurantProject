public class Guard extends Employee {
    private static int soluong = 0;

    public Guard() {
        ++soluong;
    }

    @Override
    public int calSalary() {
        return getWage() * getWorkingdays();
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
