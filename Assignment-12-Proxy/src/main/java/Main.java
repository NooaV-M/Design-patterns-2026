public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addDocument(1, "2024-01-01", "Public Document Content", false);
        library.addDocument(2, "2024-01-02", "private Document Content", true);
        library.addDocument(3, "2024-01-03", "Public Document Content", false);
        library.addDocument(4, "2024-01-04", "private Document Content", true);
        library.addDocument(5, "2024-01-05", "Public Document Content", false);

        AccesControlService.getInstance().addAccess("Alice", 2);
        AccesControlService.getInstance().addAccess("Bob", 4);

        try {
            System.out.println(library.docLibrary.get(1).getContent("Alice"));
            System.out.println(library.docLibrary.get(2).getContent("Alice"));
            System.out.println(library.docLibrary.get(3).getContent("Bob"));
            System.out.println(library.docLibrary.get(4).getContent("Alice"));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
