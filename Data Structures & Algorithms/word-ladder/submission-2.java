class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int count = 1;
        while (!q.isEmpty()) {
            for (int i = q.size(); i > 0; i--) {
                char[] word = q.poll().toCharArray();
                visited.add(String.valueOf(word));
                for (int j = 0; j < word.length; j++) {
                    for (int k = 0; k < 26; k++) {
                        char original = word[j];
                        char newChar = (char) ('a' + k);
                        if (newChar != original) {
                            word[j] = newChar;
                            String newWord = String.valueOf(word);
                            if (newWord.equals(endWord)) {
                                return count + 1;
                            }
                            if (!visited.contains(newWord) && set.contains(newWord)) {
                                q.offer(newWord);
                            }
                            word[j] = original;
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
