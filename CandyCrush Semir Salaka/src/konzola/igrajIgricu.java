package konzola;

import java.util.Scanner;

import logika.igricaCandyCrush;

/**
 * 
 * @author Semir
 *
 */
/** Klasa u kojoj su impementirane funkcije i logika iz klase igricaCandyCrush 
 * tako da se moze igrati u konzoli preko unosa koordinata odredjenih polja*/
public class igrajIgricu {
	static int odabranoX1;
	static int odabranoY1;
	static int odabranoX2;
	static int odabranoY2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		igricaCandyCrush cc = new igricaCandyCrush(8, 8, 2);

		ispisiTrenutnoStanje(cc.getPolja());

		while (!cc.kraj()) {

			birajPolja(cc.dimenzijaX, cc.dimenzijaY);

			while (!cc.daLiJeValidan(odabranoX1, odabranoY1, odabranoX2, odabranoY2)) {
				System.out.println("neispravno");
				birajPolja(cc.dimenzijaX, cc.dimenzijaY);
			}
			cc.zamijeniVrijednosti(odabranoX1, odabranoY1, odabranoX2, odabranoY2);
			cc.updateTabele();
			ispisiTrenutnoStanje(cc.polja);
			if (cc.kraj()) {
				ispisiPoruku(cc.poruka());
				System.exit(0);
			}

		}

	}

	
	private static void ispisiTrenutnoStanje(int[][] polja) {
		
		for (int i = 0; i < polja.length; i++) {
			ispisiLiniju(polja[0].length);
			for (int j = 0; j < polja[0].length; j++) {
				System.out.print("| " + polja[i][j] + " ");
			}
			System.out.println("|");
		}
		ispisiLiniju(polja[0].length);
		System.out.println();
	}

	private static void ispisiLiniju(int duzina) {
		for (int i = 0; i < duzina; i++) {
			System.out.print("|---");
		}
		System.out.println("+");
	}

	private static void ispisiPoruku(String poruka) {
		System.out.println(poruka);
	}

	private static void birajPolja(int x, int y) {
		birajPrvoPolje(x, y);
		birajDrugoPolje(x, y);
	}

	private static void birajPrvoPolje(int dimX, int dimY) {
		Scanner sc = new Scanner(System.in);
		int x1 = -1, y1 = -1;

		while (x1 == -1) {
			System.out.println("Unesi koordinatu x1 za prvo polje: ");
			try {
				x1 = Integer.parseInt(sc.next());
				odabranoX1 = x1;
			} catch (Exception e) {
				System.out.println("Unos nije tipa int.");
				x1 = -1;
			}
			if ((x1 < 0) || (x1 > dimX - 1)) {
				System.out.println("Koordinata x1 mora biti od 0 do " + (dimX - 1));
				x1 = -1;
			}
		}
		while (y1 == -1) {
			System.out.println("Unesi koordinatu y1 za prvo polje: ");
			try {
				y1 = Integer.parseInt(sc.next());
				odabranoY1 = y1;
			} catch (Exception e) {
				System.out.println("Unos nije tipa int.");
				y1 = -1;
			}
			if ((y1 < 0) || (y1 > dimY - 1)) {
				System.out.println("Koordinata y1 mora biti od 0 do " + (dimX - 1));
				y1 = -1;
			}
		}
	}

	private static void birajDrugoPolje(int dimX, int dimY) {
		Scanner sc = new Scanner(System.in);
		int x2 = -1, y2 = -1;

		while (x2 == -1) {
			System.out.println("Unesi koordinatu x2 za prvo polje: ");
			try {
				x2 = Integer.parseInt(sc.next());
				odabranoX2 = x2;
			} catch (Exception e) {
				System.out.println("Unos nije tipa int.");
				x2 = -1;
			}
			if ((x2 < 0) || (x2 > dimX - 1)) {
				System.out.println("Koordinata x2 mora biti od 0 do " + (dimX - 1));
				x2 = -1;
			}
		}
		while (y2 == -1) {
			System.out.println("Unesi koordinatu y2 za prvo polje: ");
			try {
				y2 = Integer.parseInt(sc.next());
				odabranoY2 = y2;

			} catch (Exception e) {
				System.out.println("Unos nije tipa int.");
				y2 = -1;
			}
			if ((y2 < 0) || (y2 > dimY - 1)) {
				System.out.println("Koordinata y2 mora biti od 0 do " + (dimX - 1));
				y2 = -1;
			}
		}
	}
}
