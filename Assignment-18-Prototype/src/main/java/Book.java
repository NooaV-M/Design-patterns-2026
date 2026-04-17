public class Book implements Cloneable {
    private String author;
    private String title;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    @Override
    public Book clone() {
        try {
            Book newbook = (Book) super.clone();
            newbook.setAuthor(this.author);
            newbook.setTitle(this.title);

            return newbook;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Book: " + title + " by " + author;
    }
}
