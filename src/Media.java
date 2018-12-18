import java.io.File;
import java.io.FileNotFoundException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Media {

    /**
     * This class has four private instance variables, two Strings, an int and a Date
     */
    private int assetId;
    private String name;
    private Date created = new Date();
    private String fileName;


    /**
     * This is the constructor for the class, which is used to create instances of the class
     */
    public Media() {
        //The class variable assetID gets assigned using the generate() method from the MediaID class, which returns an int
        assetId = MediaID.generate();
        //The class variable created gets assigned using now() method from the Java class Instant
        created = Date.from(Instant.now());
    }

    public void logToConsole(){
        System.out.println("Name: " + name + "\nMedia type : Media");

    }

    public void logMediaFolder(String folderName){
        File file = new File("./" + folderName);
        File[] listOfFiles = file.listFiles();
        for (File f: listOfFiles) {
            if (f.isFile())
                System.out.println("File: " + f.getName());
        }

    }

    public String[] readMediaFolder(String folderName){
        File file = new File("./" + folderName);
        File[] listOfFiles = file.listFiles();
        String[] names = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            names[i] = listOfFiles[i].getName();
        }

        ArrayList<Media> mediaObjects = new ArrayList<>();

        for (File f: listOfFiles) {
            if(f.getName().contains(".txt"))
                mediaObjects.add(new Article());
            else if (f.getName().contains(".jpg") || f.getName().contains(".png") || f.getName().contains(".gif"))
                mediaObjects.add(new Picture());
            else if (f.getName().contains(".mp4") || f.getName().contains(".m4v") || f.getName().contains(".mov"))
                mediaObjects.add(new Video());
        }
        return names;
    }

    //These 8 methods are getters and setters for the private instance variables
    //They are used for accesing and modifying the variables from outside the class
    //The 4 setter methods are void, and the 4 getters returns variables.
    public int getAssetId() {
        return assetId;
    }

    public void setAssetId(int assetId) {
        this.assetId = assetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    //This class has its own toString() method, and therefore it is overriding the toString() method from the Object class
    //The method returns a string representation of the 4 class variables
    @Override
    public String toString() {
        return "Media{" +
                "assetId=" + assetId +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}