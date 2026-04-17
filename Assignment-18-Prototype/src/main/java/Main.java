import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean onlyDigits(String s) {

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {

            // Check if the character is not a digit
            if (!Character.isDigit(s.charAt(i))) {

                // If any character is not a digit, return false
                return false;
            }
        }
        return true;  // If all characters are digits, return true
    }

    public static void main(String[] args) {
        String state = "main";
        int currentList = 0;
        String currentInput;

        Recommendation currentRecommendation = null;

        List<Recommendation> recommendationLists = new java.util.ArrayList<>(List.of(
                new Recommendation("Children"),
                new Recommendation("Young Adults"),
                new Recommendation("Adults")
        ));

        recommendationLists.get(0).addRecommendedBook(new Book() {{
            setAuthor("Dr. Seuss");
            setTitle("The Cat in the Hat");
        }});

        recommendationLists.get(1).addRecommendedBook(new Book() {{
            setAuthor("Bram Stoker");
            setTitle("Dracula");
        }});

        recommendationLists.get(2).addRecommendedBook(new Book() {{
            setAuthor("Jane Austen");
            setTitle("Pride and Prejudice");
        }});

        Scanner input = new Scanner(System.in);

        while (true) {
            switch (state) {
                case "main":
                    System.out.println("Enter 'lists' to see book recommendation lists");
                    System.out.println("Enter 'create' to create a new recommendation list");
                    System.out.println("Enter 'clone' to clone the existing recommendation list");
                    System.out.println("Enter 'main' to return to the main menu");
                    System.out.println("Enter 'exit' to exit the program");

                     currentInput = input.nextLine();
                    switch (currentInput) {
                        case "lists":
                            state = "lists";
                            break;
                        case "create":
                            state = "create";
                            break;
                        case "clone":
                            state = "clone";
                            break;
                        case "main":
                            state = "main";
                            break;
                        case "exit":
                            System.out.println("Exiting program...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid command.");
                    }
                    System.out.println();
                    System.out.println("-----------------------------------");
                    break;
                case "lists":
                    for (Recommendation recommendationList : recommendationLists) {
                        System.out.println(recommendationList);
                    }
                    System.out.println();
                    System.out.println("Enter the id number of the list you want to view");
                    System.out.println("or");
                    System.out.println("Enter 'main' to return to the main menu");

                    currentInput = input.nextLine();
                    if (onlyDigits(currentInput)) {
                        currentList =  Integer.parseInt(currentInput);
                        state = "listView";
                    } else if (currentInput.equals("main")) {
                        state = "main";
                    }

                    System.out.println();
                    System.out.println("-----------------------------------");
                    break;

                case "listView":
                    for (Recommendation recommendationList : recommendationLists) {
                        if (recommendationList.getId() == currentList) {
                            currentRecommendation = recommendationList;
                            break;
                        }
                    }
                    if (currentRecommendation == null) {
                        System.out.println("Book recommendation list not found");
                        state = "main";
                        break;
                    }

                    System.out.println("Viewing recommendation list " + currentRecommendation.getId() + " with target audience: " + currentRecommendation.getRecommendedBooks());
                    System.out.println();

                    for (Book recommendedBook : currentRecommendation.getRecommendedBooks()) {
                        System.out.println(recommendedBook);
                    }

                    System.out.println("Enter 'add' to add a book to the recommendation list");
                    System.out.println("Enter 'remove' to remove a book from the recommendation list");
                    System.out.println("Enter 'main' to return to the main menu");

                    currentInput = input.nextLine();
                    switch (currentInput) {
                        case "add":
                            state = "add";
                            break;
                        case "remove":
                            state = "remove";
                            break;
                        case "main":
                            state = "main";
                            break;
                        default:
                            System.out.println("Invalid command.");
                    }

                    System.out.println();
                    System.out.println("-----------------------------------");
                    break;

                case "add":
                    System.out.println("Enter the title of the book you want to add");
                    String title = input.nextLine();
                    System.out.println("Enter the author of the book you want to add");
                    String author = input.nextLine();
                    Book newBook = new Book();
                    newBook.setTitle(title);
                    newBook.setAuthor(author);
                    currentRecommendation.addRecommendedBook(newBook);

                    System.out.println("Book added to recommendation list " + currentRecommendation.getId());
                    state = "listView";

                    System.out.println();
                    System.out.println("-----------------------------------");
                    break;

                case "remove":
                    System.out.println("Enter the title of the book you want to remove");
                    String titleToRemove = input.nextLine();
                    Book bookToRemove = null;
                    for (Book recommendedBook : currentRecommendation.getRecommendedBooks()) {
                        if (recommendedBook.getTitle().equals(titleToRemove)) {
                            bookToRemove = recommendedBook;
                            break;
                        }
                    }
                    if (bookToRemove != null) {
                        currentRecommendation.getRecommendedBooks().remove(bookToRemove);
                        System.out.println("Book removed from recommendation list " + currentRecommendation.getId());
                    } else {
                        System.out.println("Book not found in recommendation list " + currentRecommendation.getId());
                    }

                    state = "listView";

                    System.out.println();
                    System.out.println("-----------------------------------");
                    break;

                case "create":
                    System.out.println("Enter the target audience for the new recommendation list");
                    String targetAudience = input.nextLine();
                    Recommendation newList = new Recommendation(targetAudience);
                    recommendationLists.add(newList);

                    state = "add";

                    currentRecommendation = newList;
                    currentList = newList.getId();

                    System.out.println();
                    System.out.println("New recommendation list created with target audience: " + targetAudience);
                    System.out.println("Add first recommended book");
                    System.out.println();
                    System.out.println("--------------------------------");
                    break;
                case "clone":
                    for (Recommendation recommendationList : recommendationLists) {
                        System.out.println(recommendationList);
                    }
                    System.out.println();
                    System.out.println("Enter the id number of the list you want to clone");
                    int id = input.nextInt();
                    Recommendation clonedList = null;
                    for (Recommendation recommendationList : recommendationLists) {
                        if (recommendationList.getId() == id) {
                            clonedList = recommendationList.clone();
                        }
                    }
                    if  (clonedList != null) {
                        recommendationLists.add(clonedList);
                    }

                    state = "main";
                    System.out.println();
                    System.out.println("--------------------------------");
                default:
                    System.out.println("Invalid command. Please enter 'create', 'clone', or 'exit'.");
                    state = "main";
            }

        }
    }
}
