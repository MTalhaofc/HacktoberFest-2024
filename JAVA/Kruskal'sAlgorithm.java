import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;
    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Graph {
    int vertices, edges;
    Edge[] edgeList;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        edgeList = new Edge[edges];
    }

    public void addEdge(int index, int src, int dest, int weight) {
        edgeList[index] = new Edge(src, dest, weight);
    }

    int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public void kruskalMST() {
        Edge[] result = new Edge[vertices - 1];
        int e = 0;
        int i = 0;

        Arrays.sort(edgeList, Comparator.comparingInt(edge -> edge.weight));

        int[] parent = new int[vertices];
        int[] rank = new int[vertices];
        for (int v = 0; v < vertices; v++) {
            parent[v] = v;
            rank[v] = 0;
        }

        while (e < vertices - 1) {
            Edge nextEdge = edgeList[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edge \tWeight");
        for (i = 0; i < e; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "\t" + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int vertices = 4;
        int edges = 5;
        Graph graph = new Graph(vertices, edges);

        graph.addEdge(0, 0, 1, 10);
        graph.addEdge(1, 0, 2, 6);
        graph.addEdge(2, 0, 3, 5);
        graph.addEdge(3, 1, 3, 15);
        graph.addEdge(4, 2, 3, 4);

        graph.kruskalMST();
    }
}
