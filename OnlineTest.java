import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.sql.*;

class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=-1,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }
        b1=new JButton("Start");   
        b1.addActionListener(this);
        add(b1);
        //added start button
        welcome(); 
        //displays welcome message
        b2=new JButton("Previous");
        b3=new JButton("Result"); 
        b2.addActionListener(this); 
        b3.addActionListener(this);  
        add(b2);add(b3);
        // added previous and result buttons
        l.setBounds(30,40,450,20);  
        if(current !=-1)
        {   
            jb[0].setBounds(50,80,100,20);  //setting dimensions and coordinates of radio button group
            jb[1].setBounds(50,110,100,20);  
            jb[2].setBounds(50,140,100,20);  
            jb[3].setBounds(50,170,100,20);  
        }
        b1.setBounds(100,240,100,30);  //setting dimensions and coordinates of start/next button
        b2.setBounds(270,240,100,30);  //setting dimensions and coordinates of previous button
        b3.setBounds(400,240,100,30);  //setting dimensions and coordinates of result button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);  
    }  
    public void actionPerformed(ActionEvent e)  
    {  
        if(e.getSource()==b1 && current ==9 )
        {
            adduserans();
            JOptionPane.showMessageDialog(this,"No more questions. Please go back to previous question or end test and see result.\n");   
        }
        else if(e.getSource()==b1)  
        {  
            if(current == -1)
                b1.setText("Next");
            else
                adduserans();
            current++;  
            setnext(); 
        }  
        else if(e.getSource()==b2 && current ==0 )
        {
            adduserans();
            JOptionPane.showMessageDialog(this,"No more questions. Please go back to next question or end test and see result.\n");   
        }
        else if(e.getSource()==b2)  
        {   
            current--;  
            adduserans();
            setnext();   
        }  
        else if(e.getActionCommand().equals("Result"))  
        {  
            current++;  
            //System.out.println("correct ans="+count);  
            check();
            int a = JOptionPane.showConfirmDialog(this,"Your Score: "+count+" / 10\nPercentage: "+(count*10)+" %\n Do you wish to see the answer key ?");  
            if(a==JOptionPane.YES_OPTION)
                showAnswerKey();
            else
             System.exit(0);  
        }  
    }  
    void welcome() //Welcome Message 
    {
        l.setText("Welcome to the online examination. Click button to start with the test.") ;
    }
    void setnext() 
    {  
        jb[4].setSelected(true);  
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            if(current==0)  
            {    
                String sql="select * from qao where qno=1";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==1)  
            {  
                String sql="select * from qao where qno=2";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==2)  
            {  
                String sql="select * from qao where qno=3";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==3)  
            {  
                String sql="select * from qao where qno=4";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==4)  
            {  
                String sql="select * from qao where qno=5";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==5)  
            {  
                String sql="select * from qao where qno=6";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==6)  
            {  
                String sql="select * from qao where qno=7";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==7)  
            {  
                String sql="select * from qao where qno=8";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==8)  
            {  
                String sql="select * from qao where qno=9";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            if(current==9)  
            {  
                String sql="select * from qao where qno=10";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("question");
                String s2 =rs.getString("option1");
                String s3 =rs.getString("option2");
                String s4 =rs.getString("option3");
                String s5 =rs.getString("option4");
                l.setText(s1);  
                jb[0].setText(s2);jb[1].setText(s3);jb[2].setText(s4);jb[3].setText(s5);  
            }  
            l.setBounds(30,40,450,20);  
            for(int i=0,j=0;i<=90;i+=30,j++)  
                jb[j].setBounds(50,80+i,200,20);  
        }   
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
    void adduserans() //function to connect to qa database and insert user's answers into ua table
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            for(int i=0;i<=3;i++)
            {
                if(jb[i].isSelected()) //if answer has been selected in radio button group
                {
                    String sql1 = "insert into ua(qno,userans) values("+(current+1)+",'"+jb[i].getText()+"') on duplicate key update userans='"+jb[i].getText()+"'";
                    //if user opts to change answer, she/he can do so because of the above command. 
                    //This allows the table to accept overwriting of existing values
                    stmt.executeUpdate(sql1);
                    //con.close();
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void check()  //function to check number of correct answers 
    {  
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            for(int i=1;i<=10;i++)
            {
                String sql="select userans, correctans from ua where qno="+i+"";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("userans");
                String s2 =rs.getString("correctans");
                if(s1.equals(s2)) //checks if user's answer matches correct answer
                 count++;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    void showAnswerKey() //function to print answer key if requested for
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            String answerkey="";
            answerkey+="Answer Key:\nQ.No.  Your answer  Correct Answer\n";
            for(int i=1;i<=10;i++)
            {
                String sql="select userans, correctans from ua where qno="+i+"";
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();
                String s1 =rs.getString("userans"); //stores user's answer
                if(s1.equals("")) //if user hasn't attempted this question, we assign NA to variable
                    s1="NA";
                String s2 =rs.getString("correctans"); //stores correct answer
                if(i<=9)
                 answerkey+="   "+(char)(i+48)+"         "+s1+"         "+s2+"\n";
                else //0-9 is 48-57 in ascii 
                 answerkey+="  10"+"         "+s1+"         "+s2+"\n";
            }
            JOptionPane.showMessageDialog(this,answerkey); //prints answer key
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static void qaoDBcon() //function to connect to qa database and insert correct answers into qao table
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into qao values(1,'Q1. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(2,'Q2. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(3,'Q3. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(4,'Q4. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(5,'Q5. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(6,'Q6. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(7,'Q7. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(8,'Q8. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(9,'Q9. What language are we using ?','C','C++','Java','Python')");
            stmt.executeUpdate("insert into qao values(10,'Q10. What language are we using ?','C','C++','Java','Python')");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    static void uaDBcon() //function to connect to qa database and insert correct answers into ua table
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///qa","root","shivhek25@mysql");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("insert into ua values(1,'','Java')");
            stmt.executeUpdate("insert into ua values(2,'','Java')");
            stmt.executeUpdate("insert into ua values(3,'','Java')");
            stmt.executeUpdate("insert into ua values(4,'','Java')");
            stmt.executeUpdate("insert into ua values(5,'','Java')");
            stmt.executeUpdate("insert into ua values(6,'','Java')");
            stmt.executeUpdate("insert into ua values(7,'','Java')");
            stmt.executeUpdate("insert into ua values(8,'','Java')");
            stmt.executeUpdate("insert into ua values(9,'','Java')");
            stmt.executeUpdate("insert into ua values(10,'','Java')");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String s[])
    {  
        qaoDBcon(); //creating question-option database
        uaDBcon(); //creating user answer-correct answer database
        new OnlineTest("Online Exam System");  // creating object 
    }  
}  