import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileStatus {
	public FileStatus() {

	}

	public boolean checkFileStatus() {
		Scanner fileCheckScanner = null;
		try {
			fileCheckScanner = new Scanner(new File(//file you are looking for));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		fileCheckScanner.close();
		return true;

	}
}
