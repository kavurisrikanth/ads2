import java.util.Scanner;

public class DiGraphTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numV = sc.nextInt(),
                numE = sc.nextInt(),
            a = 0, b = 0;
        DirectedGraph dGraph = new DirectedGraph(numV);

        for(int i = 0; i < numE; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            dGraph.addEdge(a, b);
        }
        sc.close();

        /*
        Iterable<Integer> it =  TopologicalSort.doTopologicalSort(dGraph);
        for(int x: it)
            System.out.print(x + " ");

        System.out.println(HamiltonCheck.HamiltonPathExists(dGraph)); */

        System.out.println(dGraph);
        Kosaraju ks = new Kosaraju(dGraph);
        System.out.println(ks);
    }

    public static void testDiGraph(DirectedGraph dGraph) {
        System.out.println(dGraph);
        System.out.println();

        DirectedGraph rev = dGraph.reverse();
        System.out.println(rev);
    }
}
