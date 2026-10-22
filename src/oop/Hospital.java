package oop;

public class Hospital {
    public static void main(String[] args) {
        System.out.println();

        Surgeon s = new Surgeon("Josef");
        System.out.println(s.name);
        System.out.println(s.salary);
        System.out.println();
        s.diagnose();
        s.surgery();
        System.out.println(s.salary);

        CardiacSurgeon cs = new CardiacSurgeon("Pepík");

    }
}
