public class Test2
{
    public void isAmicable(int start, int end)//give the function a range to search
    {
        
        //220 and 284 are the smallest amicable numbers
        for(int i = start; i <= end; i++)
        {
            for(int j = end; j >= start; j--) //we could make j >= i to cut down processing, but for a small program, not important
            {
                if ((sumFactors(i)==j) && (sumFactors(j)==i) && (i != j)) //last conditional is important other wise it will return a same pair of numbersn
                {
                    System.out.println("("+i +","+ j + ")");
                }
            }
        }
    }
    public int sumFactors(int number) //Find the sum of the factors of the given number (divisors)
    {
        int factor = 0, sum = 0;
    
        for (int i = 1; i < number; i++)
        {
            if ((number % i)==0)
            {
                factor = i;
                sum += factor;
            }
        }
        return sum;
    }

    public static void main(String arp[])
    {
        StopWatch s= new StopWatch();
        s.start();

        int a = 1;
        int b = 50000;
        Test2 t  = new Test2();
        t.isAmicable(a,b);
        s.stop();
        System.out.println("Elapsed Time: "+s.getElapsedTime());
    }
}
