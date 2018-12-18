import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


/**
 *  Hver mediefil hos TV2 skal have et unikt ID, og denne klasse hjælper med at genrere unikke ID'er
 *  The name of the class is MediaID. The class does not have a constructor, due to its only method being static
 */
public class MediaID {

    //Class variable of type int. It is private meaning it can only be accesed from this class
    //It is also static , meaning it can only be used by static methods
    private static int latestId = 100;


    /**
     * This method is called generate and is static, meaning it can be used without creating an instance of the class MediaID
     * The generate() method returns an int
     * @return int
     */
    public static int generate() {

        //An instance of the File class named file is instantiated.
        //The File class constructor taking a String as a parameter is used
        //The string parameter represents the path for the file we want to acces
        File file = new File("media_id.txt");

        // Låser filen op før adgang
        // file.setWritable(true);

        //The code within the try block will run, if an IOException happens the catch block will run
        // and the program will continue after the catch block is excecuted
        try {

            //This block of code will run if the if-statement is true
            //The exists() method is called on the File instance created earlier
            //The exists() method returns a boolean if the path specified earlier leads to a file
            if (file.exists()) {

                //An instance of the FileReader class is instanciated called fileReader
                //In this instance the constructor takes the file instance of the File class s a parameter
                FileReader fileReader = new FileReader(file);

                //An instance of the Scanner class is instantiated called scanner
                //In this instance the constructor takes the file instance of the File class as a parameter
                Scanner scanner = new Scanner(file);

                //The class variable latestId is assigned the value of the next int from the file using the nextInt()
                //method which returns an int.
                // The method already returns an int, which makes it obsolete to cast it as an int
                latestId = (int) scanner.nextInt();
            }

            //The class variable latestID is incremented by one
            latestId++;

            //An instance of the FileWriter class called fileWriter is instaniated
            //The constructor from the FileWriter class taking a file as a parameter is used
            FileWriter fileWriter = new FileWriter(file);

            //The write() method from the FileWriter class is called on fileWriter
            //The write() method can add text to the file
            //In this case the write method takes a String as a parameter
            //To convert the latestID value from an int to a string, the static method toString from
            //the Integer class is used
            fileWriter.write(Integer.toString(latestId));

            //The close() method is called on the instance of the FileWriter class
            //It would have to be opened to edit again
            fileWriter.close();

            //As mentioned ealier, if an IOException happens in the try block, this catch block will run
            //If an IOException happens and instance of the IOException class called e is instantiated
        } catch (IOException e) {
            //The printStackTrace() method is called on e, which will print a message to the console
            e.printStackTrace();
        }

        // Låser filen ned for at den ikke redigeres ved en fejl
        // file.setReadOnly();

        //Returns the class variable latestID
        return latestId;
    }

}