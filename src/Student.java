import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Student {
	
	String sttStudent;
	String studentID;
	String nameStudent;
	String genderStudent;
	String identityCard;
	String classRoom;
	@Override
    public String toString() {
        return sttStudent +  studentID + nameStudent + genderStudent + identityCard + classRoom ;
 }
	public Student(String stt, String id, String name,String gender,String idCard,String classR)
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
		try (BufferedReader br = Files.newBufferedReader(pathToFile)) {
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
			
			String stt = metadata[0];
			String id = metadata[1];
			String name = metadata[2];
			String gender = metadata[3];
			String idCard = metadata[4];
			String classR = metadata[5];
			return new Student(stt,id,name,gender,idCard,classR);
		}
		
	

}
