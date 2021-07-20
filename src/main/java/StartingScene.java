import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.control.*;


public class StartingScene {
    private Scene scene;
    private TilePane tp = new TilePane();
    private Button b = new Button("Create range tree!");
    private HBox hb = new HBox();

    public StartingScene(){
        b.setOnAction(e->{
            CreatingScene cs = new CreatingScene();
            Main.stage.setScene(cs.getCreatingScene());
            Main.stage.show();
        });
        hb.getChildren().addAll(b);
        tp.getChildren().addAll(hb);
        tp.setPadding(new Insets(10, 10, 10, 10));
        scene = new Scene(tp, 1600, 900);
    }
    public Scene getStartingScene(){
        return scene;
    }
}
