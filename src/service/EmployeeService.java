package service;

import Model.Employee;
import repository.EmployeeRepository;
import view.Validation;

import java.util.ArrayList;

public class EmployeeService {
    ArrayList<Employee> employeeList = new ArrayList<>();
    Validation val;
    EmployeeRepository er = new EmployeeRepository();
    public EmployeeService(){
        val = new Validation();
        er.readFile(employeeList);
    }

    //view employee
    public void viewEmployee(){
        for(Employee employee: employeeList){
            System.out.println(employee);
        }
    }

    public void addNewEmployee(){
        while (true){
            String empID = val.getAndValidString("Enter new Employee ID: ");
            if(employeeList.contains(findByID(empID))){
                System.out.println("ID already exists");
                continue;
            }
            String departmentID = val.getAndValidString("Enter department ID: ");
            String empName = val.getValue("Enter employee name: ");
            Employee newEmp = new Employee(empID, departmentID, empName);
            employeeList.add(newEmp);
            System.out.println("Add successfully");
        }
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

    //delete employee
    public void deleteEmployee(Employee employee){
        employeeList.remove(employee);
        System.out.println("Delete successfully");
    }

    //update employee
    public void updateEmployee(Employee employee){
        String empID = val.getAndValidString("Enter new employee ID ");
        String departmentID = val.getAndValidString("Enter new department ID: ");
        String empName = val.getValue("Enter employee name: ");
        employee.setEmpID(empID);
        employee.setDepartmentID(departmentID);
        employee.setEmpName(empName);
        System.out.println("Update successfully");
    }

    public static void main(String[] args) {
        EmployeeService es = new EmployeeService();
        es.viewEmployee();
    }
}
