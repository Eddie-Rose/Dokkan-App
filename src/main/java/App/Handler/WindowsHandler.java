package App.Handler;

import java.io.File;
import java.util.ArrayList;

public class WindowsHandler {

    public static int fileCounter(String pathname){
        File directory = new File(pathname);
        int fileCount = directory.list().length;

        return fileCount;
    }


    public static ArrayList<String> fileLister(String pathname){
        File directory = new File(pathname);
        ArrayList<String> listOfFiles = new ArrayList<>();
        for(File file : directory.listFiles()){
            if(file.toString().toLowerCase().endsWith(".png")){
                listOfFiles.add(file.getName());
            }
            else if(file.toString().toLowerCase().endsWith(".jpg")){
                listOfFiles.add(file.getName());
            }
            else{
                continue;
            }
        }

        return listOfFiles;
    }


}
