import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Iterator;

public class Graph<T>
    {
    private LinkedHashMap<T, Set<T>> graph;

    public Graph()
        {
        graph = new LinkedHashMap<>();
        }

    public void addVertex(T vertex)
        {
        graph.put(vertex, new LinkedHashSet<>());
        }

    public void addEdge(T vertex1, T vertex2)
        {
        graph.get(vertex1).add(vertex2);
        graph.get(vertex2).add(vertex1);
        }

    public Iterator<T> getIteratorDFS(T vertex)
        {
        return new GraphIterator<T>(vertex, graph);
        }

    public LinkedHashMap<T, Set<T>> getGraph()
        {
        return graph;
        }
    }
