public class CheckBoxB extends CheckBox{
    @Override
    public void display() {
        System.out.print("+");
        for (int i = 0; i < this.content.length(); i++) {
            System.out.print("=");
        }
        System.out.println("+");
        System.out.println("|" + this.content + "|");
        System.out.print("+");
        for (int i = 0; i < this.content.length(); i++) {
            System.out.print("=");
        }
        System.out.println("+");
        System.out.println();
    }}
