import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Hangman extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1122005756145629468L;
	private HWord word;
	private int mistakes;
	private JButton hint;
	private int hints = 3;

	public Hangman() {
		setBackground(Color.white);
		setMinimumSize(new Dimension(800, 900));
		setPreferredSize(new Dimension(800, 900));
		setMaximumSize(new Dimension(800, 900));

		setOpaque(true);
		word = new HWord();
		addLetters();
		mistakes = 0;
		hint = new JButton("Hint");
		hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (hints > 0) {
					word.giveHint();
					hints--;
				} else
					hint.setEnabled(false);
				repaint();

			}
		});
		add(hint);

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		g.setColor(Color.BLUE);
		if (mistakes < 7)
			draw(g);

		if (mistakes >= 7)
			gameover(g);
		if (word.finished())
			win(g);

	}

	public void createButton(final Character c) {
		String bname = c.toString();
		final JButton b = new JButton(bname);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.setEnabled(false);

				if (word.replace(c) == false) {
					mistakes++;
				}

				repaint();

			}
		});
		add(b);
	}

	public void addLetters() {
		for (Character c = 'A'; c <= 'Z'; c++) {

			createButton(c);
		}

	}

	public void draw(Graphics g) {
		g.drawString(word.toString(), 200, 800);
		String m = String.valueOf(mistakes);
		String name = "state" + m + ".jpg";
		try {
			BufferedImage img = ImageIO.read(new File(name));

			g.drawImage(img, 50, 100, 500, 600, null);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void gameover(Graphics g) {
		try {
			BufferedImage img = ImageIO.read(new File("state6.jpg"));

			g.drawImage(img, 50, 100, 500, 600, null);
			String w = word.getWord();
			g.drawString(w, 200, 800);
			g.drawString("GAME OVER", 200, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void win(Graphics g) {
		try {
			BufferedImage img = ImageIO.read(new File("state6.jpg"));

			g.drawImage(img, 50, 100, 500, 600, null);
			String w = word.getWord();
			g.drawString(w, 200, 800);
			g.drawString("YOU WON!", 200, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
