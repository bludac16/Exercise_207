
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
    private String[] colNames = {};
    private LinkedList<Wetterstation> wetterstationen = new LinkedList<>();

    public void addStation(Wetterstation s)
    {
        wetterstationen.add(s);
        fireTableDataChanged();
    }
    public void removeStation(int[] i)
    {
        for (int j : i) {
         wetterstationen.remove(j);   
        }
        fireTableDataChanged();
    }
    
    public void updatecolNames(boolean anzeigen)
    {
        if(anzeigen == true)
        {
            colNames = new String[4];
            colNames[0] = "Place";
            colNames[1] = "Sea Level";
            colNames[2] = "Temperature";
            colNames[3] = "rel.Humidity";
        } else{
            colNames = new String[3];
            colNames[0] = "Place";
            colNames[1] = "Temperature";
            colNames[2] = "rel.Humidity";
        }
       fireTableDataChanged();
    }
    
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
