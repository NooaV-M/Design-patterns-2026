public class TrainState extends State {
    public TrainState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        this.getGame().setExp(1);
        this.getGame().setState(new CheckUpdateState(this.getGame()));
    }
}
