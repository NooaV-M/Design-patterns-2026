import java.util.Arrays;

public class PrintCodeCommand implements Command {

    private GridController gridController;

    PrintCodeCommand(GridController gridController) {
        this.gridController = gridController;
    }

    @Override
    public void execute() {
        System.out.println();
        for (int i = 0; i < gridController.gridData.length; i++) {
            System.out.println(Arrays.toString(gridController.gridData[i]));
        }
    }
}
