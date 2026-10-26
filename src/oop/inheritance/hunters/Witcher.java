package oop.inheritance.hunters;

public class Witcher extends Soldier{
    public Witcher(String name) {
        super(name);
        golds += 50;
    }

    public void killMonster(){
        System.out.println(name + " is killing monster");
        golds += 50;
    }

    @Override
    void hunt() {
        System.out.println(name + " is hunting beast and hes good");
        golds+= 50;
    }
}
