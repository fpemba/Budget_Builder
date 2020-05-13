package org.wecancodeit;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private int mailboxCapacity = 600;
    private String department;
    private String email;
    private String compaySuffix = "company.com";
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


        this.department = setDepartment();


        this.password = randomPassword(8);
        System.out.println("Your password is: " + password);


        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + compaySuffix;

    }

    public String setDepartment() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your department code: \n1:Accounting\n2:Sales\n3:Admin\n4:Dev");
        int deptChoice = scn.nextInt();

        if (deptChoice == 1) {
            return "Accounting";
        } else if (deptChoice == 2) {
            return "Sales";
        } else if (deptChoice == 3) {
            return "Admin";
        } else if (deptChoice == 4) {
            return "Dev";
        }else {
            return "";
        }
    }


    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIGKLMOPQRSTUVWXYZ0123456789!@#$";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }

        return new String(password);
    }


    public void setMailboxCapacity(int capacity) {

        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {

        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapcity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;

    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}


