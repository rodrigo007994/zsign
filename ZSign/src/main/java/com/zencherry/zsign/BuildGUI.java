/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zencherry.zsign;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 *
 * @author rodri
 */
public class BuildGUI {
    BuildGUI(){
        JFrame frame1=new JFrame("ZSign by Zencherry");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(800, 600);
        JPanel panel1=new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        JTextArea ta1=new JTextArea("   ");
        JTextArea ta2=new JTextArea("FIRMA");
        JButton b1= new JButton("Firmar");
        b1.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                Sign sig = new Sign();
                
               ta2.setText(sig.getSign(ta1.getText(), "C:\\Users\\rodrigo\\Videos\\FIEL2014\\00001000000305406605.cer", "C:\\Users\\rodrigo\\Videos\\FIEL2014\\Claveprivada_FIEL_VICR870902I42_20141029_174607.key", "Astaro09"));; 
               
                        
            } catch (IOException | GeneralSecurityException ex) {
                Logger.getLogger(BuildGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        panel1.add(ta1);
        panel1.add(b1);
        panel1.add(ta2);
        frame1.add(panel1);
        frame1.setVisible(true);
    }

    
}
