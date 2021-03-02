import java.awt.*;
import java.time.format.*;
import java.time.*;
import java.io.*;
import java.util.logging.*;

public class InvAndRec
{	
	public static void generateRec(transact a)
	{	
		try
		{
			
	           FileWriter transact_Inv = new FileWriter("/Users/JC/Desktop/INVENTORY.txt");
	                transact_Inv.write("ITEM PRICE"+
	                        "\nRINGLIGHT: 700.99"+
	                        "\nELECTRIC FAN: 420.69"+
	                        "\nBLUETOOTH EARBUDS: 900.59"+
	                        "\n\nINVENTORY LEFT"+
	                        "\nRINGLIGHT: "+a.acs_i1Inv()+
	                         "\nELECTRIC FAN: "+a.acs_i2Inv()+
	                         "\nBLUETOOTH EARBUDS: "+a.acs_i3Inv()+
	                        "\n\nREMOVED QUANTITIES"+
	                        "\nRINGLIGHT: "+POS.acs_i1RQ()+
	                         "\nELECTRIC FAN: "+POS.acs_i2RQ()+
	                         "\nBLUETOOTH EARBUDS: "+POS.acs_i3RQ()+
	                        "\n\nPURCHASED"+
	                        "\nRinglight/s bought: "+a.acs_i1Q()+" TOTAL: "+(a.acs_i1Q() * 700.99)+
	                        "\nElectric Fan/s bought: "+a.acs_i2Q()+" TOTAL: "+(a.acs_i2Q() * 420.69)+
	                        "\nBluetooth Earbuds/s bought: "+a.acs_i3Q()+" TOTAL: "+(a.acs_i3Q() * 900.59)+
	                      "\n\n TOTAL AMOUNT: "+String.format("%.2f", a.acs_TA())+
	                         "\n\n CASH AMOUNT: "+String.format("%.2f", a.acs_C())+
	                          "\n\n CHANGE: "+ String.format("%.2f", a.acs_CC())
	                
	                );      
	                transact_Inv.close();
	                
	                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	                LocalDateTime now = LocalDateTime.now();
	                
	                
	        				
	        				FileWriter Receipt = new FileWriter("/Users/JC/Desktop/CUSTOMER RECEIPT.txt");
	        				
	        				Receipt.append("\n\t     COIN-TA SHOP\n");
	        				Receipt.append("Corrales Extension, Cagayan de Oro City\n");
	        				Receipt.append("  Prop: Sombilon, Banaag & Paner Inc.\n");
	        				Receipt.append("\t   " + dtf.format(now) +"\n\n");
	        				Receipt.append("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n");
	        				
	        				Receipt.append("\n  "+ a.acs_i1Q() + "x    " + "RINGLIGHT" + "\t\tPhp" + " 700.99");
	        				Receipt.append("\n  "+ a.acs_i2Q() + "x    " + "ELECTRIC FAN" + "\t\tPhp" + " 420.69");
	        				Receipt.append("\n  "+ a.acs_i3Q() + "x    " + "BLUETOOTH EARBUDS" + "\tPhp" + " 900.59");
	        				
	        				Receipt.append("\n\n\n\t Total: \tPhp " + String.format("%.2f", a.acs_TA()));
	        				Receipt.append("\n\t Payment: \tPhp " + String.format("%.2f", a.acs_C()));
	        				Receipt.append("\n\t Change: \tPhp " + String.format("%.2f", a.acs_CC()));
	        				Receipt.append("\n\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
	        				Receipt.append("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n");
	        				
	        				Receipt.close();
	            
	        } catch (IOException ex) {
	            Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex); //jerson wth is this charot HAHAAHAHAHA

		}
		
		open_Rec();
	}
	
	public static void open_Rec() //open receipt
	{
		if (Desktop.isDesktopSupported()) //i-check whether supported sa OS ang clicking or maka-open ba ug file
		{
		    try 
		    {
		        File open_Rec = new File("/Users/JC/Desktop/CUSTOMER RECEIPT.txt");
		        Desktop.getDesktop().open(open_Rec); //kwaon ang filesystem sa OS then abrihon ang file
		    } 
		    catch (IOException ex)
		    {
		    	ex.printStackTrace();
		    }
		}
	}
	
}

