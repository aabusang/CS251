package backend.managers;

import backend.accounts.Account;
import backend.accounts.exceptions.AccountNotFound;
import backend.people.Member;
import backend.people.Person;
import backend.people.exceptions.MemberNotFound;

/**
 * The loans manager is responsible for approving or denying loan requests.
 */
public class LoansManager implements Manager {

    public LoansManager() {}

    /**
     * System report.
     */
    public void report() {
        System.out.println("Loan Manager checking in.");
    }

    /**
     * Debt to equity ratio is calculated as follows:
     * [debt + (current loan balance)] /
     * [(bank account balance) + (yearly income)]
     *
     * The following rules are followed when deciding whether someone
     * can get a loan:
     * Must be 18 years or older
     *
     * For loans less than or equal to $10,000 no other criteria are considered:
     *
     * For loans between $10,000 and $100,000 you must have a debt to equity
     * ratio of less than or equal to 1 and a credit score greater than 600.
     *
     * For loans between $100,000 and $1,000,000 you must have a debt to equity
     * ratio of less than or equal to 0.5 and a credit score greater than 700.
     *
     * For loans greater than 1,000,000 you must have a debt to equity ratio of
     * 0 and credit score greater than 800.
     *
     * @param person Person applying for a loan
     * @param amount Amount of the loan
     * @return Boolean representing if the loan was approved
     */
    // TODO: Fill this in with the above logic
    public boolean processNewLoanRequest(Person person,
                                         Member member,
                                         Account account,
                                         double amount) {




        double dteRatio = (person.getDebt() + amount)/(account.balance() + (person.getMonthlyIncome() * 12));

        if (person.getAge() < 18){
            return false;//turn person away if age < 18;
        }else if(amount <= 10_000){
            return true;//say yes to process loan if person is > 18 and amount <= 10_000
        }else if(member.hasGoldMemberCard()){
            return true;
        }else{
            if ((amount > 10_000 && amount < 100_000)) {
                return (Double.compare(dteRatio, 1) > 0) && (person.getCreditScore() > 600);
            } else if (amount >= 100_000 && amount <= 1_000_000) {
                return (Double.compare(dteRatio, 0.5) > 0) && (person.getCreditScore() > 700);
            } else if (amount > 1_000_000) {
                return (Double.compare(dteRatio, 0) > 0 && (person.getCreditScore() > 800));
            }
        }
        return false;
    }
}
