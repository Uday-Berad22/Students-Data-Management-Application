package com.student.manage;
import java.sql.*;
import java.sql.Connection;
public class StudentDao {
	public static boolean insertStudentToDB(Student st) {
		//JDBC code...
		boolean f=false;
		try {
			Connection con= CP.createC();
			String q="insert into students(sname,sphone,scity) values(?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt =con.prepareStatement(q);
			//Set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2,st.getStudentPhone());
			pstmt.setString(3,st.getStudentCity());
			
			//Execute
			pstmt.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static boolean deleteStudent(int userId) {
		boolean f=false;
		try {
			Connection con= CP.createC();
			String q="delete from students where sid = ?";
			//PreparedStatement
			PreparedStatement pstmt =con.prepareStatement(q);
			//Set the values of parameters
			pstmt.setInt(1, userId);
			
			//Execute
			pstmt.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public static void showAll(){
		try {
			Connection con= CP.createC();
			String q="select * from students;";
			Statement stmt= con.createStatement();
			ResultSet set= stmt.executeQuery(q);
			while(set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				String city=set.getString("scity");
				System.out.println("ID: "+id);
				System.out.println("Name :"+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("---------------------------------------------------");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	public static boolean updateStudent(int oldId,int newId) {
		boolean f=false;
		try {
			Connection con= CP.createC();
			String q="update students set sid=? where sid = ?";
			//PreparedStatement
			PreparedStatement pstmt =con.prepareStatement(q);
			//Set the values of parameters
			pstmt.setInt(1, newId);
			pstmt.setInt(2, oldId);
			//Execute
			pstmt.executeUpdate();
			f=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
