public class LeftCommand implements Command {
    GridController gridController;
    public LeftCommand(GridController gridController) {
        this.gridController = gridController;
    }
    @Override
    public void execute() {
        if (gridController.cursorX > 0) {
            gridController.cursorX -= 1;
        }
    }
}
