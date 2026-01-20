public abstract class UIFactory {
    public Button createButton(String label) {
        return new ButtonB();
    }
    public CheckBox createCheckBox(String label) {
        return new CheckBoxB();
    }
    public TextField createTextField(String text) {
        return new TextFieldB();
    }
}