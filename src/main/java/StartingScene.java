import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class StartingScene {
    private Scene scene;
    private FlowPane fp = new FlowPane();
    private Button b = new Button("Create range tree!");
    private HBox hb = new HBox();
    private String rtname;
    private ArrayList<String> nameList = new ArrayList<>();
    private ArrayList<Button> buttonList = new ArrayList<>();
    private ArrayList<String> rtlist = new ArrayList<>();
    private ArrayList<String> cblist = new ArrayList<>();
    private ArrayList<String> rlist = new ArrayList<>();
    private ArrayList<ArrayList> rangeList = new ArrayList<>();
    private ArrayList<ArrayList> categoryList = new ArrayList<>();
    private ArrayList<RangeTree> rangeTreeList = new ArrayList<>();

    public StartingScene(){
        b.setOnAction(e->{
            CreatingScene cs = new CreatingScene();
            Main.stage.setScene(cs.getCreatingScene());
            Main.stage.show();
        });
        hb.getChildren().addAll(b);
        fp.getChildren().addAll(hb);
        createButtons();
        createRangeTrees(nameList);
        fp.setPadding(new Insets(10, 10, 10, 10));
        fp.setHgap(20);
        fp.setVgap(20);
        scene = new Scene(fp, 1600, 900);
    }
    public Scene getStartingScene(){
        return scene;
    }

    public void readTreeNames(){
        try {
            File f = new File("treeNames");
            Scanner reader = new Scanner(f);
            while(reader.hasNextLine()){
                nameList.add(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createButtons(){
        readTreeNames();
        for(int i = 0; i< nameList.size();i++){
            Button b = new Button(nameList.get(i));
            buttonList.add(b);
            fp.getChildren().add(b);
            b.setOnAction(e->{
            });
        }
    }

    /**
     * toinen iteraatio ei toimi oikein, korjatkaa ensi kerralla =)!
     *
     */
    private void createRangeTrees(ArrayList<String> nameList){
        int temp = 0;
        for(int i=0; i<nameList.size();i++){
            categoryList.clear();
            rangeList.clear();
            File f = new File(nameList.get(i));
            try {
                Scanner reader = new Scanner(f);
                while(reader.hasNextLine()){
                    rtlist.add(reader.nextLine());
                }
                for(int j=1;j<rtlist.size();j++){
                    if(rtlist.get(j).isEmpty()){
                        temp++;
                        break;
                    }else{
                        temp++;
                        ArrayList<String> temp1 = new ArrayList<>();
                        String[] temp2 = rtlist.get(j).split(",");
                        for(int k = 0; k<temp2.length;k++){
                            cblist.add(temp2[k]);
                        }
                        categoryList.add(temp1);
                    }
                }
                for(int j=temp+1;j<rtlist.size();j++){
                    ArrayList<String> temp1 = new ArrayList<>();
                    String[] temp2 = rtlist.get(j).split(",");
                    for(int k = 0; k<temp2.length;k++){
                        temp1.add(temp2[k]);
                    }
                    rangeList.add(temp1);
                    rlist = temp1;
                }
                rtname = rtlist.get(0);
                if(categoryList.isEmpty()){
                    RangeTree rt = new RangeTree(rtname, rlist);
                }
                else{
                    RangeTree rt = new RangeTree(rtname, categoryList, rangeList);
                    System.out.println(rt.toString());
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
