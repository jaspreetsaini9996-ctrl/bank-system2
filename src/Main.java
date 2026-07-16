void main() {
    Bank bank = new Bank();
    Scanner sc = new Scanner(System.in);
    Bankaccount bankaccount = new Bankaccount("ddjd",
            10000, 111, 111, Accounttype.SAVINGS);
    bank.create(bankaccount);
    Bankaccount bankaccount1 = new Bankaccount("djd",
            10000, 211, 1111, Accounttype.SAVINGS);
    bank.create(bankaccount);

    IO.println("===Banking===");
    IO.println("1.Admin Login");
    IO.println("2. Customer Account");

    IO.println("3. Exit");
    int ch=sc.nextInt();
    switch(ch) {
        case 1:
            IO.println("Enter Username");
            String Char = sc.next();
            IO.println("Enter pin number");
            Integer pin = sc.nextInt();

            if (Char.equals("admin") && pin == 2215) {
                int choice;
                do {
                    IO.println("====Admin ===");
                    IO.println("1. View all Accounts");
                    IO.println("2. Search Account");
                    IO.println("3. Total Accounts");
                    IO.println("4. Total Balance");
                    IO.println("5. Delete Account");
                    IO.println("6. Exit");
                    System.out.println("Enter Your Choice");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            bank.displayacc();
                            break;
                        case 2:
                            System.out.println("Enter Account Number");
                            Integer accountnumber = sc.nextInt();
                            bank.seachacc(accountnumber);
                            break;
                        case 3:
                            bank.total();
                            break;
                        case 4:
                            bank.totalb();
                            break;
                        case 5:
                            System.out.println("Enter Account Number");
                            Integer accountnumber1 = sc.nextInt();
                            bank.delete(accountnumber1);
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("Invalid Choice");
                    }
                }while (choice != 6);

            }else {
                System.out.println("Invalid Choice");
            }
        case 2:
            IO.println("enter account number");
            Integer number = sc.nextInt();
            IO.println("enter pin number");
            Integer pi = sc.nextInt();
            Bankaccount user = bank.login(number, pi);
            if (user != null) {
                IO.println("Login successful");
                int choice;
                do {
                    IO.println("\n------Bank Menu------");
                    IO.println("1. Deposit");
                    IO.println("2. Withdraw");
                    IO.println("3. Check Balance");
                    IO.println("4. Send Money");
                    IO.println("5. Transactions");

                    IO.println("6. Exit");
                    IO.println("Enter your choice");
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            IO.println("enter Amount to deposit");
                            Double amount = sc.nextDouble();
                            bank.deposit(user, amount);
                            break;
                        case 2:
                            IO.println("enter Amount to withdraw");
                            Double amount2 = sc.nextDouble();
                            bank.withdraw(user, amount2);
                            break;
                        case 3:
                            IO.println("Your balance is $" + user.getBalance());
                            break;
                        case 4:
                            IO.println("enter reciver's account number");
                            Integer accountnumber = sc.nextInt();
                            IO.println("enter Amount:");
                            Double amount1 = sc.nextDouble();
                            bank.transfer(user, accountnumber, amount1);
                            break;
                        case 5:
                            for (Transaction t : user.getTransactions()) {
                                System.out.println(t);
                            }
                            break;
                        case 6:
                      break;

                        default:
                            IO.println("Invalid choice");
                    }
                } while (choice != 6);
            } else {
                IO.println("Invalid input");
            }
        case 3:
            System.exit(0);
    }


}
