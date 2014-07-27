package QuizesOld;

// Write read txt file

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;


import java.util.Scanner;



public class IOWriteReadTXT {

	public static void main(String[] args) throws IOException {
		String ar = "Exmple sdfsdfsdfdsfsdfsdf";
		File file = new File ("testtxt.txt");
		if (!file.exists()) {file.createNewFile();};
		FileWriter fw = new FileWriter (file);
		BufferedWriter bw = new BufferedWriter (fw);
		bw.write(ar);
		bw.flush();
		bw.close();
//		---------not working------------
//		FileReader fr = new FileReader (file);
//		String af;
//		fr.read(af);
//		----------	
		Scanner inFl = new Scanner(file);
		String strout = "";
		while (inFl.hasNextLine()) {
			strout += inFl.nextLine();
		}
		System.out.println(strout);
	}

}
