package mandatory_assignments.assignment1;

public class UnderflowExeption extends Exception {

    private String exeption;
    public UnderflowExeption(String e) {
        this.exeption = e;
    }
}
