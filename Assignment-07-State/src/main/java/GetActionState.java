public class GetActionState extends State {
    public GetActionState(Game game) {
        super(game);
    }

    @Override
    public void action() {
        System.out.println("Choose your action:");
        switch (this.getGame().getLevel()) {
            case "Novice":
                System.out.println("Train");
                break;
            case "Intermediate":
                System.out.println("Train");
                System.out.println("Meditate");
                break;
            case "Expert":
                System.out.println("Train");
                System.out.println("Meditate");
                System.out.println("Fight");
                break;
        }

        System.out.println("Enter your choice:");
        String choice = getGame().getInput().nextLine();
        switch (this.getGame().getLevel()) {
            case "Novice":
                if (!choice.equals("Train")) {
                    System.out.println("Invalid choice. Please try again.");
                    return;
                }
                break;
            case "Intermediate":
                if (!choice.equals("Train") && !choice.equals("Meditate")) {
                    System.out.println("Invalid choice. Please try again.");
                    return;
                }
                break;
            case "Expert":
                if (!choice.equals("Train") && !choice.equals("Meditate") && !choice.equals("Fight")) {
                    System.out.println("Invalid choice. Please try again.");
                    return;
                }
                break;
        }
        switch (choice) {
            case "Train":
                System.out.println("You train and gain experience!");
                getGame().setState(new TrainState(this.getGame()));
                break;
            case "Meditate":
                System.out.println("You rest and recover health!");
                getGame().setState(new MediateState(this.getGame()));
                break;
            case "Fight":
                System.out.println("You engage in battle and gain experience but lose health!");
                getGame().setState(new FightState(this.getGame()));
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
