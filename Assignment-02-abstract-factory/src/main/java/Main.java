public class Main {
    public  static void main(String[] args) {
        UIFactory factory = new AFactory();
        Button button = factory.createButton("button A");
        CheckBox checkBox = factory.createCheckBox("checkbox A");
        TextField textField = factory.createTextField("textfield A");
        button.display();
        checkBox.display();
        textField.display();

        factory = new BFactory();
        button = factory.createButton("button B");
        checkBox = factory.createCheckBox("checkbox B");
        textField = factory.createTextField("textfield B");
        button.display();
        checkBox.display();
        textField.display();
    }
}
