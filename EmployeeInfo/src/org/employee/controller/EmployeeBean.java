package org.employee.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.employee.database.DatabaseConnection;
import org.employee.model.Employee;

public class EmployeeBean
{
	DatabaseConnection dbc = new DatabaseConnection();
	PreparedStatement ps = null;
	Connection conn = null;

	public void addNew(Employee e)
	{
		conn = dbc.dbConnection();
		String insertQuery = "INSERT INTO dbo.employeeinfo(empid,empname,empdob,empemail,empsalary,empdesignation) VALUES(?,?,?,?,?,?)";

		if (conn != null)
		{
			try
			{
				ps = conn.prepareStatement(insertQuery);
				ps.setInt(1, e.getEmpId());
				ps.setString(2, e.getEmpName());
				ps.setString(3, e.getEmpDOB());
				ps.setString(4, e.getEmpEmail());
				ps.setFloat(5, e.getEmpSalary());
				ps.setString(6, e.getEmpDesgination());
				ps.execute();

			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}
		}
	}

	public List<Employee> getEmployes()
	{
		conn = dbc.dbConnection();
		Statement st = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from dbo.employeeinfo order by empid");
			while (rs.next())
			{
				Employee e = new Employee();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpDOB(rs.getString(3));
				e.setEmpEmail(rs.getString(4));
				e.setEmpSalary(rs.getFloat(5));
				e.setEmpDesgination(rs.getString(6));
				list.add(e);
			}
		} catch (Exception e)
		{
			System.out.println("Exception >>>>>>" + e);
		}
		return list;

	}

	public Employee getEmploye(int id)

	{
		Employee emp = null;
		Statement stm = null;
		ResultSet rs = null;

		try
		{
			conn=dbc.dbConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery("select * from dbo.employeeinfo where empid= "
					+ id);
			while (rs.next())
			{

				emp = new Employee();
				emp.setEmpId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpDOB(rs.getString(3));
				emp.setEmpEmail(rs.getString(4));
				emp.setEmpSalary(rs.getFloat(5));
				emp.setEmpDesgination(rs.getString(6));
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}
		return emp;

	}

	public void update(Employee e)
	{
		PreparedStatement ps = null;
		try
		{
			
			conn = dbc.dbConnection();
			ps = conn
					.prepareStatement("update dbo.employeeinfo set empname=?, empdob=?, empemail=?, empsalary=?, empdesignation=? where empid=?");

			ps.setString(1, e.getEmpName());
			ps.setString(2, e.getEmpDOB());
			ps.setString(3, e.getEmpEmail());
			ps.setFloat(4, e.getEmpSalary());
			ps.setString(5, e.getEmpDesgination());
			ps.setInt(6, e.getEmpId());
			ps.executeUpdate();
		} catch (Exception ee)
		{
			System.out.println("Exception ee");
		}

	}

	public void delete(int delid)
	{

		try
		{
			conn = dbc.dbConnection();
			Statement stf = conn.createStatement();
			stf.execute("DELETE FROM dbo.employeeinfo WHERE empId="
					+ String.valueOf(delid));

		} catch (Exception e)
		{
			System.out.println(e);
		}

	}
}
