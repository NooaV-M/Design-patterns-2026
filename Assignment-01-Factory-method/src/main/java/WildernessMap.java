public class WildernessMap extends Map {
    WildernessMap (int size) {
        super(size);
    }

    public Tile createTile() {
        int rand = (int) (Math.random() * 3);
        return switch (rand) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            case 2 -> new ForestTile();
            default -> null;
        };
    }
}
