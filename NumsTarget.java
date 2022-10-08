class NumsTarget 
{
    public static void main(String[] args) 
    {
        // Let's assume user input sorted numbers first 
        // and a target number at last in args
        int target=Integer.parseInt(args[args.length-1]);
        int nums[]=new int[args.length-1];
        for (int i=0;i<args.length-1;i++)
            nums[i]=Integer.parseInt(args[i]);
        System.out.print("array:");
            for (int x:nums)
        System.out.print(x+",");
        System.out.println("Target:"+target);
        findsoln(nums,target);
    }
    private static void findsoln(int n[],int t)
    {
        for (int i=0;i<n.length;i++)
        {
            for (int j=i+1;j<n.length;j++)
            {
                if((n[i]+n[j])==t) // add ith number with all other numbers
                {
                System.out.println("index:"+i+","+j+" "+n[i]+"+"+n[j]+"="+t);
                break;
                }
            }
        }
    }
}
