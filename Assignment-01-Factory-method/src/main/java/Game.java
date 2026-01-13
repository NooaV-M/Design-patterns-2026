public class Game {

    private Map CreateMap (String mapType, int size) {
        return switch (mapType) {
            case "Forest" -> new WildernessMap(size);
            case "City" -> new CityMap(size);
            default -> null;
        };
    }

    public static void main(String[] args) {
        Game game = new Game();
        Map cityMap = game.CreateMap("City", 5);
        cityMap.display();
    }
}
