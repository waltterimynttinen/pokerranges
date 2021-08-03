import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application {
    public static Stage stage;

    public void setStage(Stage stage){ Main.stage = stage;}

    public static void main(String[] args){
        launch();
    }

    public void start(Stage stage) throws Exception {
        try {
            File f = new File("treeNames");
            f.createNewFile();
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        setStage(stage);
        StartingScene sc = new StartingScene();
        stage.setTitle("Poker Ranges");
        stage.setScene(sc.getStartingScene());
        stage.show();
    }
}
