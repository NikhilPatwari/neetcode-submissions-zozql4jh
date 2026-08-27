public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;

        int[] sides = new int[4];
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        return dfs(matchsticks, sides, 0, sum / 4);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int i, int length) {
        if (i == matchsticks.length) {
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }

        for (int j = 0; j < 4; j++) {
            if (sides[j] + matchsticks[i] <= length) {
                sides[j] += matchsticks[i];
                if (dfs(matchsticks, sides, i + 1, length))
                    return true;
                sides[j] -= matchsticks[i];
            }
            if (sides[j] == 0) break;
        }

        return false;
    }
    private void reverse(int[] matchsticks) {
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
    }
}