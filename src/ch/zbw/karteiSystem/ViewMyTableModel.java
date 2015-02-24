package ch.zbw.karteiSystem;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ViewMyTableModel extends AbstractTableModel implements TableModelListener {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ViewDatenLieferant daten = new ViewDatenLieferant();

	
	public ViewMyTableModel(CardFile cardFile){
		daten.setDefaultTable();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 200;
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

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
	    return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	


}
