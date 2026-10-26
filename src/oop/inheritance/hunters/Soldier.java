package oop.inheritance.hunters;

public class Soldier extends Hunter{
    protected final int SOLDIER_DEFAULT_BONUS = 10;

    public Soldier(String name) {
        super(name);
        golds += 40;

    }

    public void killBandit(){
        System.out.println(name + " is kiling bandít");
        golds += 100;
    }
}
