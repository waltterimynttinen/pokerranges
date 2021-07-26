import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class RangeTree {
    private String name;
    private int category;
    private ArrayList<String> cblist = new ArrayList<>();
    private ArrayList<ArrayList> alist = new ArrayList<>();
    private ArrayList<ArrayList> categoryList = new ArrayList<>();

    public RangeTree(String name, ArrayList<String> cblist, ArrayList<ArrayList> alist){
        category = 1;
        this.name = name;
        this.cblist = cblist;
        this.alist = alist;
    }

    public RangeTree(String name, ArrayList<ArrayList> alist){
        category = 1;
        this.name = name;
        this.alist = alist;
        this.categoryList = new ArrayList<>();
    }

    public String toString(){
        return name+" "+cblist+" "+alist;
    }
}
