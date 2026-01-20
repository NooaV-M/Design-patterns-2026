public class AFactory extends UIFactory {
    @Override
    public Button createButton(String label) {
        ButtonA button = new ButtonA();
        button.content = label;
        return button;
    }

    @Override
    public CheckBox createCheckBox(String label) {
        CheckBoxA checkBox = new CheckBoxA();
        checkBox.content = label;
        return checkBox;
    }

    @Override
    public TextField createTextField(String text) {
        TextFieldA textField = new TextFieldA();
        textField.content = text;
        return textField;
    }
}
