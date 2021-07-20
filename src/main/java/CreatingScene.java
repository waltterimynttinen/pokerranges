import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class CreatingScene {
    private Scene scene;
    private BorderPane bp = new BorderPane();
    private Label lb = new Label("Give name:");
    private TextField tf = new TextField();
    private HBox hb = new HBox();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();

    public CreatingScene(){
        hb.getChildren().addAll(lb,tf);
        hb.setSpacing(10);
        vb1.setSpacing(10);
        vb2.setSpacing(10);
        createTextFields(5);
        bp.setTop(hb);
        bp.setLeft(vb1);
        bp.setRight(vb2);
        hb.setAlignment(Pos.CENTER);
        bp.setPadding(new Insets(20,20,20,20));
        scene = new Scene(bp, 1600, 900);
    }

    public Scene getCreatingScene(){
        return scene;
    }

    public void createTextFields(int x){
        for(int i = 0; i<x ; i++){
            vb1.getChildren().add(new Label("New category:"));
            vb1.getChildren().add(new TextField());
            vb2.getChildren().add(new Label("Import range:"));
            vb2.getChildren().add(new TextField());
        }
    }
}
