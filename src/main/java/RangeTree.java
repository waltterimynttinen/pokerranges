import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class RangeTree {
    private String name;
    private int category;
    ArrayList<ArrayList> list;
    ArrayList<String> categories;

    public RangeTree(String name, int category, ArrayList<ArrayList> list, ArrayList<String> categories){
        this.name = name;
        this.category = category;
        this.list = new ArrayList<>();
        this.categories = new ArrayList<>();
    }
}
