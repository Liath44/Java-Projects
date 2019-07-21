public class Main
    {
    private static void method()
        {
        boolean aa  =true;
        System.out.println("sss");
        if(aa)
            {
            return;
            }
        System.out.println("sss");
        }

    public static void main(String[] args)
        {
        method();
        String sum = "Sample text";
        StringBuilder builder = new StringBuilder(sum);
        for(int i = 0; i < 5; ++i)
            {
            builder.append("a");
            }
        System.out.println(sum);
        System.out.println(builder.toString());
        }
    }
