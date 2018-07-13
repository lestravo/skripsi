/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skripsi;

import java.awt.Color;

/**
 *
 * @author user
 */
public class Skripsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MainJFrame frame = new MainJFrame();
        frame.getContentPane().setBackground(new Color(55,52,53));
        //frame.setBackground();
        frame.setTitle("Software Encrypt Decrypt Polsek Mangkubumi");
        frame.setLocationRelativeTo(frame);
        frame.setDefaultCloseOperation(MainJFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
