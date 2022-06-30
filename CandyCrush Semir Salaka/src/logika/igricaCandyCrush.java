package logika;

import java.util.Random;

/**
 * 
 * @author Semir
 *
 */
/** Klasa koja sadrzi svu logiku igrice Candy Crush */
public class igricaCandyCrush {

	public int dimenzijaX, dimenzijaY;
	int krajX, krajY;
	int br = 0;
	int smjer = 0;
	public int[][] polja;
	public int koraka;
	public Random r = new Random();
	int bodovi = 0;

	/**
	 * Konstruktor igrice Candy Crush postavlja broj mogucih poteza igraca,
	 * dimenzije tabele, dvoustruki niz za genserisane vrijednosti koje ce se cuvati
	 * u tabeli
	 * 
	 * @param dimenzijaX oznacava broj kolona tabele igrice
	 * @param dimenzijaY oznacava broj redova tabele igrice
	 * @param koraka
	 */
	public igricaCandyCrush(int dimenzijaX, int dimenzijaY, int koraka) {
		this.dimenzijaX = dimenzijaX;
		this.dimenzijaY = dimenzijaY;
		this.koraka = koraka;
		this.polja = new int[dimenzijaX][dimenzijaY];
		popuni();

		while (provjeraIstih()) {
			updatePolja(this.smjer, this.krajX, this.krajY, this.br);
		}
	}

	/**
	 * Konstruktor kopije
	 * 
	 * @param c vec postojeca instanca igrice Candy Crush koja se kopira
	 */

	public igricaCandyCrush(igricaCandyCrush c) {
		this.dimenzijaX = c.dimenzijaX;
		this.dimenzijaY = c.dimenzijaY;
		this.koraka = c.koraka;
		this.polja = new int[c.dimenzijaX][c.dimenzijaY];

		for (int i = 0; i < dimenzijaX; i++) {
			for (int j = 0; j < dimenzijaY; j++) {
				polja[i][j] = c.polja[i][j];
			}
		}
	}

	/**
	 * Vraca da li su brojevi u tabeli poredani horizontalno ili vertiaklno
	 * 
	 * @return vrijednost smjera koji znaci horizontalno za 1 ili vertikalno za 2
	 */
	public int getSmjer() {
		return this.smjer;
	}

	/**
	 * Vraca x koordinatu zadnjeg broja ako najmanje tri ista broja stoje jedan do
	 * drugog
	 * 
	 * @return vrijednost x koordinate u tabeli
	 */
	public int getkrajX() {
		return krajX;
	}

	/**
	 * Vraca y koordinatu zadnjeg broja ako najmanje tri ista broja stoje jedan do
	 * drugog
	 * 
	 * @return vrijednost y koordinate u tabeli
	 */
	public int getKrajY() {
		return krajY;

	}

	/**
	 * Vraca broj istih brojeva koji stoje horizontalno ili vertikalno jedan do
	 * drugog
	 * 
	 * @return broj koji oznacava koliko istih brojeva stoji jedan do drugog
	 */
	public int getBr() {
		return br;
	}

	/**
	 * Funkcija koja popounjava dvostruki niz "polja" random generisanim cijelim
	 * vrojevima od 0 do 3
	 */
	public void popuni() {
		for (int i = 0; i < dimenzijaX; i++) {
			for (int j = 0; j < dimenzijaY; j++) {
				polja[i][j] = r.nextInt(4);
			}
		}
	}

