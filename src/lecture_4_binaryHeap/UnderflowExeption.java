package lecture_4_binaryHeap;

public class UnderflowExeption extends Exception {

    private String exeption;
    public UnderflowExeption(String e) {
        this.exeption = e;
    }
}
