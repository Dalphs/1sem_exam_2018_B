import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Media {

    /**
     * This class has 5 private instance variables, two Strings, an int, a boolean and a Date
     * The boolean userGeneratedContent is used to tell wether the content is created by TV2.dk or a user
     */
    private int assetId;
    private String name;
    private Date created = new Date();
    private String fileName;
    private boolean userGeneratedContent;


    /**
     * This is the constructor for the class, which is used to create instances of the class
     */
    public Media() {
        //The class variable assetID gets assigned using the generate() method from the MediaID class, which returns an int
        assetId = MediaID.generate();
        //The class variable created gets assigned using now() method from the Java class Instant
        created = Date.from(Instant.now());
    }

    //Method that saves the varibles of an instance of the class Media.
    //It does not take parametres but it uses the class variables.
    public void saveToDB() {
        try {
            //Creates an instance of the Connection class and establishes a connection to the tv2dk database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tv2dk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            //Creates an instance of the Statement class, which connects the con Object
            Statement st = con.createStatement();

            //The executeUpdate() method form the Statement class is used, and it takes a String as a parameter
            //The String is an SQL-statement which will add a new row to the database
            st.executeUpdate("INSERT INTO mediadata(assetid, name, date, filename) VALUES (" + assetId + ", '" + name
             + "', '" + created.toString() + "', '" + fileName + "');");
            //Closing conection to database
            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    //Method that prints the name of the instance and name of the class to the console
    public void logToConsole(){
        System.out.println("Name: " + name + "\nMedia type : Media");

    }

    //This method takes a string as a parameter
    public void logMediaFolder(String folderName){
        //The parameter is used to find a specific fold by concatenation
        //An instance of the File is created and the path for the file is obtained using the parameter
        File file = new File("./" + folderName);

        //An array of File-objects is instantiated with the the names of files in the folder
        File[] listOfFiles = file.listFiles();
        //This for-each loop runs through the listOfFiles Array and prints all the names of the files to the console
        for (File f: listOfFiles) {
            if (f.isFile())
                System.out.println("File: " + f.getName());
        }
    }

    //This method returns a String array with the names of all the files in the folderName that the method takes as a parameter
    public String[] readMediaFolder(String folderName){
        //An instance of the File class is instantiated and sets the path using thefolderName parameter
        //Two arrays are created and the name of the Files are saved in the names String array
        File file = new File("./" + folderName);
        File[] listOfFiles = file.listFiles();
        String[] names = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            names[i] = listOfFiles[i].getName();
        }

        //An arraylist with Media Object is created
        ArrayList<Media> mediaObjects = new ArrayList<>();

        //All Files from the File array listOfFiles are checked for their datatype.
        //If the file is a .txt an instance of the Article class is created and saved in the mediaObjects ArrayList
        //.jpg, .png and .gif are created as instances of the Picture class
        //.mp4, .m4v, .mov are created as instances of the Movie class
        for (File f: listOfFiles) {
            if(f.getName().contains(".txt"))
                mediaObjects.add(new Article());
            else if (f.getName().contains(".jpg") || f.getName().contains(".png") || f.getName().contains(".gif"))
                mediaObjects.add(new Picture());
            else if (f.getName().contains(".mp4") || f.getName().contains(".m4v") || f.getName().contains(".mov"))
                mediaObjects.add(new Video());
        }
        //The String array names is returned
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