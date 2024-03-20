package service;

import Model.Employee;
import repository.EmployeeRepository;
import view.Validation;

import java.util.ArrayList;

public class EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<>();
    Validation val;
    EmployeeRepository er = new EmployeeRepository();
    private EmployeeService(){
        val = new Validation();
        employeeList = er.readFile();
    }

    public void addNewEmployee(){
        String empID = val.getAndValidString("Enter new Emplyee ID: ");
        String departmentID = val.getAndValidString("Enter department ID: ");
        String empName = val.getAndValidString("Enter employee name: ");
        Employee newEmp = new Employee(empID, departmentID, empName);
        employeeList.add(newEmp);
        System.out.println("Add successfully");
    }

    //find by ID
    public Employee findByID(String empID){
        for(Employee emp: employeeList){
            if(emp.getEmpID().equalsIgnoreCase(empID)){
                System.out.println(emp);
                return emp;
            }
        }
        System.out.println("Can not find that Employee");
        return null;
    }
}
