import javax.swing.text.html.ImageView;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class RangeTree {
    private String name;
    private ArrayList<String> rlist = new ArrayList<>();
    private ArrayList<ArrayList> alist = new ArrayList<>();
    private ArrayList<ArrayList> categoryList = new ArrayList<>();
    private int categoryAmount = 1;
    private int type;

    public RangeTree(String name, ArrayList<ArrayList> categoryList, ArrayList<ArrayList> alist){
        this.name = name;
        this.alist = deleteArrays(alist);
        this.categoryList = categoryList;
        this.type = checkType();
    }

    public RangeTree(String name, ArrayList<String> rlist){
        this.name = name;
        this.rlist = deleteStringArrays(rlist);
        this.type = checkType();
    }

    public String toString(){
        return this.name+" "+this.categoryList+" "+this.alist + " "+this.type;
    }

    public String toStringSimple(){
        return this.name+" "+this.rlist+" "+this.type;
    }

    public ArrayList<ArrayList> deleteArrays(ArrayList<ArrayList> al){
        ArrayList<ArrayList> temp = al;
        temp.removeIf(item -> item == null || item.isEmpty());
        return temp;
    }
    public static ArrayList<String> deleteStringArrays(ArrayList<String> al){
        ArrayList<String> temp = al;
        temp.removeIf(item -> item == null || "".equals(item));
        return temp;
    }
    public String getName(){
        return name;
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
    public int getCategoryAmount(){
        return categoryAmount;
    }
    public void addCategoryAmount(){
        categoryAmount++;
    }
    public int getType(){
        return type;
    }
    public int checkType(){
        if(categoryList.isEmpty()){
            return 1;
        }
        else if(checkLists(categoryList)){
            return 2;
        }
        else{
            return 3;
        }
    }
    public boolean checkLists(ArrayList<ArrayList> al){
        for(int i=0;i<al.size();i++){
            if(al.get(i).size() != 1){
                return false;
            }else{
                continue;
            }
        }
        return true;
    }
}
