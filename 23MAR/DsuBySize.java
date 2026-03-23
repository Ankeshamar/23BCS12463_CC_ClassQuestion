import java.util.*;

public class DsuBySize {
    private int[] parent;
    private int[] size;
    private int components;

    public DsuBySize(int n) {
        parent = new int[n];
        size = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); 
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV) {
            return false; 
        }

        if (size[rootU] < size[rootV]) {
            parent[rootU] = rootV;
            size[rootV] += size[rootU];
        } else {
            parent[rootV] = rootU;
            size[rootU] += size[rootV];
        }

        components--; 
        return true;
    }

    public int getComponents() {
        return components;
    }

    public int getSize(int x) {
        return size[find(x)];
    }

    public boolean isConnected(int u, int v) {
        return find(u) == find(v);
    }
    public static void main(String[] args) {
        DsuBySize dsu = new DsuBySize(6);

        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println("Components: " + dsu.getComponents()); // 3

        System.out.println("Size of component containing 0: " + dsu.getSize(0)); // 3

        System.out.println("0 and 2 connected? " + dsu.isConnected(0, 2)); 
        System.out.println("0 and 5 connected? " + dsu.isConnected(0, 5)); 
    }
}