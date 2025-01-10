package PAF.day2.RestController;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import PAF.day2.Model.Employee;
import PAF.day2.Service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> employees = employeeService.getAllEmployee();

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeID(@PathVariable("id")int id){
        Employee employee = employeeService.getEmployeeID(id);

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<List<Employee>> update(@PathVariable("id") int id, @RequestBody Employee employee){
        Boolean updateSuccess = employeeService.updateEmployee(employee,id);
        if(updateSuccess){
            List<Employee> employees = employeeService.getAllEmployee();

            return ResponseEntity.ok(employees);
        }
                return ResponseEntity.status(404).body(Collections.emptyList());
    }
    
}
