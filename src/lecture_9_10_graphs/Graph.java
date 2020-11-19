package lecture_9_10_graphs;

import java.util.*;

public class Graph {
    List<List<Vertex>> adj_list = new ArrayList<>();

    //Graph Constructor
    public Graph() {
    }

    public Graph(List<Edge> edges) {

        for (int i = 0; i <= edges.size(); i++)
            adj_list.add(i, new ArrayList<>());


        for (Edge e : edges) {

            adj_list.get(e.source).add(new Vertex(e.destination, e.weight));
        }
    }

    // Bruger BFS
    public static boolean isBipartite(Graph graph, int vertex, int number_of_vertices) {
        boolean[] discovered = new boolean[number_of_vertices];
        int[] level = new int[number_of_vertices];

        // Marker første node og set level til 0 som start
        discovered[vertex] = true;
        level[vertex] = 0;

        // Laver Queue til BFS og sæt vertex sourcen ind i queuen.
        Queue<Integer> q = new ArrayDeque<>();
        q.add(vertex);

        // looper queuen igennem indtil den er tom.
        while (!q.isEmpty()) {
            vertex = q.poll();
            //(vertex -> u)
            for (Vertex u : graph.adj_list.get(vertex)) {
                // Hvis første vertex u er først gang blevet
                if (!discovered[u.value]) {
                    discovered[u.value] = true; // Marker vertex som fundet
                    level[u.value] = level[vertex] + 1;  // set level som level af parent node + 1
                    q.add(u.value);  // Push vertex til queuen
                }
                // Hvis vertex allerede er fundet, og level af vertex u og vertex er den samme
                // så vill grafen indeholde en odd-cycle og er ikke bipartite.
                else if (level[vertex] == level[u.value])
                    return false;
            }
        }
        return true;
    }

    public String checkIsBipartite(Graph graph, int vertexStart, int number_of_vertices) {
        if (isBipartite(graph, vertexStart, number_of_vertices))
            return "Bipartite Graph";
        else
            return "Not a Bipartite Graph";
    }

    public static void printGraph(Graph graph) {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();

        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {

            for (Vertex edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value +
                        " (" + edge.weight + ")\t");
            }
            System.out.println();


            src_vertex++;
        }
    }


    public static void main(String[] args) {
        // define edges of the graph
        Edge v1 = new Edge(0, 1, 2);
        Edge v2 = new Edge(0, 2, 4);
        Edge v3 = new Edge(1, 2, 4);
        Edge v4 = new Edge(2, 0, 5);
        Edge v5 = new Edge(2, 1, 4);
        Edge v6 = new Edge(3, 2, 3);
        Edge v7 = new Edge(4, 5, 1);
        Edge v8 = new Edge(5, 4, 3);
        List<Edge> edges;
        edges = new ArrayList<>();

        edges.add(v1);
        edges.add(v2);
        edges.add(v3);
        edges.add(v4);
        edges.add(v5);
        edges.add(v6);
        edges.add(v7);
        edges.add(v8);
        int number_of_vertices = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).source != 0) {
                number_of_vertices++;
            }
        }

        // call graph class Constructor to construct a graph
        Graph graph = new Graph(edges);

        // print the graph as an adjacency list
        Graph.printGraph(graph);
        System.out.println(graph.checkIsBipartite(graph, 0, number_of_vertices) + "\n");
        List<Edge> edges2;
        edges2 = new ArrayList<>();
        Edge v11 = new Edge(1, 2, 2);
        Edge v22 = new Edge(2, 3, 4);
        Edge v33 = new Edge(2, 8, 4);
        Edge v44 = new Edge(3, 4, 5);
        Edge v55 = new Edge(4, 6, 4);
        Edge v66 = new Edge(5, 7, 3);
        Edge v77 = new Edge(5, 9, 1);
        Edge v88 = new Edge(8, 9, 3);


        edges2.add(v11);
        edges2.add(v22);
        edges2.add(v33);
        edges2.add(v44);
        edges2.add(v55);
        edges2.add(v66);
        edges2.add(v77);
        edges2.add(v88);

        Graph graph2 = new Graph(edges);
        Graph.printGraph(graph);
        number_of_vertices = 0;
        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).source != 0) {
                number_of_vertices++;
            }
        }
        System.out.println(graph.checkIsBipartite(graph, 1, number_of_vertices));
    }


}