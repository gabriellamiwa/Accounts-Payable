import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public class Main {
        static ArrayList<Employee> listEmployee = new ArrayList<>();
        static ArrayList<Bill> listBills = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Accounts Payable: \n");

        //method in DataProvider class to initialize the list of Employees
        listEmployee = DataProvider.initializeEmployees();
        Scanner userInput = new Scanner(System.in);
        String option = "";
        do {
            System.out.println("--- Menu ---");
            System.out.println("1- Add an employee: ");
            System.out.println("2- Add a bill:");
            System.out.println("3- Issue cheques: ");
            System.out.println("4- EXIT:");
            option = userInput.nextLine();

            switch (option) {
                case "1":
                    addEmployee();
                    break;

                case "2":
                    addBill();
                   break;

                case "3":
                    issueCheque();
                    break;

                case "4":
                    System.out.println("Exit program.");
                    break;

                default:
                    System.out.println(" Unknown selection, please try again");
                    break;
            }
        } while (!option.equals("4"));
    }
    private static void addEmployee(){
        int age = 0;
        Scanner userInput = new Scanner(System.in);
        double annualSalary = 0.0;
        System.out.println("Enter first name of employee:");
        String firstName = userInput.nextLine();
        System.out.println("Enter last name of employee:");
        String lastName = userInput.nextLine();

        while(true){
            System.out.println("Enter age of employee:");
            //validating age input
            try {
                age = userInput.nextInt();
                userInput.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid age.");
                userInput.nextLine();
            }
        }
        while(true) {
            System.out.println("Enter 1 to add a Full Timer or 2 to add a Part Timer employee:");
            String employeeDetail = userInput.nextLine();
            if (employeeDetail.equals("1")) {
                while (true) {
                    System.out.println("Enter the employee's annual salary:");
                    try {
                        //validating employee's salary input
                        annualSalary = userInput.nextDouble();
                        userInput.nextLine();
                        FullTimer fullTimeEmployee = new FullTimer(firstName, lastName, age, annualSalary);
                        listEmployee.add(fullTimeEmployee);
                        break;

                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid salary.");
                        userInput.nextLine();
                    }
                }
                break;
            }
            else if (employeeDetail.equals("2")) {
                int echelon = 0;
                int hoursPerMonth = 0;
                double hourlyRate = 0.0;
                while (true) {
                    System.out.println("Enter employee's echelon (1-5):");
                    try {
                        echelon = userInput.nextInt();
                        //validating echelon input
                        if (echelon>=1 && echelon<=5){
                            userInput.nextLine();
                            break;
                        }
                        else{
                            System.out.println("Invalid input, echelon 1-5.");
                        }
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid echelon.");
                        userInput.nextLine();
                    }
                }
                while (true) {
                    System.out.println("Enter the number of hours:");
                    try {
                        //validating number of hours input
                        hoursPerMonth = userInput.nextInt();
                        userInput.nextLine();
                        PartTimer partTimeEmployee = new PartTimer(firstName, lastName, age, echelon, hoursPerMonth);
                        listEmployee.add(partTimeEmployee);
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid number of hours.");
                        userInput.nextLine();
                    }
                }
                break;
            }
            else {
                System.out.println("Invalid input. Please enter 1 or 2.");

            }
        }
    }
    private static void addBill(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the name of the company which this bill belongs to:");
        String companyName = userInput.nextLine();
        double billAmount = 0;

        while (true) {
            System.out.println("Enter the amount to be paid:");
            try {
                //validating bill amount
                billAmount = userInput.nextDouble();
                userInput.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                userInput.nextLine();
            }
        }
        while (true) {
            System.out.println("Enter due date (DD MM YYYY):");
            String inputDate = userInput.nextLine();
            //splitting the date and saving in the array to be able to get just the month and return it as a string
            String[] date = inputDate.split(" ");
            if (date.length == 3){
                try {
                    int day = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    //monthName method to return it as the name of the month
                    String monthString = monthName(month);

                    String dateString = String.format("%02d %s %04d", day, monthString, year);
                    //validating date input
                    if (validateDate(dateString)) {
                        LocalDate dueDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd MMMM yyyy"));
                        Bill currentBill = new Bill(companyName, billAmount, dueDate);
                        listBills.add(currentBill);
                        System.out.println(currentBill);
                        break;
                    }
                    else {
                        System.out.println("Invalid date format. Please use the right format, example: 18 11 2023.");
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid date in the format Day Month Year.");
                    userInput.nextLine();
                }
            }
        }
    }
    private static void issueCheque(){
        System.out.println("\n\tList of Cheques\n");

        if (!listEmployee.isEmpty() || !listBills.isEmpty()){
            // use of polymorphism, the program will only define if it is parttimer or fulltimer during run time
            for(Employee emp : listEmployee) {
                System.out.println(emp.issueEmployeeCheque());
            }
            for(Bill bill : listBills) {
                System.out.println(bill.issueBillCheque());
            }
        } else {
            System.out.println("There are no registered employees or bills.\n");
}
    }
    private static String monthName(int month) {
        //getting month name
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        if (month >= 1 && month <= 12) {
            return months[month];
        } else {
            return "Invalid Month";
        }
    }
    private static boolean validateDate(String dateString) {
            try {
                //validating date input
                LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd MMMM yyyy"));
                return true;
            } catch (DateTimeParseException e) {
                return false;
            }

    }

}