package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * 
 * @author Semir
 *
 */
/** Klasa koja nasljedjuje klasu JPanel u kojoj ce se cuvati podaci o bodovima i broju preostalih poteza */
public class panelScore extends JPanel {

	JLabel bodovi, koraka;
	JTextField bodovi1, koraka1;

	/**
	 * Konstruktor klase panelScore
	 */
	public panelScore() {
		build();
	}

	private void build() {
		TitledBorder panel1 = new TitledBorder("Bodovi");
		setBorder(panel1);
		setLayout(new GridBagLayout());

		bodovi = new JLabel("Bodovi: ");
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		add(bodovi, c);
		
		bodovi1 = new JTextField();
		bodovi.setText("0");
		c.gridx = 1;
		c.gridy = 0;
		add(bodovi1, c);
		
		koraka = new JLabel("Imate poteza: ");
		c.gridx = 0;
		c.gridy = 1;
		add(koraka, c);
		
		koraka1 = new JTextField();
		//koraka1.setText();
		c.gridx = 1;
		c.gridy = 1;
		add(bodovi1, c);

		JLabel nevidljivi = new JLabel();
		c.gridx = 1;
		c.gridy = 3;
		c.weightx = 1;
		c.weighty = 2;
		add(nevidljivi, c);
		c.weightx = 0;
		c.weighty = 0;
	}
}
