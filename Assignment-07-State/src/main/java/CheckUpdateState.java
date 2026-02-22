public class CheckUpdateState extends State {
    public CheckUpdateState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        if (this.getGame().getHealth() <= 0) {
            System.out.println("Your health has dropped to zero or below.");
            System.out.println("Game Over!");
            this.getGame().setState(new EndGameState(this.getGame()));
            return;
        }
        switch (this.getGame().getLevel()) {
            case "Novice":
                if (this.getGame().getExp() >= this.getGame().getExpToLevelUp()) {
                    this.getGame().setLevel("Intermediate");
                    this.getGame().setExp(0);
                    this.getGame().setExpToLevelUp(10);
                }
                break;
            case "Intermediate":
                if (this.getGame().getExp() >= this.getGame().getExpToLevelUp()) {
                    this.getGame().setLevel("Expert");
                    this.getGame().setExp(0);
                    this.getGame().setExpToLevelUp(15);
                }
                break;
            case "Expert":
                if (this.getGame().getExp() >= this.getGame().getExpToLevelUp()) {
                    System.out.println("Congratulations! You have reached the maximum level!");
                    this.getGame().setState(new EndGameState(this.getGame()));
                    return;
                }
        }
        this.getGame().setState(new DisplayStatsState(this.getGame()));
    }
}
