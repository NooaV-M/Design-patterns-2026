public class Document implements DocumentShell{
    int id;
    String date;
    String content;
    private boolean isProtected = false;

    public Document(int id, String date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }
    public String getContent(String username) {
        return content;
    }


}
