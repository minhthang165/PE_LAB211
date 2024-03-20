package controller;


import Model.User;
import service.UserService;
import service.notificationService;
import service.registerService;
import view.Menu;
import view.Validation;

import java.util.Date;

public class Controller extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
    private static final String[] STAFF_MENU_OPTIONS = { "Register a schedule", "View all notifications", "View all schedules", "Edit your information", "Log out" };
    Validation val = new Validation();
    registerService rs = new registerService();
    notificationService ns = new notificationService();
    public Controller(String role) {
        super(MENU_TITLE, STAFF_MENU_OPTIONS);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                // register a schedule and warn if the schedule is overlap
                rs.addNewRegister();
                break;
            case 2:
                //view all notification
                ns.viewNotifications();
                break;
            case 3:
                //view schedule by time
                Date startDate = val.getAndCheckDate("Enter start date");
                Date endDate = val.getAndCheckDate("Enter end date: ");
                rs.viewByTime(startDate, endDate);
                break;
            case 4:
                //Manage information about Users, Department, Meeting Rooms, Personnel
                //Meeting participants


                break;

            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }
    public void ManageInfoMenu(){
        final String MANAGE_MENU_TITLE = "MENU";
        final String[] OPTIONS = { "Manage Users", "Manage Departments", "Manage Meeting rooms",
                "Manage personnel", "Back" };
        Menu manageInfoMenu = new Menu(MANAGE_MENU_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                 switch (ch){
                     case 1:
                        //manage users
                         userMenu();
                         break;
                     case 2:
                         //manage department

                         break;
                     case 3:
                         //manage meeting room

                         break;
                     case 4:
                         //manage personnel

                         break;
                     case 5:
                         System.out.println("Good Bye");
                         break;

                 }
            }
        };
        manageInfoMenu.run();
    }

    public void userMenu(){
        final String MANAGE_MENU_TITLE = "USER MENU";
        final String[] OPTIONS = { "Manage Users", "Manage Departments", "Manage Meeting rooms",
                "Manage personnel", "Back" };
        UserService us = new UserService();
        Menu manageUserMenu = new Menu(MANAGE_MENU_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch){
                    case 1:
                        //add new user
                        us.addNewUser();
                        break;
                    case 2:
                        //delete user
                        String foundDeleteID = val.getAndValidString("Enter id want to delete:");
                        User deleteUser = us.findByUserID(foundDeleteID);
                        us.deleteUser(deleteUser);
                        break;
                    case 3:
                        //update user
                        String foundUpdateID = val.getAndValidString("Enter ID want to update: ");
                        User updateUser = us.findByUserID(foundUpdateID);
                        us.updateUser(updateUser);
                        System.out.println("Update successfully");
                        break;
                }
            }
        };
        manageUserMenu.run();
    }
}