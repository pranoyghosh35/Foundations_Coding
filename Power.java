class Power 
{
    public static void main(String[] args) 
    {
     // Let's assume user enter integer x then power n in args
    int x=Integer.parseInt(args[0]);
    int n=Integer.parseInt(args[1]);
    int result=pow(x,n);
    System.out.println(x+"^"+n+"="+result);
    }
    private static int pow(int x,int n) // calculates power by recursion
    {
     /* O(logn) : divide and conquer,
      * x ^ n = x ^ (n/2) * x ^ (n/2) (even n)
      * x ^ n = x ^ (int)(n/2) * x ^ (n-(int)(n/2)) (odd n)
      * x ^ 0 = 1 (n=0 base)
      * x ^ 1 = x (n=1 base)
      */
    if (n==0)
    return 1;
    if (n==1)
    return x;
    if (n%2 ==0)
    return pow(x,n/2)*pow(x,n/2);
    else
    return pow(x,(int)(n/2))*pow(x,n-(int)(n/2));
    }
}
