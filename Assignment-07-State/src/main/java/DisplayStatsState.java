public class DisplayStatsState extends State {
    public DisplayStatsState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        System.out.println();
        System.out.println(this.getGame().getLevel() + " " + this.getGame().getName());
        System.out.println("Health: " + this.getGame().getHealth());
        System.out.println("Experience: " + this.getGame().getExp() + " out of " + this.getGame().getExpToLevelUp());
        System.out.println();
            this.getGame().setState(new GetActionState(this.getGame()));
    }
}
