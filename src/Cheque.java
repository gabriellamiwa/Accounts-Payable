import java.text.DecimalFormat;
/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public abstract class Cheque {
/* The Cheque class is abstract and therefore objects of this class will not be initialized.
It provides the static method issueCheque() that will increment the chequeNumber and return a String for each cheque*/

    private static int chequeNumber = 0;
    // The static method issueCheque is accessible for the all the classes (Employee and Bill)
    public static String issueCheque(String payableTo, double chequeAmount) {
        DecimalFormat round = new DecimalFormat("#.#");

        // The chequeNumber will be incremented every time that a cheque is issued
        chequeNumber++;
        return "\nCheque number: " + chequeNumber + "\nPayable to: " + payableTo + "\nAmount: $" + round.format(chequeAmount)+"\n";
}
}