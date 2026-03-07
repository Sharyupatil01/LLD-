import java.util.ArrayList;
import java.util.List;


interface DepositOnlyAccount
{
    void deposit(int amount);
}
interface WithdrawalAccount extends DepositOnlyAccount
{
    void withdraw(int amount);
}
class SavingsAccount implements WithdrawalAccount
{
    private double balance;
    SavingsAccount()
    {
        balance=0;
    }
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Savings Account Desposit: "+amount+" Balance: "+balance);
    }
    public void withdraw(int amount)
    {
        if(amount>balance)
        {
            System.out.println("Insufficient Balance");
            return;
        }
        balance-=amount;
        System.out.println("Savings Account Withdraw: "+amount+" Balance: "+balance);
    }
}

class CurrentAccount implements WithdrawalAccount
{
    private double balance;
    CurrentAccount()
    {
        balance=0;
    }
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Current Account Desposit: "+amount+" Balance: "+balance);
    }
    public void withdraw(int amount)
    {
        if(amount>balance)
        {
            System.out.println("Insufficient Balance");
            return;
        }
        balance-=amount;
        System.out.println("Current Account Withdraw: "+amount+" Balance: "+balance);
    }
}

class FixedDepositAccount implements DepositOnlyAccount
{
    private double balance;
    FixedDepositAccount()
    {
        balance=0;
    }
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Fixed Deposit Account Desposit: "+amount+" Balance: "+balance);
    }
}

class BankClient{
    private List<WithdrawalAccount> withdrawableAcount;
    private List<DepositOnlyAccount> depositableAccount;

    BankClient(List<WithdrawalAccount> withdrawableAcount,List<DepositOnlyAccount> depositableAccount)
    {
        this.withdrawableAcount=withdrawableAcount;
        this.depositableAccount=depositableAccount;
    }

    public void Processtranscation()
    {
        for(WithdrawalAccount account:withdrawableAcount)
        {
            account.deposit(1000);
            account.withdraw(100);
        }
        for(DepositOnlyAccount account:depositableAccount)
        {
            account.deposit(1000);
            
        }
    }

}
public class Correct_LSP_Form {
    public static void main(String args[])
    {
         List<WithdrawalAccount> withdrawableAcount=new ArrayList<>();
        SavingsAccount savingsAccount=new SavingsAccount();
        CurrentAccount currentAccount=new CurrentAccount();
        FixedDepositAccount fixedDepositAccount=new FixedDepositAccount();
       
        withdrawableAcount.add(savingsAccount);
        withdrawableAcount.add(currentAccount);


        List<DepositOnlyAccount> depositableAccount=new ArrayList<>();
        depositableAccount.add(savingsAccount);
        depositableAccount.add(fixedDepositAccount);


        BankClient client=new BankClient(withdrawableAcount,depositableAccount);
        client.Processtranscation();
    }
}
