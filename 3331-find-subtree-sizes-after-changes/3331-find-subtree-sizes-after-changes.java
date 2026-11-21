class Solution {
    private List<Integer>[] origTree;
    private List<Integer>[] newTree;
    private int[] newParent;
    private int[] ans;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = new int[n];
        this.newParent = Arrays.copyOf(parent, n);

        origTree = new ArrayList[n];
        newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        dfsRewire(0, lastSeen);

        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }

        dfsSize(0);
        return ans;
    }

    private void dfsRewire(int u, int[] lastSeen) {
        int c = s.charAt(u) - 'a';
        int prevAncestor = lastSeen[c];

        if (prevAncestor != -1) {
            newParent[u] = prevAncestor;
        }

        lastSeen[c] = u;

        for (int v : origTree[u]) {
            dfsRewire(v, lastSeen);
        }

        lastSeen[c] = prevAncestor;
    }

    private int dfsSize(int u) {
        int size = 1;
        for (int v : newTree[u]) {
            size += dfsSize(v);
        }
        ans[u] = size;
        return size;
    }
}