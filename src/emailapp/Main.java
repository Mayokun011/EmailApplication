package emailapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter first name:");
        String fName = scanner.next();
        System.out.println("Enter last name:");
        String lName = scanner.next();

        // Creating Object for Email Class
        Email em1 = new Email(fName, lName);
        int choice = -1;
        do{
            System.out.println("\n******\nEnter your choice\n1.Show Info\n2.Change password\n3.Change mailbox " +
                    "capacity\n4.Set Alternate mail\5.Store Data In File\n6.Display Data From File\n7.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    em1.getInfo();
                    break;
                case 2:
                    em1.setPassword();
                    break;
                case 3:
                    em1.setMailCap();
                    break;
                case 4:
                    em1.alternateEmail();
                    break;
                case 5:
                    em1.storeFile();
                    break;
                case 6:
                    em1.readFile();
                    break;
                case 7:
                    System.out.println("Thank You For Using Application!");
                    break;
                   default:
                    System.out.println("Invalid Choice!\nEnter Proper Choice..");
            }
        } while (choice != 7);

    }
}
