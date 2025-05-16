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
    private String diet, sound, type;

    public Mammal(String name, int age, String diet, String sound, String type) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
        this.type = type;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " moves like a mammal."); }
    public String getType() { return type; }
}

class Reptile extends Animal implements Feedable {
    private String diet, sound, type;

    public Reptile(String name, int age, String diet, String sound, String type) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
        this.type = type;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " crawls like a reptile."); }
    public String getType() { return type; }
}


class Bird extends Animal implements Feedable {
    private String diet, sound, type;

    public Bird(String name, int age, String diet, String sound, String type) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
        this.type = type;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " flies like a bird."); }
    public String getType() { return type; }
}


class Amphibian extends Animal implements Feedable {
    private String diet, sound, type;

    public Amphibian(String name, int age, String diet, String sound, String type) {
        super(name, age);
        this.diet = diet;
        this.sound = sound;
        this.type = type;
    }

    public void eat() { System.out.println(name + " eats: " + diet); }
    public void makeSound() { System.out.println(name + " says: " + sound); }
    public void move() { System.out.println(name + " hops like an amphibian."); }
    public String getType() { return type; }
}

