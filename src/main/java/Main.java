import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage stage;

    public void setStage(Stage stage){ Main.stage = stage;}

    public static void main(String[] args){
        launch();
    }

    public void start(Stage stage) throws Exception {
        setStage(stage);
        StartingScene sc = new StartingScene();
        stage.setTitle("Poker Ranges");
        stage.setScene(sc.getStartingScene());
        stage.show();
    }
}
