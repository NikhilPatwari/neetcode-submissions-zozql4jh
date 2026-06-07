class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Pair[][] reached = new Pair[ROWS][COLS];
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < COLS; j++) {
                q.offer(new Pair(i, j));
                reached[i][j] = new Pair(1,0);
            }
        }
        for (int i = 1; i < ROWS; i++) {
            for (int j = 0; j < 1; j++) {
                q.offer(new Pair(i, j));
                reached[i][j] = new Pair(1,0);
            }
        }
        reached[0][COLS-1] = new Pair(1,1);
        reached[ROWS-1][0] = new Pair(1,1);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.a;
            int j = p.b;
            addToReached(heights, reached, heights[i][j], q, i + 1, j, ROWS, COLS, true);
            addToReached(heights, reached, heights[i][j], q, i - 1, j, ROWS, COLS, true);
            addToReached(heights, reached, heights[i][j], q, i, j + 1, ROWS, COLS, true);
            addToReached(heights, reached, heights[i][j], q, i, j - 1, ROWS, COLS, true);
        }

        for (int i = ROWS - 1; i == ROWS - 1; i--) {
            for (int j = 0; j < COLS; j++) {
                q.offer(new Pair(i, j));
                if(reached[i][j] == null){
                    reached[i][j] = new Pair(0,1);
                }else{
                    reached[i][j].b = 1;
                }
            }
        }
        for (int i = 0; i < ROWS - 1; i++) {
            for (int j = COLS - 1; j == COLS - 1; j--) {
                q.offer(new Pair(i, j));
                if(reached[i][j] == null){
                    reached[i][j] = new Pair(0,1);
                }else{
                    reached[i][j].b = 1;
                }
            }
        }
        reached[0][COLS-1] = new Pair(1,1);
        reached[ROWS-1][0] = new Pair(1,1);
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int i = p.a;
            int j = p.b;
            addToReached(heights, reached, heights[i][j], q, i + 1, j, ROWS, COLS, false);
            addToReached(heights, reached, heights[i][j], q, i - 1, j, ROWS, COLS, false);
            addToReached(heights, reached, heights[i][j], q, i, j + 1, ROWS, COLS, false);
            addToReached(heights, reached, heights[i][j], q, i, j - 1, ROWS, COLS, false);
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (reached[i][j] != null && reached[i][j].a == 1 && reached[i][j].b == 1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }
    private void addToReached(int[][] heights, Pair[][] reached, int height, Queue<Pair> q, int i,
        int j, int ROWS, int COLS, boolean isPacific) {
        if (i < 0 || j < 0 || i >= ROWS || j >= COLS || heights[i][j] < height) {
            return;
        }
        if (reached[i][j] == null) {
            if (isPacific) {
                reached[i][j] = new Pair(1, 0);
            } else {
                reached[i][j] = new Pair(0, 1);
            }
            q.add(new Pair(i, j));
        } else {
            Pair p = reached[i][j];

            if (isPacific) {
                if (p.a == 0) {
                    q.add(new Pair(i, j));
                }
                p.a = 1;
            } else {
                if (p.b == 0) {
                    q.add(new Pair(i, j));
                }
                p.b = 1;
            }
        }
    }
}
class Pair {
    public int a;
    public int b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}