import java.util.Iterator;

public class MainClass
    {
    public static void main(String[] args)
        {
        ComponentFinder<Integer> ReportComponents = new ComponentFinder<>();
        Graph<Integer> graph1 = new Graph<>();
        graph1.addVertex(1);
        graph1.addVertex(2);
        graph1.addVertex(3);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 1);
        ReportComponents.FindComponents(graph1.getGraph());
        Iterator<Integer> i1 = graph1.getIteratorDFS(1);
        while(i1.hasNext())
            {
            System.out.print(i1.next() + " ");
            }
        System.out.print("\n");

        ComponentFinder<String> ReportComponents2 = new ComponentFinder<>();
        Graph<String> graph2 = new Graph<>();
        graph2.addVertex(";__;");
        graph2.addVertex("a");
        graph2.addVertex("b");
        graph2.addVertex("c");
        graph2.addEdge("a", "b");
        graph2.addEdge("c", "b");
        ReportComponents2.FindComponents(graph2.getGraph());
        Iterator<String> i2 = graph2.getIteratorDFS("a");
        while(i2.hasNext())
            {
            System.out.print(i2.next() + " ");
            }
        System.out.print("\n");
        Iterator<String> i21 = graph2.getIteratorDFS(";__;");
        while(i21.hasNext())
            {
            System.out.print(i21.next() + " ");
            }
        System.out.print("\n");

        ComponentFinder<Double> ReportComponents3 = new ComponentFinder<>();
        Graph<Double> graph3 = new Graph<>();
        graph3.addVertex(0.5);
        graph3.addVertex(1.5);
        graph3.addVertex(2.5);
        graph3.addVertex(3.5);
        graph3.addEdge(0.5, 1.5);
        graph3.addEdge(1.5, 2.5);
        graph3.addEdge(2.5, 3.5);
        graph3.addEdge(3.5, 0.5);
        ReportComponents3.FindComponents(graph3.getGraph());
        Iterator<Double> i3 = graph3.getIteratorDFS(0.5);
        while(i3.hasNext())
            {
            System.out.print(i3.next() + " ");
            }
        System.out.print("\n");

        ComponentFinder<Integer> ReportComponents4 = new ComponentFinder<>();
        Graph<Integer> graph4 = new Graph<>();
        graph4.addVertex(1);
        graph4.addVertex(2);
        graph4.addVertex(3);
        graph4.addVertex(4);
        graph4.addVertex(5);
        graph4.addVertex(6);
        graph4.addEdge(1, 2);
        graph4.addEdge(2, 3);
        graph4.addEdge(3, 1);
        graph4.addEdge(3, 6);
        graph4.addEdge(6, 4);
        graph4.addEdge(4, 5);
        graph4.addEdge(5, 6);
        ReportComponents4.FindComponents(graph4.getGraph());
        Iterator<Integer> i4 = graph4.getIteratorDFS(1);
        while(i4.hasNext())
            {
            System.out.print(i4.next() + " ");
            }
        System.out.print("\n");
        }

    }
