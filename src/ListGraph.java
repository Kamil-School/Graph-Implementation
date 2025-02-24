//Graph ADT, implemented with adjacency lists
//Created by James Vanderhyde, 19 November 2024

package c311graphadt;

public class ListGraph
{
    private class Node
    {
        int data;
        Node next;

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }

        void removeNodeAfter()
        {
            next = next.next;
        }

        static int linkedLength(Node head)
        {
            int r = 0;
            while (head != null)
            {
                r++;
                head = head.next;
            }
            return r;
        }
    }

    private final Node[] lists;

    /**
     * Creates a new graph with the given number of vertices.
     * The graph is implemented with adjacency lists.
     * @param n The number of vertices in the graph.
     */
    public ListGraph(int n)
    {
        lists = new Node[n];
    }

    /**
     * Determines whether the given edge is part of this graph.
     * @param i The starting vertex
     * @param j The end vertex
     * @return true if the edge is part of this graph, false if not.
     */
    public boolean edgeExists(int i, int j)
    {
        Node current = lists[i];
        while (current != null) {
            if (current.data == j) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Adds the given edge to this graph. If the edge already exists, the graph
     * is not changed.
     * @param i The starting vertex
     * @param j The end vertex
     */
    public void addEdge(int i, int j)
    {
        if (!this.edgeExists(i, j))
        {
            this.lists[i] = new Node(j,this.lists[i]);
        }
        if (!this.edgeExists(j, i)) {
            this.lists[j] = new Node(i, this.lists[j]);
        }
    }

    /**
     * Removes the given edge from the graph. If the edge is not present in the
     * graph, the method returns false and leaves the graph unchanged.
     * @param i The starting vertex
     * @param j The end vertex
     * @return true if the given edge was removed, false if the edge wasn't 
     * present to begin with.
     */
    public boolean removeEdge(int i, int j)
    {
        if (lists[i]==null)
            return false;
        boolean removedFromIToJ = false;
        if (lists[i] != null)
        {
            if (lists[i].data == j)
            {
                lists[i] = lists[i].next;
                removedFromIToJ = true;
            }
            else
            {
                Node precursor = lists[i];
                Node cursor = lists[i].next;
                while (cursor != null)
                {
                    if (cursor.data == j)
                    {
                        precursor.removeNodeAfter();
                        removedFromIToJ = true;
                        break;
                    }
                    precursor = cursor;
                    cursor = cursor.next;
                }
            }
        }
        boolean removedFromJToI = false;
        if (lists[j] != null)
        {
            if (lists[j].data == i)
            {
                lists[j] = lists[j].next;
                removedFromJToI = true;
            }
            else
            {
                Node precursor = lists[j];
                Node cursor = lists[j].next;
                while (cursor != null)
                {
                    if (cursor.data == i)
                    {
                        precursor.removeNodeAfter();
                        removedFromJToI = true;
                        break;
                    }
                    precursor = cursor;
                    cursor = cursor.next;
                }
            }
        }
        return removedFromIToJ || removedFromJToI;
    }

    /**
     * Returns the number of vertices in this graph.
     * @return the number of vertices in this graph.
     */
    public int getNumVertices()
    {
        return this.lists.length;
    }

    /**
     * Returns the number of edges in this graph.
     * @return the number of edges in this graph.
     */
    public int getNumEdges()
    {
        int r = 0;
        for (Node vertex:this.lists)
        {
            r += Node.linkedLength(vertex);
        }
        return r;
    }

    /**
     * Returns the degree of the given vertex. That is the number of other 
     * vertices this vertex is adjacent to.
     * @param i The vertex to find the degree for
     * @return the degree of the given vertex
     */
    public int getDegree(int i)
    {
        return Node.linkedLength(this.lists[i]);
    }
}
