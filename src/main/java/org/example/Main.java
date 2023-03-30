package org.example;

import org.example.models.Classes;
import org.example.models.User;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = DBUtils.connect();


        String username;
        String password;
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter username: ");
        username = scanner.nextLine();
        System.out.println("Enter password:");
        password = scanner.nextLine();

        User user1 = new User(username, password);
        DBUtils.addUsers(user1, connection);

        List<User> userList = DBUtils.getUser(connection, "Pranjal");
        for (User user : userList) {
            System.out.println(user.getUsername() + " " + user.getPassword());
        }

        String classname;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter classname:");
        classname = scanner1.nextLine();

        Classes class1 = new Classes(classname);
        DBUtils.addClass(class1, connection);

        List<Classes> classesList = DBUtils.getClasses(connection, "Lobutche");
        for (Classes classes: classesList) {
            System.out.println(classes.getClassname());
        }

        
    }
}