package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;


public class Email {

    public Scanner scanner = new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    public Email(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
        System.out.println("New Employee: " + this.fname + " " + this.lname);

        this.dept = this.setDept();
        this.password = this.generatePassword(10);
        this.email = this.generateEmail();
    }

    private String generateEmail() {
        return this.fname.toLowerCase() + "." + this.lname.toLowerCase() + "@" + this.dept.toLowerCase() + ".company.com";
    }

    private String setDept() {
        System.out.println("Department Codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do {
            System.out.println("Enter Department code");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return "Sales";
                case 2:
                    return "Development";
                case 3:
                    return "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose correct option");
            }

        } while (!flag);
        return null;
    }

    // To Generate Random Password Method
    private String generatePassword(int lenght) {
        Random random = new Random();
        String Capital_chars = "ABCDEFJHIJK";
        String Small_chars = "abcdefghijk";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = Capital_chars + Small_chars + numbers + symbols;
        String password = "";
        for (int i = 0; i < lenght; i++) {
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    // To Change Password Method
    public void setPassword() {
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password! (YES/NO)");
            char choice = scanner.next().charAt(0);
            if (choice == 'Y' || choice == 'y') {
                flag = true;
                System.out.println("Enter current password:");
                String temp = scanner.next();
                if (temp.equals(this.password)) {
                    System.out.println("Enter new password:");
                    this.password = scanner.next();
                    System.out.println("Password changed successfully");
                } else {
                    System.out.println("Incorrect password");
                }
            } else if (choice == 'N' || choice == 'n') {
                flag = true;
                System.out.println("Password changed option cancelled!");
            } else {
                System.out.println("Enter valid choice");
            }

        } while (!flag);


    }

    // To Set Mailbox Capacity Method
    public void setMailCap() {
        System.out.println("Current capacity= " + this.mailCapacity + "mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // To Set Alternate Email
    public void alternateEmail() {
        System.out.println("Enter new alternate mail: ");
        this.alterEmail = scanner.next();
        System.out.println("Alternate email is set");
    }

    // Display user information Method
    public void getInfo() {
        System.out.println("New:" + this.fname + " " + this.lname);
        System.out.println("Department:" + this.dept);
        System.out.println("Email:" + this.email);
        System.out.println("Password:" + this.password);
        System.out.println("Mailbox capacity" + this.mailCapacity + "mb");
        System.out.println("Alternate mail" + this.alterEmail);
    }

    // Store in file
    public void storeFile() {
        try {
            FileWriter in = new FileWriter("C:\\Users\\hp\\Desktop\\info.txt");
            in.write("First name:" + this.fname);
            in.append("\nLast name:" + this.lname);
            in.append("\nEmail:" + this.email);
            in.append("\nPassword:" + this.password);
            in.append("\nCapacity:" + this.mailCapacity);
            in.append("\nAlternate mail:" + this.alterEmail);
            in.close();
            System.out.println("Data Stored..");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readFile() {
        try {
            FileReader f1 = new FileReader("C:\\Users\\hp\\Desktop\\info.txt");
            int i;
            while (true) {
                boolean b = (i = f1.read()) != -1;
                if (!b) break;
            }
            System.out.print((char) i);
            System.out.println();
            f1.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

