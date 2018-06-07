/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.borneclient.renderer;

import fr.miage.toulouse.spacelibshared.admin.ObjNavette;
import fr.miage.toulouse.spacelibshared.admin.ObjQuai;
import fr.miage.toulouse.spacelibshared.admin.ObjStation;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author pierreliaubet
 */
public class StationRenderer implements ListCellRenderer{

    protected DefaultListCellRenderer defaultRendrer = new DefaultListCellRenderer();
    
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel renderer = (JLabel) defaultRendrer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof ObjStation){
            ObjStation station = (ObjStation) value;
            renderer.setText(station.toString());
        }
        if (value instanceof ObjQuai){
            ObjQuai quai = (ObjQuai) value;
            renderer.setText(quai.toString());
        }
        if (value instanceof ObjNavette){
            ObjNavette navette = (ObjNavette) value;
            renderer.setText(navette.toString());
        }
        return renderer;
    }
    
}
