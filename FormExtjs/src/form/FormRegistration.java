package form;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormRegistration
 */
public class FormRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	FormBean fb = new FormBean();

	String url = "jdbc:jtds:sqlserver://192.168.8.109:1433/master";
	String name = "sa";
	String pass = "sakthi123";
	String dbname = "form_registration";
	Connection conn = null;
	Statement st = null;

	public FormRegistration() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post!!!!");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String dob = request.getParameter("dob");
		String password = request.getParameter("password");
		String confpassword = request.getParameter("confirmPassword");

		fb.setFirstname(firstname);
		fb.setLastName(lastname);
		fb.setEmail(email);
		fb.setDateOfBirth(dob);
		fb.setPassword(password);
		fb.setConfpassword(confpassword);

		Date d = new Date();
		System.out.println("Create Database starts at " + d.toString());
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			conn = DriverManager.getConnection(url + dbname, name, pass);
			System.out.println("Connected to database_____");
			String query = "insert into user_registration set firstname='"
					+ fb.getFirstname() + "',lastname='" + fb.getLastName()
					+ "',email='" + fb.getEmail() + "',dob='"
					+ fb.getDateOfBirth() + "',password='" + fb.getPassword()
					+ "' ,confpassword='" + fb.getConfpassword() + "' ";

			st = conn.createStatement();
			st.executeUpdate(query);

			System.out.println("Record is inserted into DBUSER table! at"
					+ d.toString());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

}
