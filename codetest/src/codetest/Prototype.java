package codetest;

class Prototype {
    private static Prototype instance = new Prototype();
    private Prototype() {}
    
    public static Prototype getInstance() {
        try {
			return (Prototype)instance.clone();
		} catch (CloneNotSupportedException e) {
			return new Prototype();
		}
    }
}