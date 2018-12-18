public class Main {

    /**
     * This class has two constant classvariables that are public, SOFTWARE_VERSION and MEDIA_MAPPE
     */
    public static final String SOFTWARE_VERSION = "0.1.0";
    public static final String MEDIA_MAPPE = "media/";

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {

        //The static method test is called from the Test class
        Media media = new Media();
        media.setName("Hans");
        media.logToConsole();

    }
}

