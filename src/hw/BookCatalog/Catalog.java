package hw.BookCatalog;

import java.util.Objects;

public class Catalog {
    private Publication[] publications = new Publication[100];
    private int count=0;
    public void addPublication(Publication pub){
        if(count< publications.length){
            publications[count]=pub;
            count++;
        }
    }
    void printAll(){
        System.out.println("All publications in catalog:");
        for(int i=0; i<count; i++){
            System.out.println(publications[i].getInfo());
        }

    }
    void printClassics(){
        System.out.println("Classic books:");
        for (int i = 0; i < count; i++) {
            if (publications[i] instanceof ClassicCheckable){
                ClassicCheckable classicCheckable = (ClassicCheckable) publications[i];
                if (classicCheckable.isClassic())
                    System.out.println(publications[i].getInfo());
            }
        }
    }
    Publication findByTitle(String title){
        int index=0;
        for(int i=0; i<count; i++){
            if(Objects.equals(publications[i].getTitle(), title)) {
                index = i;
                break;
            }
        }
        return publications[index];
    }
    Publication[] findByYear(int year){
        Publication[] found = new Publication[count];
        int index=0;
        for(int i=0; i<count; i++){
            if(publications[i].getYear()==year) {
                found[index]=publications[i];
                index++;
            }
        }
        return found;
    }

    void printByType(Class<?> type){
        System.out.println("Publications by specified class:");
        for (int i = 0; i < count; i++) {
            if (type == Book.class && publications[i] instanceof Book
            || type == Magazine.class && publications[i] instanceof Magazine){
                System.out.println(publications[i].getInfo());
            }
        }
    }
}
