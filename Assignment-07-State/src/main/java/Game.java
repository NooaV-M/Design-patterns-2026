import java.util.Scanner;

public class Game {
    private static Scanner input = new Scanner(System.in);

    private State state;
    private String name;
    private String level;
    private int exp;
    private int expToLevelUp;
    private int health;

    public Game() {
        this.state = new GetNameState(this);
        level = "Novice";
        exp = 0;
        expToLevelUp = 5;
            health = 5;
    }

    public void run() {
        while (true) {
            state.action();
        }
    }

    public Scanner getInput() {
        return input;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void  setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    public void setExp(int exp) {
        this.exp += exp;
    }
    public int getExp() {
        return exp;
    }

    public  void setExpToLevelUp(int expToLevelUp) {
        this.expToLevelUp = expToLevelUp;
    }
    public int getExpToLevelUp() {
        return expToLevelUp;
    }

    public void setHealth(int health) {
        this.health += health;
    }
    public int getHealth() {
        return health;
    }
}
