package forme;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Prijava;

public class ModelTabelePrijave extends AbstractTableModel {
    private List<Prijava> listaPrijava;
    private final String[] kolone = {"Datum", "Pozicija", "Smena", "Status"};

    public ModelTabelePrijave(List<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
    public List<Prijava> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(List<Prijava> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
    @Override
    public int getRowCount() {
        return listaPrijava.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prijava prijava = listaPrijava.get(rowIndex);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return switch (columnIndex) {
            case 0 -> prijava.getDatum().format(dtf);
            case 1 -> prijava.getPozicija().name().toLowerCase().replace("_", " ");
            case 2 -> prijava.getSmena().name().toLowerCase().replace("_", " ");
            case 3 -> prijava.getStatus().name().toLowerCase().replace("_", " ");
            default -> "";
        };
    }
    
    @Override
    public String getColumnName(int column) {
            return kolone[column];
    }
    
    public void osveziTabelu(){
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        listaPrijava.remove(red);
        fireTableRowsDeleted(red, red);
    }
}
