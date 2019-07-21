public class RPN
    {
    class TooManyOperatorsException extends Exception{}
    class TooFewOperatorsException extends Exception{}
    class UnknownSymbolException extends Exception{}
    class TooLongExpression extends Exception{}

    public RPN()
        {
        }

    public int calculate(String[] Expression) throws TooManyOperatorsException, TooFewOperatorsException, UnknownSymbolException, TooLongExpression
        {
        if(Expression.length == 0)//sprawdzenie czy nie otrzymaliśmy na wejściu pustego wyrażenia
            {
            throw new TooFewOperatorsException();
            }

        Stack StackA = new Stack();
        try
            {
            int i = 0;
            while(i < Expression.length)
                {
                String S = Expression[i];
                switch(S)
                    {
                    case("+"):
                        {
                        int a = StackA.pop();
                        int b = StackA.pop();
                        StackA.push(a + b);
                        break;
                        }
                    case("*"):
                        {
                        int a = StackA.pop();
                        int b = StackA.pop();
                        StackA.push(a * b);
                        break;
                        }
                    default:
                        {
                        int a = Integer.parseInt(S);
                        StackA.push(a);
                        break;
                        }
                    }
                ++i;
                }
            }
        catch(Stack.EmptyException a)//pop ERROR za mało liczb, za dużo operatorów
            {
            throw new TooManyOperatorsException();
            }
        catch(Stack.StackOverflow b)//za duże wejście
            {
            throw new TooLongExpression();
            }
        catch(NumberFormatException c)//ERROR w parsowaniu S
            {
            throw new UnknownSymbolException();
            }

        if(StackA.size() != 0)//Na stosie więcej niż jedna liczba została
            {
            throw new TooFewOperatorsException();
            }
        else
            {
            try
                {
                return StackA.pop();
                }
            catch(Stack.EmptyException d)//wydaje mi się to zbędne, ale kompilator się czepia
                {
                throw new TooFewOperatorsException();
                }
            }
        }
    }
