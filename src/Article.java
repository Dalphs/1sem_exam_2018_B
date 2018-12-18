public class Article extends Media{

    private String Author;
    private String articleText;
    private String picturePath;

    @Override
    public void logToConsole() {
        System.out.println("Media type: Article");
    }
}
