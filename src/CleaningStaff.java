public class CleaningStaff extends Employee implements ICalculateSalary {
    @Override
    public int calSalary() {
        return getWage() * getWorkingdays();
    }
}
