import java.util.ArrayList;
import java.util.Scanner;

public class Function {

    private int highestXDegree;
    private ArrayList<Integer> xCofactor;
    private int constantTerm;
    private ArrayList<Integer> powers;
    public Function(){
        this.highestXDegree = 0;
        this.xCofactor = new ArrayList<>();
        this.constantTerm = 0;
        this.powers = new ArrayList<>();
    }

    public int getHighestXDegree() {
        return highestXDegree;
    }

    public void setHighestXDegree(int highestXDegree) {
        this.highestXDegree = highestXDegree;
    }

    public int getConstantTerm() {
        return constantTerm;
    }

    public void setConstantTerm(int constantTerm) {
        this.constantTerm = constantTerm;
    }

    public ArrayList<Integer> getxCofactor() {
        return xCofactor;
    }

    public void setxCofactor(ArrayList<Integer> xCofactor) {
        this.xCofactor = xCofactor;
    }

    public ArrayList<Integer> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<Integer> powers) {
        this.powers = powers;
    }

    public static double functionValue(Function function, double xValue) {
        ArrayList<Integer> functionCofactors = function.getxCofactor();
        ArrayList<Integer> powers = function.getPowers();

        double value = 0;
        for(int i = 0; i < functionCofactors.size(); i++) {
            value += Math.pow(xValue, powers.get(i)) * functionCofactors.get(i);
        }
        value += function.getConstantTerm();
        return value;
    }

    public static int aboveOrBeneath(double x, Function function, double y) {
        double functionValue = functionValue(function, x);
        if (y > functionValue) {
            return 1;
        } else if (y < functionValue) {
            return -1;
        } else if (y == functionValue) {
            return 0;
        }
        return 2;
    }

    public static String convertToSuperscript(String expression) {
        return expression.replaceAll("\\^0", "⁰")
                .replaceAll("\\^1", "¹")
                .replaceAll("\\^2", "²")
                .replaceAll("\\^3", "³")
                .replaceAll("\\^4", "⁴")
                .replaceAll("\\^5", "⁵")
                .replaceAll("\\^6", "⁶")
                .replaceAll("\\^7", "⁷")
                .replaceAll("\\^8", "⁸")
                .replaceAll("\\^9", "⁹");
    }

    public static void functionBuilder(Function function) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the highest \"x\" degree: ");
        int highestXDegree = scanner.nextInt();
        function.setHighestXDegree(highestXDegree);

        ArrayList<Integer> functionCofactors = new ArrayList<>();
        ArrayList<Integer> powers = new ArrayList<>();
        for (int i = highestXDegree; i > 0; i --) {
            System.out.println("Enter x^" + i + " cofactor: ");
            int cofactor = scanner.nextInt();
            functionCofactors.add(cofactor);
            powers.add(i);
        }
        function.setxCofactor(functionCofactors);
        function.setPowers(powers);

        System.out.print("Enter the constant term: \n");
        int constantTerm = scanner.nextInt();
        function.setConstantTerm(constantTerm);

        StringBuilder functionString = new StringBuilder();
        for (int i = function.getHighestXDegree(); i > 0; i--) {
            if(function.getxCofactor().get(function.getHighestXDegree() - i) != 0) {
                if (function.getxCofactor().get(function.getHighestXDegree() - i) == 1) {
                    if (i == 1) {
                        functionString.append("x");
                    } else {
                        functionString.append("x^").append(i).append("+");
                    }
                } else {
                    if (i == 1) {
                        functionString.append(function.getxCofactor().get(function.getHighestXDegree() - i)).append("x");
                    } else {
                        functionString.append(function.getxCofactor().get(function.getHighestXDegree() - i)).append("x^").append(i).append("+");
                    }
                }
            } else {
                continue;
            }
        }
        if(function.getConstantTerm() != 0) {
            functionString.append("+").append(function.getConstantTerm());
        }

        System.out.println("f(x) = " + convertToSuperscript(functionString.toString()));
    }

}
