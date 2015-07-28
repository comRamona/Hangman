import java.util.Random;

public class HWord {
	private Character[] chars;
	private String word;
	private int nr;

	public HWord() {
		LoadWords words = new LoadWords();
		int max = words.getSize() - 1;
		int min = 0;
		Random rand = new Random();
		int pos = min + rand.nextInt((max - min) + 1);
		word = words.getWord(pos);
		nr = word.length();
		chars = new Character[nr];
		for (int i = 0; i < nr; i++)
			chars[i] = '-';
	}

	public boolean replace(Character c) {
		boolean replaced = false;
		for (int i = 0; i < nr; i++)
			if ((word.charAt(i)) == c.charValue()) {
				chars[i] = c;
				replaced = true;
			}
		return replaced;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < nr; i++)
			s += chars[i];
		return s;
	}

	public String getWord() {
		return word;
	}

	public boolean finished() {
		boolean test = true;
		for (int i = 0; i < nr; i++)
			if ((word.charAt(i)) != chars[i])
				test = false;
		return test;
	}

	public void giveHint() {
		for (int i = 0; i < nr; i++)
			if (chars[i].equals('-')) {
				chars[i] = word.charAt(i);
				break;
			}
	}

}
