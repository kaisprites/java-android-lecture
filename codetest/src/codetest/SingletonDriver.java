package codetest;

public class SingletonDriver {
    public static void main(String args[]) {
        Singleton s = Singleton.getInstance();
        System.out.println(s);
        Singleton s2 = Singleton.getInstance();
        System.out.println(s2);
        Prototype p = Prototype.getInstance();
        System.out.println(p);
        Prototype p2 = Prototype.getInstance();
        System.out.println(p2);
        
    }
}
