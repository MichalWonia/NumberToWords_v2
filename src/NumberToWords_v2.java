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

    public static void numberToWords(int number) {
        String thousands = "thousand";
        String hundreds = "hundred ";

        String[] tens = new String[9];
        tens[0] = "ten ";
        tens[1] = "twenty ";
        tens[2] = "thirty ";
        tens[3] = "forty ";
        tens[4] = "fifty ";
        tens[5] = "sixty ";
        tens[6] = "seventy ";
        tens[7] = "eighty ";
        tens[8] = "ninety ";

        String[] teens = new String[9];
        teens[0] = "eleven";
        teens[1] = "twelve";
        teens[2] = "thirteen";
        teens[3] = "fourteen";
        teens[4] = "fifteen";
        teens[5] = "sixteen";
        teens[6] = "seventeen";
        teens[7] = "eighteen";
        teens[8] = "nineteen";

        String[] unities = new String[10];
        unities[0] = "zero";
        unities[1] = "one";
        unities[2] = "two";
        unities[3] = "three";
        unities[4] = "four";
        unities[5] = "five";
        unities[6] = "six";
        unities[7] = "seven";
        unities[8] = "eight";
        unities[9] = "nine";

        System.out.println("Your number in words is:");

        if (number < 0) {
            System.out.print("minus ");
            number = -number;
        }

        String numberString = Integer.toString(number);
        int[] numArray = new int[4];

        for (int i = 0, end = numberString.length() - 1; i < numberString.length(); i++, end--) {
            numArray[i] = Character.getNumericValue(numberString.charAt(end));
        }

        int hun = numArray[2];
        int ten = numArray[1];
        int uni = numArray[0];

        if (numberString.length() == 4)
        {
            System.out.print(thousands);

        } else {
            if (numberString.length() == 3) {
                System.out.print(unities[hun] + " " + hundreds + "and ");
            }
            if (ten >= 2) {
                System.out.print(tens[ten - 1]);
            }
            if (ten == 1) {
                if (uni == 0) {
                    System.out.print(tens[0]);
                } else {
                    System.out.print(teens[uni - 1]);
                }
            }
            if (uni != 0 && (numberString.length() == 1 || ten == 0 || ten >= 2 && uni > 0))
            {
                System.out.print(unities[uni]);
            }
            if (uni == 0 && numberString.length() == 1) {
                System.out.print(unities[0]);
            }
        }
    }

    public static void main(String[] args) {
        int number = enterTheNumber();
        numberToWords(number);
    }
}

