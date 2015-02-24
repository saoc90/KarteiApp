package ch.zbw.karteiSystem;

import javax.swing.table.AbstractTableModel;

public class ViewMyTableModel extends AbstractTableModel {
	
    private ViewDatenLieferant daten = null; // wo die Daten herkommen

	
	public ViewMyTableModel(CardFile cardFile){
		daten=new ViewDatenLieferant();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	
	@Override
    public Object getValueAt(int zeile, int spalte) { // Die eigentlichen Daten
        if (spalte==0) return daten.getSprache1(zeile);
        if (spalte==1) return daten.getSprache2(zeile);
        return null;
    }
	
	
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	
	@Override
    public String getColumnName(int arg0) {    // Die Spaltenueberschriften
        if (arg0==0) return "Sprache1";
        if (arg0==1) return "Sprache2";
        return null;
    }
	
	
	
	
	


}
