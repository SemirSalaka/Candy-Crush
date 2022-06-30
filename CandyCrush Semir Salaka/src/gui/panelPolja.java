package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import logika.igricaCandyCrush;

/**
 * 
 * @author Semir
 *
 */
/** Klasa koja nasljedjuje klasu JPanel i prikazuje polja igrice Candy Crush */
public class panelPolja extends JPanel {
	igricaCandyCrush cc;
	JButton dugme1 = null;
	JButton dugme2 = null;
	int x1, y1, x2, y2;
	public JButton[][] matDugmadi;
	final static Dimension DIMENZIJA_DUGMADI = new Dimension(45, 45);

	private void ubaciDugmadi() {

		GridBagConstraints c = new GridBagConstraints();

		for (int i = 0; i < cc.polja.length; i++) {
			for (int j = 0; j < cc.polja[0].length; j++) {
				c.gridx = j;
				c.gridy = i;
				matDugmadi[i][j].setText(String.valueOf(cc.polja[i][j]));
				matDugmadi[i][j].setPreferredSize(DIMENZIJA_DUGMADI);
				matDugmadi[i][j].addActionListener(naKlik);
				add(matDugmadi[i][j], c);
				// obojiDugme(i,j);
			}
		}
	}

	/**
	 * Kada
	 */
	ActionListener naKlik = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (dugme1 != null) {
				dugme2 = (JButton) e.getSource();
				x2 = dugme2.getX() / DIMENZIJA_DUGMADI.width;
				y2 = dugme2.getY() / DIMENZIJA_DUGMADI.height;

				if (cc.daLiJeValidan(x1, y1, x2, y2)) {
					cc.zamijeniVrijednosti(x1, y1, x2, y2);

					updateDugmadi();
					if (cc.kraj()) {
						System.exit(0);
					}
				}
				dugme1 = null;
				dugme2 = null;
			} else {
				dugme1 = (JButton) e.getSource();
				x1 = dugme1.getX() / DIMENZIJA_DUGMADI.width;
				y1 = dugme1.getY() / DIMENZIJA_DUGMADI.height;
			}
			// obojenaDugmad();
		}
	};

	private void updateDugmadi() {
		
		cc.updateTabele();
		for (int i = 0; i < cc.dimenzijaX; i++) {
			for (int j = 0; j < cc.dimenzijaY; j++) {
				matDugmadi[i][j].setText(String.valueOf(cc.polja[i][j]));
			}
		}
		for (int i = 0; i < cc.dimenzijaX; i++) {
			for (int j = 0; j < cc.dimenzijaY; j++) {
			}
			System.out.println();
		}
		obojenaDugmad();
	}

	private void build() {
		setLayout(new GridBagLayout());

	}

	private void vrijednostiDugmadi(int visina, int sirina, int[][] polja) {
		matDugmadi = new JButton[visina][sirina];
		for (int i = 0; i < visina; i++) {
			for (int j = 0; j < visina; j++) {
				matDugmadi[i][j] = new JButton(String.valueOf(polja[i][j]));
			}
		}
	}

	/**
	 * Konstruktor klase panelPolja
	 * 
	 * @param visina oznacava visinu tabele igrice Candy Crush
	 * @param sirina oznacava sirinu tabele igrice Candy Crush
	 * @param poteza oznacava broj poteza koje ce igrac moci uraditi
	 */
	public panelPolja(int visina, int sirina, int poteza) {
		cc = new igricaCandyCrush(visina, sirina, poteza);
		vrijednostiDugmadi(visina, sirina, cc.polja);
		obojenaDugmad();
		build();
		ubaciDugmadi();
	}
	
	private void obojiDugme(int i, int j) {
		if(matDugmadi[i][j].getText().equals("0")) {
			matDugmadi[i][j].setBackground(Color.blue);
		}
		if(matDugmadi[i][j].getText().equals("1")) {
			matDugmadi[i][j].setBackground(Color.red);
		}
		if(matDugmadi[i][j].getText().equals("2")) {
			matDugmadi[i][j].setBackground(Color.yellow);
		}
		if(matDugmadi[i][j].getText().equals("3")) {
			matDugmadi[i][j].setBackground(Color.green);
		}
	}
	
	private void obojenaDugmad() {
		for(int i = 0; i < matDugmadi.length; i++) {
			for(int j = 0; j < matDugmadi[0].length; j++) {
				obojiDugme(i, j);
			}
		}
	}
}
