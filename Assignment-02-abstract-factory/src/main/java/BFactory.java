public class BFactory extends UIFactory {
    @Override
    public Button createButton(String label) {
        ButtonB button = new ButtonB();
        button.content = label;
        return button;
    }

    @Override
    public CheckBox createCheckBox(String label) {
        CheckBoxB checkBox = new CheckBoxB();
        checkBox.content = label;
        return checkBox;
    }

    @Override
    public TextField createTextField(String text) {
        TextFieldB textField = new TextFieldB();
        textField.content = text;
        return textField;
    }
}
