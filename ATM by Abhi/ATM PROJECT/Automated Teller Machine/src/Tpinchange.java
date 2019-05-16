/*ATM Tpinchange Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Tpinchange extends JFrame implements ActionListener
{
    JFrame f1;
    JPanel p9;
    JLabel cdL,l1,l2,l3,l4;
    JTextField cdT;
    JPasswordField t13,t14,t15;
    JButton b29,b30;
    JOptionPane j1;
    JLabel l100;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public Tpinchange()
    {
        super("PIN CHANGE");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p9=new JPanel();
        add(p9);
        p9.setLayout(null);
        l1=new JLabel("CHANGE YOUR PIN");
        l1.setFont(ft1);
        cdL=new JLabel("Card No. :");
        cdL.setFont(ft2);
        l2=new JLabel("Current PIN :");
        l2.setFont(ft2);
        l3=new JLabel("New PIN :");
        l3.setFont(ft2);
        l4=new JLabel("Confirm New PIN :");
        l4.setFont(ft2);
        cdT=new JTextField(20);
        t13=new JPasswordField(20);
        t14=new JPasswordField(20);
        t15=new JPasswordField(20);
        b29=new JButton("SAVE");
        b30=new JButton("BACK");
        //positioning
        l1.setBounds(200,150,400,30); //x,y,width,height
        p9.add(l1);//change
        cdL.setBounds(180,240,180,30); //x,y,width,height
        p9.add(cdL);//aadhaar label
        l2.setBounds(180,300,180,30); //x,y,width,height
        p9.add(l2);//current label
        l3.setBounds(180,360,180,30); //x,y,width,height
        p9.add(l3);//new label
        l4.setBounds(180,420,180,30); //x,y,width,height
        p9.add(l4);//re-enter label
        cdT.setBounds(360,240,220,30);
        p9.add(cdT);//aadhaar val
        t13.setBounds(360,300,220,30);
        p9.add(t13);//current
        t13.setToolTipText("Enter your Current 4 digit ATM PIN");
        t14.setBounds(360,360,220,30);
        p9.add(t14);//new
        t14.setToolTipText("Enter your New 4 digit ATM PIN");
        t15.setBounds(360,420,220,30);
        t15.setToolTipText("Re-Enter your New 4 digit ATM PIN");
        p9.add(t15);//re-enter
        b29.setBounds(215,500,150,30);
        p9.add(b29);
        b30.setBounds(395,500,150,30);
        p9.add(b30);
        
//Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkpin.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p9.add(l100);
        //Listeners
        b29.addActionListener(this);
        b30.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        String a4=cdT.getText();//cardno
        String cardno="";
        String v1="";
        //------------------------
        String a1=t13.getText();
        String pinno="";
        String a2=t14.getText();
        String a3=t15.getText();
        
        if(e1.getSource()==b29)
        {
            //----------------------------------
            
            if(a4.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a4.length()!=0 && a4.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            if(a1.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your Current PIN No.","Warning",2);
            }
            if(a1.length()!=0 && a1.length()!=4)
            {
                j1.showMessageDialog(null,"Current PIN No. Must Have 4 Digits !","Warning",2);
            }
            //-----------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your New PIN No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=4)
            {
                j1.showMessageDialog(null,"New PIN No. Must Have 4 Digits !","Warning",2);
            }
            //------------
            if(a3.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Confirm Your New PIN No.","Warning",2);
            }
            //-----------------------------
            if(! a2.equals(a3))
            {
                j1.showMessageDialog(null,"New PIN not matching!","Warning",2);
            }
            if(a4.length()==0 && a1.length()==0 && a2.length()==0 && a3.length()==0)
            {
                j1.showMessageDialog(null,"Please Fill The Details To Continue","Warning",2);
            }
            //----------------------------------------------
            if(a4.length()==16 && a1.length()==4 && a2.length()==4 && a3.length()==4)
            {
            //database part
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //aadhaar authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a4);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardno=res0.getString(1);
            pinno=res0.getString(30);
            }
            }
            catch(Exception z)
            {
                System.out.println(z);
            }
            //-----------------------------
            //*************************
            if(!cardno.equals(a4))
            {
                j1.showMessageDialog(null,"Please Check Your Card No.!","Invalid",2);
            }
            //**************************
            if(cardno.equals(a4))
            {/*
                try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //pin authentication check
            PreparedStatement stat3=con3.prepareStatement("select * from atm_db2 where pin=?");
            stat3.setString(1,a1);
            ResultSet res2=stat3.executeQuery();
            while(res2.next())
            {
            pinno=res2.getString(1);
            }
            }
            catch(Exception z5)
            {
             System.out.println(z5);
            }*/
            //------------
            if(pinno.equals(a1) && a2.equals(a3))
            {
            //-------------------main task
            try
            {
                int npin=Integer.parseInt(a3);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con4=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            PreparedStatement stat4=con4.prepareStatement("update atm_db set pin ="+npin+" where card_no="+a4+" ");
            stat4.executeUpdate();
            j1.showMessageDialog(null,"PIN Changed Successfully !","PIN Changed",1);
            setVisible(false);
            Welcome wel=new Welcome();
            }
                catch(Exception z8)
            {
                System.out.println(z8);
            }
            }
            }
            if(!pinno.equals(a1))
            {
                j1.showMessageDialog(null,"Please Check Your Current PIN No.!","Invalid",2);
            }
//---------------------------------
            }//if before try1
            }//main if closed
        if(e1.getSource()==b30)
        {
            setVisible(false);
            transact trans=new transact();
        }
    }
    public static void main(String a[])
    {
        new Tpinchange();
    }
}