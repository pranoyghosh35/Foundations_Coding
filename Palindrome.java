class Palindrome
{
    public static void main(String args[])
    {
        // Let users pass all the Strings to check in args
        for (String s: args)
        {
            boolean f=false;
            /* alt method : check if original string is same as rev 
            if(s.equalsIgnoreCase(rev(s)))
                f=true;
            */
            f=isPalin(s);
            System.out.println(s+" palindrome?"+f);
        }
    }

    private static boolean isPalin(String s) // recursively compares i th and len-i th characters
    {
        if(s.length()==1)
            return true;
        // 2 characters check last and first
        else if (s.length()==2)
        {
            if (s.charAt(0)!=s.charAt(1))
                return false;
            else
                return true;
        }
        else
        // substring from 2nd character before last character
            return isPalin(s.substring(1,s.length()-1)); 
    }

        /* alt method 
    private static String rev(String s) // recursively reverses a String
    {
        if (s.length()<=1)
            return s; // if single character or empty reverse same as input
        else
            // multiple characters : add n th, n-1 (recur) ...to 1st character.
            return rev(s.substring(1))+s.charAt(0); 
    }
    */
}