package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String email;
    private String password;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String companySuffix = ".com";
    private String alternateEmail;

    // constructor to receive the first name and last name
    public Email (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created" + this.firstName + this.lastName);

        // Call a method asking for the dpeartment
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;
//        System.out.println("Your email is: " + email);
    }

    private String setDepartment(){
        System.out.println("New worker: " + firstName + ". Department Codes\n1 for Sales \n2 for develpent \n3 for Accoutning \n4 for none");
        Scanner sc  = new Scanner(System.in);
        int depChoice =sc.nextInt();
        if(depChoice == 1){
            return "sales";
        } else if (depChoice == 2){
            return "dev";
        } else if (depChoice == 3){
            return "acct";
        } else {
            return "";
        }
    }

    // generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789!@$%";
        char[] password = new char[length];
        for(int i=0; i < length; i++){
           int rand =  (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }


    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }


    // change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";

    }
}
