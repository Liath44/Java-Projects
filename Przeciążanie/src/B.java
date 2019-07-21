public class B extends A
    {
    private int b;
    private static int stat;

    public B(int b)
        {
        this.b = b;
        stat = 4;
        }

    public void  metoda(int c)
        {
        System.out.println("metoda z B");
        System.out.println("wynik konkatenacji: " + b + c);
        }
    }
