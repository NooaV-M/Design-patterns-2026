public class DownCommand implements Command {

    GridController gridController;
    public DownCommand(GridController gridController) {
        this.gridController = gridController;
    }

    @Override
    public void execute() {
        if (gridController.cursorY < 7) {
            gridController.cursorY += 1;
        }
    }
}
