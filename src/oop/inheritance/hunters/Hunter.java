package oop.inheritance.hunters;

public class Hunter {
    protected String name;
    protected int golds;
    protected int salary;
    protected final int HUNTER_DEFAULT_SALARY = 10;

    public void setGolds(int golds) {
        this.golds = golds;
    }

    public Hunter(String name) {
        this.name = name;
        this.golds = 10;
        this.salary += HUNTER_DEFAULT_SALARY;
    }

    void hunt(){
        System.out.println(this.name + " is hunting");
        this.golds += HUNTER_DEFAULT_SALARY;
    }
}

