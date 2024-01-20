import java.util.Random;

public class Hero {
    //properties
    private String name;
    private int hitPoints;

    //constructor
    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    //behaviours
    public String getName(){
        return name;
    }

    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero{name='" + name + "', hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        Random random = new Random();
        double randomNumber = random.nextDouble();

        if (randomNumber < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean(){
        hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent){
        while (hitPoints > 0 && opponent.hitPoints > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();

        fightUntilTheDeathHelper(opponent);

        return this.name + ": " + this.hitPoints + " " + opponent.name + ": " + opponent.hitPoints;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] results = new int[2];

        for (int i = 0; i < n; i++) {
            senzuBean();
            opponent.senzuBean();

            fightUntilTheDeathHelper(opponent);

            if (hitPoints <= 0) {
                results[0]++;
            } else {
                results[1]++;
            }
        }

        return results;
    }

    public String nFightsToTheDeath(Hero opponent, int n){
        int[] results = nFightsToTheDeathHelper(opponent, n);

        String resultString = this.name + ": " + results[1] + " wins\n" +
                opponent.name + ": " + results[0] + " wins\n";

        if (results[0] > results[1]) {
            resultString += opponent.name + " wins!";
        } else if (results[0] < results[1]) {
            resultString += this.name + " wins!";
        } else {
            resultString += "OMG! It was actually a draw!";
        }

        return resultString;
    }

    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        senzuBean();
        opponent.senzuBean();

        while (hitPoints > 0 && opponent.hitPoints > 0) {
            attack(opponent);

            Thread.sleep(1000);

            System.out.println(this);
            System.out.println(opponent);
        }

        if (hitPoints <= 0) {
            System.out.println(opponent.name + " wins!");
        } else {
            System.out.println(this.name + " wins!");
        }
    }
}
