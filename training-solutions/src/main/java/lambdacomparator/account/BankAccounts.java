package lambdacomparator.account;

import java.text.Collator;
import java.util.*;

public class BankAccounts {
    private List<BankAccount> bankAccounts;

    public BankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        Collections.sort(result);
        return result;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        Collections.sort(result, ((a1,a2) -> (int) (Math.abs(a1.getBalance()) - Math.abs(a2. getBalance()))));
        return result;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        Collections.sort(result, Comparator.comparing(BankAccount::getBalance).reversed());
        return result;
    }

    public List<BankAccount> listBankAccountsByNameThenAccountNumber() {
        List<BankAccount> result = new ArrayList<>(bankAccounts);
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        result.sort(
                Comparator.comparing(BankAccount::getNameOfOwner,
                                Comparator.nullsFirst(collator))
                        .thenComparing(BankAccount::getAccountNumber));
        return result;
    }
}
