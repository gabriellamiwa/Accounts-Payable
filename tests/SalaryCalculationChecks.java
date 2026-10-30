public final class SalaryCalculationChecks {
    private static final double TOLERANCE = 0.0001;

    public static void main(String[] args) {
        check(
                "full-time monthly salary",
                5000.0,
                new FullTimer("Test", "Employee", 30, 60000.0).calculateMonthlySalary()
        );

        double[] hourlyRates = {15.0, 20.0, 25.0, 30.0, 40.0};
        for (int echelon = 1; echelon <= hourlyRates.length; echelon++) {
            double expectedMonthlySalary = hourlyRates[echelon - 1] * 100;
            double actualMonthlySalary = new PartTimer(
                    "Test", "Employee", 30, echelon, 100
            ).calculateMonthlySalary();

            check("part-time echelon " + echelon, expectedMonthlySalary, actualMonthlySalary);
        }

        System.out.println("All salary calculation checks passed.");
    }

    private static void check(String description, double expected, double actual) {
        if (Math.abs(expected - actual) > TOLERANCE) {
            throw new AssertionError(
                    description + ": expected " + expected + ", got " + actual
            );
        }
    }
}