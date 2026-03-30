public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int size;

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getContents()) {
            element.accept(this);
        }
        System.out.println("Directory: " + directory.getName() + ", Size: " + size);
    }

    @Override
    public void visit(File file) {
        this.size += file.getSize();
        System.out.println("File: " + file.getName() + ", Size: " + file.getSize());
    }

}
