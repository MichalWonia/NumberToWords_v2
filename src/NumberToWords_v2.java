import java.util.Scanner;

public class NumberToWords_v2 {

    public static int enterTheNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number in the range -1000 to 1000:");
        int number;

        while (true) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 1000 || number < -1000) {
                    System.out.println("Number out of range. Specify a number in range -1000 to 1000");
                } else {
                    break;
                }
            } else {
                System.out.println("You must enter the number");
                sc.next();
            }
        }
        sc.close();
        return number;
    }


    public static void main(String[] args) {
        enterTheNumber();


    }
}

