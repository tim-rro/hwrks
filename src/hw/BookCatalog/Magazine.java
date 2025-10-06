package hw.BookCatalog;

public class Magazine extends Publication implements ClassicCheckable {
    int issueNumber;

    public int getIssueNumber() {
        return issueNumber;
    }

    public Magazine(String title, int year, int issueNumber) {
        super(title, year);
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean isClassic() {
        int year=getYear();
        return 2025 - year >= 30;
    }

    @Override
    public String getInfo() {
        return "Magazine name: " + getTitle() + ", Year of issue: " + getYear() + ", Issue number: " + getIssueNumber();
    }
}
