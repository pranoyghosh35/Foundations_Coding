public class App
{
    public static void main(String[] args)
    {
        try
        {
            VendingMachine v=new VendingMachine();
            v.displayProducts();
            v.selectProduct();
            v.calculate();
            v.displayPaymentOptions();
            v.makePayment();
            v.displayChangeMessage();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
