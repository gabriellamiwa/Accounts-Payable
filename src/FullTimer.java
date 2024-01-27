/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public class FullTimer extends Employee{
    //inherits from Employee class
    private double annualSalary;
    public FullTimer(String firstName, String lastName, int age, Double annualSalary){
        super(firstName, lastName, age);
        this.annualSalary= annualSalary;
    }
    //getting the month salary
    public double calculateMonthlySalary(){
        return this.annualSalary / 12.0;
    }
    @Override
    public String toString() {
        int employeeId= this.getEmployeeID();
        return "\nEmployee ID: " + employeeId + "\nName: " + this.getFullName();
    }
}
