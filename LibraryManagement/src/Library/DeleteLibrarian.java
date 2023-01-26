
package Library;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class DeleteLibrarian  extends JFrame implements ActionListener{
    
    String x[] = {"Id","Name","Password","Email","Contact","Address","City"};
    JButton bt1;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    JTextField tf1;
    JPanel p1;
    
    Font f,f1;
    
    DeleteLibrarian()
    {
   super("Librarian Information ");
   setLocation(1,1);
   setSize(1000,400);
   
   f = new Font("Arial",Font.BOLD,15);
   
   try{
        ConnectionClass obj = new ConnectionClass();
        String q = "select * from librarian";
        ResultSet rest =  obj.stm.executeQuery(q);
        while(rest.next()){
        
            y[i][j++] = rest.getString("Lid");
            y[i][j++] = rest.getString("Name");
            y[i][j++] = rest.getString("Password");
            y[i][j++] = rest.getString("Email");
            y[i][j++] = rest.getString("Contact");
            y[i][j++] = rest.getString("Address");
            y[i][j++] = rest.getString("City");
            
            i++;
            j=0;
         
        }
        
        t = new JTable(y,x);
        t.setFont(f);
      
    }
    
    catch(Exception ee){
    
        ee.printStackTrace();
     
    }
    
    JScrollPane sp = new JScrollPane(t);
    l1 = new JLabel("Delete LIbrarian");
    tf1 = new JTextField();
    
    bt1 = new JButton("Delete");
    bt1.addActionListener(this);
    
    l1.setFont(f);
    tf1.setFont(f);
    bt1.setFont(f);
    
    
    p1 = new JPanel();
    p1.setLayout(new GridLayout(1,3,10,10));
    p1.add(l1);
    p1.add(tf1);
    p1.add(bt1);
    
    setLayout(new  BorderLayout(10,10));
    add(sp,"Center");
    add(p1,"South");
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    public void actionPerformed(ActionEvent e){
        
         if(e.getSource()==bt1)
         {
             
            int id = Integer.parseInt(tf1.getText()) ;
            try{
            
                ConnectionClass obj = new ConnectionClass();
                String q = "delete from librarian where Lid = '"+id+"'";
                int res = obj.stm.executeUpdate(q);
                if(res==1){
                    JOptionPane.showMessageDialog(null,"Your data is successfully deleted !");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                    
                
                }
                else{
                
                    JOptionPane.showMessageDialog(null,"Your data did not deleted successfully !");
                    this.setVisible(false);
                    new DeleteLibrarian().setVisible(true);
                
                }
                
                
                
                
            
            
            }
            catch(Exception ee){
            
            
                ee.printStackTrace();
            
            }
            
             
             
             
         }
         
         
         }
    
    
    
    
    
    
    
    
    public static void main(String[] args){
    
    
        new DeleteLibrarian().setVisible(true);
    
    
    
    
    
    
    
}
    
    
}
