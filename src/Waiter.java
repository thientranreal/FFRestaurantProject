public class Waiter extends Employee implements CalculateSalary{
    @Override
    public int calSalary(int working_days) {
        int salary = getWage() * working_days;
        if (getType().compareToIgnoreCase("full-time") == 0) {
            return salary + getWage();
        }
        if (getType().compareToIgnoreCase("part-time") == 0) {
            return salary;
        }
        return 0;
    }
}
