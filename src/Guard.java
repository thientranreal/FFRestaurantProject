public class Guard extends Employee {
    @Override
    public int calSalary() {
        return getWage() * getWorkingdays();
    }
}
