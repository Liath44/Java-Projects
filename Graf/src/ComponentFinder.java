import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashMap;
import java.util.Stack;

public class ComponentFinder<T>
    {
    private ArrayList<T> visited;

    public ComponentFinder()
        {
        visited = new ArrayList<>();
        }

    public void FindComponents(LinkedHashMap<T, Set<T>> graph)
        {
        int co_number = 1;
        for(T vertex: graph.keySet())
            {
            if(wasntVisited(vertex))
                {
                System.out.print("Component number: " + co_number);
                ++co_number;
                int j = countVertexes(graph, vertex);
                System.out.println(" | Number of vertexes: " + j);
                }
            }
        }

    private int countVertexes(LinkedHashMap<T, Set<T>> graph, T vertex)
        {
        int i = 0;
        Stack<T> stack = new Stack<>();
        stack.push(vertex);
        visited.add(vertex);
        while(!stack.empty())
            {
            T ver = stack.pop();
            ++i;
            for(T ver_: graph.get(ver))
                {
                if(wasntVisited(ver_))
                    {
                    visited.add(ver_);
                    stack.push(ver_);
                    }
                }
            }
        return i;
        }

    private boolean wasntVisited(T vertex)
        {
        boolean outcome = true;
        int i = 0;
        while(outcome && i < visited.size())
            {
            if(visited.get(i).equals(vertex))
                {
                outcome = false;
                }
            ++i;
            }
        return outcome;
        }
    }
