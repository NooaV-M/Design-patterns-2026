public class DocumentProxy implements DocumentShell{
    private int id;
    private String date;
    private Document document;
    private boolean isProtected = true;

    DocumentProxy(int id, String date, Document document) {
        this.id = id;
        this.date = date;
        this.document = document;
    }

    @Override
    public String getContent(String username) {
        if (AccesControlService.getInstance().isAllowed(id, username)){
            return document.getContent(username);
        } else {
            throw new AccessDeniedException("User " + username + " is not allowed to access document with id " + id);
        }
    }
}
