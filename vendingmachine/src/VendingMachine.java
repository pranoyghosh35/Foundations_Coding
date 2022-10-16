import java.util.ArrayList;
import java.util.Scanner;
interface VendingMachineInterface 
{
    Scanner in=new Scanner(System.in);
    // welcome message, products and their selection number
    void displayProducts(); 
    // takes selection numbers for products user buy till users type N
    void selectProduct();
    // calculates total price of all products added in cart
    void calculate();
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
private static ArrayList<Integer> cart=new ArrayList<Integer>(); // stores prices of products
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
        for(;;)
        {
        System.out.println(" \n Please select your product id: ");
        int selectedProduct=in.nextInt();
        price=(Product.valueOf(selectedProduct)).getPrice();   
        if(price==0)
        System.out.println("Product unavailable! Please select something else.");
        else
        {
        System.out.println("Added to cart! Rs"+price);
        cart.add(price);
        }
        System.out.println("Ready to select more products? type N to STOP.");
        if (in.next().equals("N"))
        break;
        }
    }
    @Override
    public void calculate()
    {
        price=0;
        for (int p:cart)
            price=price+p; // add prices of all items in cart.
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
    price=(choice==2)?(2*price):((choice==1)?price:-1); // twice to be paid if by card. if neither card or cash invalid choice.   
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
    }
    
}
