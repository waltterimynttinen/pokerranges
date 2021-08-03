import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class ViewingScene {
    private Scene scene;
    private BorderPane bp = new BorderPane();
    private HBox hb1 = new HBox();
    private ComboBox cb = new ComboBox();

    public ViewingScene(RangeTree rt){
        bp.setTop(new Label(rt.getName()));
        scene = new Scene(bp, 1600,900);
    }
}
