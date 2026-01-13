public class CityMap extends Map {
    CityMap (int size) {
        super(size);
    }

    public Tile createTile() {
        int rand = (int) (Math.random() * 3);
        return switch (rand) {
            case 0 -> new BuildingTile();
            case 1 -> new RoadTile();
            case 2 -> new ForestTile();
            default -> null;
        };
    }
}
