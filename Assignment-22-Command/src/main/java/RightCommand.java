public class RightCommand implements Command {
    GridController gridController;
    public RightCommand(GridController gridController) {
        this.gridController = gridController;
    }
    @Override
    public void execute() {
        if (gridController.cursorX < 7) {
            gridController.cursorX += 1;
        }
    }
}
