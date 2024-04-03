package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    String formno;
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    SignupTwo(String formno){
        this.formno=formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails=new JLabel("Page 2:Additional Details");
        additionalDetails.setFont(new Font("Railway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel Religion=new JLabel("Religion:");
        Religion.setFont(new Font("Railway",Font.BOLD,20));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        
        String valReligion[]={"Select","Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel Category=new JLabel("Category:");
        Category.setFont(new Font("Railway",Font.BOLD,20));
        Category.setBounds(100,190,200,30);
        add(Category);
        
        String valcategory[]={"Select","General","OBC","SC","ST","Other"};
        category=new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel Income=new JLabel("Income:");
        Income.setFont(new Font("Railway",Font.BOLD,20));
        Income.setBounds(100,240,200,30);
        add(Income);
        
        String incomecategory[]={"Select","Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel Education=new JLabel("Educationl:");
        Education.setFont(new Font("Railway",Font.BOLD,20));
        Education.setBounds(100,290,200,30);
        add(Education);
        
        JLabel Qualification=new JLabel("Qualification:");
        Qualification.setFont(new Font("Railway",Font.BOLD,20));
        Qualification.setBounds(100,315,200,30);
        add(Qualification);
        
        String educationValues[]={"Select","Non-Graduation","Graduate","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(educationValues);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);
        
        
        JLabel Occupation=new JLabel("Occupation:");
        Occupation.setFont(new Font("Railway",Font.BOLD,20));
        Occupation.setBounds(100,390,200,30);
        add(Occupation);
        
        String occupationValues[]={"Select","Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        JLabel Pan=new JLabel("PAN Number:");
        Pan.setFont(new Font("Railway",Font.BOLD,20));
        Pan.setBounds(100,440,200,30);
        add(Pan);
        
        pan=new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel aadharcard=new JLabel("Aadhar Number:");
        aadharcard.setFont(new Font("Railway",Font.BOLD,20));
        aadharcard.setBounds(100,490,200,30);
        add(aadharcard);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        JLabel seniorCitizen=new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Railway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,200,30);
        add(seniorCitizen);
        
        syes =new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno =new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sgroup=new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);
        
        JLabel existingAccount=new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Railway",Font.BOLD,20));
        existingAccount.setBounds(100,590,200,30);
        add(existingAccount);
        
        eyes =new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno =new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup egroup=new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion= (String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        } else if (sno.isSelected()){
            seniorcitizen="No";
        }
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        } else if (eno.isSelected()){
            existingaccount="No";
        }
        
        
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{
            if(category.equals("")){
                JOptionPane.showMessageDialog(null,"Category is Required");
            }else if(income.equals("")){
                JOptionPane.showMessageDialog(null,"Income is required");
            }else if(education.equals("")){
                JOptionPane.showMessageDialog(null,"Education is required");
            }else if(aadhar.equals("")){
                JOptionPane.showMessageDialog(null,"Date of Birth is required");
            }else if(pan.equals("")){
                JOptionPane.showMessageDialog(null,"Address is required");
            }else{
                Conn c=new Conn();
                String query="insert into signuptwo values ('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
                c.s.executeUpdate(query);
               
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
