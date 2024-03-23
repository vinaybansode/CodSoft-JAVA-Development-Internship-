package Task3;

import java.util.Scanner;
public class ATMV {
    public BankAccountV bankAccountV;
    public ATMV(BankAccountV bankAccountV)
    {
        this.bankAccountV=bankAccountV;
    }
    public void withdraw()
    {
        System.out.print("Enter amount to withdraw: $");
        Scanner scanner=new Scanner(System.in);
        int withdrawAmount=scanner.nextInt();
        bankAccountV.withdraw(withdrawAmount);
    }
    public void deposit()
    {
        System.out.print("Enter amount to deposit: $");
        Scanner scanner=new Scanner(System.in);
        int depositAmount=scanner.nextInt();
        bankAccountV.deposit(depositAmount);
    }
    public void checkBalance()
    {
        System.out.println("Your account balance is: $"+bankAccountV.getBalance1());
    }
    public static void main(String[] args)
    {
        BankAccountV bankAccountV1=new BankAccountV(1000);
        ATMV atmv=new ATMV(bankAccountV1);
        int choice;
        Scanner scanner=new Scanner(System.in);
        while(true) {
            System.out.println("ATM MENU");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            // while(true) {
            System.out.println("Please enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    atmv.withdraw();
                    break;
                case 2:
                    atmv.deposit();
                    break;
                case 3:
                    atmv.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting. Thank You!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
}

