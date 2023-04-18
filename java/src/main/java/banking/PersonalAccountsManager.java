package banking;

import java.math.BigDecimal;

class PersonalAccountsManager {
    private final BankAccounts bankAccounts;

    public PersonalAccountsManager(BankAccounts bankAccounts) {
        // in a real system it would load bank accounts from a database
        this.bankAccounts = bankAccounts;
    }

    boolean withdraw(String customerName, BigDecimal cashAmount) {
        // new feature to start lookup by String bankManager too, but how? We're past branch now?
        return wwithdraw(bankAccounts, customerName, cashAmount);
    }

    private static boolean wwithdraw(BankAccounts bankAccounts, String customerName, BigDecimal cashAmount) {
        return bankAccounts.accounts().stream()
                .filter(a -> a.belongsTo(customerName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("unknown customer " + customerName))
                .withdraw(cashAmount);
    }

}
