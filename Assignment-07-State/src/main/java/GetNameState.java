public class GetNameState extends State {
    public GetNameState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        System.out.println("Enter your name:");
        while (true) {
            String name = getGame().getInput().nextLine();
            if (name.trim().isEmpty()) {
                System.out.println("Name cannot be empty. Please enter your name:");
            } else {
                getGame().setName(name);
                getGame().setState(new DisplayStatsState(getGame()));
                break;
            }
        }
    }
}
