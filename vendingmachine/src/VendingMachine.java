import java.util.Scanner;
interface VendingMachineInterface 
{
    Scanner in=new Scanner(System.in);
    // welcome message, products and their selection number
    void displayProducts(); 
    // takes selection number
    void selectProduct();
    // card or cash and payment
    void displayPaymentOptions();
    // takes amount that user paid and proceeds with transaction & calculates change 
    void makePayment();
    // display transaction successful or fail and change if any
    void displayChangeMessage();
}
class VendingMachine implements VendingMachineInterface
{
private int change,price;
    @Override
    public void displayProducts() 
    {
        System.out.println(" *********************************************");
        System.out.println("     WELCOME TO THE VENDING MACHINE           ");
        System.out.println(" *********************************************");
        System.out.println("            Products available:               ");
        System.out.println("                                              ");
        for(Product product: Product.values())
        {
            if(!Product.EMPTY.equals(product)) 
                System.out.println("     " + product.getSelectionNumber() + "  " + product.name() + " - Price: Rs" + product.getPrice() + "   ");
        } 
    }
    @Override
    public void selectProduct() 
    {  
        System.out.println(" \n Please select your product id: ");
        int selectedProduct=in.nextInt();
        price=(Product.valueOf(selectedProduct)).getPrice();   
    }

    @Override
    public void displayPaymentOptions() 
    {
   System.out.println("Check out option 1. Cash  pay: Rs"+price);  
   System.out.println("OR 2. Card pay: Rs"+2*price);         
    }

    @Override
    public void makePayment()
    {
    System.out.println("Select checkout option 1 or 2?");
    int choice=in.nextInt();
    System.out.println("Payment in Rs?");  
    int paid=in.nextInt();
    price=(choice==2)?(2*price):((choice==1)?price:-1);    
    change=paid-price;  
    }
    @Override
    public void displayChangeMessage() 
    {
        if(price>0 && change>0)
        System.out.println(" Transaction Successful! Collect your change amount:"+change);
        else if(price>0 && change==0)
        System.out.println(" Transaction Successful! Thanks for paying exact amount.");
        else if(price>0 && change<0)
        System.out.println(" Transaction failed! Insufficient amount paid.");
        else if(price<0)
        System.out.println(" Transaction failed! Invalid payment option.");
        else if(price==0)
        System.out.println(" Transaction failed! Product unavailable.");
    }
    
}
