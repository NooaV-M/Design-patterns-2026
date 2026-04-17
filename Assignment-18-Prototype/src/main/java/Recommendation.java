import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable{
    private String targetAudience;
    private List<Book> recommendedBooks;
    private static int idCounter = 0;
    private int id;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.id  = idCounter++;
    }

    public void addRecommendedBook(Book book) {
        if (recommendedBooks == null) {
            recommendedBooks = new ArrayList<Book>();
        }
        recommendedBooks.add(book);
    }

    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public int getId() {
        return id;
    }

    @Override
    public Recommendation clone() {
        try {
            Recommendation clone = (Recommendation) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            clone.id = idCounter++;
            clone.recommendedBooks = new ArrayList<Book>();
            for (Book recommendedBook : recommendedBooks) {
                recommendedBook = (Book) recommendedBook.clone();
                clone.recommendedBooks.add(recommendedBook);
            }

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String toString() {
        return "Recommendation list " + id + " with target audience: " + targetAudience + " " + recommendedBooks.size() + " books: " + recommendedBooks;
    }
}
