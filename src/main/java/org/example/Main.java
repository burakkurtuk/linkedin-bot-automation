package org.example;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please enter your username");
        String username = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        System.out.println("Please enter target profile name");
        String targetProfile = scanner.nextLine();
        System.out.println("Please write your message");
        String message = scanner.nextLine();



        App app = new App();
        app.signUp(username,password);
        app.navigateToProfile(targetProfile);
        app.messageButton(message);
    }
}
