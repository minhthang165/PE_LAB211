package repository;

import Model.Department;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DepartmentRepository {
    private final String srcPath = new File("src").getAbsolutePath();
    final String departmentPath = "\\data\\Department.txt";
    final String DATE_FORMAT = "yyyy-MM-dd";
    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    public DepartmentRepository() {
    }

    public ArrayList<Department> readFile() {
        String line;
        try {
            BufferedReader input = new BufferedReader(new FileReader(srcPath + departmentPath));
            ArrayList<Department> departs = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                for (int i = 0; i < attributes.length; i++) {
                    attributes[i] = attributes[i].trim();
                }
                Department depart = new Department(attributes[0], attributes[1]);
                departs.add(depart);
            }
            return departs;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
