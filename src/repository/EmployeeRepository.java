package repository;

import Model.Employee;
import Model.MeetingDetails;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EmployeeRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String employeePath = "\\data\\Employee.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    final String HOUR_FORMAT = "HH:mm:ss";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
//    SimpleDateFormat hourFormat = new SimpleDateFormat(HOUR_FORMAT);

    public EmployeeRepository() {
    }

    public ArrayList<Employee> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + employeePath));
            ArrayList<Employee> employees = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].trim();
                }
                Employee employee = new Employee(attributes[0], attributes[1], attributes[2]);
                employees.add(employee);
            }
            return employees;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
