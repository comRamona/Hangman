import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Launcher extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4796392158436621989L;
	Hangman h;

	public Launcher() {

		h = new Hangman();
		setDefaultLookAndFeelDecorated(true);
		setTitle("Hangman Rama");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

		setContentPane(h);
		JMenuBar jmb = new JMenuBar();
		JMenu j = new JMenu("Game");
		JMenuItem ng = new JMenuItem("New Game");
		ng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Launcher();

			}
		});
		j.add(ng);
		jmb.add(j);
		setJMenuBar(jmb);
		pack();

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Launcher();

			}
		});
	}
}
