import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Student {
	int sttStudent;
	String studentID;
	String nameStudent;
	String genderStudent;
	String identityCard;
	String classRoom;
	
	public Student(int stt, String id, String name,String gender,String idCard,String classR)
	{
		this.sttStudent = stt;
		this.studentID = id;
		this.nameStudent = name;
		this.genderStudent = gender;
		this.identityCard = idCard;
		this.classRoom = classR;
	}
	
	public static List<Student> readStudents(String fileName) {
		
		List<Student> Students = new ArrayList<Student>();
		Path pathToFile = Paths.get(fileName);
		try (BufferedReader br = Files.newBufferedReader(pathToFile,StandardCharsets.UTF_8))) {
			String line = br.readLine();
			while(line != null) {
				
				String[] attributes = line.split(";");
				Student student = createStudent(attributes);
				Students.add(student);
				line = br.readLine();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return Students;
	}
		
		private static Student createStudent(String[] metadata) {
			
			int stt = Integer.parseInt(metadata[0]);
			String id = metadata[1];
			String name = metadata[2];
			String gender = metadata[3];
			String idCard = metadata[4];
			String classR = metadata[5];
			return new Student(stt,id,name,gender,idCard,classR);
		}
		
	

}