	/**
	 * Vraca true ako je igrac odigrao mogucih n koraka sto oznacava kraj igre, u
	 * suprotnom vraca false sto znaci da nije kraj
	 * 
	 * @return vraca da li je kraj
	 */
	public boolean kraj() {
		if (koraka == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Provjerava da li postoji istih brojeva jedan uz drugog, postavlja vrijednosti koordinata x i y 
	 * zadnjeg broja u tom nizu i vrijednost smjera na 1 ako su brojevi horizontalno poredani ili na ako su horizontalno poredani  
	 * 
	 * @return vraca true ako postoji 3 ili vise istih brojeva jedan do drugog hrizontalno ili vertikalno
	 */
	public boolean provjeraIstih() {
		br = 0;

		for (int i = 0; i < dimenzijaX; i++) {
			for (int j = 0; j < dimenzijaY - 1; j++) {
				if (polja[i][j] == polja[i][j + 1]) {
					br += 1;
				}
				if (!(polja[i][j] == polja[i][j + 1]) || j + 1 == dimenzijaY - 1) {
					if (br > 1) {
						krajX = i;
						if (j + 1 == dimenzijaY - 1) {
							krajY = j + 1;
						} else {
							krajY = j;
						}
						smjer = 1;
						return true;
					}
					br = 0;
				}
			}
		}

		br = 0;

		for (int i = 0; i < dimenzijaY; i++) {
			for (int j = 0; j < dimenzijaX - 1; j++) {
				if (polja[j][i] == polja[j + 1][i]) {
					br += 1;
				}
				if (!(polja[j][i] == polja[j + 1][i]) || j + 1 == dimenzijaX - 1) {
					if (br > 1) {
						if (j + 1 == dimenzijaX - 1) {
							krajX = j + 1;
						} else {
							krajX = j;
						}
						krajY = i;
						smjer = 2;
						return true;
					}
					br = 0;
				}
			}
		}
		smjer = 0;
		return false;
	}

	/**
	 * Funkcija ukida brojeve koji su isti u nizu i zamijenjuje ih spustanjem postojecih 
	 * brojeva koji se nalaze iznad njih sve dok ih ima, nakon toga generisu se novi random 
	 * brojevi koji popunjavaju prostor u vrhu
	 * 
	 * @param smjer 	vrijednost za horizonralno ili vertikalno poredane brojeve
	 * @param x 		x kooridinata zadnjeg broja u nizu istih 
	 * @param y			y kooridinata zadnjeg broja u nizu istih
	 * @param duzina	broj koji oznacava koliko ima brojeva koji stoje jedan do drugog
	 */
	public void updatePolja(int smjer, int x, int y, int duzina) {
		if (smjer == 1) {
			for (int i = x; i >= 0; i--) {
				for (int j = y; j >= y - duzina; j--) {
					if (i != 0) {
						polja[i][j] = polja[i - 1][j];

					} else {
						polja[i][j] = r.nextInt(4);
					}

				}
			}
		} else if (smjer == 2) {
			for (int i = x; i >= 0; i--) {
				if (i - duzina - 1 >= 0) {
					polja[i][y] = polja[i - duzina - 1][y];
				} else {
					polja[i][y] = r.nextInt(4);
				}
			}
		}
	}
	public void prikaziBodove() {
		
	}

	
	/**
	 * Funkcija update-uje tabelu sve dok ima 3 ili vise istih brojeva jedan do drugog
	 */
	public void updateTabele() {
		while (provjeraIstih()) {
			updatePolja(getSmjer(), getkrajX(), getKrajY(), getBr());
		}
	}

	/**
	 * Funkcija provjerava da li su odabani brojevi jedan do drugog sto je prvi uslov za legalan potez.
	 * U konstruktoru kopije zamjenjuje vrijednosti i u toj kopiji provjerava da li ima tri i vise istih 
	 * da bi mogao primarnoj igrici mijenjati brojeve ako je i taj uslov ispunjen
	 * 
	 * @param x1 x kooridinata prvog odabranog broja  
	 * @param y1 y kooridinata prvog odabranog broja  
	 * @param x2 x kooridinata drugog odabranog broja  
	 * @param y2 y kooridinata drugog odabranog broja  
	 * @return vraca true ako je potez ispravan, u suprotnom false
	 */
	public boolean daLiJeValidan(int x1, int y1, int x2, int y2) {

		if (!(x1 == x2 - 1 && y1 == y2 || x1 == x2 + 1 && y1 == y2 || y1 == y2 - 1 && x1 == x2
				|| y1 == y2 + 1 && x1 == x2)) {

			return false;
		}

		igricaCandyCrush kopija = new igricaCandyCrush(this);
		kopija.zamijeniVrijednosti(x1, y1, x2, y2);
		if (kopija.provjeraIstih()) {
			koraka -= 1;
			return true;
		}
		return false;
	}

	/**
	 * Vraca dvosturki niz "polja" sa random generisanim brojevima 
	 * @return vraca dvostruki niz "polja"
	 */
	public int[][] getPolja() {
		return polja;
	}
	
	/**
	 * Vraca obavijest o kraju igrice
	 * 
	 * @return vraca poruku
	 */
	public String poruka() {
		return "KRAJ IGRICE";
	}

	/**
	 * Funkcija mijenja vrijdenosti odabranim poljima
	 * 
	 * @param x1 x kooridinata prvog odabranog broja  
	 * @param y1 y kooridinata prvog odabranog broja  
	 * @param x2 x kooridinata drugog odabranog broja  
	 * @param y2 y kooridinata drugog odabranog broja 
	 */
	public void zamijeniVrijednosti(int x1, int y1, int x2, int y2) {
		int pom = polja[y1][x1];
		polja[y1][x1] = polja[y2][x2];
		polja[y2][x2] = pom;

	}
	
	
}
