public class MediateState extends State {
    public MediateState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        this.getGame().setHealth(1);
        this.getGame().setState(new CheckUpdateState(this.getGame()));
    }
}
