import java.util.*;

class Solution {
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        int LOGN = 17; // 2^16 = 65536 > 50000
        int[][] up = new int[n][LOGN];
        int[] depth = new int[n];
        int[] tin = new int[n];
        int[] tout = new int[n];
        int[] initXor = new int[n];
        int[] charVal = new int[n];

        for (int i = 0; i < n; i++) {
            charVal[i] = 1 << (s.charAt(i) - 'a');
        }

        int timer = 1;
        int[] stack = new int[n];
        int[] parent = new int[n];
        int[] edgeIdx = new int[n];
        int top = 0;

        stack[0] = 0;
        parent[0] = -1;
        depth[0] = 0;
        initXor[0] = charVal[0];
        tin[0] = timer++;

        while (top >= 0) {
            int u = stack[top];
            int p = parent[u];

            if (edgeIdx[u] < adj[u].size()) {
                int v = adj[u].get(edgeIdx[u]++);
                if (v != p) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    initXor[v] = initXor[u] ^ charVal[v];
                    up[v][0] = u;
                    tin[v] = timer++;
                    stack[++top] = v;
                }
            } else {
                tout[u] = timer - 1;
                top--;
            }
        }

        up[0][0] = 0;
        for (int j = 1; j < LOGN; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        int[] bit = new int[n + 5];
        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            if (q.charAt(0) == 'u') {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                char c = q.charAt(secondSpace + 1);

                int newVal = 1 << (c - 'a');
                int oldVal = charVal[u];
                int diff = oldVal ^ newVal;
                charVal[u] = newVal;

                bitUpdate(bit, tin[u], diff);
                bitUpdate(bit, tout[u] + 1, diff);
            } else {
                int firstSpace = q.indexOf(' ');
                int secondSpace = q.indexOf(' ', firstSpace + 1);
                int u = Integer.parseInt(q.substring(firstSpace + 1, secondSpace));
                int v = Integer.parseInt(q.substring(secondSpace + 1));

                int lca = getLca(u, v, up, depth, LOGN);
                int pu = initXor[u] ^ bitQuery(bit, tin[u]);
                int pv = initXor[v] ^ bitQuery(bit, tin[v]);
                int pathXor = pu ^ pv ^ charVal[lca];

                ans.add((pathXor & (pathXor - 1)) == 0);
            }
        }

        return ans;
    }

    private int getLca(int u, int v, int[][] up, int[] depth, int logn) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        int diff = depth[u] - depth[v];
        for (int j = 0; j < logn; j++) {
            if (((diff >> j) & 1) == 1) {
                u = up[u][j];
            }
        }
        if (u == v) return u;
        for (int j = logn - 1; j >= 0; j--) {
            if (up[u][j] != up[v][j]) {
                u = up[u][j];
                v = up[v][j];
            }
        }
        return up[u][0];
    }

    private void bitUpdate(int[] bit, int idx, int val) {
        for (; idx < bit.length; idx += idx & -idx) {
            bit[idx] ^= val;
        }
    }

    private int bitQuery(int[] bit, int idx) {
        int res = 0;
        for (; idx > 0; idx -= idx & -idx) {
            res ^= bit[idx];
        }
        return res;
    }
}