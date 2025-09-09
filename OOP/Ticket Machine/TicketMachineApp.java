import java.util.Scanner;


public class TicketMachineApp{
        private int balance;
        Scanner scanner = new Scanner(System.in);

        public void checkMoney(){
            balance=3000;
            System.out.println("Your balance now: " + this.balance);
            return;
        }

        public void addMoney(int amount){
            if(amount>0){
                this.balance+=amount;
                System.out.println("Added: " + amount);
                System.out.println("Your balance now: " + this.balance);
                return;
            }else{
                System.out.println("Put a valid amount!");
                return;
            }
        }

        public void pay(int price){
            if(price>this.balance){
                System.out.println("You don't have enough money");
                return;
            }else if(price<=0){
                System.out.println("Put a valid price!");
                return;
            }
            else{
                this.balance-=price;
                System.out.println("Your balance now: " + this.balance);
                return;
            }
        }
        
    
}