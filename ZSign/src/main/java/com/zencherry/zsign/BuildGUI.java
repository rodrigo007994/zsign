/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zencherry.zsign;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author rodri
 */
public class BuildGUI {
    BuildGUI(){
        JFrame frame1=new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800, 600);
        JPanel panel1=new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        JTextArea ta=new JTextArea("   ");
        
        panel1.add(ta);
        frame1.add(panel1);
        frame1.setVisible(true);
    }

    
}
