import java.util.*;


class Zookeeper {
    private String name;

    public Zookeeper(String name) {
        this.name = name;
    }

    public void feedAnimal(Animal animal) {
        if (animal instanceof Feedable f) {
            f.eat();
        } else {
            System.out.println(animal.getInfo() + " cannot be fed.");
        }
    }
}

class Enclosure {
    private String name;
    private List<Animal> animals = new ArrayList<>();

    public Enclosure(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> getAnimals() { return animals; }

    public void listAnimals() {
        for (Animal a : animals) {
            System.out.println("  - " + a.getInfo());
        }
    }
}


class Zoo {
    private List<Enclosure> enclosures = new ArrayList<>();
    private Zookeeper currentUser;
    private Stack<Animal> recentInteractions = new Stack<>();
    private List<Appointment> appointments = new ArrayList<>();

    public Zoo(Zookeeper keeper) {
        this.currentUser = keeper;
    }

    public void addEnclosure(Enclosure enclosure) {
        enclosures.add(enclosure);
    }

    public void addAnimalToEnclosure(Animal animal, String enclosureName) {
        for (Enclosure e : enclosures) {
            if (e.getName().equalsIgnoreCase(enclosureName)) {
                e.addAnimal(animal);
                System.out.println(animal.getInfo() + " added to " + enclosureName);
                return;
            }
        }
        System.out.println("Enclosure not found.");
    }

    public void listAllAnimals() {
        int index = 0;
        for (Enclosure e : enclosures) {
            System.out.println("Enclosure: " + e.getName());
            for (Animal a : e.getAnimals()) {
                String type = "";
                if (a instanceof Mammal m) type = m.getType();
                else if (a instanceof Reptile r) type = r.getType();
                else if (a instanceof Bird b) type = b.getType();
                else if (a instanceof Amphibian am) type = am.getType();

                System.out.println("  [" + index + "] " + a.getInfo() + " - Type: " + type);
                index++;
            }
        }
    }

    public Animal getAnimalByIndex(int index) {
        int count = 0;
        for (Enclosure e : enclosures) {
            for (Animal a : e.getAnimals()) {
                if (count == index) return a;
                count++;
            }
        }
        return null;
    }

    public Animal getAnimalByName(String name) {
        for (Enclosure e : enclosures) {
            for (Animal a : e.getAnimals()) {
                if (a.name.equalsIgnoreCase(name)) {
                    return a;
                }
            }
        }
        return null;
    }

    public void listEnclosures() {
        for (Enclosure e : enclosures) {
            System.out.println("Enclosure: " + e.getName());
            e.listAnimals();
        }
    }

    public void addRecentInteraction(Animal animal) {
        recentInteractions.push(animal);
        if (recentInteractions.size() > 5) {
            recentInteractions.remove(0);
        }
    }

    public void viewRecentInteractions() {
        if (recentInteractions.isEmpty()) {
            System.out.println("No recent animal interactions.");
            return;
        }
        System.out.println("Recent animal interactions:");
        for (int i = recentInteractions.size() - 1; i >= 0; i--) {
            System.out.println("  - " + recentInteractions.get(i).getInfo());
        }
    }

    public void scheduleAppointment(Appointment appt) {
        appointments.add(appt);
        System.out.println("Appointment scheduled.");
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        for (Appointment appt : appointments) {
            System.out.println(appt.getDetails());
        }
    }
}


class Appointment {
    private String animalName, purpose, time;

    public Appointment(String animalName, String purpose, String time) {
        this.animalName = animalName;
        this.purpose = purpose;
        this.time = time;
    }

    public String getDetails() {
        return "Appointment for " + animalName + " at " + time + " - Purpose: " + purpose;
    }
}


