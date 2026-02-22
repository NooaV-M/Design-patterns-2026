public class FightState extends State {
    public FightState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        this.getGame().setHealth(-1);
        this.getGame().setExp(2);
        this.getGame().setState(new CheckUpdateState(this.getGame()));
    }
}
