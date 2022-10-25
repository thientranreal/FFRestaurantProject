public class Guard extends Employee implements ICalculateSalary {
    @Override
    public int calSalary(int working_days) {
        return getWage() * working_days;
    }
}
