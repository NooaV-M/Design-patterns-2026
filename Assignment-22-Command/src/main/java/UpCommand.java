public class UpCommand implements Command{

    private GridController gridController;

    public UpCommand(GridController gridController) {
        this.gridController = gridController;
    }

    @Override
    public void execute() {
        if (gridController.cursorY > 0) {
            gridController.cursorY -= 1;
        }
    }
}
