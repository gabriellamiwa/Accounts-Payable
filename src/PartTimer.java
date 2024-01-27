/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public class PartTimer extends Employee {
    //inherits from Employee class

    private int echelon;
    private double hourlyRate;
    private int hoursPerMonth;

    public PartTimer(String firstName, String lastName, int age, int echelon, int hoursPerMonth) {
        super(firstName, lastName, age);
        this.echelon = echelon;
        this.setHourlyRate(); //set hourly rate based on echelon
        this.hoursPerMonth = hoursPerMonth;
    }

    public double calculateMonthlySalary() {
        return this.hourlyRate * this.hoursPerMonth;
    }

    @Override
    public String toString() {
        int employeeId = this.getEmployeeID();
        return "\nEmployee ID: " + employeeId + "\nName: " + this.getFullName();

    }

    private void setHourlyRate() {
        switch (echelon) {
            case 1:
                hourlyRate = 15;
                break;
            case 2:
                hourlyRate = 20;
                break;
            case 3:
                hourlyRate = 25;
                break;
            case 4:
                hourlyRate = 30;
                break;
            case 5:
                hourlyRate = 40;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + echelon);
        }

}
}