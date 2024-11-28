public class Integral {
    private float lowerLimit;
    private float upperLimit;
    private Function function;

    public Integral() {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.function = function;
    }

    public float getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(float lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public float getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(float upperLimit) {
        this.upperLimit = upperLimit;
    }

    public static void trapezoidalMethod(double lowerLimit, double upperLimit, Function function) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        int n = 1000;
        double h = (upperLimit - lowerLimit) / n;
        double integral = 0;

        // Summation notation implementation
        for (int k = 1; k < n; k++) {
            integral += Function.functionValue(function, lowerLimit + k * h);
        }

        integral += (Function.functionValue(function, lowerLimit) / 2) + (Function.functionValue(function, upperLimit) / 2);

        integral *= h;

        System.out.println("Calculated integral ("+ methodName + "): " + integral);
    }

    public static void monteCarlo(Function function, double minX, double maxX) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;
        int samplePoints = 10000;

        for (int i = 0; i < samplePoints; i++) {
            double x = minX + Math.random() * (maxX - minX);
            double y = Function.functionValue(function, x);
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        int totalPoints = 10000000;
        int pointsUnderCurve = 0;
        double area = (maxX - minX) * (maxY - minY);

        for (int i = 0; i < totalPoints; i++) {
            double xOfPoint = minX + Math.random() * (maxX - minX);
            double yOfPoint = minY + Math.random() * (maxY - minY);
            int position = Function.aboveOrBeneath(xOfPoint, function, yOfPoint);

            if ((Function.functionValue(function, xOfPoint) >= 0 && position == -1) ||
                    (Function.functionValue(function, xOfPoint) < 0 && position == 1)) {
                pointsUnderCurve++;
            }
        }

        double integral = ((double) pointsUnderCurve / totalPoints) * area;
        System.out.println("Calculated integral (" + methodName + "): " + integral);
    }

    public static void rectangularMethod(Function function, double lowerLimit, double upperLimit) {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        int n = 1000;
        double deltaX = (upperLimit - lowerLimit) / n;
        double integral = 0;

        for (int i = 0; i < n; i++) {
            double x = lowerLimit + (i + 0.5) * deltaX;
            integral += deltaX * Function.functionValue(function, x); // Add the area of the rectangle
        }
        System.out.println("Calculated integral (" + methodName + "): " + integral);
    }

}


