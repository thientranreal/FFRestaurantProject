public class CleaningStaff extends Employee implements CalculateSalary{
    @Override
    public int calSalary(int working_days) {
        return getWage() * working_days;
    }
}
