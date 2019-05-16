/*ATM transact Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class transact extends JFrame implements ActionListener
{
    JFrame f1;
    JPanel p5;
    JLabel l1;
    JOptionPane j1;
    JLabel l100;
    Icon c1;
    JButton b8,b9,b10,b11,b12,b13,b14;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public transact()
    {
        super("TRANSACTION");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p5=new JPanel();
        add(p5);
        p5.setLayout(null);
        l1=new JLabel("Please Select Your Transaction");
        l1.setFont(ft1);
        b8=new JButton("DEPOSIT");
        b9=new JButton("CASH WITHDRAWAL");
        b10=new JButton("FAST CASH");
        b11=new JButton("MINI STATEMENT");
        b12=new JButton("PIN CHANGE");
        b13=new JButton("BALANCE ENQUIRY");
        b14=new JButton("EXIT");
        //positioning
        //p5.setBackground(Color.orange);
        l1.setBounds(90,150,600,30); //x,y,width,height
        p5.add(l1);//select your trans
        b8.setBounds(100,250,200,40);
        p5.add(b8);
        b9.setBounds(450,250,200,40);
        p5.add(b9);
        b10.setBounds(100,340,200,40);
        p5.add(b10);
        b11.setBounds(450,340,200,40);
        p5.add(b11);
        b12.setBounds(100,430,200,40);
        p5.add(b12);
        b13.setBounds(450,430,200,40);
        p5.add(b13);
        b14.setBounds(270,550,200,40);
        p5.add(b14);
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bktrans.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p5.add(l100);
    //Listeners
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==b8)
        {
            setVisible(false);
            Tdeposit dep=new Tdeposit();
        }
        if(e1.getSource()==b9)
        {
            setVisible(false);
            Twithdraw draw=new Twithdraw();
        }
        if(e1.getSource()==b10)
        {
            setVisible(false);
            Tfastcash fcash=new Tfastcash();
        }
        if(e1.getSource()==b11)
        {
            setVisible(false);
            Tmini stmt=new Tmini();
        }
        if(e1.getSource()==b12)
        {
            setVisible(false);
            Tpinchange pchange=new Tpinchange();
        }
        if(e1.getSource()==b13)
        {
            setVisible(false);
            Tbalance tbal=new Tbalance();  
        }
        if(e1.getSource()==b14)
        {
            setVisible(false);
            Welcome wel=new Welcome();
        }
    }
    public static void main(String a[])
    {
        new transact();
    }
}