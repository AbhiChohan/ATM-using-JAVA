/*ATM Tfastcash Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Tfastcash extends JFrame implements ActionListener
{
    JFrame f1;
    JPanel p8;
    JLabel l1,cnL;
    JTextField cnT;
    JOptionPane j1;
    JButton b21,b22,b23,b24,b25,b26,b27,b28;
    JLabel l100;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public Tfastcash()
    {
        super("FAST CASH");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p8=new JPanel();
        add(p8);
        p8.setLayout(null);
        l1=new JLabel("SELECT WITHDRAWAL AMOUNT");
        l1.setFont(ft1);
        cnL=new JLabel("Card no.");
        cnT=new JTextField(20);
        b21=new JButton("Rs.100");
        b22=new JButton("Rs.1500");
        b23=new JButton("Rs.500");
        b24=new JButton("Rs.5000");
        b25=new JButton("Rs.1000");
        b26=new JButton("Rs.10000");
        b27=new JButton("BACK");
        b28=new JButton("EXIT");
        //positioning
        l1.setBounds(60,130,650,30); //x,y,width,height
        p8.add(l1);//select your trans
        cnL.setBounds(150,230,100,30);
        cnL.setFont(ft2);
        p8.add(cnL);//card no label
        cnT.setBounds(250,230,280,30);
        p8.add(cnT);//card no val
        b21.setBounds(100,320,200,40);
        p8.add(b21);
        b22.setBounds(450,320,200,40);
        p8.add(b22);
        b23.setBounds(100,410,200,40);
        p8.add(b23);
        b24.setBounds(450,410,200,40);
        p8.add(b24);
        b25.setBounds(100,500,200,40);
        p8.add(b25);
        b26.setBounds(450,500,200,40);
        p8.add(b26);//
        b27.setBounds(125,600,150,40);
        p8.add(b27);
        b28.setBounds(475,600,150,40);
        p8.add(b28);
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkfast.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p8.add(l100);
        //Listeners
        b21.addActionListener(this);
        b22.addActionListener(this);
        b23.addActionListener(this);
        b24.addActionListener(this);
        b25.addActionListener(this);
        b26.addActionListener(this);
        b27.addActionListener(this);
        b28.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        String a2=cnT.getText();//card no
            String cardval="";
            String v1=""; 
        if(e1.getSource()==b21)
        {
            long a3=100;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b22)
        {
            long a3=1500;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b23)
        {
            long a3=500;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b24)
        {
            long a3=5000;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b25)
        {
            long a3=1000;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b26)
        {
            long a3=10000;//withdrew amt
            long a1=0;//deposit = 0
            long AVB=0;
            long avbal=0;
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
            //-------------------
            if(a2.length()==16)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //card authentication check
            PreparedStatement stat=con.prepareStatement("select * from atm_db where card_no=?");
            stat.setString(1,a2);
            ResultSet res0=stat.executeQuery();
            while(res0.next())
            {
            cardval=res0.getString(1);
            }
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con3=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //avl_bal get and convert
            PreparedStatement stat2=con3.prepareStatement("select * from atm_db2 where card_no=?");
            stat2.setString(1,a2);
            ResultSet res1=stat2.executeQuery();
            while(res1.next())
            {
            v1=res1.getString(5);
            }
            avbal=Long.parseLong(v1);
            
            if(avbal==0)
            {
            j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3)
            {
            try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con1=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            //data insertion
            String sql="insert into atm_db2 (card_no,deposited,withdrew,avl_bal,date_time) values (?,?,?,?,current_timestamp)";
            PreparedStatement stat3=con1.prepareStatement(sql);
            stat3.setString(1,a2);//card val insert into db3
            stat3.setLong(2,a1);//deposit
            stat3.setLong(3,a3);//withdrew
            stat3.setLong(4,AVB);//update avl_bal
            stat3.executeUpdate();//
            //----------------------------
            j1.showMessageDialog(null,"Please Collect Your Money !","Withdrew",1);
            }//---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
            }
            }
            }
            }
            catch(Exception z1)
            {
                System.out.println(z1);
            }
            }
            }//main if closed
        if(e1.getSource()==b27)
        {
            setVisible(false);
            transact trans=new transact();
        }
        if(e1.getSource()==b28)
        {
            setVisible(false);
            thankyou1 thanks=new thankyou1();
        }
    }
    public static void main(String a[])
    {
        new Tfastcash();
    }
}