package googlesheets.model.generic.rowselection;

public class PairSelection<T, U> {
    private T first;
    private U second;


    public PairSelection(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}
