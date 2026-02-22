public class EndGameState extends State {
    public EndGameState(Game game) {
        super(game);
    }

    @Override
    public void action() {
            System.exit(0);
    }
}
