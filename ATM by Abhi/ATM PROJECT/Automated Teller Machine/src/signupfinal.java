/*ATM signupfinal Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
public class signupfinal extends JFrame implements ActionListener
{
//*********************************************************Signup1
    //JFrame f1;
    JPanel p2;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JLabel ld1,ld2,ld3;//dob
    JTextField t3,t4,t5,t6,t7,t8,t9;//t1,t2 used
    JButton b4; //b1,b2,b3 used
    JButton cancel;
    JOptionPane j1;
    String col1[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String col2[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
    String col3[]={"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964","1965","1966","1967","1968","1969","1970",
    "1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990",
    "1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008"};
    JComboBox cb1,cb2,cb3; //dob
    JRadioButton rd1,rd2,rd3,rd4,rd5;
    ButtonGroup g1,g2;
    JLabel l100;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
//************************************************************Signup2
//JFrame f1;
    JPanel p3;
    JLabel l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
    JTextField t10,t11;//previous used
    JButton b5; //previous used
    JButton cancel2;
    //JOptionPane j1;
    JLabel l210;
    //Icon c1;
    String col12[]={"Hindu","Muslim","Sikh","Christian","Others"};
    String col123[]={"General","OBC","SC","ST","Others"};
    String col124[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000","Above 10,00,000"};
    String col125[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
    String col126[]={"Student","Salaried","Self-Employed","Business","Retired","Others"};
    JComboBox cb4,cb5,cb6,cb7,cb8;
    JRadioButton rd6,rd7,rd8,rd9;
    ButtonGroup g3,g4;
    //Font ft1=new Font("arial",Font.BOLD,40);
    //Font ft2=new Font("arial",Font.BOLD,18);
//************************************************************Signup3
//JFrame f1;
    JPanel p4;
    //JOptionPane j1;
    JLabel l23,l24,l25,l26,l27,l28,l29,l30,l31,l32;
    JButton b6;
    JButton Cancel3; //previous used
    JRadioButton rd10,rd11,rd12,rd13;
    ButtonGroup g5;
    JLabel l310;
    //Icon c1;
    JCheckBox x1,x2,x3,x4,x5,x6,x7;
    //Font ft1=new Font("arial",Font.BOLD,40);
    //Font ft2=new Font("arial",Font.BOLD,18);
    Font ft3=new Font("arial",Font.BOLD,10);
    Font ft4=new Font("arial",Font.PLAIN,10);
    
//*************************************************************
    public signupfinal()
    {
        super("NEW ACCOUNT APPLICATION FORM");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p2=new JPanel();
        add(p2);
        p2.setLayout(null);
        cancel=new JButton("CANCEL");
        /*l1=new JLabel("APPLICATION FORM NO. 1967");
        l1.setFont(ft1);*/
        l2=new JLabel("Personal Details");
        l2.setFont(ft1);
        l3=new JLabel("Name:");
        l3.setFont(ft2);
        l4=new JLabel("Father's Name:");
        l4.setFont(ft2);
        l5=new JLabel("Date of Birth:");
        l5.setFont(ft2);
        l6=new JLabel("Gender:");
        l6.setFont(ft2);
        l7=new JLabel("Email Address:");
        l7.setFont(ft2);
        l8=new JLabel("Marital Status:");
        l8.setFont(ft2);
        l9=new JLabel("Address:");
        l9.setFont(ft2);
        l10=new JLabel("City:");
        l10.setFont(ft2);
        l11=new JLabel("Pin Code:");
        l11.setFont(ft2);
        l12=new JLabel("State:");
        l12.setFont(ft2);
        ld1=new JLabel("Date");
        ld2=new JLabel("Month");
        ld3=new JLabel("Year");
        cb1=new JComboBox(col1);
        cb2=new JComboBox(col2);
        cb3=new JComboBox(col3);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);
        t6=new JTextField(20);
        t7=new JTextField(20);
        t8=new JTextField(20);
        t9=new JTextField(20);
        b4=new JButton("NEXT");
        rd1=new JRadioButton("Male");
        rd1.setSelected(true);
        rd2=new JRadioButton("Female");
        g1=new ButtonGroup();
        g1.add(rd1);
        g1.add(rd2);
        rd3=new JRadioButton("Married");
        rd3.setSelected(true);
        rd4=new JRadioButton("Unmarried");
        rd5=new JRadioButton("Others");
        g2=new ButtonGroup();
        g2.add(rd3);
        g2.add(rd4);
        g2.add(rd5);
        //positioning
        /*l1.setBounds(100,20,600,30); //x,y,width,height
        p2.add(l1);//app form*/
        l2.setBounds(230,40,600,30);//(300,60,400,30);
        p2.add(l2);//page 1
        l3.setBounds(100,110,100,30);
        p2.add(l3);//name
        t3.setBounds(300,110,370,30);
        p2.add(t3);
        l4.setBounds(100,160,150,30);
        p2.add(l4);//f name
        t4.setBounds(300,160,370,30);
        p2.add(t4);
        l5.setBounds(100,210,150,30);
        p2.add(l5);//dob
        ld1.setBounds(300,210,35,30);
        p2.add(ld1);
        cb1.setBounds(335,210,50,30);
        p2.add(cb1);
        ld2.setBounds(405,210,35,30);
        p2.add(ld2);
        cb2.setBounds(450,210,90,30);
        p2.add(cb2);
        ld3.setBounds(560,210,35,30);
        p2.add(ld3);
        cb3.setBounds(600,210,70,30);
        p2.add(cb3);
        l6.setBounds(100,260,150,30);
        p2.add(l6);//gender
        //radio buttons
        rd1.setBounds(300,260,100,30);
        //rd1.setBackground(Color.orange);
        p2.add(rd1);
        rd2.setBounds(400,260,100,30);
        //rd2.setBackground(Color.orange);
        p2.add(rd2);
        l7.setBounds(100,310,150,30);
        p2.add(l7);//email
        t5.setBounds(300,310,370,30);
        p2.add(t5);
        l8.setBounds(100,360,150,30);
        p2.add(l8);//marital
        rd3.setBounds(300,360,100,30);
        //rd3.setBackground(Color.orange);
        p2.add(rd3);
        rd4.setBounds(400,360,100,30);
        //rd4.setBackground(Color.orange);
        p2.add(rd4);
        rd5.setBounds(500,360,100,30);
        //rd5.setBackground(Color.orange);
        p2.add(rd5);
        l9.setBounds(100,410,150,30);
        p2.add(l9);//addr
        t6.setBounds(300,410,370,30);
        p2.add(t6);
        l10.setBounds(100,460,150,30);
        p2.add(l10);//city
        t7.setBounds(300,460,370,30);
        p2.add(t7);
        l11.setBounds(100,510,150,30);
        p2.add(l11);//pin
        t8.setBounds(300,510,370,30);
        p2.add(t8);
        l12.setBounds(100,560,150,30);
        p2.add(l12);//state
        t9.setBounds(300,560,370,30);
        p2.add(t9);
        b4.setBounds(200,610,100,30);
        p2.add(b4);
        cancel.setBounds(350,610,100,30);
        p2.add(cancel);
        
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bksignup.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p2.add(l100);
        //Listeners
        b4.addActionListener(this);
        cancel.addActionListener(this);
        setVisible(true);
