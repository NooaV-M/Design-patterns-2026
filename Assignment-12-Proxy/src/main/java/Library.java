import java.util.HashMap;

public class Library {
    public HashMap<Integer, DocumentShell> docLibrary;
    public Library() {
        docLibrary = new HashMap<>();
    }

    public void addDocument(int id, String date, String content, boolean isProtected) {
        if (isProtected) {
            Document document = new Document(id, date, content);
            DocumentProxy documentProxy = new DocumentProxy(id, date, document);
            docLibrary.put(id, documentProxy);
        } else {
            Document document = new Document(id, date, content);
            docLibrary.put(id, document);
        }
    }
}
