package controller;


import Model.Department;
import Model.Employee;
import Model.MeetingLocation;
import Model.User;
import service.*;
import view.Menu;
import view.Validation;

import java.util.Date;

public class Controller extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
    private static final String[] STAFF_MENU_OPTIONS = { "Register a schedule", "View all notifications", "View all schedules", "Edit your information", "Log out" };
    Validation val = new Validation();
    registerService rs = new registerService();
    notificationService ns = new notificationService();
    public Controller() {
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
                manageInfoMenu();
                break;

            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
                break;
        }
    }
    public void manageInfoMenu(){
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
                         departmentMenu();
                         break;
                     case 3:
                         //manage meeting room
                         meetingRoomMenu();
                         break;
                     case 4:
                         //manage personnel
                         employeeMenu();
                         break;
                     case 5:
                         System.out.println("Good Bye");
                         break;

                 }
            }
        };
        manageInfoMenu.run();
    }

    private void userMenu(){
        final String MANAGE_MENU_TITLE = "USER MENU";
        final String[] OPTIONS = { "Add new user", "Delete User", "Update User",
                        "Back" };
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
                        break;
                    case 4:
                        System.out.println("Thank You");
                        break;
                }
            }
        };
        manageUserMenu.run();
    }

    private void departmentMenu(){
        final String MANAGE_DEPARTMENT_TITLE = "DEPARTMENT MENU";
        final String[] OPTIONS = { "Add new department", "Delete department", "Update department"
                , "Back" };
        DepartmentService ds = new DepartmentService();
        Menu manageUserMenu = new Menu(MANAGE_DEPARTMENT_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch(ch){
                    case 1:
                        //add new department
                        ds.addNewDepartment();
                        break;
                    case 2:
                        //delete department
                        String foundDeleteID = val.getAndValidString("Enter ID need to delete");
                        Department foundDepartment = ds.findDepartmentByID(foundDeleteID);
                        ds.deleteDepartment(foundDepartment);
                        break;

                    case 3:
                        //update department
                        String foundUpdateID = val.getAndValidString("Enter ID need to delete");
                        Department foundUpdateDepartment = ds.findDepartmentByID(foundUpdateID);
                        ds.updateDepartment(foundUpdateDepartment);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        manageUserMenu.run();
    }

    private void meetingRoomMenu(){
        final String MANAGE_MEETING_ROOM_TITLE = "MEETING ROOM MENU";
        final String[] OPTIONS = { "Add new meeting room", "Delete meeting room", "Update meeting room"
                , "Back" };
        MeetingRoomService mrs = new MeetingRoomService();
        Menu meetingRoomMenu = new Menu(MANAGE_MEETING_ROOM_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch){
                    case 1:
                        //add new meeting room
                        mrs.addNewRoom();
                        break;
                    case 2:
                        //delete meeting room
                        String roomID = val.getAndValidString("Enter room ID ");
                        MeetingLocation foundRoom = mrs.findByID(roomID);
                        mrs.deleteMeetingLocation(foundRoom);
                        break;
                    case 3:
                        //update meeting room
                        String roomUpdateID = val.getAndValidString("Enter room ID ");
                        MeetingLocation foundUpdateRoom = mrs.findByID(roomUpdateID);
                        mrs.deleteMeetingLocation(foundUpdateRoom);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        meetingRoomMenu.run();
    }

    private void employeeMenu(){
        final String MANAGE_EMPLOYEE_TITLE = "MEETING ROOM MENU";
        final String[] OPTIONS = { "Add new employee", "Delete employee", "Update employee"
                , "Back" };
        EmployeeService es = new EmployeeService();
        Menu personnelMenu = new Menu(MANAGE_EMPLOYEE_TITLE, OPTIONS) {
            @Override
            public void execute(int ch) {
                switch (ch){
                    case 1:
                        //add new employee
                        es.addNewEmployee();
                        break;
                    case 2:
                        //delete employee
                        String empID = val.getAndValidString("Enter employee ID ");
                        Employee foundEmployee = es.findByID(empID);
                        es.deleteEmployee(foundEmployee);
                        break;
                    case 3:
                        //update employee
                        String empUpdateID = val.getAndValidString("Enter employee ID ");
                        Employee foundUpdateEmployee = es.findByID(empUpdateID);
                        es.updateEmployee(foundUpdateEmployee);
                        break;
                    case 4:
                        System.out.println("Thank you");
                        break;
                }
            }
        };
        personnelMenu.run();
    }
}