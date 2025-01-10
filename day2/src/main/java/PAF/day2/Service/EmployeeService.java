package PAF.day2.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PAF.day2.Model.Employee;
import PAF.day2.Repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.getAllEmployee();
    }

    public Employee getEmployeeID( int id){
        return employeeRepository.getByID(id);
    }

    public Boolean updateEmployee(Employee employee,int id){
        return employeeRepository.update(employee,id);
    }
}
