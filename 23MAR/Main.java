import java.io.*;
import java.util.*;

public class Main {

    static class DSU {
        int[] parent, size;
        int components, maxSize;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            components = n;
            maxSize = 1;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        void union(int u, int v) {
            int ru = find(u);
            int rv = find(v);

            if (ru == rv) return;

            if (size[ru] < size[rv]) {
                parent[ru] = rv;
                size[rv] += size[ru];
                maxSize = Math.max(maxSize, size[rv]);
            } else {
                parent[rv] = ru;
                size[ru] += size[rv];
                maxSize = Math.max(maxSize, size[ru]);
            }

            components--;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);

        DSU dsu = new DSU(n);

        for (int i = 0; i < m; i++) {
            String[] parts = br.readLine().split(" ");

            int u = Integer.parseInt(parts[0]) - 1;
            int v = Integer.parseInt(parts[1]) - 1;

            dsu.union(u, v);

            sb.append(dsu.components).append(" ").append(dsu.maxSize).append('\n');
        }

        System.out.print(sb);
    }
}