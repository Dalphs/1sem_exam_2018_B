public class Video extends Media {

    private String fileType;
    private String length;
    private String resolution;
    private String potographerName;

    public Video(){

    }

    @Override
    public void logToConsole() {
        System.out.println("Media type: Video");
    }
}
