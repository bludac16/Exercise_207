
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class WetterTableModel extends AbstractTableModel{
    private String[] colNames = {"Place", "Sea Level", "Temperature", "rel. Humidity"};
    private LinkedList<Wetterstation> wetterstationen = new LinkedList<>();

    @Override
    public int getRowCount() {
        return wetterstationen.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    
     @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return wetterstationen.get(row);
    }
    
}
