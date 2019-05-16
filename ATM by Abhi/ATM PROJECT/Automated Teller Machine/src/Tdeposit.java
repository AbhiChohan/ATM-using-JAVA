/*ATM Tdeposit Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Tdeposit extends JFrame implements ActionListener
{
    JFrame f1;
    JPanel p6;
    JLabel l1;
    JButton b15,b16,b17;
    JTextField cnT,t12;
    JOptionPane j1;
    JLabel l100,cnL,depL;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public Tdeposit()
    {
        super("DEPOSIT");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p6=new JPanel();
        add(p6);
        p6.setLayout(null);
        l1=new JLabel("<html><center>ENTER AMOUNT YOU WANT TO DEPOSIT</center><html>");
        l1.setFont(ft1);
        cnT=new JTextField(20);
        cnL=new JLabel("Card no.");
        depL=new JLabel("Amount");
        b15=new JButton("DEPOSIT");
        b16=new JButton("BACK");
        b17=new JButton("EXIT");
        t12=new JTextField(20);
        //positioning
        l1.setBounds(90,150,600,80); //x,y,width,height
        p6.add(l1);//enter amount
        cnL.setBounds(150,300,100,30);
        cnL.setFont(ft2);
        p6.add(cnL);//card label
        cnT.setBounds(250,300,280,30);
        p6.add(cnT);//card val
        depL.setBounds(150,360,100,30);
        depL.setFont(ft2);
        p6.add(depL);//amt label
        t12.setBounds(250,360,280,30);
        p6.add(t12);//amt
        b15.setBounds(260,440,100,30);
        p6.add(b15);//dep
        b16.setBounds(420,440,100,30);
        p6.add(b16);//back
        b17.setBounds(310,540,160,30);
        p6.add(b17);//exit
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkdeposit.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p6.add(l100);
        //Listeners
        b15.addActionListener(this);
        b16.addActionListener(this);
        b17.addActionListener(this);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==b15)
        {
            String zz=t12.getText();
            if(zz.length()==0)
            {
                j1.showMessageDialog(null,"Please Enter Deposit Amount !","Warning",2);
            }
            //--------------------
            long a1=Long.parseLong(zz);//deposited amt
            String a2=cnT.getText();//card no
            long a3=0;//withdrew = 0
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
            if(a1==0 || a1<0)
            {
                j1.showMessageDialog(null,"Please Enter Valid Deposit Amount !","Warning",2);
            }
            if(a1>50000)
            {
                j1.showMessageDialog(null,"Maximum Deposit Per Transaction Is Rs. 50,000","Limit",1);
            }
            if(a1>=1 && a1<=499 || a1>=501 && a1<=999 || a1>=1001 && a1<=1499 || a1>=1501 && a1<=1999 || a1>=2001 && a1<=2499 || a1>=2501 && a1<=2999 || a1>=3001 && a1<=3499 || a1>=3501 && a1<=3999 || a1>=4001 && a1<=4499 || a1>=4501 && a1<=4999 || a1>=5001 && a1<=5499 || a1>=5501 && a1<=5999 || a1>=6001 && a1<=6499 || a1>=6501 && a1<=6999 || a1>=7001 && a1<=7499 || a1>=7501 && a1<=7999 || a1>=8001 && a1<=8499 || a1>=8501 && a1<=8999 || a1>=9001 && a1<=9999 || a1>=10001 && a1<=10499 || a1>=10501 && a1<=10999 || a1>=11001 && a1<=11499 || a1>=11501 && a1<=11999 || a1>=12001 && a1<=12499 || a1>=12501 && a1<=12999 || a1>=13001 && a1<=13499 || a1>=13501 && a1<=13999 || a1>=14001 && a1<=14499 || a1>=14501 && a1<=14999 || a1>=15001 && a1<=15499 || a1>=15501 && a1<=15999 || a1>=16001 && a1<=16499 || a1>=16501 && a1<=16999 || a1>=17001 && a1<=17499 || a1>=17501 && a1<=17999 || a1>=18001 && a1<=18499 || a1>=18501 && a1<=18999 || a1>=19001 && a1<=19499 || a1>=19501 && a1<=19999 || a1>=20001 && a1<=20499 || a1>=20501 && a1<=20999 || a1>=21001 && a1<=21499 || a1>=21501 && a1<=21999 || a1>=22001 && a1<=22499 || a1>=22501 && a1<=22999 || a1>=23001 && a1<=23499 || a1>=23501 && a1<=23999 || a1>=24001 && a1<=24499 || a1>=24501 && a1<=24999 || a1>=25001 && a1<=25499 || a1>=25501 && a1<=25999 || a1>=26001 && a1<=26499 || a1>=26501 && a1<=26999 || a1>=27001 && a1<=27499 || a1>=27501 && a1<=27999 || a1>=28001 && a1<=28499 || a1>=28501 && a1<=28999 || a1>=29001 && a1<=29499 || a1>=29501 && a1<=29999 || a1>=30001 && a1<=30499 || a1>=30501 && a1<=30999 || a1>=31001 && a1<=31499 || a1>=31501 && a1<=31999 || a1>=32001 && a1<=32499 || a1>=32501 && a1<=32999 || a1>=33001 && a1<=33499 || a1>=33501 && a1<=33999 || a1>=34001 && a1<=34499 || a1>=34501 && a1<=34999 || a1>=35001 && a1<=35499 || a1>=35501 && a1<=35999 || a1>=36001 && a1<=36499 || a1>=36501 && a1<=36999 || a1>=37001 && a1<=37499 || a1>=37501 && a1<=37999 || a1>=38001 && a1<=38499 || a1>=38501 && a1<=38999 || a1>=39001 && a1<=39499 || a1>=39501 && a1<=39999 || a1>=40001 && a1<=40499 || a1>=40501 && a1<=40999 || a1>=41001 && a1<=41499 || a1>=41501 && a1<=41999 || a1>=42001 && a1<=42499 || a1>=42501 && a1<=42999 || a1>=43001 && a1<=43499 || a1>=43501 && a1<=43999 || a1>=44001 && a1<=44499 || a1>=44501 && a1<=44999 || a1>=45001 && a1<=45499 || a1>=45501 && a1<=45999 || a1>=46001 && a1<=46499 || a1>=46501 && a1<=46999 || a1>=47001 && a1<=47499 || a1>=47501 && a1<=47999 || a1>=48001 && a1<=48499 || a1>=48501 && a1<=48999 || a1>=49001 && a1<=49499 || a1>=49501 && a1<=49999)
            {
                j1.showMessageDialog(null,"Deposit Amount Should Be Multiple Of 500s!","Warning",1);
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
            //*******************
            if(!cardval.equals(a2))
                    {
                        j1.showMessageDialog(null,"Please Enter Valid Card No. !","Invalid",2);
                    }
            //********************
            //-----------------------------
            if(cardval.equals(a2) && a1!=0 && a1>0 && a1<=50000)
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
            AVB=avbal+a1;
            }
            catch(Exception z2)
            {
                System.out.println(z2);
            }
            //-------------------
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
            j1.showMessageDialog(null,"Money Desposited Successfully ☻","Deposit",1);
            }
            //---------------------------------
            catch(Exception z)
            {
                System.out.println(z);
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
        if(e1.getSource()==b16)
        {
            setVisible(false);
            transact trans=new transact();
        }
        if(e1.getSource()==b17)
        {
            setVisible(false);
            thankyou1 thanks=new thankyou1();
        }
    }
    public static void main(String a[])
    {
        new Tdeposit();
    }
}