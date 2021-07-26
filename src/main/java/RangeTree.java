import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class RangeTree {
    private String name;
    private int category;
    ArrayList<ArrayList> list;
    ArrayList<ArrayList> categoryList;

    public RangeTree(String name, ArrayList<String> clist, ArrayList<ArrayList> alist){
        category = 1;
        this.name = name;
        this.list = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }

    public RangeTree(String name, ArrayList<ArrayList> alist){
        category = 1;
        this.name = name;
        this.list = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }
}
