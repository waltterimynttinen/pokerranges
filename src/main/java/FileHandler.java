import com.sun.javafx.iio.ios.IosDescriptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    public static void createFile(RangeTree rt) throws IOException {
        try {
            File f = new File(rt.getName());
            if (f.createNewFile()) {
                System.out.println("File created: " + f.getName());
                writeNameToFile(rt);
            } else {
                System.out.println("File couldn't be created");
            }
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void writeToFileBasic(RangeTree rt){
        try{
            FileWriter fw = new FileWriter(rt.getName());
            fw.write(rt.getName() + ",\n" + "\n" + createStrings(rt.getRlist()));
            fw.close();
        }catch(IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void writeToFileAdvanced(RangeTree rt){
        try{
            FileWriter fw = new FileWriter(rt.getName());
            fw.write(rt.getName() + ",\n");
            for(int i = 0; i<rt.getCategoryList().size(); i++){
                fw.write(createStrings(rt.getCategoryList().get(i)) + "\n");
            }
            fw.write("\n");
            for(int i = 0; i<rt.getAlist().size(); i++){
                fw.write(createStrings(rt.getAlist().get(i)) + "\n");
            }
            fw.close();
        }catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public static void writeNameToFile(RangeTree rt){
        try{
            FileWriter fw = new FileWriter("treeNames", true);
            fw.write(rt.getName() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createStrings(ArrayList<String> list){
        String s = "";
        for(int i = 0; i<list.size();i++){
            s += list.get(i) + ",";
        }
        return s;
    }
}
