public class TogglePixelCommand implements Command {
    GridController gridController;
    public TogglePixelCommand(GridController gridController) {
        this.gridController = gridController;
    }
    @Override
    public void execute() {
        int x = gridController.cursorX;
        int y = gridController.cursorY;
        if (gridController.gridData[y][x] == 0) {
            gridController.gridData[y][x] = 1;
        } else {
            gridController.gridData[y][x] = 0;
        }

    }
}
