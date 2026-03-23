package guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history

    private int timesUndone = 0;

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        deleteFuture();
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        deleteFuture();
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.get(history.size() - 1);
            model.restoreState(previousState);
            gui.updateGui();

            timesUndone++;
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void deleteFuture() {
        history.removeIf(memento -> history.indexOf(memento) > history.size() - timesUndone);
    }
}
