public abstract class Map {
    int mapSize;
    Map(int mapsize) {
        this.mapSize = mapsize;
    }
    public abstract Tile createTile();
    void display() {
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                Tile tile = createTile();
                System.out.print(tile.getCharacter() + "  ");
            }
            System.out.println();
        }
    }
}
