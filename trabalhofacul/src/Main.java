import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;


public class Main {
    public static void main(String[] args) {
        //desenvolvimento
        JLabel label = new JLabel("O culto terminou?", JLabel.CENTER);
        label.setFont(new Font("Calibri", Font.BOLD, 40));
        label.setForeground(Color.BLACK);
        JButton SIM = new JButton("sim");
        SIM.setFont(new Font("Calibri", Font.BOLD, 20));
        JButton NAO = new JButton("daqui 5 minutos");
        NAO.setFont(new Font("Calibri", Font.BOLD, 20));

        //janela
        JFrame janela = new JFrame();
        janela.setLayout( new FlowLayout() );
        janela.setVisible(true);
        janela.setSize(700,250);
        janela.add(label);
        janela.getContentPane().setBackground(new Color(200,200,200));
        janela.add(SIM);
        janela.add(NAO);


    }
    }
