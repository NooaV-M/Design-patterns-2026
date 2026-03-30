public class SearchVisitor implements FileSystemVisitor {
    private String searchTerm;

    public SearchVisitor(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    @Override
    public void visit(Directory directory) {
        if (directory.getName().contains(searchTerm)) {
            System.out.println("Found Directory: " + directory.getName() + " Matching Search Term: " + searchTerm);
        }
        for (FileSystemElement element : directory.getContents()) {
            element.accept(this);
        }
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchTerm)) {
            System.out.println("Found File: " + file.getName() + " Matching Search Term: " + searchTerm);
        }
    }
}
