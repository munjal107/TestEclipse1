package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import util.Connect;
import modal.Student;

public class StudenDao {
	static Connection connection;
	static PreparedStatement ps;
	public static boolean validate(Student s) {	
		try {
			
			connection = Connect.getConnection();
		
			String sql = "select * from login where user=? and password=?";
			ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUname());
			ps.setString(2, s.getPass());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return true;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("StudentDao: "+e.getMessage()+ " "+e);
		}/*finally {
			try {
				connection.close();
			} catch (Exception e2) {
				System.out.println("StudentDao: "+e2.getMessage());
			}
		}*/
		return false;
	}
	public static void register(Student s){
		try {
			connection = Connect.getConnection();
			String sql = "insert into login values(?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUname());
			ps.setString(2, s.getPass());
			int i = ps.executeUpdate();
			
			System.out.println("i: "+i);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static ArrayList<Student>  getStudentList(){
		ArrayList<Student> slist=new ArrayList<Student>();

		try 
		{
			connection = Connect.getConnection();
			String sql = "select *from login";
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//Student s=new Student();
			while(rs.next()) 
			{
				Student s=new Student();
				//s=new Student();
				s.setUname(rs.getString(1));
				s.setPass(rs.getString(2));			
				slist.add(s);
				
			}
			
			

			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return slist;
	}
}
