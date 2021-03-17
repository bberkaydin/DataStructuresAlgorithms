package Interview.DFS;

public class NumberOfIslands {
    int y;          // The height of the given grid
    int x;          // The width of the given grid
    char[][] g;     // The given grid, stored to reduce recursion memory usage
    
    /**
     * Given a 2d grid map of '1's (land) and '0's (water),
     * count the number of islands.
     * This method approaches the problem as one of depth-first connected
     * components search
     */
    public int numIslands(char[][] grid) {
        // Store the given grid
        // This prevents having to make copies during recursion
        g = grid;

        // Our count to return
        int c = 0;
        
        // Dimensions of the given graph
        y = g.length;
        if (y == 0) return 0;
        x = g[0].length;
        
        // Iterate over the entire given grid
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (g[i][j] == '1') {
                    dfs(i, j);
                    c++;
                }
            }
        }
        return c;
    }
    
    /**
     * Marks the given site as visited, then checks adjacent sites.
     * 
     * Or, Marks the given site as water, if land, then checks adjacent sites.
     * 
     * Or, Given one coordinate (i,j) of an island, obliterates the island
     * from the given grid, so that it is not counted again.
     * 
     * @param i, the row index of the given grid
     * @param j, the column index of the given grid
     */
    private void dfs(int i, int j) {
        
        // Check for invalid indices and for sites that aren't land
        if (i < 0 || i >= y || j < 0 || j >= x || g[i][j] != '1') return;
        
        // Mark the site as visited
        g[i][j] = '0';
        
        // Check all adjacent sites
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
/*
The time complexity is O(cells). Every cell is inspected at least once, due to the nested for loops.
Any single cell is inspected at most 5 times. We know this because there are 5 ways a cell (i, j) can be inspected:

inspected in the nested for loop, before dfs is called
dfs from cell (i + 1, j)
dfs from cell (i - 1, j)
dfs from cell (i, j + 1)
dfs from cell (i, j - 1)
The nested for loops obviously inspect each cell exactly once.

dfs(i, j) exits immediately if (i, j) has been inspected already,
which implies (i, j) can only be visited from dfs(i + 1, j) once,
visited from dfs(i - 1, j) once, visited from dfs(i, j + 1) once, and visited from (i, j - 1) once.
*/