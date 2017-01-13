package Model;

import java.util.ArrayList;

/**
 * Created by ronnykibet on 12/30/16.
 */
public class Loan {

    private double userLoanAmount;
    private int userLoanTermYears;
    private int userLoanTermMonths;
    private double userLoanInterestRate;

    private String loanAmountFormatted;
    private String loanInterestFormatted;
    private String loanTermFormatted;
    private String numberofPaymentsFormatted;
    private String monthlyPaymentFormatted;
    private String totalInterestFormatted;
    private String totalPaymentFormatted;

    private ArrayList<ScheduleItem> scheduleArrayList = new ArrayList<ScheduleItem>();



    public Loan() {
    }

    public Loan(double userLoanAmount, int userLoanTermYears, int userLoanTermMonths, double userLoanInterestRate) {
        this.userLoanAmount = userLoanAmount;
        this.userLoanTermYears = userLoanTermYears;
        this.userLoanTermMonths = userLoanTermMonths;
        this.userLoanInterestRate = userLoanInterestRate;
    }

    public ArrayList<ScheduleItem> getScheduleArrayList() {
        return scheduleArrayList;
    }

    public void setScheduleArrayList(ArrayList<ScheduleItem> scheduleArrayList) {
        this.scheduleArrayList = scheduleArrayList;
    }

    public String getNumberofPaymentsFormatted() {
        return numberofPaymentsFormatted;
    }

    public void setNumberofPaymentsFormatted(String numberofPaymentsFormatted) {
        this.numberofPaymentsFormatted = numberofPaymentsFormatted;
    }

    public String getMonthlyPaymentFormatted() {
        return monthlyPaymentFormatted;
    }

    public void setMonthlyPaymentFormatted(String monthlyPaymentFormatted) {
        this.monthlyPaymentFormatted = monthlyPaymentFormatted;
    }

    public String getTotalInterestFormatted() {
        return totalInterestFormatted;
    }

    public void setTotalInterestFormatted(String totalInterestFormatted) {
        this.totalInterestFormatted = totalInterestFormatted;
    }

    public String getTotalPaymentFormatted() {
        return totalPaymentFormatted;
    }

    public void setTotalPaymentFormatted(String totalPaymentFormatted) {
        this.totalPaymentFormatted = totalPaymentFormatted;
    }

    public String getLoanTermFormatted() {
        return loanTermFormatted;
    }

    public void setLoanTermFormatted(String loanTermFormatted) {
        this.loanTermFormatted = loanTermFormatted;
    }

    public String getLoanAmountFormatted() {
        return loanAmountFormatted;
    }

    public void setLoanAmountFormatted(String loanAmountFormatted) {
        this.loanAmountFormatted = loanAmountFormatted;
    }

    public String getLoanInterestFormatted() {
        return loanInterestFormatted;
    }

    public void setLoanInterestFormatted(String loanInterestFormatted) {
        this.loanInterestFormatted = loanInterestFormatted;
    }



    public double getUserLoanAmount() {
        return userLoanAmount;
    }

    public void setUserLoanAmount(double userLoanAmount) {
        this.userLoanAmount = userLoanAmount;
    }

    public int getUserLoanTermYears() {
        return userLoanTermYears;
    }

    public void setUserLoanTermYears(int userLoanTermYears) {
        this.userLoanTermYears = userLoanTermYears;
    }

    public int getUserLoanTermMonths() {
        return userLoanTermMonths;
    }

    public void setUserLoanTermMonths(int userLoanTermMonths) {
        this.userLoanTermMonths = userLoanTermMonths;
    }

    public double getUserLoanInterestRate() {
        return userLoanInterestRate;
    }

    public void setUserLoanInterestRate(double userLoanInterestRate) {
        this.userLoanInterestRate = userLoanInterestRate;
    }
}
