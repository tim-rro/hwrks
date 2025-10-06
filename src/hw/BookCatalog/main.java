package hw.BookCatalog;

import java.util.Arrays;

public class main {
    static void main(String[] args) {
        Magazine m1= new Magazine("Vogue", 2012, 142);
        Magazine m2= new Magazine("Forbes", 2022, 222);

        Book b1=new Book("JK Rowling", "Harry Potter", 2001, 345);
        Book b2 = new Book("Ray Bradbury", "Fahrenheit 451", 1953);

        EBook eb1 = new EBook("Stephen King", "the Shining", 1977, 340, "epub");
        EBook eb2 = new EBook("Some Author", "Some book", 2012, 520, "fb2");

        Publication[] publications = new Publication[4];
        publications[0] = b1;
        publications[1] = b2;
        publications[2] = eb1;
        publications[3] = eb2;

        for(int i=0; i<4; i++){
            System.out.println(publications[i].getInfo());
        }
        System.out.println("\nClassic Books:");
        for(int i=0; i<4; i++){
            if(publications[i].isClassic())
                System.out.println(publications[i].getInfo());
        }
        System.out.println("\n");

        Catalog catalog = new Catalog();

        catalog.addPublication(b1);
        catalog.addPublication(b2);
        catalog.addPublication(eb1);
        catalog.addPublication(eb2);
        catalog.addPublication(m1);
        catalog.addPublication(m2);

        System.out.println("detailed: check: ");
        System.out.println(b1.getInfo());
        System.out.println(b1.getInfo(true));
        System.out.println("\n");

        catalog.printAll();
        System.out.println("\n");

        System.out.println("Found by title Vogue\n" + catalog.findByTitle("Vogue").getInfo());
        System.out.println("\n");

        System.out.println("Found by year 2012\n");
        for(int i=0; i<catalog.findByYear(2012).length;i++) {
            if (catalog.findByYear(2012)[i]!=null)
                System.out.println(catalog.findByYear(2012)[i].getInfo());
        }
        System.out.println("\n");

        b1.setRating(3.3);
        System.out.println("rating of "+b1.getTitle()+" is: " + b1.getRating());
        System.out.println("\n");


        catalog.printByType(Book.class);
        System.out.println("\n");
        catalog.printClassics();

        System.out.println("\nEBooks' specific data: ");
        for (int i = 0; i < 4; i++) {
            if(publications[i] instanceof EBook){
                EBook checked = (EBook) publications[i];
                System.out.println("EBook: " + publications[i].getTitle());
                System.out.println("Format: " + checked.getFormat() + ", File size: " + checked.getFileSizeMB() + " MB");            }
        }
    }
}
