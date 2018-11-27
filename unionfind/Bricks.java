package leetcode.unionfind;

public class Bricks {

    private int[] bricks;
    private int rows;
    private int cols;
    private UnionFind uf;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[] hitBricks(int[][] grid, int[][] hits) {
        rows = grid.length;
        cols = grid[0].length;
        uf = new UnionFind(rows * cols + 1);

        for(int[] hit : hits) {
            if(grid[hit[0]][hit[1]] == 1)
                grid[hit[0]][hit[1]] = 2;
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1)
                    unionAround(grid, i, j);
            }
        }

        int bricksLeft = uf.rank[uf.find(0)];

        for(int i = hits.length - 1; i >= 0; i--) {
            if( grid[hits[i][0]][hits[i][1]] != 2) continue;
            grid[hits[i][0]][hits[i][1]] = 1;
            unionAround(grid, hits[i][0], hits[i][1]);
            int curBricksLeft = uf.rank[uf.find(0)];
            if(curBricksLeft != bricksLeft) bricks[i] = curBricksLeft - bricksLeft - 1;
            bricksLeft = curBricksLeft;
        }
        return bricks;
    }

    private int serialize(int x, int y) {
        return x * cols + y;
    }

    private void unionAround(int[][] grid, int x, int y) {
        int cur = serialize(x, y);

        for(int[] dir : dirs) {
            int tx = x + dir[0];
            int ty = y + dir[1];
            if(tx < 0 || ty < 0 || tx >= rows || ty >= cols || grid[tx][ty] != 1) continue;
            uf.union(cur, serialize(tx, ty));
        }

        if(x == 0)
            uf.union(cur, 0);
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(parent[x] == x) {
                return x;
            }
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) {
                return;
            }
            if(rank[rootX] < rank[rootY]) {
                rank[rootY] += rank[rootX];
                parent[rootX] = rootY;
            } else {
                rank[rootX] += rank[rootY];
                parent[rootY] = rootX;
            }
        }
    }
}
