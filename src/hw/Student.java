package hw;


public class Student {
    public static void printInfo(String name, String surname, int age, String major, int year){
        System.out.println(name + " " + surname + ", " + age + " years old. " + year + " year " + major + " student.");
    }

    static void main() {
        String name="MR";
        String surname="Student";
        String major="CS";
        int age=18;
        int year=4;
        printInfo(name, surname, age, major, year);
    }
}
