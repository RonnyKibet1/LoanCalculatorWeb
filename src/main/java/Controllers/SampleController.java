package Controllers;

import Model.Loan;
import Model.ScheduleItem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by ronnykibet on 12/29/16.
 */
@Controller
@ComponentScan
@EnableAutoConfiguration
public class SampleController {

    private ArrayList<ScheduleItem> scheduleItemList = new ArrayList<ScheduleItem>();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("loan", new Loan());
        return "index";
    }

    @RequestMapping(value = "/desktop")
    public String desktop(){
        return "desktop";
    }

    @RequestMapping(value = "/android")
    public String android(){
        return "android";
    }

    @RequestMapping(value = "/ios")
    public String ios(){
        return "ios";
    }

    @PostMapping("/")
    public String calculateButtonPressed(@ModelAttribute(value = "loan") Loan loan){
        //formatters
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        NumberFormat interestFormat = NumberFormat.getPercentInstance();

        //number of payments
        //years
        int termInYearsEntered = loan.getUserLoanTermYears();
        //loan months
        int termInMonthsEntered = loan.getUserLoanTermMonths();
        loan.setNumberofPaymentsFormatted("Number of payments: " + ((termInYearsEntered * 12) + termInMonthsEntered));

        //loan amount
        double loanEntered = loan.getUserLoanAmount();
        loanEntered = (double)Math.round(loanEntered * 100) / 100; //round loan
        loan.setLoanAmountFormatted("Loan amount: " + currencyFormat.format(loanEntered)); //currency format the rounded loan

        //interestFormat rate
        double interestEntered = loan.getUserLoanInterestRate();
        interestEntered = (double)Math.round(interestEntered * 100) / 100; //round loan
        loan.setLoanInterestFormatted("Interest rate: " + interestFormat.format(interestEntered)); //currency format the rounded loan

        //loan term
        if(termInYearsEntered > 1){
            loan.setLoanTermFormatted("Loan term: " + termInYearsEntered + " years " + termInMonthsEntered + " months");
        }else{
            loan.setLoanTermFormatted("Loan term: " + termInYearsEntered + " year " + termInMonthsEntered + " months");
        }


        printAmortizationSchedule(loanEntered, interestEntered, termInYearsEntered, termInMonthsEntered, loan);


        return "index";
    }



    private static double monthlyPayment(double loanAmount, double monthlyInterestRate, int numberOfYears, int numofMonths) {
        monthlyInterestRate /= 100;  // e.g. 5% => 0.05
        return loanAmount * monthlyInterestRate /
                ( 1 - 1 / Math.pow(1 + monthlyInterestRate, (numberOfYears * 12)+ numofMonths) );
    }

    public  void printAmortizationSchedule(double principal, double annualInterestRate,
                                           int numYears, int numOFMonths, Loan loan) {
        double interestPaid, principalPaid, newBalance;
        double monthlyInterestRate, monthlyPayment;
        int month;
        int numMonths = (numYears * 12) + numOFMonths;
        double cumulativeInterest = 0;

        // Output monthly payment and total payment
        monthlyInterestRate = annualInterestRate / 12;
        monthlyPayment      = monthlyPayment(principal, monthlyInterestRate, numYears, numOFMonths);

        NumberFormat currencyFormat =
                NumberFormat.getCurrencyInstance();
        System.out.format("Monthly Payment: %8.2f%n", monthlyPayment);
        System.out.format("Total Payment:   %8.2f%n", monthlyPayment * ((numYears * 12) + numOFMonths));
        //total payment
        double totalPayment = monthlyPayment * ((numYears * 12) + numOFMonths);
        double totalPaymentRounded = (double) Math.round(totalPayment * 100) / 100;
        loan.setTotalPaymentFormatted("Total Payment: "+ currencyFormat.format(totalPaymentRounded));
        //monthly payment rounded
        double monthlyPaymentRounded = (double) Math.round(monthlyPayment * 100) / 100;
        loan.setMonthlyPaymentFormatted("Monthly payments: " + currencyFormat.format(monthlyPaymentRounded));

        //total interest
        double totalInterest = totalPaymentRounded - loan.getUserLoanAmount();
        double totalInterestROunded = (double) Math.round(totalInterest * 100) / 100;
        String totalInterestCurrencyFormat = currencyFormat.format(totalInterestROunded);
        loan.setTotalInterestFormatted("Total interest: " + totalInterestCurrencyFormat);


        scheduleItemList.clear();

        // Print the table header
        printTableHeader();

        for (month = 1; month <= numMonths; month++) {
            // Compute amount paid and new balance for each payment period
            interestPaid  = principal      * (monthlyInterestRate / 100);
            principalPaid = monthlyPayment - interestPaid;
            newBalance    = principal      - principalPaid;
            cumulativeInterest += interestPaid;

            //create new schedule item and add to list of schedules
            ScheduleItem item = new ScheduleItem(monthlyPayment, month, interestPaid, principalPaid, newBalance, cumulativeInterest);
            scheduleItemList.add(item);
            loan.setScheduleArrayList(scheduleItemList);

            // Output the data item
            printScheduleItem(monthlyPayment, month, interestPaid, principalPaid, newBalance, cumulativeInterest);

            // Update the balance
            principal = newBalance;
        }
    }

    private  void printScheduleItem(double monthlyPayment, int month, double interestPaid,
                                    double principalPaid, double newBalance, double cumulativeInterest) {
        System.out.format("%8d%12.2f%10.2f%10.2f%12.2f%12.2f\n",
                month, monthlyPayment, principalPaid, interestPaid, newBalance, cumulativeInterest);
    }

    /**
     * Prints the table header for the amortization schedule.
     */
    private  void printTableHeader() {
        System.out.println("\nAmortization schedule");
        for(int i = 0; i < 40; i++) {  // Draw a line
            System.out.print("-");
        }
        System.out.format("\n%8s%12s%10s%10s%12s%12s\n",
                "Month#", "Payment", "Principal", "Interest", "Balance", " Total Interest");
        System.out.format("%8s%10s%10s%12s\n\n",
                "", "", "", "");
    }


    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }

}
