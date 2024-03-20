package service;

import Model.Department;
import repository.DepartmentRepository;
import view.Validation;

import java.util.ArrayList;

public class DepartmentService {
    ArrayList<Department> departmentList = new ArrayList<>();
    DepartmentRepository dr = new DepartmentRepository();
    Validation val;

    private DepartmentService(){
        val = new Validation();
        departmentList = dr.readFile();
    }

    public void addNewDepartment(){
        String depID = val.getAndValidString("Enter new DepartmentID: ");
        String depName = val.getAndValidString("Enter new department name: ");
        Department department = new Department(depID, depName);
        departmentList.add(department);
    }

    //find by ID
    public Department findDepartmentByID(String depID){
        for(Department department: departmentList){
            if(department.getDepartmentID().equalsIgnoreCase(depID)){
                System.out.println(department);
                return department;
            }
            else{
                System.out.println("Can not find that Department!");
            }
        }
        return null;
    }
}
