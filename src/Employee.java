/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public abstract class Employee {
    private int employeeId;
    private static int lastemployeeId= 0;
    private String firstName;
    private String lastName;
    private int age;
    public Employee(String firstName, String lastName, int age){
        // The employeeId will be incremented every time that an employee is created
        employeeId = ++lastemployeeId;
        this.firstName= firstName;
        this.lastName= lastName;
        this.age = age;
    }
    public int getEmployeeID() {
        return this.employeeId;
    }

    public abstract double calculateMonthlySalary();

    //concatenating first name and last name
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    //method from Cheque to issue employee's Cheque
    public String issueEmployeeCheque() {
        return Cheque.issueCheque(this.getFullName(), this.calculateMonthlySalary());
    }

}
