/*ATM Tmini Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
public class Tmini extends JFrame implements ActionListener
{
    final Vector columnNames = new Vector();
    final Vector data = new Vector();
    JFrame f1;
    JPanel p6;
    JLabel l1;
    JButton b15,b16,b17;
    JTextField cnT;
    JOptionPane j1;
    JLabel l100,cnL;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public Tmini()
    {
        super("MINI STATEMENT");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p6=new JPanel();
        add(p6);
        p6.setLayout(null);
        l1=new JLabel("<html><center>ENTER YOUR CARD NO. FOR MINI STATEMENT</center><html>");
        l1.setFont(ft1);
        cnT=new JTextField(20);
        cnL=new JLabel("Card no.");
        b15=new JButton("SHOW");
        b16=new JButton("BACK");
        b17=new JButton("EXIT");
        //positioning
        l1.setBounds(90,150,600,80); //x,y,width,height
        p6.add(l1);//bal enq label
        cnL.setBounds(150,300,100,30);
        cnL.setFont(ft2);
        cnT.setBounds(250,300,280,30);
        p6.add(cnT);//card val
        p6.add(cnL);//card no. label
        b15.setBounds(260,380,100,30);
        p6.add(b15);//dep
        b16.setBounds(420,380,100,30);
        p6.add(b16);//back
        b17.setBounds(310,480,160,30);
        p6.add(b17);//exit
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkmini.jpg");
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
        {//get value from avl_bal
            String a2=cnT.getText();//card no
            String cardval="";
            String v1="";
            //------------------
            if(a2.length()==0)
            {
                j1.showMessageDialog(null,"Please ! Enter Your 16 Digit Card No.","Warning",2);
            }
            if(a2.length()!=0 && a2.length()!=16)
            {
                j1.showMessageDialog(null,"Length Of Card No. Must Be 16","Warning",2);
            }
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
            }
            catch(Exception z)
            {
                System.out.println(z);
            }
            //-----------------------------
            if(cardval.equals(a2))
            {
            try
{
Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from atm_db2 where card_no='"+a2+"'");
ResultSetMetaData md = rs.getMetaData();
int columns = md.getColumnCount();
for (int i = 2; i <=columns; i++)
{
columnNames.addElement( md.getColumnName(i) );
}
while (rs.next())
{
Vector row = new Vector(columns);
for (int i = 2; i <= columns; i++)
{
row.addElement( rs.getObject(i) );
}
data.addElement( row );
}
JFrame frame=new JFrame("MINI STATEMENT");
frame.setSize(750,700);
setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //most important to free memory
JTable table = new JTable(data, columnNames);
//setDefaultCloseOperation(JTable.RESET_ON_CLOSE); //most important to free memory
JScrollPane pane=new JScrollPane(table);
frame.add(pane);
frame.setVisible(true);
frame.pack();
}
catch(Exception ex)
{
System.out.println(ex);
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
        new Tmini();
    }
}