import java.util.*;

class ZooManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        Zookeeper keeper = new Zookeeper(username);

        Zoo zoo = new Zoo(keeper);
        zoo.addEnclosure(new Enclosure("Savanna"));
        zoo.addEnclosure(new Enclosure("Jungle"));
        zoo.addEnclosure(new Enclosure("Reptile House"));
        zoo.addEnclosure(new Enclosure("Bird House"));

        zoo.addAnimalToEnclosure(new Mammal("Leo", 4, "meat", "Roar!"), "Savanna");
        zoo.addAnimalToEnclosure(new Mammal("Ella", 7, "grass", "Trumpet!"), "Jungle");
        zoo.addAnimalToEnclosure(new Reptile("Sly", 2, "insects", "Hiss!"), "Reptile House");
        zoo.addAnimalToEnclosure(new Bird("Polly", 3, "seeds", "Squawk!"), "Bird House");
        zoo.addAnimalToEnclosure(new Amphibian("Froggy", 1, "flies", "Ribbit!"), "Jungle");

        int choice;
        do {
            System.out.println("\n--- Zoo Management System (User: " + username + ") ---");
            System.out.println("1. View all animals");
            System.out.println("2. Feed an animal");
            System.out.println("3. Make an animal do something");
            System.out.println("4. Add a new animal");
            System.out.println("5. View enclosures");
            System.out.println("6. View recent interactions");
            System.out.println("7. Schedule an appointment");
            System.out.println("8. View appointments");
            System.out.println("0. Exit");
            System.out.print("Choose an action: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> zoo.listAllAnimals();
                case 2 -> {
                    System.out.print("Enter name of animal to feed: ");
                    String name = scanner.nextLine();
                    Animal animalToFeed = zoo.getAnimalByName(name);
                    if (animalToFeed != null) {
                        keeper.feedAnimal(animalToFeed);
                        zoo.addRecentInteraction(animalToFeed);
                    } else {
                        System.out.println("Animal not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter name of animal to interact with: ");
                    String animalName = scanner.nextLine();
                    Animal animal = zoo.getAnimalByName(animalName);
                    if (animal != null) {
                        animal.makeSound();
                        animal.move();
                        zoo.addRecentInteraction(animal);
                    } else {
                        System.out.println("No animal found with that name.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter species type (mammal/reptile/bird/amphibian): ");
                    String species = scanner.nextLine();
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter enclosure name: ");
                    String enclosure = scanner.nextLine();
                    System.out.print("Enter diet description: ");
                    String diet = scanner.nextLine();
                    System.out.print("Enter sound: ");
                    String sound = scanner.nextLine();

                    Animal newAnimal = switch (species.toLowerCase()) {
                        case "mammal" -> new Mammal(name, age, diet, sound);
                        case "reptile" -> new Reptile(name, age, diet, sound);
                        case "bird" -> new Bird(name, age, diet, sound);
                        case "amphibian" -> new Amphibian(name, age, diet, sound);
                        default -> null;
                    };

                    if (newAnimal != null) zoo.addAnimalToEnclosure(newAnimal, enclosure);
                    else System.out.println("Unknown species type.");
                }
                case 5 -> zoo.listEnclosures();
                case 6 -> zoo.viewRecentInteractions();
                case 7 -> {
                    System.out.print("Enter animal name for appointment: ");
                    String animalName = scanner.nextLine();
                    System.out.print("Enter purpose of appointment: ");
                    String purpose = scanner.nextLine();
                    System.out.print("Enter appointment time: ");
                    String time = scanner.nextLine();
                    zoo.scheduleAppointment(new Appointment(animalName, purpose, time));
                }
                case 8 -> zoo.viewAppointments();
                case 0 -> System.out.println("Goodbye, " + username + "!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        scanner.close();
    }
}

interface Feedable {
    void eat();
}

