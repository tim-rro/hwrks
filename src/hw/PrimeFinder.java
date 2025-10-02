package hw;

import java.util.Scanner;
class PrimeFinder{
    public static boolean prime(int n){
        int count=0;
        if (n <= 1) {
            return false;
        }
        for (int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    static void main() {
        int[] n=new int[10];
        int count=0;
        Scanner scanner = new Scanner(System.in);

        for (int i=0; i<10;i++){
            System.out.println("Enter num "+(i+1)+":");
            n[i] = scanner.nextInt();
        }
        for (int i=0; i<10; i++) {
            if (prime(n[i])) {
                count++;
                System.out.println(n[i] + " is prime num!");
            }
        }

        if(count==0){
            System.out.println("There was 0 prime numbers.");
        }
        else {
            System.out.println("There was " + count + " prime numbers.");
        }
    }
}
