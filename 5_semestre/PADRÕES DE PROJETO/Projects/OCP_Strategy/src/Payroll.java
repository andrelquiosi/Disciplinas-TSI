
public class Payroll {

    private IEmployee employee;

    public Payroll(IEmployee employee) {
        super();
        this.employee = employee;
    }

    public float calculateSalary(float hours) {
        return employee.calculateSalary(hours);
    }
}
