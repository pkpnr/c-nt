import java.io.*;
import java.util.regex.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

    
public class POS implements ActionListener
{   
    private double pay_Cash = 0.0;                                   
    private double i1_TP, i2_TP, i3_TP; //i = item,  TP = total price
    private static int item1_RQuant, item2_RQuant, item3_RQuant; //R = remove
    private static JButton b1, b2, b3, b4, b5, b6;
    private static JTextArea txt;
    private static JScrollPane txt_scr;
    private static JPanel p1, p2, p3;
    private static JFrame scr_POS;
    
    private static transact a = new transact();
       
    
    POS()
    {   
        Border bo1 = BorderFactory.createLineBorder(Color.WHITE,3); // 8 - size in thickness
        
        ImageIcon image = new ImageIcon("COIN-TA LOGO.png");
    	
    	Border bo2 = BorderFactory.createLineBorder(Color.WHITE);
    	
    	txt = new JTextArea(5, 5);
       txt.setBackground(Color.decode("#FCA311"));
       txt.setForeground(Color.BLACK);
       
       Font txt_F = txt.getFont();
       txt.setFont(txt_F.deriveFont(Font.BOLD));
       txt.setEditable(false);
       
       

       txt_scr = new JScrollPane(txt);
       txt_scr.setBounds(190, 10, 320, 170);
       txt_scr.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        
       
       b1 = new JButton("Ringlight");
       b1.setBackground(Color.decode("#FCA311"));
       b1.setBorder(bo2);
       b1.setForeground(Color.BLACK);
       b1.setBounds(25, 170, 140, 40);
       b1.addActionListener(this);
       
       
       b2 = new JButton("Electric Fan");
       b2.setForeground(Color.BLACK);
       b2.setBorder(bo2);
       b2.setBackground(Color.decode("#FCA311"));
       b2.setBounds(198, 170, 140, 40);
       b2.addActionListener(this);
       
       
       b3 = new JButton("Bluetooth Earbuds");
       b3.setForeground(Color.BLACK);
       b3.setBorder(bo2);
       b3.setBackground(Color.decode("#FCA311"));
       b3.setBounds(365, 170, 140, 40);
       b3.addActionListener(this);
       
       b4 = new JButton("Remove Item Quantity");
       b4.setForeground(Color.BLACK);
       b4.setBorder(bo2);
       b4.setBackground(Color.decode("#FCA311"));
       b4.setBounds(25, 100, 140, 25);
       b4.addActionListener(this);
       
       
       b5 = new JButton("Add Inventory");
       b5.setForeground(Color.BLACK);
       b5.setBorder(bo2);
       b5.setBackground(Color.decode("#FCA311"));
       b5.setBounds(25, 20, 140, 25);
       b5.addActionListener(this);
       
       b6 = new JButton("Checkout");
       b6.setForeground(Color.BLACK);
       b6.setBorder(bo2);
       b6.setBackground(Color.decode("#FCA311"));
       b6.setBounds(25, 140, 140, 25);
       b6.addActionListener(this);
       
           b1.setEnabled(false);
           b2.setEnabled(false);
           b3.setEnabled(false);
           b4.setEnabled(false);
           b6.setEnabled(false);
       
       
        
        
       p1 = new JPanel();
       p1.setBackground(Color.decode("#001845"));
       p1.setBounds(0, 0, 550, 250);
       p1.setLayout(null);
       
       p1.add(b1);
       p1.add(b2);
       p1.add(b3);
       
       try
       {
			BufferedImage woop = ImageIO.read(new File("LOGO1.png"));
			
			Image res_Woop = woop.getScaledInstance(400, 400, Image.SCALE_SMOOTH); //res = "resize"
			
			ImageIcon logo = new ImageIcon(res_Woop);
	        
			JLabel put_Woop = new JLabel();
	        put_Woop.setBounds(50, 30, 430, 100);
	        put_Woop.setIcon(logo);
	        
	        p1.add(put_Woop);
       }
       catch(IOException lele)
       {
    	   lele.printStackTrace();
       }
			
       
       
       p2 = new JPanel();
       p2.setBackground(Color.decode("#001845"));
       p2.setBounds(0, 250, 550, 250);
       p2.setLayout(null);
       
       p2.add(txt_scr);
       p2.add(b4);
       p2.add(b5);
       p2.add(b6);
       
 
       
       scr_POS = new JFrame();
       scr_POS.addWindowListener(new WindowAdapter()
    		   {
    	   @Override
    	   public void windowClosing(WindowEvent aespa)
    	   {
    		   if(JOptionPane.showConfirmDialog(scr_POS, "Are you sure you want to exit POS?", "Exit POS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
    		   {
    			   System.exit(0);
    		   }
    	   }
    		   });
       scr_POS.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       scr_POS.setLayout(null);
       scr_POS.setSize(550,500);
       scr_POS.setResizable(false);
       scr_POS.setTitle("CO-INTA SHOP");
       scr_POS.setVisible(true); 
       scr_POS.add(p1);
       scr_POS.add(p2);
       scr_POS.getRootPane().setBorder(bo1);
       scr_POS.setIconImage(image.getImage());
       
       
       

       
       
       
       
    }
    
    public static int acs_i1RQ() //accessor methods
    {
    	return item1_RQuant;
    }
    
    public static int acs_i2RQ()
    {
    	return item2_RQuant;
    }
    
    public static int acs_i3RQ()
    {
    	return item3_RQuant;
    }
    
    public void upd_i1UP() //"update item 1 unit price"
    {
    	i1_TP = a.i1_QnUP(a.acs_i1Q()); //item 1 quantity
    }
    
    public void upd_i2UP() 
    {
    	i2_TP = a.i2_QnUP(a.acs_i2Q());
    }
    
    public void upd_i3UP()
    {
    	i3_TP = a.i3_QnUP(a.acs_i3Q());
    }
    
    
    public static void prnt_Rec(double cash, double TA, double ch)
    {
    	txt.append("\nReceived Php " + String.format("%.2f", cash) + " in Cash"); 
    	txt.append("\nChange is: Php " + String.format("%.2f", ch)); 
    }
    
    public static void main(String[] args)
    {   
        new POS();
    }
    
    public void actionPerformed(ActionEvent e) //
    {   
        if(e.getSource() == b1)
        {
        	 String inp_i1Q = JOptionPane.showInputDialog("Ringlight = Php 700.99/pc\n\nEnter quantity: ");
             
             if(inp_i1Q != null)
             { 
            	 if(isWord(inp_i1Q))
            	 {
            		 int item1_Quant = Integer.parseInt(inp_i1Q);
            		 
            		 if(item1_Quant < 0)
                     {
                     	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                     }
                     else if(item1_Quant > a.acs_i1Inv())
                     {
                     	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                     }
                     else if((item1_Quant >= 0) && (item1_Quant <= a.acs_i1Inv()))
                     {
                         a.chg_i1Q(item1_Quant); //chg = "change" -> mutator method
                         
                         if(a.acs_i1Q() != 0)
                         {
                             b4.setEnabled(true);
                             b6.setEnabled(true);
                         }
                         
                         a.chg_DownInvI1(item1_Quant);
                         
                     if(a.acs_i1Inv() == 0) 
                     {
                         b1.setEnabled(false);
                     }
                     
                     upd_i1UP();
                     
                     txt.append("\n\nRinglight Quantity is: " + a.acs_i1Q());
                     }
            	 }
            	 else
            	 {
            		 JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);  
            	 }
             }
        }
        
        else if(e.getSource() == b2)
        {
            String inp_i2Q = JOptionPane.showInputDialog("Electric Fan = Php 420.69/pc\n\nEnter quantity: ");
            
            if(inp_i2Q != null)
            {
            	if(isWord(inp_i2Q))
            	{
            		int item2_Quant = Integer.parseInt(inp_i2Q);
            		
            		if(item2_Quant < 0)
                    {
                    	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(item2_Quant > a.acs_i2Inv())
                    {
                    	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if((item2_Quant >= 0) && (item2_Quant <= a.acs_i2Inv()))
                    {
                        a.chg_i2Q(item2_Quant);
                        
                        
                        if(a.acs_i2Q() != 0)
                        {
                            b4.setEnabled(true);
                            b6.setEnabled(true);
                        }
                    
                        a.chg_DownInvI2(item2_Quant);
                        
                    if(a.acs_i2Inv() == 0)
                    {
                        b2.setEnabled(false);
                    }
                    
                    upd_i2UP();
                    
                    txt.append("\n\nElectric Fan Quantity is: " + a.acs_i2Q());
                    }
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
     
        }
        
        else if(e.getSource() == b3)
        {
            String inp_i3Q = JOptionPane.showInputDialog("Bluetooth Earbuds = Php 900.59/pc\n\nEnter quantity: ");
            
            if(inp_i3Q != null)
            {
            	if(isWord(inp_i3Q))
            	{
            		int item3_Quant = Integer.parseInt(inp_i3Q);
            		
            		if(item3_Quant < 0)
                    {
                    	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(item3_Quant > a.acs_i3Inv())
                    {
                    	JOptionPane.showMessageDialog(null, "INVALID QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if((item3_Quant >= 0) && (item3_Quant <= a.acs_i3Inv()))
                    {
                        a.chg_i3Q(item3_Quant);
                        
                        if(a.acs_i3Q() != 0)
                        {
                            b4.setEnabled(true);
                            b6.setEnabled(true);
                        }
                    
                        a.chg_DownInvI3(item3_Quant);
                        
                     if(a.acs_i3Inv() == 0)
                    {
                        b3.setEnabled(false);
                    }
                   
                     upd_i3UP();
                     
                    txt.append("\n\nBluetooth Earbuds Quantity is: " + a.acs_i3Q());
                    }
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
            

        }
        
        
        
        
        else if(e.getSource() == b4)
        {
            String inp_RP = JOptionPane.showInputDialog("Pick an item: \n\n 0 - Ringlight\n1 - Electric Fan\n2 - Bluetooth Earbuds");
            
            if(inp_RP != null)
            {
            	if(isWord(inp_RP))
            	{
            		int item_RemPick = Integer.parseInt(inp_RP);
            		
            		if (item_RemPick == 0)
                    {
                    	if (a.acs_i1Inv() != 0 && a.acs_i1Q() != 0)
                    	{
                    		String inp_i1RQ = JOptionPane.showInputDialog("Enter quantity");
                    		
                            if(isWord(inp_i1RQ))
                            {
                            	item1_RQuant = Integer.parseInt(inp_i1RQ);
                            	
                            	if(item1_RQuant > a.acs_i1Q())
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY EXCEEDED THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                else if(item1_RQuant < 0)
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY IS LESS THAN THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                else if((item1_RQuant >= 0) && (item1_RQuant <= a.acs_i1Q()))
                                {
                                	a.chg_RemI1Q(item1_RQuant);
                                	
                                    if(a.acs_i1Q() == 0)
                                    {
                                        b4.setEnabled(false);
                                        b1.setEnabled(true);
                                        b6.setEnabled(false);
                                    }
                                	
                                    a.chg_AddInvI1(item1_RQuant);
                                    
                                    upd_i1UP();
                                    
                                    txt.append("\n\nRemoved Ringlight Quantity is: " + item1_RQuant);
                                    txt.append("\nRinglight Quantity is: " + a.acs_i1Q());
                                }
                            }
                    	}
                    	else if(a.acs_i1Inv() == 0 && a.acs_i1Q() == 0)
                    	{
                    		JOptionPane.showMessageDialog(null, "Item has no quantity.",  "Error", JOptionPane.ERROR_MESSAGE);
                    	}
                        
                    }
                    
                    else if (item_RemPick == 1)
                    {
                    	if (a.acs_i2Inv() != 0 && a.acs_i2Q() != 0)
                    	{
                    		 String inp_i2RQ = JOptionPane.showInputDialog("Enter quantity");
                            
                            
                            if(isWord(inp_i2RQ))
                            {
                            	item2_RQuant = Integer.parseInt(inp_i2RQ);
                            	
                            	if(item2_RQuant > a.acs_i2Q())
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY EXCEEDED THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                else if(item2_RQuant < 0)
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY IS LESS THAN THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                
                                else if((item2_RQuant >= 0) && (item2_RQuant <= a.acs_i2Q()))
                                {
                                    a.chg_RemI2Q(item2_RQuant);
                                    
                                    if(a.acs_i2Q() == 0)
                                    {
                                        b4.setEnabled(false);
                                        b2.setEnabled(true);
                                        b6.setEnabled(false);
                                    }
                                	
                                	
                                	a.chg_AddInvI2(item2_RQuant);
                                    
                                	upd_i2UP();
                                    
                                    txt.append("\n\nRemoved Electric Fan Quantity is: " + item2_RQuant);
                                    txt.append("\nElectric Fan Quantity is: " + a.acs_i2Q());
                                }
                            }
                    	}
                    	else if(a.acs_i2Inv() == 0 && a.acs_i2Q() == 0)
                    	{
                    		JOptionPane.showMessageDialog(null, "Item has no quantity.",  "Error", JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	
                        		
                        
                        

                    }
                    
                    else if (item_RemPick == 2)
                    {
                        if(a.acs_i3Inv() != 0 && a.acs_i3Q() != 0)
                        {
                        	String inp_i3RQ = JOptionPane.showInputDialog("Enter quantity");
                            
                            
                            if(isWord(inp_i3RQ))
                            {
                            	item3_RQuant = Integer.parseInt(inp_i3RQ);
                            	
                            	if(item3_RQuant > a.acs_i3Q())
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY EXCEEDED THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                else if(item3_RQuant < 0)
                                {
                                	 JOptionPane.showMessageDialog(null, "REMOVED QUANTITY IS LESS THAN THE ORDERED QUANTITY",  "Error", JOptionPane.ERROR_MESSAGE);   
                                }
                                else if((item3_RQuant >= 0) && (item3_RQuant <= a.acs_i3Q()))
                                {
                                    a.chg_RemI3Q(item3_RQuant);
                                    
                                    if(a.acs_i3Q() == 0)
                                    {
                                        b4.setEnabled(false);
                                        b3.setEnabled(true);
                                        b6.setEnabled(false);
                                    }
                                	
                                	
                                	a.chg_AddInvI3(item3_RQuant);
                                	
                                	upd_i3UP();
                                    
                                    txt.append("\n\nRemoved Bluetooth Earbuds Quantity is: " + item3_RQuant);
                                    txt.append("\nBluetooth Earbuds Quantity is: " + a.acs_i3Q());
                                }
                            }
                        }
                        else if(a.acs_i3Inv() == 0 && a.acs_i3Q() == 0)
                        {
                        	JOptionPane.showMessageDialog(null,"Item has no quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                    else if (item_RemPick < 0 || item_RemPick > 2)
                    {
                    	JOptionPane.showMessageDialog(null,"Item does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
        
        else if(e.getSource() == b5)
        {
            String choice = JOptionPane.showInputDialog("Pick an item: \n\n 0 - Ringlight, 1 - Electric Fan, 2 - Bluetooth Earbuds");
            
            if(choice != null)
            {
            	if(isWord(choice))
            	{
            		int item_InvPick = Integer.parseInt(choice);
                	
                    if (item_InvPick == 0)
                    {
                        String inp_i1Inv = JOptionPane.showInputDialog("Enter amount of inventory");
                        
                        if(isWord(inp_i1Inv))
                        {
                        	int item1_Inv = Integer.parseInt(inp_i1Inv);
                        	
                        	if(item1_Inv < 0)
                            {
                            	 JOptionPane.showMessageDialog(null, "INVALID INVENTORY AMOUNT",  "Error", JOptionPane.ERROR_MESSAGE);   
                            }
                            else if(item1_Inv >= 0)
                            {
                                a.chg_AddInvI1(item1_Inv);
                                
                                if(a.acs_i1Inv() != 0)
                               {
                                   b1.setEnabled(true);
                                   //b6.setEnabled(true);
                               }
                               
                               txt.append("\n\nAdded " + item1_Inv + " Ringlight(s) to inventory");
                               txt.append("\nCurrent Ringlight Inventory is: " + a.acs_i1Inv() + "\n\n");
                            }
                        }
                    }
                    
                    else if (item_InvPick == 1)
                    {
                        String inp_i2Inv = JOptionPane.showInputDialog("Enter amount of inventory");
                        
                        if(isWord(inp_i2Inv))
                        {
                        	int item2_Inv = Integer.parseInt(inp_i2Inv);
                        	
                        	if(item2_Inv < 0)
                            {
                            	 JOptionPane.showMessageDialog(null, "INVALID INVENTORY AMOUNT",  "Error", JOptionPane.ERROR_MESSAGE);   
                            }
                            else if(item2_Inv >= 0)
                            {
                                a.chg_AddInvI2(item2_Inv);
                                
                                if(a.acs_i2Inv() != 0)
                                {
                                    b2.setEnabled(true);
                                    //b6.setEnabled(true);
                                }
                                
                                txt.append("\n\nAdded " + item2_Inv + " Electric Fan(s) to inventory");
                                txt.append("\nCurrent Electric Fan Inventory is: " + a.acs_i2Inv() + "\n\n");
                            }
                        }
                    }
                    
                    else if (item_InvPick == 2)
                    {
                        String inp_i3Inv = JOptionPane.showInputDialog("Enter amount of inventory");
                        
                        if(isWord(inp_i3Inv))
                        {
                        	int item3_Inv = Integer.parseInt(inp_i3Inv);
                        	
                        	if(item3_Inv < 0)
                            {
                            	 JOptionPane.showMessageDialog(null, "INVALID INVENTORY AMOUNT",  "Error", JOptionPane.ERROR_MESSAGE);   
                            }
                            else if(item3_Inv >= 0)
                            {
                                a.chg_AddInvI3(item3_Inv);
                                
                                if(a.acs_i3Inv() != 0)
                                {
                                    b3.setEnabled(true);
                                    //b6.setEnabled(true);
                                }
                                
                                txt.append("\n\nAdded " + item3_Inv + " Bluetooth Earbuds(s) to inventory");
                                txt.append("\nCurrent Bluetooth Earbuds Inventory is: " + a.acs_i3Inv() + "\n\n");
                            }
                        }
                    }
                    
                    else if (item_InvPick < 0 || item_InvPick > 2)
                    {
                    	JOptionPane.showMessageDialog(null,"Item does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
        
        else if(e.getSource() == b6)
        {
        	transact.pay_Prop(i1_TP, i2_TP, i3_TP); //static method
        	
        	txt.append("\n\nTotal purchase amount is: " + String.format("%.2f", a.acs_TA()));
        	
        	String inp_C = JOptionPane.showInputDialog("\nEnter cash amount: "); 
        	
        	
            if(inp_C != null)
            {
            	
            	if(isWord(inp_C))
            	{
            		pay_Cash = Double.parseDouble(inp_C);
         
                	a.chg_C(pay_Cash); //instance method
                	
                	
                    if((a.acs_C()) >= (a.acs_TA()))
                    {	
                    	a.chg_CC((a.acs_C()) - (a.acs_TA()));
                        
                        prnt_Rec(a.acs_C(), a.acs_TA(), a.acs_CC());
                        
                    	InvAndRec.generateRec(a);
                    	
                    	a.set_allItemQZ();
                    	
                    	a.chg_i1UP(0); //set total unit price to zero
                    	a.chg_i2UP(0);
                    	a.chg_i3UP(0);
                    	
                    	a.rem_TA(0); //rem = "remove"
                    	
                    	i1_TP = 0;
                    	i2_TP = 0;
                    	i3_TP = 0;
       
                    	b4.setEnabled(false);
                    	b6.setEnabled(false);
                    	
                    	JOptionPane.showMessageDialog(null,"Transaction Complete");
                    	
                    	txt.setText("");
                    }
                    else if((a.acs_C()) < (a.acs_TA()))
                    {
                    	JOptionPane.showMessageDialog(null, "INSUFFICIENT AMOUNT", "Error", JOptionPane.ERROR_MESSAGE); 	
                    }
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, "PLEASE ENTER NUMBER ONLY", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            	}
            }
        }
    }
    
    public static boolean isWord(String in)
    {
        return Pattern.matches("[0-9]+", in);
    }
}