//***********************************************************************signupfinal2
/*super("NEW ACCOUNT APPLICATION FORM");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory*/
        p3=new JPanel();
        add(p3);
        p3.setLayout(null);
        cancel2=new JButton("CANCEL");
        l13=new JLabel("Additional Details");
        l13.setFont(ft1);
        l14=new JLabel("Religion:");
        l14.setFont(ft2);
        l15=new JLabel("Category:");
        l15.setFont(ft2);
        l16=new JLabel("Income:");
        l16.setFont(ft2);
        l17=new JLabel("<html>Educational<br>Qualification:</html>");
        l17.setFont(ft2);
        l18=new JLabel("Occupation:");
        l18.setFont(ft2);
        l19=new JLabel("Phone No.:");
        l19.setFont(ft2);
        l20=new JLabel("Aadhaar No.:");
        l20.setFont(ft2);
        l21=new JLabel("Senior Citizen:");
        l21.setFont(ft2);
        l22=new JLabel("Existing Account:");
        l22.setFont(ft2);
        t10=new JTextField(20);
        t11=new JTextField(20);
        b5=new JButton("NEXT");
        rd6=new JRadioButton("Yes");
        rd7=new JRadioButton("No");
        rd7.setSelected(true);
        g3=new ButtonGroup();
        g3.add(rd6);
        g3.add(rd7);
        rd8=new JRadioButton("Yes");
        rd9=new JRadioButton("No");
        rd9.setSelected(true);
        g4=new ButtonGroup();
        g4.add(rd8);
        g4.add(rd9);
        cb4=new JComboBox(col12);
        cb5=new JComboBox(col123);
        cb6=new JComboBox(col124);
        cb7=new JComboBox(col125);
        cb8=new JComboBox(col126);
        
        //positioning
        l13.setBounds(230,40,600,30);
        p3.add(l13);//page 2
        l14.setBounds(100,110,100,30);
        p3.add(l14);//religion
        cb4.setBounds(320,110,370,30);
        p3.add(cb4);
        l15.setBounds(100,160,150,30);
        p3.add(l15);//category
        cb5.setBounds(320,160,370,30);
        p3.add(cb5);
        l16.setBounds(100,210,150,30);
        p3.add(l16);//income
        cb6.setBounds(320,210,370,30);
        p3.add(cb6);
        l17.setBounds(100,270,150,50);
        p3.add(l17);//edu
        cb7.setBounds(320,290,370,30);
        p3.add(cb7);
        l18.setBounds(100,350,150,30);
        p3.add(l18);//occu
        cb8.setBounds(320,350,370,30);
        p3.add(cb8);
        l19.setBounds(100,400,150,30);
        p3.add(l19);//pan
        t10.setBounds(320,400,370,30);
        p3.add(t10);
        l20.setBounds(100,450,150,30);
        p3.add(l20);//aadhar
        t11.setBounds(320,450,370,30);
        p3.add(t11);
        l21.setBounds(100,500,150,30);
        p3.add(l21);//senior
       //radio buttons
        rd6.setBounds(320,500,100,30);
        //rd6.setBackground(Color.orange);
        p3.add(rd6);
        rd7.setBounds(420,500,100,30);
        //rd7.setBackground(Color.orange);
        p3.add(rd7);
        l22.setBounds(100,550,170,30);
        p3.add(l22);//existing
        //radio buttons
        rd8.setBounds(320,550,100,30);
        //rd8.setBackground(Color.orange);
        p3.add(rd8);
        rd9.setBounds(420,550,100,30);
        //rd9.setBackground(Color.orange);
        p3.add(rd9);
        //---------------------
        b5.setBounds(200,600,100,30);
        p3.add(b5);
        cancel2.setBounds(350,600,100,30);
        p3.add(cancel2);
        
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bksignup.jpg");
    l210=new JLabel(c1);
    l210.setBounds(0,0,750,700);//Background
    p3.add(l210);
        //Listeners
        b5.addActionListener(this);
        cancel2.addActionListener(this);
        setVisible(true);
