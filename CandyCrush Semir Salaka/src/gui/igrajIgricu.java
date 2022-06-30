package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

/**
 * 
 * @author Semir
 *
 */
/** Klasa koja uvezuje panelScore i panelPolja i sve prikazuje u jednom prozoru */ 
public class igrajIgricu {

	static panelScore panelScore;
	static panelPolja panelPolja;

	public static void main(String[] args) {
		panelScore = new panelScore();
		panelPolja = new panelPolja(8, 8, 5);

		JFrame jf = new JFrame();
		jf.setLayout(new GridBagLayout());
		jf.setTitle("Candy Crush");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;

		c.gridx = 0;
		c.gridy = 0;
		jf.add(panelScore, c);

		c.gridx = 1;
		c.gridy = 0;
		jf.add(panelPolja, c);

		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);

	}

}
