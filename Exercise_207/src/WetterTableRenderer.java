
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class WetterTableRenderer implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean isSelected, boolean hasRow, int row, int col) {
        Wetterstation w = (Wetterstation) o;
        JLabel label = new JLabel();
        label.setOpaque(true);
        
        if(w.getTemperature() > 25 && w.getHumidity() < 20)
        {
            label.setBackground(Color.yellow);
        }
        if(w.getTemperature() < 0 && w.getHumidity() < 30)
        {
            label.setBackground(Color.blue);
        }
        if(w.getTemperature() <= 25 && w.getTemperature() >= 0 && w.getHumidity() > 50)
        {
            label.setBackground(Color.green);
        }
        
        switch(col)
        {
            case 0: label.setText(w.getPlace());break;
            case 1: label.setText(String.format("%dm", w.getSeaLevel()));break;
            case 2: label.setText(String.format("%.1f°", w.getTemperature()));break;
            case 3: label.setText(String.format("%d", w.getHumidity()).concat("%")); break;
        }
        return label;
    }
    
}
