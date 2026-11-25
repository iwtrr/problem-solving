// https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Map<String, List<String>> conversions = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();

        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = begin;

        for (String word : words) {
            conversions.put(word, new ArrayList<>());
            distances.put(word, -1);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];

                if (isConvertible(word, word2)) {
                    conversions.get(word).add(word2);
                    conversions.get(word2).add(word);
                }
            }
        }

        Deque<String> queue = new ArrayDeque<>();
        queue.offer(begin);
        distances.put(begin, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            List<String> nexts = conversions.get(current);

            for (String next : nexts) {
                if (distances.get(next) == -1) {
                    distances.put(next, distances.get(current) + 1);
                    queue.offer(next);
                }

                if (next.equals(target)) {
                    return distances.get(next);
                }
            }
        }

        return 0;
    }

    private boolean isConvertible(String word, String word2) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            count += word.charAt(i) != word2.charAt(i) ? 1 : 0;
        }

        return count == 1;
    }
}