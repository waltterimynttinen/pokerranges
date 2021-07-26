import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.concurrent.Flow;

public class BranchScene {
    private Scene scene;
    private FlowPane fp = new FlowPane();
    private int branches;
    private String name;
    private Button readyButton = new Button("Ready");
    private ArrayList<VBox> vlist = new ArrayList<>();
    private ArrayList<Button> blist = new ArrayList<>();
    private ArrayList<TextField> tflist1 = new ArrayList<>();
    private ArrayList<TextField> tflist2 = new ArrayList<>();
    private ArrayList<String> brlist = new ArrayList<>();
    private ArrayList<String> categories = new ArrayList<>();
    private ArrayList<ArrayList> alist1 = new ArrayList<>();
    private ArrayList<ArrayList> alist2 = new ArrayList<>();
    private String cssLayout = "-fx-border-color: black;\n" +
            "-fx-border-insets: 10;\n" +
            "-fx-border-width: 3;\n";

    public BranchScene(int branches, String name, ArrayList<String> categories){
        this.branches = branches;
        this.name = name;
        this.categories = categories;
        createBranches(branches);
        fp.getChildren().add(readyButton);
        scene = new Scene(fp,1600,900);
        onReadyButtonAction(readyButton);
    }

    public Scene getBranchScene(){
        return scene;
    }

    public void createBranches(int branches){
        for(int i = 0;i<branches;i++){
            VBox vtemp = new VBox();
            Button btemp = new Button("Import ranges");
            TextField tftemp1 = new TextField();
            TextField tftemp2 = new TextField();
            vtemp.getChildren().addAll(new Label("Give name to branch"),tftemp1,new Label("Give number of branches"),tftemp2,btemp);
            vtemp.setSpacing(10);
            vtemp.setStyle(cssLayout);
            fp.setPadding(new Insets(20,20,20,20));
            fp.getChildren().add(vtemp);
            fp.setHgap(20);
            fp.setVgap(20);
            vlist.add(vtemp);
            tflist1.add(tftemp1);
            tflist2.add(tftemp2);
            blist.add(btemp);
            createTemplateList();
            btemp.setOnAction(e->{
                vtemp.getChildren().clear();
                vtemp.getChildren().addAll(new Label(tftemp1.getText()), new Label("Give number of branches"), tftemp2, btemp);
                createTextFields(Integer.parseInt(tftemp2.getText()), vtemp, blist.indexOf(btemp), tftemp1);
            });
        }
    }
    public void createTextFields(int x, VBox vb, int y, TextField tf){
        ArrayList<TextField> temp2 = new ArrayList<>();
        for(int i = 0; i<x;i++){
            TextField temp1 = new TextField();
            temp2.add(temp1);
            vb.getChildren().add(temp1);
        }
        alist1.remove(y);
        alist1.add(y, temp2);
        brlist.remove(y);
        brlist.add(y, tf.getText());
    }

    public void createTemplateList(){
        for(int i = 0; i<20; i++){
            alist1.add(new ArrayList());
            brlist.add(new String());
        }
    }

    public void onReadyButtonAction(Button b){
        b.setOnAction(e->{
            for(String s: brlist){
                if(!s.isEmpty()){
                    categories.add(s);
                }
            }
            for(ArrayList<TextField> list : alist1){
                ArrayList<String> rlist = new ArrayList<>();
                for(TextField textField : list){
                    if(!textField.getText().isEmpty()) {
                        rlist.add(textField.getText());
                    }
                }
                alist2.add(rlist);
            }
            RangeTree rt = new RangeTree(name, categories, alist2);
            System.out.println(rt.toString());
        });
    }
}
