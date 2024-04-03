package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton a1,a2,a4,a3,a5,a6,back;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        a1 =new JButton("Rs.100");
        a1.setBounds(170,415,150,30);
        a1.addActionListener(this);
        image.add(a1);
        
        a2 =new JButton("Rs.500");
        a2.setBounds(355,415,150,30);
        a2.addActionListener(this);
        image.add(a2);
        
        a3 =new JButton("Rs.1000");
        a3.setBounds(170,450,150,30);
        a3.addActionListener(this);
        image.add(a3);
        
        a4 =new JButton("Rs.2000");
        a4.setBounds(355,450,150,30);
        a4.addActionListener(this);
        image.add(a4);
        
        a5 =new JButton("Rs.5000");
        a5.setBounds(170,485,150,30);
        a5.addActionListener(this);
        image.add(a5);
        
        a6 =new JButton("Rs.10000");
        a6.setBounds(355,485,150,30);
        a6.addActionListener(this);
        image.add(a6);
        
        back =new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
       
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }String num="17";
                if(ae.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                if(ae.getSource()==back){
                    this.setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Successfully");

                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
