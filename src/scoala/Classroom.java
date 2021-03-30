package scoala;

public class Classroom {
    private int number;
    private int capacity;

    @Override
    public String toString() {
        return "\nClasa: " +
                number +
                " cu numarul de elevi " + capacity +
                ' ';
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Classroom(int number) {

        this.number = number;
    }


}
