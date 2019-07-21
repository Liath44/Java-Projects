public class Stack
    {
    class StackOverflow extends Exception{}
    class EmptyException extends Exception{}

    private int[] stack;
    private final static int maxSize = 15;
    private int index;//points to stack's top

    public Stack()
        {
        stack = new int[maxSize];
        index = -1;
        }

    public void push(int a) throws StackOverflow
        {
        if(index == maxSize - 1)
            {
            throw new StackOverflow();
            }
        ++index;
        stack[index] = a;
        }

    public int size()
        {
        return index;
        }

    private boolean IsEmpty()
        {
        return index == -1;
        }

    public int pop() throws EmptyException
        {
        if(IsEmpty())
            {
            throw new EmptyException();
            }
        int pom = stack[index];
        --index;
        return pom;
        }

    /*public void resetStack()
        {
        index = -1;
        }*/
    }
