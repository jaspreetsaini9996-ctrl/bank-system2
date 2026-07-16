import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bank {
    private List<Bankaccount> account=Filemanager.load();
    Bankaccount bankaccount;
    public void create(Bankaccount bankaccount){
        account.add(bankaccount);
        System.out.println("Account created successfully"+bankaccount.toString());

        System.out.println("Account created");
    }
    public void save(){
        Filemanager.save(account);
    }

    public Bankaccount find(Integer accountnumber){
        for(Bankaccount acc:account){
            if(Objects.equals(acc.getAccountnumber(), accountnumber)){
                return acc;
            }
        }return null;
    }
    public  void transfer(Bankaccount from, Integer accountnumber ,Double amount){
        Bankaccount to=find(accountnumber);
        if(to!=null){
            if(amount>=from.getBalance()){
                System.out.println("insufficient funds");
                return;
            }else {

                to.setBalance(to.getBalance()+amount);
                from.setBalance(from.getBalance()-amount);
                from.getTransactions().add(new Transaction("Transfer sent ", amount));
                to.getTransactions().add(new Transaction("Transfer received ",amount));

                System.out.println("transfer successfully");
                System.out.println("Balance is "+from.getBalance());
            }
        }
    }
    public Bankaccount login(Integer accountnumber,Integer pin){
        Bankaccount account=find(accountnumber);
        if(account!=null && Objects.equals(account.getPin(), pin)){
            return account;
        }
        return null;
    }
    public void deposit(Bankaccount bankaccount,Double amount){
       if(amount<50){
           System.out.println("Insufficient funds");
       }else{
       bankaccount.setBalance(bankaccount.getBalance()+amount);
       bankaccount.getTransactions().add(new Transaction("Deposited",amount));
       System.out.println("Deposited "+amount);
        System.out.println("Balance "+bankaccount.getBalance());
    }}
    public void withdraw(Bankaccount bankaccount,Double amount){
        if(amount>bankaccount.getBalance()){
            System.out.println("Insufficient funds");
        }else{
        bankaccount.setBalance(bankaccount.getBalance()-amount);
        bankaccount.getTransactions().add(new Transaction("Withdrawn",amount));
        System.out.println("Deposited "+amount);
        System.out.println("Balance "+bankaccount.getBalance());
    }}
    public void totalb(){
        double sum=0;
        for(Bankaccount acc:account){
            sum+=acc.getBalance();
        }
        System.out.println("Total Balance "+sum);
    }
    public void total(){
        System.out.println("Total Accounts"+account.size());
    }
    public void delete(Integer accountnumber){
        Bankaccount acc=find(accountnumber);
        if(acc!=null){
            account.remove(acc);
            System.out.println("Account deleted successfully"+acc.toString());
        }
    }
    public void seachacc(Integer accountnumber){
        Bankaccount bankaccount=find(accountnumber);
        if(bankaccount!=null){
            System.out.println(bankaccount.toString());
        }else {
            System.out.println("Account not found");
        }
    }
    public void displayacc(){
        if(account.size()<0){
            System.out.println("Account is empty");
        }else {
            for(Bankaccount acc:account){
                System.out.println(acc.toString());
            }
        }
    }

}
