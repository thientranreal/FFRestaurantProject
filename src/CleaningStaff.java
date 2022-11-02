public class CleaningStaff extends Employee {
    @Override
    public int calSalary() {
        return getWage() * getWorkingdays();
    }
}
