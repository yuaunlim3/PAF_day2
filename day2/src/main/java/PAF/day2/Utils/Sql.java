package PAF.day2.Utils;

public class Sql {
    public static final String allEmployee = "SELECT * FROM employee";
    public static final String employeeId = "SELECT * FROM employee WHERE id = ?";
    public static final String deleteID = "DELETE FROM employee wherre id = ? ";
    public static final String insertEmployee = "INSERT into employee(first_name,last_name,email,job_title,department,employment_date,salary,active) values(?,?,?,?,?,?,?,?)'";
    public static final String updateEmployee = "UPDATE employee set first_name = ?,email = ?, job_title = ?, department = ?, employment_date = ?, salary= ? where id = ?";
    public static final String statusEmployee = "UPDATE employee set active = false where id = ?";

}
