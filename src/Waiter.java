public class Waiter extends Employee {
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
}
