public class MatrixGraph {
    private boolean[][] adjacencyMatrix;
    private int numVertices;

    public MatrixGraph(int numVertices)
    {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int from, int to)
    {
        if(from >= 0 && from < numVertices && to >= 0 && to < numVertices)
        {
            adjacencyMatrix[from][to] = true;
            adjacencyMatrix[to][from] = true;
        }
        else
        {
            System.out.println("Invalid vertex index");
        }
    }

    public int getDegree(int vertex)
    {
        int degree = 0;
        for(int i = 0; i < numVertices; i++)
        {
            if(adjacencyMatrix[vertex][i])
            {
                degree++;
            }
        }
        return degree;
    }

    public boolean removeEdge(int from, int to) {
        if (from >= 0 && from < numVertices && to >= 0 && to < numVertices) {
            boolean existed = adjacencyMatrix[from][to];
            adjacencyMatrix[from][to] = false;
            adjacencyMatrix[to][from] = false;
            return existed;
        } else {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }

    public boolean edgeExists(int from, int to)
    {
        if (from >= 0 && from < numVertices && to >= 0 && to < numVertices)
        {
            return adjacencyMatrix[from][to];
        }
        else
        {
            throw new IllegalArgumentException("Invalid vertex");
        }
    }

    public int getNumVertices()
    {
        return numVertices;
    }


}
