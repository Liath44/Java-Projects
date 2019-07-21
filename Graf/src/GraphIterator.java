import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.util.Set;
import java.util.LinkedHashMap;

public class GraphIterator <T> implements Iterator<T>
    {
    private ArrayList<T> Iteraterro;

    public GraphIterator(T vertex, LinkedHashMap<T, Set<T>> graph)
        {
        Iteraterro = new ArrayList<>();
        fillStack(vertex, graph);
        }

    private void fillStack(T vertex, LinkedHashMap<T, Set<T>> graph)
        {
        ArrayList<T> visited = new ArrayList<>();
        Stack<T> helpStack = new Stack<>();
        visited.add(vertex);
        helpStack.push(vertex);
        while(!helpStack.empty())
            {
            T ver = helpStack.pop();
            Set<T> neighbours = graph.get(ver);
            for(T ver_n: neighbours)
                {
                if(wasntVisited(visited, ver_n))
                    {
                    visited.add(ver_n);
                    helpStack.push(ver_n);
                    }
                }
            Iteraterro.add(ver);
            }
        }

    private boolean wasntVisited(ArrayList<T> visited, T ver_n)
        {
        boolean outcome = true;
        int i = 0;
        while(outcome && i < visited.size())
            {
            if(visited.get(i).equals(ver_n))
                {
                outcome = false;
                }
            ++i;
            }
        return outcome;
        }

    public boolean hasNext()
        {
        return !Iteraterro.isEmpty();
        }

    public T next()
        {
        T outcome = Iteraterro.get(0);
        Iteraterro.remove(0);
        return outcome;
        }
    }
