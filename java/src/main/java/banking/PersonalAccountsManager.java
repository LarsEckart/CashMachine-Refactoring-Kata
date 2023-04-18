package banking;

import java.math.BigDecimal;

class PersonalAccountsManager {
    private final BankAccounts bankAccounts;

    public PersonalAccountsManager(BankAccounts bankAccounts) {
        // in a real system it would load bank accounts from a database
        this.bankAccounts = bankAccounts;
    }

    boolean withdraw(String customerName, BigDecimal cashAmount) {
        return bankAccounts.withdraw(customerName, cashAmount);
    }

}
