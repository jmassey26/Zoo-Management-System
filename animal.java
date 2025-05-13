abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();
    public abstract void move();

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public String getInfo() {
        return name + " (Age: " + age + ")";
    }
}

class Mammal extends Animal implements Feedable {
    private String diet;
    private String sound;

    public Mammal(String name, int age, String diet, String sound) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " moves like a mammal."); }
}

class Reptile extends Animal implements Feedable {
    private String diet;
    private String sound;

    public Reptile(String name, int age, String diet, String sound) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " crawls like a reptile."); }
}

class Bird extends Animal implements Feedable {
    private String diet;
    private String sound;

    public Bird(String name, int age, String diet, String sound) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " flies like a bird."); }
}

class Amphibian extends Animal implements Feedable {
    private String diet;
    private String sound;

    public Amphibian(String name, int age, String diet, String sound) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " hops like an amphibian."); }
}
