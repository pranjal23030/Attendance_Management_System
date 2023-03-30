package org.example;

import org.example.models.Attendance;
import org.example.models.Classes;
import org.example.models.User;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Connection connection = DBUtils.connect();


//        Table user
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

//        TABLE CLASS
        String classname;

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter classname:");
        classname = scanner2.nextLine();

        Classes classes00 = new Classes(classname);
        DBUtils.addClass(classes00, connection);

            List<Classes> classesList = DBUtils.getClasses(connection, "Khumbila");
            for (Classes classes : classesList) {
                System.out.println(classes.getClassname());
            }


//        TABLE ATTENDANCE
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter classId: ");
        int classId = scanner1.nextInt();
        System.out.println("Enter userId:");
        int userId = scanner1.nextInt();
        scanner1.close();


        try {
            Attendance attendance = new Attendance(classId, userId);
            DBUtils.addAttendance(attendance, connection);
            System.out.println("Attendance added successfully!");
        } catch (Exception e) {
            System.out.println("Failed to add attendance: " + e.getMessage());
        }
    }
}