import java.io.File;
import java.time.Instant;
import java.util.Date;

public class Media {

    /**
     * This class has four private class variables, two Strings, an int and a Date
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

    //These 8 methods are getters and setters for the private class variables
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