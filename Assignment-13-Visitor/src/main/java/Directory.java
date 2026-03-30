import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{
    private String name;

    private List<FileSystemElement> contents;

    public Directory(String name, List<FileSystemElement> contents) {
        this.name = name;
        this.contents = contents;
    }

    public Directory(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public Directory() {
            this.contents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<FileSystemElement> getContents() {
        return contents;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setContents(List<FileSystemElement> contents) {
        this.contents = contents;
    }

    public void addContent(FileSystemElement content) {
        this.contents.add(content);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
