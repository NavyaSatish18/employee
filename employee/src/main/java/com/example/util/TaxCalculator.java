package com.example.util;

public class TaxCalculator {

    public static double calculateTax(double yearlySalary) {
        double tax = 0;

        if (yearlySalary <= 250000) {
            return tax;
        } else if (yearlySalary <= 500000) {
            tax += (yearlySalary - 250000) * 0.05;
        } else if (yearlySalary <= 1000000) {
            tax += 250000 * 0.05;
            tax += (yearlySalary - 500000) * 0.10;
        } else {
            tax += 250000 * 0.05;
            tax += 500000 * 0.10;
            tax += (yearlySalary - 1000000) * 0.20;
        }

        return tax;
    }

    // Placeholder for cess calculation if applicable
    public static double calculateCess(double yearlySalary) {
        if (yearlySalary > 2500000) {
            return (yearlySalary - 2500000) * 0.02;
        }
        return 0;
    }

    public static double calculateYearlySalary(double monthlySalary, LocalDate doj) {
        LocalDate startOfFinancialYear = LocalDate.of(doj.getYear(), Month.APRIL, 1);
        LocalDate endOfFinancialYear = LocalDate.of(doj.getYear() + 1, Month.MARCH, 31);

        if (doj.isAfter(startOfFinancialYear)) {
            int monthsWorked = (int) ChronoUnit.MONTHS.between(doj.withDayOfMonth(1), endOfFinancialYear.withDayOfMonth(1));
            double proratedFirstMonthSalary = monthlySalary * ((double) (doj.lengthOfMonth() - doj.getDayOfMonth() + 1) / doj.lengthOfMonth());
            return (monthsWorked - 1) * monthlySalary + proratedFirstMonthSalary;
        } else {
            return 12 * monthlySalary;
        }
    }
}
