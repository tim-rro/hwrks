package hw.BookCatalog;

public class Book extends Publication implements ClassicCheckable, Rateable{
    private String author;
    private int pageCount;
    private double rating;

    public String getAuthor() {
        return author;
    }

    public Book(String author, String title, int year) {
        super(title, year);
        this.author=author;
    }
    public Book(String author, String title, int year, int pageCount) {
        super(title, year);
        this.author=author;
        this.pageCount = this.pageCount;
    }

    @Override
    public boolean isClassic() {
        int year=getYear();
        return 2025 - year >= 50;

    }
    @Override
    public void setRating(double rating) {
        this.rating=rating;
    }

    @Override
    public double getRating() {
        return rating;
    }
    @Override
    public String getInfo(){
        return "Book: " + getTitle() + ", Author: " +  getAuthor() + ", Year: " +  getYear();
    }
}