//*********************************************************signupfinal3

/*super("NEW ACCOUNT APPLICATION FORM");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory*/
        p4=new JPanel();
        add(p4);
        p4.setLayout(null);
        l23=new JLabel("Account Details");
        l23.setFont(ft1);
        l24=new JLabel("Account Type:");
        l24.setFont(ft2);
        l25=new JLabel("CARD NUMBER:");
        l25.setFont(ft2);
        l26=new JLabel("(Your 16 digit Card Number)");
        l26.setFont(ft3);
        l27=new JLabel("XXXX-XXXX-XXXX-1234");
        l27.setFont(ft2);
        l28=new JLabel("It would appear on ATM Card/Cheque Book & Statements");
        l28.setFont(ft4);
        l29=new JLabel("PIN:");
        l29.setFont(ft2);
        l30=new JLabel("(4 digit password");
        l30.setFont(ft3);
        l31=new JLabel("XXXX");
        l31.setFont(ft2);
        l32=new JLabel("Services Required:");
        l32.setFont(ft2);
        g5=new ButtonGroup();
        rd10=new JRadioButton("Savings Account");
        rd10.setSelected(true);
        rd11=new JRadioButton("Fixed Deposit Account");
        rd12=new JRadioButton("Current Account");
        rd13=new JRadioButton("Recurring Deposit Account");
        g5.add(rd10);
        g5.add(rd11);
        g5.add(rd12);
        g5.add(rd13);
        x1=new JCheckBox("ATM Card");
        x1.setSelected(true);
        //x1.setBackground(Color.orange);
        x2=new JCheckBox("Internet Banking");
        //x2.setBackground(Color.orange);
        x3=new JCheckBox("Mobile Banking");
        //x3.setBackground(Color.orange);
        x4=new JCheckBox("Email Alerts");
        x4.setSelected(true);
        //x4.setBackground(Color.orange);
        x5=new JCheckBox("Cheque Book");
        //x5.setBackground(Color.orange);
        x6=new JCheckBox("E-Statement");
        //x6.setBackground(Color.orange);
        x7=new JCheckBox("<html>I hereby declare that the above entered details are<br>correct to the best of my knowledge</html>");
        //x7.setBackground(Color.orange);
        b6=new JButton("SUBMIT");
        Cancel3=new JButton("CANCEL");
        //positioning
        l23.setBounds(200,40,600,30);
        p4.add(l23);//page 3
        l24.setBounds(100,110,200,30);
        p4.add(l24);//Acc type
        //radio buttons
        rd10.setBounds(100,140,200,30);
        //rd10.setBackground(Color.orange);
        p4.add(rd10);
        rd11.setBounds(320,140,200,30);
        //rd11.setBackground(Color.orange);
        p4.add(rd11);
        rd12.setBounds(100,170,200,30);
        //rd12.setBackground(Color.orange);
        p4.add(rd12);
        rd13.setBounds(320,170,200,30);
        //rd13.setBackground(Color.orange);
        p4.add(rd13);
        //---------------------
        l25.setBounds(100,230,150,30);
        p4.add(l25);//card no
        l26.setBounds(100,250,200,30);
        p4.add(l26);//hint 16 digit
        l27.setBounds(320,230,300,30);
        p4.add(l27);//dummy 16 digit
        l28.setBounds(320,250,400,30);
        p4.add(l28);//hint dummy 16 digit
        l29.setBounds(100,310,150,30);
        p4.add(l29);//pin
        l30.setBounds(100,330,200,30);
        p4.add(l30);//hint 4 digit
        l31.setBounds(320,310,150,30);
        p4.add(l31);//4 digit
        l32.setBounds(100,390,170,30);
        p4.add(l32);//services
        x1.setBounds(100,430,200,30);
        p4.add(x1);
        x2.setBounds(320,430,200,30);
        p4.add(x2);
        x3.setBounds(100,460,200,30);
        p4.add(x3);
        x4.setBounds(320,460,200,30);
        p4.add(x4);
        x5.setBounds(100,490,200,30);
        p4.add(x5);
        x6.setBounds(320,490,200,30);
        p4.add(x6);
        x7.setBounds(160,540,400,30);
        p4.add(x7);
        b6.setBounds(200,600,100,30);
        p4.add(b6);
        Cancel3.setBounds(350,600,100,30);
        p4.add(Cancel3);
        //Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bksignup.jpg");
    l310=new JLabel(c1);
    l310.setBounds(0,0,750,700);//Background
    p4.add(l310);
        //Listeners
        b6.addActionListener(this);
        Cancel3.addActionListener(this);
	p2.setVisible(true);
	p3.setVisible(false);
	p4.setVisible(false);
	
        setVisible(true);

