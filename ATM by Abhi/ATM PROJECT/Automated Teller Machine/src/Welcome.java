/*ATM Welcome Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Welcome extends JFrame implements ActionListener {

    //JFrame f1;
    JPanel p1;
    JLabel l1, l2, l3;
    JLabel L1;//nameL;
    Icon C1;
    JTextField t1;//nameT;
    JPasswordField t2;
    JButton b1, b2, b3;
    JOptionPane j1;
    JLabel l100;
    Icon c1;
    Font ft1 = new Font("arial", Font.BOLD, 60);
    Font ft2 = new Font("arial", Font.BOLD, 18);

    public Welcome() {
        super("AUTOMATED TELLER MACHINE");
        setSize(750, 700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p1 = new JPanel();
        add(p1);
        p1.setLayout(null);
        l1 = new JLabel("WELCOME TO ATM");
        l1.setFont(ft1);
        //nameL=new JLabel("Name :");
        //nameL.setFont(ft2);
        l2 = new JLabel("Card no. :");
        l2.setFont(ft2);
        l3 = new JLabel("PIN :");
        l3.setFont(ft2);
        //nameT=new JTextField(20);
        t1 = new JTextField(20);
        t2 = new JPasswordField(4);
        b1 = new JButton("SIGN IN");
        b2 = new JButton("CLEAR");
        b3 = new JButton("SIGN UP");
        //positioning
        l1.setBounds(80, 70, 600, 80); //x,y,width,height
        p1.add(l1);//welcome
        //nameL.setBounds(200,240,100,30); //x,y,width,height
        //p1.add(nameL);//name label
        l2.setBounds(200, 240, 100, 30);//(200,300,100,30); //x,y,width,height
        p1.add(l2);//card no label
        l3.setBounds(200, 300, 100, 30);//(200,360,100,30); //x,y,width,height
        p1.add(l3);//pin label
        //nameT.setBounds(350,240,220,30);
        //p1.add(nameT);//name
        //nameT.setToolTipText("Enter Your Name Here");
        t1.setBounds(350, 240, 220, 30);//(350,300,220,30);
        p1.add(t1);//card
        t1.setToolTipText("Enter Your ATM Card No. Here");
        t2.setBounds(350, 300, 220, 30);//(350,360,220,30);
        p1.add(t2);//pin
        t2.setToolTipText("Enter Your 4 Digit PIN No. Here");
        b1.setBounds(350, 380, 100, 30);//(350,440,100,30);
        p1.add(b1);
        b1.setToolTipText("Click Here To Sign In");
        b2.setBounds(470, 380, 100, 30);//(470,440,100,30);
        p1.add(b2);
        b2.setToolTipText("Click To Clear All Fields");
        b3.setBounds(350, 440, 220, 30);//(350,500,220,30);
        p1.add(b3);
        b3.setToolTipText("Click Here To Sign Up");

        //Background
        c1 = new ImageIcon("D:\\NIIT\\misc\\bkwelcome.jpg");
        l100 = new JLabel(c1);
        l100.setBounds(0, 0, 750, 700);//Background
        p1.add(l100);
        //Listeners
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e1) {
        if (e1.getSource() == b1) {
            //String a3=nameT.getText();
            //String nameval="";//atm db
            //String nameval2="";//atmdb2
            String a1 = t1.getText();
            String a2 = t2.getText();

            /*if(a3.length()==0)
            {
                j1.showMessageDialog(null,"Please! Enter Your Registered Name","Warning",2);
            }*/
            if (a1.length() == 0 && a2.length() == 4) {
                j1.showMessageDialog(null, "Please! Enter Your 16 Digit Card No.", "Warning", 2);
            }
            if (a1.length() != 0 && a1.length() != 16) {
                j1.showMessageDialog(null, "Length Of Card No. Must Be 16", "Warning", 2);
            }
            if (a2.length() == 0 && a1.length() == 16) {
                j1.showMessageDialog(null, "Please ! Enter Your 4 Digit PIN No.", "Warning", 2);
            }
            if (a2.length() != 0 && a2.length() != 4) {
                j1.showMessageDialog(null, "Length Of PIN Must Be 4", "Warning", 2);
            }
            if (a1.length() == 0 && a2.length() == 0) {
                j1.showMessageDialog(null, "Please Fill The Details To Continue", "Warning", 2);
            }
            //-------------------------------------------------
            if (a1.length() == 16 && a2.length() == 4) {
                //database part
                String cardno = "", pinno = "";
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
                    //name from atm_db authentication check
                    PreparedStatement stat = con.prepareStatement("select * from atm_db where card_no=?");
                    stat.setString(1, a1);
                    ResultSet res0 = stat.executeQuery();
                    while (res0.next()) {
//            nameval=res0.getString(2);
                        cardno = res0.getString(1);
                        pinno = res0.getString(30);
                    }
                    //-----------------------------
                    /*
//pin number------------------------------------------   
            PreparedStatement stat3=con.prepareStatement("select * from atm_db2 where name=?");
            stat3.setString(1,a3);
            ResultSet res2=stat3.executeQuery();
            while(res2.next())
            {   
                nameval2=res2.getString(2);
                pinno=res2.getString(1);
            }
            //------------------------
                     */
                    //if(nameval.equals(a3) && cardno.equals(a1) && pinno.equals(a2) && nameval2.equals(a3) )
                    if (cardno.equals(a1) && pinno.equals(a2)) {
                        long zb = 0, zc = 0, zd = 0;
                        String sql = "insert into atm_db2(card_no,deposited,withdrew,avl_bal,date_time)values(?,?,?,?,current_timestamp)";
                        PreparedStatement stat4 = con.prepareStatement(sql);
                        stat4.setString(1, a1);
                        stat4.setLong(2, zb);
                        stat4.setLong(3, zc);
                        stat4.setLong(4, zd);
                        stat4.executeUpdate();
//table 3 finish-----------------------------------------

                        //***************************************
                        j1.showMessageDialog(null, "Successfully Signed In !", "Welcome", 1);
                        //----------------------------------------
                        setVisible(false);
                        transact trans = new transact();
                    } //-------------------------------------
                    else if (!cardno.equals(a1) && !pinno.equals(a2)) {
                        j1.showMessageDialog(null, "Please Enter Correct Details !", "Warning", 2);
                    } else if (cardno.equals(a1) && !pinno.equals(a2)) {
                        j1.showMessageDialog(null, "Invalid PIN No.", "Invalid", 2);
                    } else if (!cardno.equals(a1) && pinno.equals(a2)) {
                        j1.showMessageDialog(null, "Please Enter Correct Details !", "Warning", 2);
                    }
                } catch (Exception z2) {
                    System.out.println(z2);
                }
            }
        }

//------------------------------------------------------------------------
        if (e1.getSource() == b2) {
            t1.setText("");
            t2.setText("");
        }
        if (e1.getSource() == b3) {
            setVisible(false);
            signupfinal sig1 = new signupfinal();
        }
    }

    public static void main(String a[]) {
        Welcome wel = new Welcome();
    }
}