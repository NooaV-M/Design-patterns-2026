package guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history
    private List<IMemento> future; // Memento future for redo functionality

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        this.future = new ArrayList<>();
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
        System.out.println("History size: " + history.size());
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");
            IMemento previousState = history.remove(history.size() - 1);
            future.add(previousState);
            model.restoreState(previousState);
            gui.updateGui();
        }
    }

    public void redo() {
        System.out.println("History size: " + history.size());
        System.out.println("Future size: " + future.size());
        if (!future.isEmpty()) {
            System.out.println("Memento found in future");
            IMemento nextState = future.remove(future.size() - 1);
            history.add(nextState);
            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);
    }

    private void deleteFuture() {
        future.clear();
    }

}
