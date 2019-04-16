/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador_Ordenamiento;

import Metodos_Ordenamiento.MergeClass;
import Metodos_Ordenamiento.Metodos_deOrdenacion;
import Metodos_Ordenamiento.QuickSClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import View_Resultados.GUI;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Controlador_Ordenar implements ActionListener {

    private MergeClass merge;
    private QuickSClass quick;
    private Metodos_deOrdenacion ordenar;
    private GUI view;
    private int OE;

    private int[] v = new int[500];

    public Controlador_Ordenar(Metodos_deOrdenacion ordenar, GUI view, MergeClass merge, QuickSClass quick) {
        this.ordenar = ordenar;
        this.merge = merge;
        this.quick = quick;
        this.view = view;
        this.view.setVisible(true);
        this.view.bComenzar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.limpiar_tabla();
        if (e.getSource() == view.bComenzar) {
            if(!(this.view.textfieldLongitud.getText().equals(""))){
           //while(view.textfieldLongitud.getText() == null){
            if(view.radioAleatorio.isSelected())
                v=this.vectoraleatorio(Integer.valueOf(view.textfieldLongitud.getText()));
            if(view.radioAscendente.isSelected())
                v=this.vectorascendente(Integer.valueOf(view.textfieldLongitud.getText()));
            if(view.radioDescendente.isSelected())
                v=this.vectordescendente(Integer.valueOf(view.textfieldLongitud.getText()));
            

            if (this.view.checkboxBubble.isSelected()) {

                double tiempo = this.ordenar.bubbleSort(v);

                view.jTable1.setValueAt(this.ordenar.getContComparaciones(), 0, 1);
                view.jTable1.setValueAt(this.ordenar.getContEO(), 0, 2);
                view.jTable1.setValueAt(this.ordenar.getContMovimientos(), 0, 3);
                view.jTable1.setValueAt(tiempo, 0, 4);
            }
            if (this.view.checkboxInsertion.isSelected()) {

                double tiempo = this.ordenar.insertionSort(v);

                view.jTable1.setValueAt(this.ordenar.getContComparaciones(), 2, 1);
                view.jTable1.setValueAt(this.ordenar.getContEO(), 2, 2);
                view.jTable1.setValueAt(this.ordenar.getContMovimientos(), 2, 3);
                view.jTable1.setValueAt(tiempo, 2, 4);
            }
            if (this.view.checkboxSelectionSort.isSelected()) {

                double tiempo = this.ordenar.selectionSort(v);

                view.jTable1.setValueAt(this.ordenar.getContComparaciones(), 1, 1);
                view.jTable1.setValueAt(this.ordenar.getContEO(), 1, 2);
                view.jTable1.setValueAt(this.ordenar.getContMovimientos(), 1, 3);
                view.jTable1.setValueAt(tiempo, 1, 4);
            }
            if (this.view.checkboxShell.isSelected()) {

                double tiempo = this.ordenar.shellSort(v);

                view.jTable1.setValueAt(this.ordenar.getContComparaciones(), 3, 1);
                view.jTable1.setValueAt(this.ordenar.getContEO(), 3, 2);
                view.jTable1.setValueAt(this.ordenar.getContMovimientos(), 3, 3);
                view.jTable1.setValueAt(tiempo, 3, 4);
            }
            if (this.view.checkboxQuick.isSelected()) {

                double tiempo = this.quick.sort(v);

                view.jTable1.setValueAt(this.quick.getContComparaciones(), 5, 1);
                view.jTable1.setValueAt(this.quick.getContEO(), 5, 2);
                view.jTable1.setValueAt(this.quick.getContMovimientos(), 5, 3);
                view.jTable1.setValueAt(tiempo, 5, 4);

            }
            if (this.view.checkboxMerge.isSelected()) {

                double tiempo = this.merge.sort(v);

                view.jTable1.setValueAt(this.merge.getContComparaciones(), 4, 1);
                view.jTable1.setValueAt(this.merge.getContEO(), 4, 2);
                view.jTable1.setValueAt(this.ordenar.getContMovimientos(), 4, 3);
                view.jTable1.setValueAt(tiempo, 4, 4);

            }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione la longitud del vector");
            }
        }
    }

    private int[] vectoraleatorio(int orden) {
       int[] vec = new int[orden];
       
       Random ran = new Random();
       for(int i =0 ; i<vec.length; i++){
        vec[i]=ran.nextInt(500);
    }
       return vec;
    }
    
    private int[] vectorascendente(int orden){
        int[] vec = new int[orden];
        
        for (int i = 0; i<vec.length; i++){
            vec[i] = i;
        }
        return vec;
    }
    
    private int[] vectordescendente(int orden){
        int[] vec = new int[orden];
        
        for(int i = 0; orden>0; orden--){
            vec[i] = orden;
        }
        return vec;
    }
    
    public void limpiar_tabla(){
        for(int i=1;i<view.jTable1.getColumnCount();i++){
            for(int j=0;j<view.jTable1.getRowCount();j++){
            this.view.jTable1.setValueAt(null, j,i);
            }
        }
    }

}
