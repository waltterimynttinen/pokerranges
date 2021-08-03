import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CreatingScene {
    private Scene scene;
    private BorderPane bp = new BorderPane();
    private Label lb1 = new Label("Give name:");
    private Label lb2 = new Label("Name category:");
    private Label lb3 = new Label("Number of ranges:");
    private Label lb4 = new Label("Number of branches:");
    private TextField tf1 = new TextField();
    private TextField tf2 = new TextField();
    private TextField tf3 = new TextField();
    private TextField tf4 = new TextField();
    private HBox hb1 = new HBox();
    private HBox hb2 = new HBox();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private Button b1 = new Button("Ready");
    private Button b2 = new Button("Import ranges");
    private Button b3 = new Button("Create category");
    private ArrayList<TextField> tflist = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<ArrayList> alist = new ArrayList<>();
    private ArrayList<ArrayList> categoryList = new ArrayList<>();


    public CreatingScene(){
        hb1.getChildren().addAll(lb1,tf1);
        hb2.getChildren().add(b1);
        vb1.getChildren().addAll(lb2,tf2,lb4,tf4,b3);
        vb2.getChildren().addAll(lb3,tf3,b2);
        hb1.setSpacing(10);
        vb1.setSpacing(10);
        vb2.setSpacing(10);
        bp.setTop(hb1);
        bp.setLeft(vb1);
        bp.setRight(vb2);
        bp.setBottom(hb2);
        hb1.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);
        bp.setPadding(new Insets(20,20,20,20));
        scene = new Scene(bp, 1600, 900);
        createTemplateList();
        onReadyButtonAction(b1);
        onImportButtonAction(b2);
        onCategoryButtonAction(b3);
    }

    public void onReadyButtonAction(Button b){
        b.setOnAction(e->{
            if(tf2.getText().isEmpty() || Integer.parseInt(tf4.getText()) == 0){
                ArrayList<String> rlist = new ArrayList<>();
                for(TextField t : tflist){
                    if(!t.getText().isEmpty()){
                        rlist.add(t.getText());
                    }
                }
                if(categoryList.isEmpty()) {
                    RangeTree rt = new RangeTree(tf1.getText(), rlist);
                    try {
                        FileHandler.createFile(rt);
                        FileHandler.writeToFileBasic(rt);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }else{
                    alist.add(rlist);
                    RangeTree rt = new RangeTree(tf1.getText(),categoryList,alist);
                    try {
                        FileHandler.createFile(rt);
                        FileHandler.writeToFileAdvanced(rt);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                StartingScene sc = new StartingScene();
                Main.stage.setScene(sc.getStartingScene());
            }
            else{
                BranchScene bs = new BranchScene(Integer.parseInt(tf4.getText()), tf1.getText(), categoryList);
                Main.stage.setScene(bs.getBranchScene());
            }
            Main.stage.show();
        });
    }
    public void onImportButtonAction(Button b){
        b.setOnAction(e->{
            tflist.clear();
            vb2.getChildren().clear();
            vb2.getChildren().addAll(lb3,tf3,b2);
            createTextFields(Integer.parseInt(tf3.getText()),vb2);
        });
    }
    public void onCategoryButtonAction(Button b){
        b.setOnAction(e->{
            if((Integer.parseInt(tf4.getText())) == 0){
                Label cname = new Label(tf2.getText());
                categories.add(0,tf2.getText());
                RangeTree.deleteStringArrays(categories);
                categoryList.add(categories);
                vb1.getChildren().clear();
                vb1.getChildren().add(cname);
            }
            else if((Integer.parseInt(tf4.getText())) > 1){
                Label next = new Label("Press ready to create your ranges");
                categories.add(0,tf2.getText());
                RangeTree.deleteStringArrays(categories);
                categoryList.add(categories);
                vb1.getChildren().clear();
                vb1.getChildren().add(next);

            }
        });
    }

    public void createTemplateList(){
        for(int i = 0; i<20; i++){
            categories.add(new String());
        }
    }

    public Scene getCreatingScene(){
        return scene;
    }

    public void createTextFields(int x, VBox vb){
        for(int i = 0; i<x;i++){
            TextField temp = new TextField();
            tflist.add(temp);
            vb.getChildren().add(temp);
        }
    }
}
