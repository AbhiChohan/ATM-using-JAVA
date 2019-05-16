/*ATM Twithdraw Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Twithdraw extends JFrame implements ActionListener
{
    JFrame f1;
    JPanel p7;
    JLabel l1,l2;
    JButton b18,b19,b20;
    JTextField cnT,t12;
    JOptionPane j1;
    JLabel l100,cnL,depL;;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    Font ft3=new Font("arial",Font.BOLD,30);
    public Twithdraw()
    {
        super("WITHDRAWAL");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p7=new JPanel();
        add(p7);
        p7.setLayout(null);
        l1=new JLabel("<html><center>MAXIMUM ONE TIME WITHDRAWAL IS RS. 10,000</center><html>");
        l1.setFont(ft1);
        cnT=new JTextField(20);
        cnL=new JLabel("Card no.");
        depL=new JLabel("Amount");
        l2=new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setFont(ft3);
        b18=new JButton("WITHDRAW");
        b19=new JButton("BACK");
        b20=new JButton("EXIT");
        t12=new JTextField(20);
        //positioning
        l1.setBounds(90,150,600,90); //x,y,width,height
        p7.add(l1);//enter amount
        l2.setBounds(170,300,600,30); //x,y,width,height
        p7.add(l2);
        cnL.setBounds(150,380,100,30);
        cnL.setFont(ft2);
        p7.add(cnL);//card label
        cnT.setBounds(250,380,280,30);
        p7.add(cnT);//cardval
        depL.setBounds(150,440,100,30);
        depL.setFont(ft2);
        p7.add(depL);//amt label
        t12.setBounds(250,440,280,30);
        p7.add(t12);//amt
        b18.setBounds(260,520,100,30);
        p7.add(b18);//withdraw
        b19.setBounds(420,520,100,30);
        p7.add(b19);//back
        b20.setBounds(310,620,160,30);
        p7.add(b20);//exit
//Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkwithdraw.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p7.add(l100);
        //Listeners
        b18.addActionListener(this);
        b19.addActionListener(this);
        b20.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
    if(e1.getSource()==b18)
        {
            String zz=t12.getText();
            if(zz.length()==0)
            {
                j1.showMessageDialog(null,"Please Enter Withdrawal Amount !","Warning",2);
            }
            //----------------------
            long a3=Long.parseLong(zz);//withdrew amt
            String a2=cnT.getText();//card no
            long a1=0;//deposit = 0
            String cardval="";
            String v1="";
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
            if(a3==0 || a3<0)
            {
                j1.showMessageDialog(null,"Please Enter Valid Withdrawal Amount !","Warning",2);
            }
            if(a3>10000)
            {
                j1.showMessageDialog(null,"Maximum Withdrawal Per Transaction Is Rs. 10,000","Limit",1);
            }
            if(a3>=1 && a3<=499 || a3>=501 && a3<=999 || a3>=1001 && a3<=1499 || a3>=1501 && a3<=1999 || a3>=2001 && a3<=2499 || a3>=2501 && a3<=2999 || a3>=3001 && a3<=3499 || a3>=3501 && a3<=3999 || a3>=4001 && a3<=4499 || a3>=4501 && a3<=4999 || a3>=5001 && a3<=5499 || a3>=5501 && a3<=5999 || a3>=6001 && a3<=6499 || a3>=6501 && a3<=6999 || a3>=7001 && a3<=7499 || a3>=7501 && a3<=7999 || a3>=8001 && a3<=8499 || a3>=8501 && a3<=8999 || a3>=9001 && a3<=9999)
            {
                j1.showMessageDialog(null,"Withdrawal Amount Should Be Multiple Of 500s!","Warning",1);
            }
            else
            {
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
            //******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //******************
            //-----------------------------
            if(cardval.equals(a2) && a3!=0 && a3>0 && a3<=10000)
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
            
            if(avbal > 0)
            {
            AVB=avbal-a3;
            }
            if(avbal<a3 || avbal==0)
            {
                j1.showMessageDialog(null,"Insufficient Balance !","Withdrew",1);
            }
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
            if(avbal>=a3 && a3<=10000)
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
            }
            }//main if closed
    if(e1.getSource()==b19)
        {
            setVisible(false);
            transact trans=new transact();
        }
    if(e1.getSource()==b20)
        {
            setVisible(false);
            thankyou1 thanks=new thankyou1();
        }
    }
    public static void main(String a[])
    {
        new Twithdraw();
    }
}