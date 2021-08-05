import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ViewingScene {
    private Scene scene;
    private BorderPane bp = new BorderPane();
    private HBox hb1 = new HBox();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private ArrayList<ComboBox> comboBoxList = new ArrayList<>();
    private ArrayList<Button> buttonList = new ArrayList<>();

    public ViewingScene(RangeTree rt){
        hb1.getChildren().add(new Label(rt.getName()));
        bp.setTop(hb1);
        bp.setLeft(vb1);
        bp.setRight(vb2);
        vb1.setSpacing(10);
        vb2.setSpacing(10);
        bp.setPadding(new Insets(20,20,20,20));
        hb1.setAlignment(Pos.CENTER);
        createComboBoxes(rt);
        scene = new Scene(bp, 1600,900);
    }

    public void createComboBoxes(RangeTree rt){
        if(rt.getType() == 1 || rt.getType() == 2) {
            createButtons(rt, 0);
        }
        else {
            for (int i = 0; i < rt.getCategoryList().size(); i++) {
                ComboBox boxTemp = new ComboBox();
                Label labelTemp = new Label((String) rt.getCategoryList().get(i).get(0));
                for (int j = rt.getCategoryAmount(); j < rt.getCategoryList().get(i).size(); j++) {
                    boxTemp.getItems().add(rt.getCategoryList().get(i).get(j));
                }
                boxTemp.setOnAction(e -> {
                    vb2.getChildren().clear();
                    buttonList.clear();
                    createButtons(rt, boxTemp.getSelectionModel().getSelectedIndex());
                });
                comboBoxList.add(boxTemp);
                vb1.getChildren().addAll(labelTemp, boxTemp);
            }
        }
    }

    public void createButtons(RangeTree rt, int x){
        if(rt.getType() == 1){
            for(int i = 0; i<rt.getRlist().size();i++){
                Button buttonTemp = new Button(rt.getRlist().get(i));
                buttonList.add(buttonTemp);
                vb2.getChildren().add(buttonTemp);
            }
        }
        else if(rt.getType() == 2){
            for(int i = 0; i< rt.getCategoryAmount(); i++){
                Button b = new Button((String) rt.getCategoryList().get(i).get(0));
                vb1.getChildren().add(b);
            }
        }
        else{
            for(int i = 0; i<rt.getAlist().get(x).size();i++){
                Button buttonTemp = new Button((String) rt.getAlist().get(x).get(i));
                buttonList.add(buttonTemp);
                vb2.getChildren().add(buttonTemp);
            }
        }
    }

    public Scene getViewingScene(){
        return scene;
    }
}
