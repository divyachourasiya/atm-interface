
import java.util.ArrayList;
import java.util.Scanner;

class account{
    static void register(){
        Scanner scc=new Scanner(System.in);
        System.out.println("________________________________________");
        System.out.println("Please enter your good name : ");
        ATM_interface.name=scc.nextLine();
        System.out.println("Enter user name :");
        //System.out.println();
        String user=scc.nextLine();
        System.out.println("Enter your password here : ");
        String password =scc.nextLine();
        System.out.println("Enter your Account number here : ");
        ATM_interface.accnumber=scc.nextLine();
        System.out.println("Registration Successfully");
        System.out.println("______________________________________");
        ATM_interface.prompt();
        while (true){
            display(ATM_interface.name);
            int choice=scc.nextInt();
            if (choice==1){
                login(user,password);
                break;

            }
            else {
                if (choice==2){
                    System.exit(0);

                }
                else{
                    System.out.println("wrong value ! Please Enter again ");
                }
            }
        }
    }
    static void display(String name){

    }
    static void login (String user,String pass){}
}
class transaction{
    static void withdraw (){
        Scanner scc=new Scanner(System.in);
        System.out.println("________________________________________________");
        System.out.println("Enter amount to withdraw :");
        int wcash=scc.nextInt();
        if (wcash <=ATM_interface.balance) {
            ATM_interface.balance = ATM_interface.balance - wcash;
            ATM_interface.history.add(Integer.toString(wcash));
            ATM_interface.history.add("withdraw");
            System.out.println("Amount rupees" + wcash + "/-withdraw Successfully");
            System.out.println("______________________________________________");

        }
        else{
            System.out.println("Insufficient Balance to withdraw the cash");
            System.out.println("__________________________________________________");

        }
        ATM_interface.prompt();}
    static void deposit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Amount to deposit :");
        int dcash=sc.nextInt();
        ATM_interface.updatebalance (dcash);
        ATM_interface.history.add("Deposite");
        System.out.println("Amount rupees " + dcash + "/-deposit successfully !");
        System.out.println("_____________________________________________________");
        ATM_interface.prompt ();


    }
    static void transfer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the receiving body : ");
        String s=sc.nextLine();
        System.out.println("Enter the account number of the receiving body ");
        int number=sc.nextInt();
        System.out.println("Enter the ammount to be transffered : ");
        int tcash =sc.nextInt();
        if( tcash <=ATM_interface.balance -tcash){
            ATM_interface.balance =ATM_interface.balance -tcash;
            ATM_interface.history.add(Integer.toString(tcash));
            ATM_interface.history.add("transffered");
            System.out.println("ammount rupees " + tcash + "/- transffered successfully");
            System.out.println("__________________________________________");

        }
        else{
            System.out.println("insufficient bal.to transfer the cash");
            System.out.println("_______________________________________________");

        }
    }

}
class check {
    static void checkbalance(){
        System.out.println("______________________________");
        System.out.println("The available bal. in the bank account");
        ATM_interface.showbalance();
        System.out.println("____________________________________________");
        ATM_interface.prompt();
    }
}
class his{
    static void transactionhistory(){
        System.out.println("________________________________________");
        System.out.println("transaction history ! ");
        int y=0;
        if(ATM_interface.balance>0){
            for (int i=0; i<(ATM_interface.history.size()/2);i++)
            {
                for (int j=0;j<2;j++)
                {
                    System.out.println(ATM_interface.history.get (y)+" ");
                    y++;
                }
                System.out.println("_______________________________________");

            }
        }
        else{
            System.out.println("your Account is empty");

        }
        ATM_interface.prompt();
    }
}


public class ATM_interface {
    public static String name;
    public static int balance = 0;
    public static String accnumber;
    public static ArrayList<String> history = new ArrayList<String>();

    static void updatebalance(int dcash) {
        balance = balance + dcash;

    }

    static void showbalance() {
        System.out.println(balance);
    }

    public static void homepage() {
        System.out.println("fgieuk+ bfhjgjkehygfguy");
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME TO ATM INTERFACE");
        System.out.println("_________________________________________________");
        System.out.println("select option :");
        System.out.println("1.registered");
        System.out.println("2.exit");
        System.out.println("ENter choice");
        int choice = sc.nextInt();
        if (choice == 1) {
            account.register();
        } else {
            System.out.println("select the value only from the given options :");
            homepage();
        }

    }

    static void prompt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("welcome" + ATM_interface.name + "/!to Atm system");
        System.out.println("_________________________________________________");
        System.out.println("selection option :");
        System.out.println("1.withdraw");
        System.out.println("2.deposit");
        System.out.println("3.transfer");
        System.out.println("4.check balance");
        System.out.println("5.transaction history");
        System.out.println("6.quit");
        System.out.println("enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transaction.withdraw();
            case 2:
                transaction.deposit();
            case 3:
                transaction.transfer();
            case 4:
                check.checkbalance();
            case 5:
                his.transactionhistory();
            case 6:
                System.exit(0);
        }


    }

    public static void main(String[] args) {
        homepage();
    }
}