class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new LinkedList<>();
        Stack<Integer> rightMovingAstroids = new Stack<>();
        for (int i : asteroids) {
            if (i > 0) {
                rightMovingAstroids.push(i);
            } else {
                boolean isDestroyed = false;
                while (!rightMovingAstroids.isEmpty() && !isDestroyed) {
                    int j = rightMovingAstroids.pop();
                    if (j == Math.abs(i)) {
                        isDestroyed = true;
                    } else if (j > Math.abs(i)) {
                        rightMovingAstroids.push(j);
                        isDestroyed = true;
                    }
                }
                if (!isDestroyed) {
                    result.add(i);
                }
            }
        }
        result.addAll(rightMovingAstroids);
        return result.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}