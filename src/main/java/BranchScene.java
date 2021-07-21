import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BranchScene {
    private Scene scene;
    private BorderPane bp = new BorderPane();


    public BranchScene(){
        scene = new Scene(bp,1600,900);
    }

    public Scene getBranchScene(){
        return scene;
    }
}
