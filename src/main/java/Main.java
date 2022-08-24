import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ConnectionProvider.createC();
        Scanner sc =new Scanner(System.in);
        boolean t=true;
        while(t) {
            System.out.println("1. Write \n2. Read\n3. Exit");
            int choice = sc.nextInt();
            if(choice == 1){
                DBoperation.insertIntoDB();
            }
            if(choice == 2){
                DBoperation.readFromDB();
            }
            if(choice == 2){
               t=false;
            }
        }
    }
}