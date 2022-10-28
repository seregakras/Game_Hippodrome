import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private final List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        Hippodrome hippodrome = new Hippodrome(horses);
        game = hippodrome;
        hippodrome.horses.add(new Horse("Belka", 3, 0));
        hippodrome.horses.add(new Horse("Strelka", 3, 0));
        hippodrome.horses.add(new Horse("Snezhok", 3, 0));

        game.run();
        game.printWinner();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            move();
            print();
            Thread.sleep(1000);
        }
    }

    public void move() {
        if (horses != null) {
            for (Horse horse : horses) {
                horse.move();
            }
        }
    }

    public void print() {
        if (horses != null) {
            for (Horse horse : horses) {
                horse.print();
            }
            for (int i = 0; i < 5; i++) System.out.println();
        }
    }

    public Horse getWinner() {
        return horses.get(0).getDistance() > horses.get(1).getDistance() ? (horses.get(0).getDistance() > horses.get(2).getDistance() ? horses.get(0) : horses.get(2)) : (horses.get(1).getDistance() > horses.get(2).getDistance() ? horses.get(1) : horses.get(2));
    }

    public void printWinner() {
        System.out.println(getWinner().getName() + " is winner!!!");
    }
}
