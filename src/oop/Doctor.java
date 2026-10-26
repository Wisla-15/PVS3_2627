package oop;

public class Doctor {
    protected final static int BASE_SALARY = 50000;
    protected String name;
    protected int salary;

    public Doctor(String name) {
        this.name = name;
        this.salary = BASE_SALARY;
    }
    void diagnose(){
        System.out.println("Diagnostikuju");
        salary += 1000;
    }
}


class Surgeon extends Doctor {
    protected final static int SURGEON_BONUS = 25000;

    public Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Operuju");
        salary += 25000;
    }
}


class CardiacSurgeon extends Surgeon {
    protected final static int CS_BONUS = 35000;

    public CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cSurgery (){
        System.out.println("řežu srce");
        salary+=30000;
    }
}