public class Article extends Media{

    private String Author;
    private String articleText;
    private String picturePath;

    public Article() {
    }

    @Override
    public void logToConsole() {
        System.out.println("Media type: Article");
    }
}
