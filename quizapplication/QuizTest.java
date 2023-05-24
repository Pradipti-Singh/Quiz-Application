/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quizapplication;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author HP
 */
public class QuizTest extends JFrame implements ActionListener{
    
    JLabel label;
    JRadioButton radioButtons[]= new JRadioButton[5];
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0,x = 1 ,y=1, now =0;
    int m[]= new int[10];
            
    
    QuizTest(String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i = 0;i<5;i++){
            radioButtons[i]= new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
            
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
            
    }
    void setData(){
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Q1: Which of the following is not an input device?");
            radioButtons[0].setText("Mouse");
            radioButtons[1].setText("Light Pen");
            radioButtons[2].setText("Keyboard");
            radioButtons[3].setText("VDU");
        }
        if(current==1){
            label.setText("Q2: What type of process creates a smaller file that is faster to transfer over the internet?");
            radioButtons[0].setText("Compression");
            radioButtons[1].setText("Fragmentation");
            radioButtons[2].setText("Encapsulation");
            radioButtons[3].setText("None of the above");
        }
        if(current==2){
            label.setText("Q3:Which of the following is used to Manage DataBase?");
            radioButtons[0].setText("Operating System");
            radioButtons[1].setText("Compiler");
            radioButtons[2].setText("DBMS");
            radioButtons[3].setText("None of the above");
        }
        if(current==3){
            label.setText("Q4: Which of the following is an example of non-volatile memory?");
            radioButtons[0].setText("Cache memory");
            radioButtons[1].setText("RAM");
            radioButtons[2].setText("ROM");
            radioButtons[3].setText("None of the above");
        }
        if(current==4){
            label.setText("Q5: File extensions are used in order to ……….");
            radioButtons[0].setText("Name the file");
            radioButtons[1].setText("Ensure the filename is not lost");
            radioButtons[2].setText("Identify the file");
            radioButtons[3].setText("Identify the file type");
        }
        if(current==5){
            label.setText("Q6: here are …………. parts to a computer system.");
            radioButtons[0].setText("2");
            radioButtons[1].setText("4");
            radioButtons[2].setText("16");
            radioButtons[3].setText("100");
        }
        if(current==6){
            label.setText("Q7: During the ………… portion of the Information Processing Cycle, the computer acquires data from some source.");
            radioButtons[0].setText("processing");
            radioButtons[1].setText("storage");
            radioButtons[2].setText("input");
            radioButtons[3].setText("output");
        }
        if(current==7){
            label.setText("Q8:bit stands for");
            radioButtons[0].setText("binary information term");
            radioButtons[1].setText("binary digit");
            radioButtons[2].setText("binary tree");
            radioButtons[3].setText("Bivariate Theory");
        }
        if(current==8){
            label.setText("Q9:Which one of the following is different from other members?");
            radioButtons[0].setText("Google");
            radioButtons[1].setText("Windows");
            radioButtons[2].setText("Linux");
            radioButtons[3].setText("MAC");
        }
        if(current==9){
            label.setText("Q10:The hexadecimal number system consists of the symbols");
            radioButtons[0].setText("0-7");
            radioButtons[1].setText("0-9,A-F");
            radioButtons[2].setText("0-7,A-F");
            radioButtons[3].setText("None of these");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90; i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);
        }
        
        
    }
    boolean checkAns(){
        if(current==0){
            return(radioButtons[3].isSelected());
        }if(current==1){
            return(radioButtons[0].isSelected());
        }
        if(current==2){
            return(radioButtons[2].isSelected());
        }
        if(current==3){
            return(radioButtons[2].isSelected());
        }
        if(current==4){
            return(radioButtons[3].isSelected());
        }
        if(current==5){
            return(radioButtons[1].isSelected());
        }
        if(current==6){
            return(radioButtons[2].isSelected());
        }
        if(current==7){
            return(radioButtons[1].isSelected());
        }
        if(current==8){
            return(radioButtons[0].isSelected());
        }
        if(current==9){
            return(radioButtons[1].isSelected());
        }
        
        return false;
    }
    public static void main(String[]args){
       new QuizTest("Simple Quiz App");
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnNext){
            if(checkAns())
                count = count +1;
            current++;
            setData();
                    if(current==9){
                        btnNext.setEnabled(false);
                        btnResult.setVisible(true);
                        btnResult.setText("Result");
                    }
        }
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count= count +1;
            current++;
            JOptionPane.showConfirmDialog(this, "Correct Answers are "+count);
            System.exit(0);
            
        }
    }
}
