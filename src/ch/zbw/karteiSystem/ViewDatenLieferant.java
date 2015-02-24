package ch.zbw.karteiSystem;

public class ViewDatenLieferant {


		String [][] inhalt = { {"Hause","house"}, {"Tür","door"}, {"Wand","wall"} };
	    String[] titel = {"Deutsch", "Englisch"};

	    public int getAnzahl() {
	        return 3;
	    }

	    public String getSprache1(int zeile) {
	        return inhalt[zeile][0];
	    }

	    public String getSprache2(int zeile) {
	        return inhalt[zeile][1];
	}
	
	
}
