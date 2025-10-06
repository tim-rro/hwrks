package hw.BookCatalog;

public abstract class Publication {
    private String title;
    private int year;
    public Publication(String title, int year){
        this.title=title;
        this.year=year;
    }
    public String getTitle(){
        return title;
    }

    public int getYear() {
        return year;
    }

    public abstract String getInfo();
    public abstract boolean isClassic();
    public String getInfo(boolean detailed){
        if(detailed)
            return getInfo() + ", Type of publication: " + this.getClass().getSimpleName();
        else
            return getInfo();
    }
}
