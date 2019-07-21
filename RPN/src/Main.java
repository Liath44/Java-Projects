public class Main
    {
    private static void tryToCalculate(String[] Expression, RPN NumberWeaver)
        {
        try
            {
            int a = NumberWeaver.calculate(Expression);
            System.out.println("Wynik: " + a);
            }
        catch(RPN.TooManyOperatorsException a)
            {
            System.out.println("TooManyOperatorsException");
            }
        catch(RPN.TooFewOperatorsException b)
            {
            System.out.println("TooFewOperatorsException");
            }
        catch(RPN.UnknownSymbolException c)
            {
            System.out.println("UnknownSymbolException");
            }
        catch(RPN.TooLongExpression d)
            {
            System.out.println("TooLongExpression");
            }
        }

    public static void main(String[] args)
        {
        RPN NumberWeaver = new RPN();
        String[] Expression1 = new String[] {"7", "3", "+", "2", "*"};//ok
        String[] Expression2 = new String[] {"7", "3", "+", "2"};//za mało operatorów
        String[] Expression3 = new String[] {"7", "+", "2", "*"};//za mało liczb
        String[] Expression4 = new String[] {};//puste wtrażenie
        String[] Expression5 = new String[] {"7", "3", "+", "2", "a"};//niewłaściwy symbol
        String[] Expression6 = new String[] {"7", "3", "0","0","0","0", "0","0", "0", "0", "0", "0", "0" ,"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "+","+","+","+","+","+","+","+","+","+","+","+","+","+", "+", "+", "+", "+","+","+","+","+", "+","+", "+", "+", "+", "+"};
        //^za długie wyrażenie - Stack.maxSize == 15
        String[] Expression7 = new String[] {"3", "2", "+", "7", "*", "5", "*", "1", "+"};//ok
        tryToCalculate(Expression1, NumberWeaver);
        tryToCalculate(Expression2, NumberWeaver);
        tryToCalculate(Expression3, NumberWeaver);
        tryToCalculate(Expression4, NumberWeaver);
        tryToCalculate(Expression5, NumberWeaver);
        tryToCalculate(Expression6, NumberWeaver);
        tryToCalculate(Expression7, NumberWeaver);
        }
    }
