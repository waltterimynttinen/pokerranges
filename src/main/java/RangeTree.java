import javax.swing.text.html.ImageView;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class RangeTree {
    private String name;
    private ArrayList<String> rlist = new ArrayList<>();
    private ArrayList<String> cblist = new ArrayList<>();
    private ArrayList<ArrayList> alist = new ArrayList<>();
    private ArrayList<ArrayList> categoryList = new ArrayList<>();

    public RangeTree(String name, ArrayList<String> cblist, ArrayList<ArrayList> alist){
        this.name = name;
        this.cblist = deleteStringArrays(cblist);
        this.alist = deleteArrays(alist);
        categoryList.add(cblist);
    }

    public RangeTree(String name, ArrayList<String> rlist){
        this.name = name;
        this.rlist = deleteStringArrays(rlist);
    }

    public String toString(){
        return this.name+" "+this.cblist+" "+this.alist;
    }

    public ArrayList<ArrayList> deleteArrays(ArrayList<ArrayList> al){
        ArrayList<ArrayList> temp = al;
        temp.removeIf(item -> item == null || item.isEmpty());
        return temp;
    }
    public ArrayList<String> deleteStringArrays(ArrayList<String> al){
        ArrayList<String> temp = al;
        temp.removeIf(item -> item == null || "".equals(item));
        return temp;
    }
    public String getName(){
        return name;
    }
    public ArrayList<String> getCblist(){
        return cblist;
    }
    public ArrayList<ArrayList> getAlist(){
        return  alist;
    }
    public ArrayList<String> getRlist(){
        return rlist;
    }
    public ArrayList<ArrayList> getCategoryList(){
        return categoryList;
    }
}
