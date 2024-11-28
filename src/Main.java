import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Function function = new Function();
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while (flag) {
            Function.functionBuilder(function);
            System.out.println("Is written function correct? [Y/N]");
            String answer = scanner.nextLine();

            switch (answer.trim().toLowerCase()) {
                case "y":
                case "yes":
                    System.out.println("Enter lower limit: ");
                    double lowerLimit = scanner.nextDouble();
                    System.out.println("Enter upper limit: ");
                    double upperLimit = scanner.nextDouble();
                    Integral.trapezoidalMethod(lowerLimit, upperLimit, function);
                    Integral.monteCarlo(function, lowerLimit, upperLimit);
                    Integral.rectangularMethod(function, lowerLimit, upperLimit);
                    flag = false;
                    break;
                case "n":
                case "no":
                    System.out.println("Try again then ;(");
                    break;
                default:
                    System.out.println("Invalid input. Please answer with Y/Yes or N/No.");
            }
        }
        scanner.close();
    }
}
