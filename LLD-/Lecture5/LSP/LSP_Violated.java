
import java.util.ArrayList;
import java.util.List;

interface Account
{
    void deposit(int amount);
    void withdraw(int amount);
}
class SavingsAccount implements Account{
    private double balance;
    SavingsAccount(){
        balance=0;
    }
    @Override 
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Savings Account Desposit: "+amount+" Balance: "+balance);

    }
    @Override
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
class CurrentAccount implements Account{
    private double balance;
    CurrentAccount(){
        balance=0;
    }
    @Override 
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Current Account Desposit: "+amount+" Balance: "+balance);

    }
    @Override
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

class FixedDepositAccount implements Account{
    private double balance;
    FixedDepositAccount(){
        balance=0;
    }
    @Override 
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Fixed Deposit Account Desposit: "+amount+" Balance: "+balance);
    }
    @Override
    public void withdraw(int amount)
    {
        throw new UnsupportedOperationException("Withdrawal not supported for Fixed Deposit Account");

    }
}

class BankClient{
    private List<Account> accounts;

    public BankClient(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void StartTranscation()
    {
        for(Account acc : accounts)
        {
            acc.deposit((200));
            try{
                acc.withdraw(100);
            }
            catch(Exception e)
            {
              System.out.println("Withdrawal not supported for Fixed Deposit Account");
            }
        }
    }


}

public class LSP_Violated {
    public static void main(String args[])
    {
        List<Account> accounts=new ArrayList<>();
        accounts.add(new SavingsAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedDepositAccount());

        BankClient client=new BankClient(accounts);
        client.StartTranscation();
    
    }


}
