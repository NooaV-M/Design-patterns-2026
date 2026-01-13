public abstract class Tile {
    String character;
    String type;

    public String getCharacter() {
        return character;
    }

    public String getType() {
        return type;
    }

    public void action() {
        System.out.println(this.getClass().getSimpleName() + " action executed.");
    }
}
