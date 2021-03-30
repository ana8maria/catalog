package scoala;

public class Professor {
    @Override
    public String toString() {
        return " " +
                name ;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Professor(String name) {
        this.name = name;
    }
}
