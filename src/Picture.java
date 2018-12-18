public class Picture extends Media {

    private String fileType;
    private int width;
    private int height;
    private String photograpgherName;

    public Picture() {
    }

    @Override
    public void logToConsole() {
        System.out.println("Media type: Picture");
    }
}
