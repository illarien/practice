package QuizesOld;

// write read object

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOWriteReadObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String x = "Test string to file asavcsd asdfasdf sadfasdf!.";
		String file = "teststring.txt";
//		----- Writing -----
		ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
		outputStream.writeObject(x);
		outputStream.flush();
		outputStream.close();
		System.out.println("Writing is Done");
//		----- Reading -----
		String y;
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
		y = (String)inputStream.readObject();
		
		inputStream.close();
		System.out.println("Reading is Done: " + y);
	}

}
