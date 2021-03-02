public class items
{
    protected static double item_Price;
    
    items()
    {
        item_Price = 0.00;
    }
}

class Ringlight extends items
{
    Ringlight()
    {
       item_Price = 700.99;
    }
}

class ElectricFan extends items
{
    ElectricFan()
    {
       item_Price = 420.69;
    }
}

class BTEarbuds extends items
{
    BTEarbuds()
    {
       item_Price = 900.59;
    }
}

