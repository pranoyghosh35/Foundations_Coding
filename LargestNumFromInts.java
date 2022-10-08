import java.util.ArrayList;
class LargestNumFromInts
{
    static ArrayList <Integer> nums= new ArrayList<Integer>();
    public static void main(String[] args) 
    {
    // Let's assume user input an array of integers in args
            for (String s:args)
            nums.add(Integer.parseInt(s));
    System.out.println("Largest number formed:"+findLargest());
    }
    private static int findLargest()
    {
        int[] n = nums.stream().mapToInt(i -> i).toArray(); 
        // from ArrayList to primitive int array n for easy sorting
        for (int i=0;i<n.length;i++)
        {
            for (int j=0;j<n.length;j++)
            {
                int x=n[i],y=n[j];
        /* x = i th , y = j th number
        * custom sort the array descending
        * while comparing whether xy or yx is greater.
        */
                if((10*x+y)<(10*y+x) && i!=j)
                {
                    int temp=n[i];
                    n[i]=n[j];
                    n[j]=temp;
                }
            }
        }
         String l="";
         for (int s:n)
         l=l+s;
    return Integer.parseInt(l);
    }
}