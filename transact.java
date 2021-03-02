import java.io.*;
import javax.swing.*;

public class transact
{
    private static int i1_quant; //quantity
    private static int i2_quant;
    private static int i3_quant;
    private static int i1_inv = 0; //inventory
    private static int i2_inv = 0;
    private static int i3_inv = 0;
    private static double amt_Cash; //cash gibayad
    private static double total_Amt = 0.0; //total amount sa tanan2x
    private static double i1_unitPri = 0.0; //total amount sa unit price
    private static double i2_unitPri = 0.0;
    private static double i3_unitPri = 0.0;
    private static double cash_Chg; //sukli
    
    transact()
    {
        i1_quant = 0;
        i2_quant = 0;
        i3_quant = 0;
        amt_Cash = 0.0;
    }

    public int acs_i1Q() //item quantity accessor method
    {
        return i1_quant;
    }
    
    public int acs_i2Q()
    {
        return i2_quant;
    }
        
    public int acs_i3Q()
    {
        return i3_quant;
    }
    
    public double acs_C() //cash accessor method, acs = "access"
    {
        return amt_Cash;
    }
    
    public double acs_TA() //total amount (billing) tanan2x accessor method
    {
    	return total_Amt;
    }
    
    public double acs_CC() //sukli accessor method
    {
    	return cash_Chg;
    }
    
    public int acs_i1Inv() //item inventory accessor method
    {
        return i1_inv;
    }
    
    public int acs_i2Inv()
    {
        return i2_inv;
    }
        
    public int acs_i3Inv()
    {
        return i3_inv;
    }

    
    public void chg_i1Q(int inp_i1Q) //change quantity mutator method 
    {
        i1_quant += inp_i1Q;
    }
    
    public void chg_i2Q(int inp_i2Q)
    {
        i2_quant += inp_i2Q;
    }
    
    public void chg_i3Q(int inp_i3Q)
    {
        i3_quant += inp_i3Q;
    }
    
    public void chg_RemI1Q(int inp_i1Q) //remove quantity mutator method
    {
        i1_quant -= inp_i1Q;
    }
    
    public void chg_RemI2Q(int inp_i2Q)
    {
        i2_quant -= inp_i2Q;
    }
    
    public void chg_RemI3Q(int inp_i3Q)
    {
        i3_quant -= inp_i3Q;
    }
    
    public void chg_AddInvI1(int inp_InvI1) //add inventory mutator method
    {
        i1_inv += inp_InvI1;
    }
    
    public void chg_AddInvI2(int inp_InvI2)
    {
        i2_inv += inp_InvI2;
    }
    
    public void chg_AddInvI3(int inp_InvI3)
    {
        i3_inv += inp_InvI3;
    }
    
    public void chg_DownInvI1(int inp_InvI1) //reduce inventory mutator method
    {
        i1_inv -= inp_InvI1;
    }
    
    public void chg_DownInvI2(int inp_InvI2)
    {
        i2_inv -= inp_InvI2;
    }
    
    public void chg_DownInvI3(int inp_InvI3)
    {
        i3_inv -= inp_InvI3;
    }
    
    
    public void chg_C(double inp_C) //cash gibayad mutator method
    {
        amt_Cash = inp_C;
    }
    
    public void chg_CC(double inp_CC) //sukli mutator method
    {
    	cash_Chg = inp_CC;
    }
    
    public void rem_TA(double inp_TA) //remove total amt mutator method
    {
    	total_Amt = inp_TA;
    }
    
    public void chg_i1UP(double inp_i1UP) //item unit price mutator method
    {
    	i1_unitPri = inp_i1UP; //para ma-zero ang unit price during checkout
    }
    
    public void chg_i2UP(double inp_i2UP)
    {
    	i2_unitPri = inp_i2UP;
    }
    
    public void chg_i3UP(double inp_i3UP)
    {
    	i3_unitPri = inp_i3UP;
    }
    
    public void set_allItemQZ() //item quantity mutator method
    {
    	i1_quant = 0;
    	i2_quant = 0;
    	i3_quant = 0;
    }
    
    
    
    
    
    
    public static double i1_QnUP(int inp_i1Q) //item "quantity" and "unit price" -> gina-calculate ang total price per item depending sa quantity
    {
        items a = new Ringlight();
        i1_unitPri = (a.item_Price * inp_i1Q);
        
        return i1_unitPri;
    }
    
    public static double i2_QnUP(int inp_i2Q)
    {
        items b = new ElectricFan();
        i2_unitPri = (b.item_Price * inp_i2Q);
        
        return i2_unitPri;
    }
        
    public static double i3_QnUP(int inp_i3Q)
    {
        items c = new BTEarbuds();
        i3_unitPri = (c.item_Price * inp_i3Q);
        
        return i3_unitPri;
    }
     
    public static void pay_Prop(double inp_i1UP, double inp_i2UP, double inp_i3UP) //total amount sa tanan2x
    {
    	total_Amt = (inp_i1UP + inp_i2UP + inp_i3UP);
    }
    
}