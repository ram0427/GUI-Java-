import javax.swing.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

class RegistrationDemo
{
  static JTextField name_tf;
  static JTextField father_tf;
  static JTextField dob_tf;
  static JTextArea add_ta;
  static JComboBox sem;
  static JComboBox branch;
  static JRadioButton male;
  static JRadioButton female;
  static JComboBox day;
  static JComboBox month;
  static JComboBox year;
  static JCheckBox tandc;
  static JButton Submit;
  static JButton Reset;
  static JButton Cancel;
  static JButton Browse;
  static JTextArea output;


  public static void main(String[] args)
  {
    JFrame frame=new JFrame("STUDENT RECORD");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(200,100,740,500);

    Container cntr=frame.getContentPane();
    cntr.setLayout(null);
    cntr.setBackground(Color.GRAY);

    JLabel name_label=new JLabel("Name :");
    name_label.setBounds(50,50,60,30);
    cntr.add(name_label);

    name_tf=new JTextField();
    name_tf.setBounds(150,50,150,25);
    cntr.add(name_tf);

    JLabel fathername_label=new JLabel("Father's Name :");
    fathername_label.setBounds(50,50,100,100);
    cntr.add(fathername_label);

    father_tf=new JTextField();
    father_tf.setBounds(150,90,150,25);
    cntr.add(father_tf);

    JLabel dob_label=new JLabel("DOB :");
    dob_label.setBounds(50,100,100,100);
    cntr.add(dob_label);

    String[] day_arr=new String[31];
    for(int i=1;i<=31;i++)
    day_arr[i-1]=Integer.toString(i);
    day=new JComboBox(day_arr);
    day.setBounds(150,140,40,25);
    cntr.add(day);

    String[] month_arr={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    month=new JComboBox(month_arr);
    month.setBounds(200,140,50,25);
    cntr.add(month);

    String[] year_arr=new String[70];
    for(int i=1951;i<=2020;i++)
    year_arr[i-1951]=Integer.toString(i);
    year=new JComboBox(year_arr);
    year.setBounds(260,140,90,25);
    cntr.add(year);
   

    JLabel sem_label=new JLabel("Semester :");
    sem_label.setBounds(50,155,100,100);
    cntr.add(sem_label);

    String[] sem_arr={"I","II","III","IV","V","VI","VII","VIII"};
    sem=new JComboBox(sem_arr);
    sem.setBounds(150,190,60,30);
    cntr.add(sem);

    JLabel branch_label=new JLabel("Branch :");
    branch_label.setBounds(51,190,105,105);
    cntr.add(branch_label);

    String[] branch_arr={"CSE","IT","ECE","EE","CE","ME","EEE"};
    branch=new JComboBox(branch_arr);
    branch.setBounds(150,230,60,20);
    cntr.add(branch);

    
    JLabel Gender_label=new JLabel("Gender :");
    Gender_label.setBounds(50,270,60,30);
    cntr.add(Gender_label);

    male=new JRadioButton("Male");
    male.setBounds(150,275,70,20);
    cntr.add(male);

    female=new JRadioButton("Female");
    female.setBounds(240,275,70,20);
    cntr.add(female);

    ButtonGroup gender=new ButtonGroup();
    gender.add(male);
    gender.add(female);
    
    JLabel Photograph_label=new JLabel("Photograph");
    Photograph_label.setBounds(565,50,100,100);
    cntr.add(Photograph_label);

    JLabel address_label=new JLabel("ADDRESS :");
    address_label.setBounds(50,290,80,80);
    cntr.add(address_label);

    add_ta=new JTextArea();
    add_ta.setBounds(150,325,230,50);
    cntr.add(add_ta);

    tandc=new JCheckBox("The above information is correct");
    tandc.setBounds(150,395,250,25);
    cntr.add(tandc);

    JButton Submit=new JButton("Submit");
    Submit.setBounds(150,450,80,40);
    cntr.add(Submit);

    JButton Reset=new JButton("Reset");
    Reset.setBounds(250,450,80,40);
    cntr.add(Reset);

    JButton Cancel=new JButton("Cancel");
    Cancel.setBounds(350,450,80,40);
    cntr.add(Cancel);

    JButton Browse=new JButton("Browse");
    Browse.setBounds(570,180,80,30);
    cntr.add(Browse);

  
    Browse.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event)
     {
       JFileChooser j = new JFileChooser();
       int returnValue = j.showOpenDialog(null);
       if (returnValue==0){
         File f = j.getSelectedFile();
         System.out.println(f.getName());
         System.out.println(f.getAbsolutePath());

 
       ImageIcon icon = new ImageIcon(f.getAbsolutePath());
       icon = new ImageIcon(icon.getImage().getScaledInstance(100,100,BufferedImage.SCALE_SMOOTH));
       Photograph_label.setIcon(icon);
   
     }
       
          
      
     }
  });					

 
   

    Submit.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event)
     {
       Submit_action(event);
     }
  });			

    Cancel.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    System.exit(0);
 }});

    Reset.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
    output.setText("");
    name_tf.setText("");
    father_tf.setText("");
    add_ta.setText("");
 
 }});
   

    output=new JTextArea();
    output.setBounds(750,50,300,450);
    cntr.add(output);

 
   }
     
   public static void Submit_action(ActionEvent event)
   {
    if(tandc.isSelected()==true)
    {
     String name=name_tf.getText();
     String father=father_tf.getText();
     String branch_name=(String)branch.getSelectedItem();
     String sem_name=(String)sem.getSelectedItem();
     String gen="Male";
     if(female.isSelected())
     gen="Female";
     String Address=add_ta.getText();
     String day_name=(String)day.getSelectedItem();
     String month_name=(String)month.getSelectedItem();
     String year_name=(String)year.getSelectedItem();
    
    

     output.setText("Name : "+name+"\nFather's Name : "+father+"\naddress : "+Address+"\nBranch : "+branch_name+"\nsem :"+sem_name+"\nDob "+day_name+" "+month_name+" "+year_name+"\nGender "+gen);
     
    }
    else
    {
      output.setText("Please check the above Information");
    }

 
 }

}


   




  






    
    


 
 
