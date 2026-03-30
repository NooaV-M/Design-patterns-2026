import java.nio.file.FileVisitor;

public class Main {
    public static void main(String[] args) {
        Directory directory1 = new Directory("Directory1");

        Directory directory2 = new Directory("Directory2");

        Directory directory3 = new Directory("Directory3");

        directory1.addContent(directory2);
        directory1.addContent(directory3);

        File file1 = new File("File1.txt", 100);
        File file2 = new File("File2.txt", 200);
        File file3 = new File("File3.pdf", 300);
        File file4 = new File("File4.gif", 400);

        directory1.addContent(file1);
        directory3.addContent(file2);
        directory3.addContent(file3);
        directory2.addContent(file4);

        SearchVisitor searchVisitor = new SearchVisitor(".txt");

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();

        directory1.accept(searchVisitor);

        directory1.accept(sizeCalculatorVisitor);
    }
}
