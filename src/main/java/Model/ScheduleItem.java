package Model;

import java.text.NumberFormat;

/**
 * Created by ronnykibet on 12/30/16.
 */
public class ScheduleItem {

    private double monthlyPayment;
    private int month;
    private double interestPaid;
    private double principalPaid;
    private double newBalance;
    private double cumulativeInterest;

    private String monthlyPaymentFormatted;
    private String interestPaidFormatted;
    private String principalPaidFormatted;
    private String newBalanceFormatted;
    private String cumulativeInterestFormatted;

    public ScheduleItem() {
    }

    public ScheduleItem(double monthlyPayment, int month, double interestPaid, double principalPaid, double newBalance, double cumulativeInterest) {
        this.monthlyPayment = monthlyPayment;
        this.month = month;
        this.interestPaid = interestPaid;
        this.principalPaid = principalPaid;
        this.newBalance = newBalance;
        this.cumulativeInterest = cumulativeInterest;
    }

    public String getMonthlyPaymentFormatted() {
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        double monthlypaymentRounded = (double) Math.round(monthlyPayment * 100) / 100;

        return currencyFormat.format(monthlypaymentRounded);
    }

    public void setMonthlyPaymentFormatted(String monthlyPaymentFormatted) {
        this.monthlyPaymentFormatted = monthlyPaymentFormatted;
    }

    public String getInterestPaidFormatted() {
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        double interestPaidRounded = (double) Math.round(interestPaid * 100) / 100;
        return currencyFormat.format(interestPaidRounded);
    }

    public void setInterestPaidFormatted(String interestPaidFormatted) {
        this.interestPaidFormatted = interestPaidFormatted;
    }

    public String getPrincipalPaidFormatted() {
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        double principalROunded = (double) Math.round(principalPaid * 100) / 100;
        return currencyFormat.format(principalROunded);
    }

    public void setPrincipalPaidFormatted(String principalPaidFormatted) {
        this.principalPaidFormatted = principalPaidFormatted;
    }

    public String getNewBalanceFormatted() {
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        double newBalanceRounded = (double) Math.round(newBalance * 100) / 100;
        return currencyFormat.format(newBalanceRounded);
    }

    public void setNewBalanceFormatted(String newBalanceFormatted) {
        this.newBalanceFormatted = newBalanceFormatted;
    }

    public String getCumulativeInterestFormatted() {
        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        double cumulativeInterestRounded = (double) Math.round(cumulativeInterest * 100) / 100;
        return currencyFormat.format(cumulativeInterestRounded);
    }

    public void setCumulativeInterestFormatted(String cumulativeInterestFormatted) {
        this.cumulativeInterestFormatted = cumulativeInterestFormatted;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getInterestPaid() {
        return interestPaid;
    }

    public void setInterestPaid(double interestPaid) {
        this.interestPaid = interestPaid;
    }

    public double getPrincipalPaid() {
        return principalPaid;
    }

    public void setPrincipalPaid(double principalPaid) {
        this.principalPaid = principalPaid;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
    }

    public double getCumulativeInterest() {
        return cumulativeInterest;
    }

    public void setCumulativeInterest(double cumulativeInterest) {
        this.cumulativeInterest = cumulativeInterest;
    }
}
