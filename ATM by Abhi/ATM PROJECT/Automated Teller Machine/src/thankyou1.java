/*ATM thankyou1 Screen*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class thankyou1 extends JFrame implements ActionListener, Runnable
{
    JFrame f1;
    JPanel p10;
    JLabel l1;
    String pos[]={"THANK YOU FOR USING ATM","HAVE A NICE DAY ! ☻ ☻ ☻"};
    int count;//not initialized, default value 0
    Thread t1;
    JButton b31,b32;
    JLabel l100;
    Icon c1;
    Font ft1=new Font("arial",Font.BOLD,40);
    Font ft2=new Font("arial",Font.BOLD,18);
    public thankyou1()
    {
        super("TRANSACTION");
        setSize(750,700);//width,height
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //most important to free memory
        p10=new JPanel();
        add(p10);
        p10.setLayout(null);
        l1=new JLabel("");
        l1.setFont(ft1);
        b31=new JButton("BACK");
        b32=new JButton("EXIT");
        //positioning
        l1.setBounds(90,210,600,40); //x,y,width,height
        p10.add(l1);//thank you
        b31.setBounds(100,400,200,40);
        p10.add(b31);
        b32.setBounds(450,400,200,40);
        p10.add(b32);
        //Thread implementation
    t1=new Thread(this);
    t1.start();
//Background
    c1=new ImageIcon("D:\\NIIT\\misc\\bkthank.jpg");
    l100=new JLabel(c1);
    l100.setBounds(0,0,750,700);//Background
    p10.add(l100);
       //Listeners
        b31.addActionListener(this);
        b32.addActionListener(this);
    setVisible(true);
    }
 //Thread implementation   
public void run()
{
    try
    {
        for(;;)//infinite loop
        {
            dis();
            t1.sleep(800);
        }
    }
    catch(Exception z2)
    {
        System.out.println(z2);
    }
}
public void dis()
{
    l1.setText(pos[count]);
    count++;
    if(count>=2)
    {
        count=0;
    }
}
 
        public void actionPerformed(ActionEvent e1)
    {
        if(e1.getSource()==b31)
        {
            setVisible(false);
            transact trans=new transact();
        }
        if(e1.getSource()==b32)
        {
            setVisible(false);
            Welcome wel=new Welcome();
        }
    }
    public static void main(String a[])
    {
        new thankyou1();
    }
}