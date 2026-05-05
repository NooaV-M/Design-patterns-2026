import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GridController extends Application {

    @FXML
    public GridPane grid;

    int[][] gridData;

    int cursorX = 4;
    int cursorY = 4;

    private UpCommand upCommand =  new UpCommand(this);
    private DownCommand downCommand =  new DownCommand(this);
    private LeftCommand leftCommand =  new LeftCommand(this);
    private RightCommand rightCommand =  new RightCommand(this);
    private TogglePixelCommand togglePixelCommand = new TogglePixelCommand(this);
    private PrintCodeCommand printCodeCommand = new PrintCodeCommand(this);

    public GridController ()  {
        gridData = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public GridController(int[][] gridData) {
        this.gridData = gridData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/grid.fxml"));
        Parent root = loader.load();

        primaryStage.setScene(new javafx.scene.Scene(root));
        primaryStage.show();

        // Use the controller instance created by FXMLLoader (it has injected @FXML fields)
        GridController controller = loader.getController();
        controller.updateGrid();

        primaryStage.getScene().setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    controller.upCommand.execute();
                    controller.updateGrid();
                    break;
                case DOWN:
                    controller.downCommand.execute();
                    controller.updateGrid();
                    break;
                case LEFT:
                    controller.leftCommand.execute();
                    controller.updateGrid();
                    break;
                case RIGHT:
                    controller.rightCommand.execute();
                    controller.updateGrid();
                    break;
                case SPACE:
                    controller.togglePixelCommand.execute();
                    controller.updateGrid();
                    break;
                case P:
                    controller.printCodeCommand.execute();
                    controller.updateGrid();
                    break;
            }
        });
    }

    public void updateGrid() {
        grid.getChildren().clear();

        Pane pane;

        for (int row = 0; row < gridData.length; row++) {
            for (int col = 0; col < gridData[row].length; col++) {
                pane = new Pane();
                if (gridData[row][col] == 0) {
                    pane.setStyle("-fx-background-color: white;");
                }
                else {
                    pane.setStyle("-fx-background-color: black;");
                }
                if (cursorX == col && cursorY == row) {
                    pane.setBorder(new javafx.scene.layout.Border(new javafx.scene.layout.BorderStroke(javafx.scene.paint.Color.RED, javafx.scene.layout.BorderStrokeStyle.SOLID, null, new javafx.scene.layout.BorderWidths(2))));
                }
                else {
                    pane.setBorder(null);
                }
                grid.add(pane, col, row);
            }
        }
        }
    }
