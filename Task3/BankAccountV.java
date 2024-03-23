package Task3;
public class BankAccountV {
    private int balance;
    public BankAccountV(int balance)
    {
        this.balance=balance;
    }
    public void withdraw(int amount)
    {
        if(balance<amount)
        {
            System.out.println("Insufficient fund");
        }
        else{
            balance-=amount;
            System.out.println("Amount Withdrawal Successful");
            System.out.println("Your Balance: $"+balance);
        }
    }
    public void deposit(int amount)
    {
        balance+=amount;
        System.out.println("Amount Deposited Successfully");
        System.out.println("Your Balance: $"+balance);
    }
    public int getBalance1()
    {
        return balance;
    }


}