//**********************************************************

}

    public void actionPerformed(ActionEvent e1)
    {
        int dpin=0;
        String a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15;
	String a16,a17,a18,a19,a20,a21,a22,a23,a24,a160,a161;
	String a25,a26,a27,a28,a29,a30,a31,a32,a33,a250,a251;

//sig1*************************************
            a1=t3.getText();
            a2=t4.getText();
            a3=(String)cb1.getSelectedItem();
            a4=(String)cb2.getSelectedItem();
            a5=(String)cb3.getSelectedItem();
            a8=t5.getText();
            a12=t6.getText();
            a13=t7.getText();
            a14=t8.getText();
            a15=t9.getText();
//sig2**************************************
            a16=(String)cb4.getSelectedItem();
            a17=(String)cb5.getSelectedItem();
            a18=(String)cb6.getSelectedItem();
            a19=(String)cb7.getSelectedItem();
            a20=(String)cb8.getSelectedItem();
            a21=t10.getText();
            a22=t11.getText();
//sig3**************************************
            /*a29=x1.isSelected;
            a30=x2.isSelected;
            a31=x3.isSelected;
            a32=x4.isSelected;
            a33=x5.isSelected;
            a250=x6.isSelected;
            a251=x7.isSelected;*/
//**************************************
        if(e1.getSource()==b4)
        {
//****************************************************sign1
            //valiation
            if(a1.length()==0 || a2.length()==0 || a3.length()==0 || a4.length()==0 || a5.length()==0 || a8.length()==0 || a12.length()==0 || a13.length()==0 || a14.length()==0 || a15.length()==0)
            {
                j1.showMessageDialog(null,"All Fields Are Mandatory !","Warning",2);
            }
            //---------------------------------------------
            if(a1.length()!=0 && a2.length()!=0 && a8.length()!=0 && a12.length()!=0 && a13.length()!=0 && a14.length()!=0 && a15.length()!=0)
            {
p2.setVisible(false);
p3.setVisible(true);
            }
        }
	if(e1.getSource()==cancel)
        {
            j1.showMessageDialog(null,"Exiting From Sign Up Process !","Cancelled",1);
            setVisible(false);
            Welcome wel=new Welcome();
        }
//******************************************sign2
if(e1.getSource()==b5)
        {
            //valiation
            if(a16.length()==0 || a17.length()==0 || a18.length()==0 || a19.length()==0 || a20.length()==0 || a21.length()==0 || a22.length()==0)
            {
                j1.showMessageDialog(null,"All Fields Are Mandatory !","Warning",2);
            }
            if(a21.length()!=0 && a21.length()!=10)//PAN validation
            {
                j1.showMessageDialog(null,"Please Enter Correct Phone No. !","Warning",2);
            }
            if(a22.length()!=0 && a22.length()!=12)//Aadhaar validation
            {
                j1.showMessageDialog(null,"Please Enter Correct Aadhaar No. !","Warning",2);
            }
            if(rd9.isSelected())
            {
                j1.showMessageDialog(null,"Existing Account In Our Bank Is Must To Proceed !","Warning",2);
            }
            //---------------------------------------------------
            if(a21.length()==10 && a22.length()==12 && rd8.isSelected())
            {
            
p3.setVisible(false);
p4.setVisible(true);
            }
        }
if(e1.getSource()==cancel2)
        {
            j1.showMessageDialog(null,"Exiting From Sign Up Process !","Cancelled",1);
            setVisible(false);
            Welcome wel=new Welcome();
        }
//***********************************************************sign3
if(e1.getSource()==b6)
        {
            if(x1.isSelected())//ATM service mandatory
            {
            if(x7.isSelected())//I have read and confirm the details
            {
                try
            {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/sample","app","app");
            String sql="insert into atm_db(name,fname,dobdate,dobmonth,dobyear,gender,email,marital,address,city,pincode,state,religion,category,income,qualification,occupation,phone,aadhaar,seniorcitizen, existingacc,acctype,atmserv,netbankserv,mobileserv,emailserv,cheqbookserv,estmtserv,pin,date_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp)";
            PreparedStatement stat=con.prepareStatement(sql);

            stat.setString(1,a1);//name//Col and value
            stat.setString(2,a2);//fname
            stat.setString(3,a3);//dobdate
            stat.setString(4,a4);//dobmonth
            stat.setString(5,a5);//dobyear
            
            if(rd1.isSelected())//gender
                 stat.setString(6,"Male");
             else if(rd2.isSelected())
                 stat.setString(6,"Female");
            
            stat.setString(7,a8);//email
            
            if(rd3.isSelected())//marital
                 stat.setString(8,"Married");
            else if(rd4.isSelected())
                 stat.setString(8,"Unmarried");
            else if(rd5.isSelected())
                 stat.setString(8,"Others");
            
            stat.setString(9,a12);//addr
            stat.setString(10,a13);//city
            stat.setString(11,a14);//pincode
            stat.setString(12,a15);//state
//******************************************signupfinal2

	stat.setString(13,a16);//rel//Col and value
            stat.setString(14,a17);//category
            stat.setString(15,a18);//income
            stat.setString(16,a19);//edu
            stat.setString(17,a20);//occu
            stat.setString(18,a21);//pan
            stat.setString(19,a22);//aadhaar
            
            if(rd6.isSelected())//senior citizen
                 stat.setString(20,"Yes");
             else if(rd7.isSelected())
                 stat.setString(20,"No");
            
            if(rd8.isSelected())//existing acc
                 stat.setString(21,"Yes");
             else if(rd9.isSelected())
                 stat.setString(21,"No");
//******************************************signupfinal3

            if(rd10.isSelected())//acc type
                 stat.setString(22,"Savings");
             else if(rd11.isSelected())
                 stat.setString(22,"Fixed Deposit");
            else if(rd12.isSelected())//existing acc
                 stat.setString(22,"Current");
             else if(rd13.isSelected())
                 stat.setString(22,"Recurring Deposit");
//services
            if(x1.isSelected())//ATM card
                stat.setString(23,"Yes");
            else
                stat.setString(23,"No");
            if(x2.isSelected())//Internetbanking
                stat.setString(24,"Yes");
            else
                stat.setString(24,"No");
            if(x3.isSelected())//Mobile banking
                stat.setString(25,"Yes");
            else
                stat.setString(25,"No");
            if(x4.isSelected())//Email alerts
                stat.setString(26,"Yes");
            else
                stat.setString(26,"No");
            if(x5.isSelected())//Cheque Book
                stat.setString(27,"Yes");
            else
                stat.setString(27,"No");
            if(x6.isSelected())//E-Statement
                stat.setString(28,"Yes");
            else
            {
                stat.setString(28,"No");
            }
            
            stat.setInt(29,dpin);

//final submit
stat.executeUpdate();
//table 1 finish-----------------------------------------            
//Second table: Pin Value as automatic idenity
/*PreparedStatement stat2=con.prepareStatement("insert into atm_db2(name,fname,aadhaar) values(?,?,?)");

            stat2.setString(1,a1);//name//Col and value
            stat2.setString(2,a2);//fname
            stat2.setString(3,a22);//aadhaar
            
//final submit
stat2.executeUpdate();*/
//table 2 finish----------------------------------------
//----------------------------------------------------

            j1.showMessageDialog(null,"Form Submitted Successfully !","Congratulations",1);
            j1.showMessageDialog(null,"Please Collect Your Card No. And PIN From The Bank !","Collect",1);
            setVisible(false);
            Welcome wel=new Welcome();
            }
            catch(Exception z)
            {
                System.out.println(z);
            }
            //---------------
        }
            else
            {
                j1.showMessageDialog(null,"Please ! Confirm The Declaration To Continue...","Mandatory",1);
            }
            }
            else
                {
                    j1.showMessageDialog(null,"ATM Card Service Must Be Selected ! ","Mandatory",2);
                }
        }
                if(e1.getSource()==Cancel3)
        {
            j1.showMessageDialog(null,"Exiting From Sign Up Process !","Cancelled",1);
            setVisible(false);
            Welcome wel=new Welcome();
        }
    }
    public static void main(String a[])
    {
        new signupfinal();
    }
}