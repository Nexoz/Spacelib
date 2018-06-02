/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.toulouse.miage.administrateurclient;

import javax.swing.JFrame;

/**
 *
 * @author pierreliaubet
 */
public class MainApp {
    
    public static void main(String[] args) {
        JFrame mainApp = new JFrame();
        mainApp.add(new Home());
        mainApp.pack();
        mainApp.setVisible(true);
        mainApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
