import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public class Bill {
    private int billID;
    private static int lastID= 0;
    private String companyName;
    private double billAmount;
    private LocalDate dueDate;

    public Bill (String companyName, double billAmount, LocalDate dueDate){
            this.dueDate =dueDate;
            // The billID will be incremented every time that a Bill is created
            billID = ++lastID;
            this.companyName = companyName;
            this.billAmount = billAmount;
    }

    @Override
    public String toString(){
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy");

    return "Bill ID: "+ billID + " to " + companyName +" in the amount of " + billAmount + " due to " + dueDate.format(dateFormat);
    }

    public String issueBillCheque() {
        return Cheque.issueCheque(this.companyName, this.billAmount);
    }

}
