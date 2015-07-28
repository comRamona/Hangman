import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadWords {
	ArrayList<String> list = new ArrayList<String>();

	public LoadWords() {
		try {
			Scanner s = new Scanner(new BufferedReader(new InputStreamReader(
					new FileInputStream(new File("words.txt")))));
			while (s.hasNext()) {
				String str = s.next();
				str = str.toUpperCase();
				list.add(str);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public int getSize() {
		return list.size();
	}

	public ArrayList<String> getWords() {
		return list;
	}

	public String getWord(int i) {
		try {
			return list.get(i);

		} catch (Exception e) {

		}
		return "";
	}
}
