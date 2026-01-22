package forme;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Gost;

public class ModelTabelePrijaveGost extends AbstractTableModel {
    private List<Gost> listaPrijava;
    private final String[] kolone = {"Datum", "Pozicija", "Smena", "Status"};

    public ModelTabelePrijaveGost(List<Gost> listaPrijava) {
        this.listaPrijava = listaPrijava;
    }
    
    public List<Gost> getListaPrijava() {
        return listaPrijava;
    }

    public void setListaPrijava(List<Gost> listaPrijava) {
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
        Gost gost = listaPrijava.get(rowIndex);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return switch (columnIndex) {
            case 0 -> gost.getDatum().format(dtf);
            case 1 -> gost.getPozicija().name().toLowerCase().replace("_", " ");
            case 2 -> gost.getSmena().name().toLowerCase().replace("_", " ");
            case 3 -> gost.getStatus().name().toLowerCase().replace("_", " ");
            default -> "";
        };
    }
    
    @Override
    public String getColumnName(int column) {
            return kolone[column];
    }
}
