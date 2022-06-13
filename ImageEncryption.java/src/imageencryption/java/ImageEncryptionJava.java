/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageencryption.java;

/**
 *
 * @author SAURABH
 */
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class ImageEncryptionJava {

    /**
     * @param args the command line arguments
     */
    
    public static void encryption(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        
        try{
            FileInputStream  fis = new FileInputStream(file);
            byte [] data = new byte[fis.available()];
            
            fis.read(data);
            int i = 0;
            for(byte b:data){
                System.out.println(b);
                data[i] = (byte) (b^key);
                i++;
            }
            
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Image Encrypted done.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //decryption
    
    public static void decryption(int key){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        
        try{
            FileInputStream  fis = new FileInputStream(file);
            byte [] data = new byte[fis.available()];
            
            fis.read(data);
            int i = 0;
            for(byte b:data){
                System.out.println(b);
                data[i] = (byte) (b^key);
                i++;
            }
            
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
           // JOptionPane.showMessageDialog(null,"Image Encrypted done.");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //System.out.println("Test");
        JFrame f = new JFrame();
        f.setTitle("Image Encryption");
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Font font = new Font("Roboto",Font.BOLD,26);
        
        
        //label
        JLabel l1 = new JLabel();  
        l1=new JLabel("Image Encryption & Decryption.");  
        l1.setFont(font);
        
        JButton button = new JButton();
        button.setBounds(50,100, 200,30);
       // button.setText("Open Image");
        button.setText("Encryption");
        button.setFont(font);
        
         JTextField textField = new JTextField(10);
        textField.setFont(font);
        f.setLayout(new FlowLayout());
        
         button.addActionListener(e->{
        System.out.println("button clicked");
        String text = textField.getText();
        int temp = Integer.parseInt(text);
        encryption(temp);});
        
        //decryption
        System.out.println("");
        JButton button2 = new JButton();
       // button.setText("Open Image");
        button2.setText("Decryption");
        button2.setBounds(50,100, 200,30);
        button2.setFont(font);
        
        
       
        
       
        //JOptionPane.showMessageDialog(null,"Image Encrypted.");
        
        
        JTextField textField2 = new JTextField(10);
        textField2.setFont(font);
        f.setLayout(new FlowLayout());
        
        button2.addActionListener(e->{
        System.out.println("Decryption button clicked");
        String text2 = textField2.getText();
        int temp2 = Integer.parseInt(text2);
        decryption(temp2);
        JOptionPane.showMessageDialog(null,"Now Image Decrypted.");
        
    });
        
        f.add(button);
        f.add(textField);
        System.out.println("");
        System.out.println("");
        f.add(button2);
        
        f.add(textField2);
        
        
        
        f.setVisible(true);
        
    }
    
}
