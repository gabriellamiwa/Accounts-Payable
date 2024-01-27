import java.util.ArrayList;
/*<Gabriella><Kaku><2234530> - <Karina><Contini><2230591>*/
public abstract class DataProvider {
    /* The DataProvider class is abstract and therefore objects of this class will not be initialized.
    It provides the static method initializeEmployees() to initialize the list of Employees with 5 Fulltimer objects and 5 PartTimer*/
    public static ArrayList<Employee> initializeEmployees() {
        ArrayList<Employee> listEmployee = new ArrayList<>();

        listEmployee.add(new FullTimer("Gabriella","Kaku",24,70000.0 ));
        listEmployee.add(new FullTimer("Karina","Contini",37,65000.0 ));
        listEmployee.add(new FullTimer("Matthew","Benett",26,67000.0 ));
        listEmployee.add(new FullTimer("Ayrton","Amaral",28,80000.0 ));
        listEmployee.add(new FullTimer("Paula","Oliveira",20,50000.0 ));

        listEmployee.add(new PartTimer("Osvaldo","Cruz",35,4, 160));
        listEmployee.add(new PartTimer("Ana","Carvalho",18,2, 80));
        listEmployee.add(new PartTimer("Clarice","Lispector",39,5, 160));
        listEmployee.add(new PartTimer("Larissa","Costa",26,3, 160));
        listEmployee.add(new PartTimer("Jorge","Souza",19,1, 80));

        return listEmployee;
    }
}