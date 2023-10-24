package mypack;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import com.student.manage.*;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to Delete student");
			System.out.println("Press 3 to Display student");
			System.out.println("Press 4 to Update Student id");
			System.out.println("Press 5 to Exit App");
			int c= Integer.parseInt(br.readLine());
			if(c==1) {
				//Add Student
				System.out.println("Enter user name: ");
				String name= br.readLine();
				System.out.println("Enter user Phone: ");
				String phone= br.readLine();
				System.out.println("Enter user City: ");
				String city=br.readLine();
				//Create Student obj. to store student
				Student st= new Student(name,phone,city);
				System.out.print(st);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added Successfully.....");
				}
				else {
					System.out.println("Something went Wrong");
				}
			}
			else if(c==2) {
				//Delete Student
				System.out.println("Enter Student Id to delete");
				int userId=Integer.parseInt(br.readLine());
				boolean answer=StudentDao.deleteStudent(userId);
				if(answer) {
					System.out.println("Student is added Successfully.....");
				}
				else {
					System.out.println("Something went Wrong");
				}
			}
			else if(c==3) {
				//Display Student
				StudentDao.showAll();
			}
			else if(c==4) {
				System.out.println("Enter  Old  id"); 
				int oldid=Integer.parseInt(br.readLine());
				System.out.println("Enter New id");
				int newid=Integer.parseInt(br.readLine());
				boolean answer= StudentDao.updateStudent(oldid,newid);
				if(answer) {
					System.out.println("Student is added Successfully.....");
				}
				else {
					System.out.println("Something went Wrong");
				}
			}
			else {
				//Exit
				break;
			}
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~  Thank You for Using Our App  ~~~~~~~~~~~~~~~~~");
	}

}
