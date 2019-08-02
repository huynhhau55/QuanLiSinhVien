import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GenericReadFile<T> {
	
	private T t;
	
	public T getT() {
		
		return t;
	}
	
	public void setT(T t) {
		
		this.t = t;
	}
	
	public  void readFile(String filePath)
	{
		Path pathToFile = Paths.get(filePath);
		try(BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)){
			//List<T> elements = new ArrayList<GenericReadFile.T>();
			String line = br.readLine();
			while(line != null) {
				
				line = br.readLine();
			}
		
		
		}catch(Exception e){
		
			e.printStackTrace();
		}
	}
	

}
