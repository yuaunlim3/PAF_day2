package PAF.day2.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import PAF.day2.Model.Employee;
import PAF.day2.Model.exception.ResourceNotFoundException;
import PAF.day2.Utils.Sql;

@Repository
public class EmployeeRepository {
    @Autowired
    private JdbcTemplate template;

    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>();
        SqlRowSet result = template.queryForRowSet(Sql.allEmployee);

        while(result.next()){
            Employee employee = new Employee(result.getInt("id"),
                result.getString("first_name"), result.getString("last_name"), result.getString("email"),result.getString("job_title"), result.getString("department"),
            result.getDate("employment_date"), result.getFloat("salary"),result.getBoolean("active"));

            employees.add(employee);
        }

        return employees;
    }

    public Employee getByID(int id){
        Employee employee = null;
        try{
            employee = template.queryForObject(Sql.employeeId, BeanPropertyRowMapper.newInstance(Employee.class), id);
            return employee;
        }
        catch(DataAccessException ex){
            throw new ResourceNotFoundException(String.format("Employee at id = %d is not in database",id));
        }
    }

    public Boolean update(Employee employee,int id){
        int temp = template.update(Sql.updateEmployee, employee.getFirst_name(),employee.getLast_name(),employee.getEmail(),employee.getJob_title(),employee.getDepartment(),employee.getEmployment_date(),employee.getSalary(),id);
        if(temp  > 0){
            return true;
        }
        return false;
    }
}
