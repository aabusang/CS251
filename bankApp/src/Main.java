import backend.managers.RequestManager;
import frontend.parser.Parser;
import frontend.parser.classes.Day;
import frontend.parser.classes.Request;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The driver of the project. This class is responsible for
 * reading in the input files then calling the request manager with the
 * appropriate process method.
 * You do not need to make any modifications to this file.
 */
public class Main {
    private static RequestManager requestManager = new RequestManager();

    public static void processRequest(Request request) {
        switch (request.getRequestType()) {
            case JOIN:
                requestManager.processJoinRequest(request.getPerson(),
                        request.getRequestAmount());
                break;
            case QUIT:
                requestManager.processQuitRequest(request.getPerson());
                break;
            case DEPOSIT:
                requestManager.processDepositRequest(request.getPerson(),
                        request.getRequestAmount());
                break;
            case WITHDRAW:
                requestManager.processWithdrawRequest(request.getPerson(),
                        request.getRequestAmount());
                break;
            case NEWLOAN:
                requestManager.processNewLoanRequest(request.getPerson(),
                        request.getRequestAmount());
                break;
            case PAYLOAN:
                requestManager.processPayLoanRequest(request.getPerson(),
                        request.getRequestAmount());
                break;
            case ROB:
                requestManager.processRobbery(request.getPerson(),
                        request.getRequestAmount());
                break;
            case NONE:
                break;
        }
    }

    public static void main(String[] args) {
        String strDaysDir = "resources/days";
        File daysDir = new File(strDaysDir);
        File[] daysFiles = daysDir.listFiles();

        if (daysFiles != null) {
            int dayNum = 1;
            for (File file : daysFiles) {
                Day day = Parser.parse(dayNum, file.toPath());
                for (Request request : day.getRequests()) {
                    processRequest(request);
                    System.out.println();
                }
                // End of day
                double membershipFee = 5;
                        //ThreadLocalRandom.current().nextDouble(1, 10);
                double interestRate = 0.1;
                        //ThreadLocalRandom.current().nextDouble(0, 0.2);
                requestManager.processEndOfDay(membershipFee, interestRate);
                // Status report
                System.out.println("Bank status after day " + dayNum + ":");
                System.out.println();
                requestManager.report();
                dayNum++;
            }
        }
        else {
            System.out.println("Could not find directory: " + strDaysDir);
        }
    }
}
