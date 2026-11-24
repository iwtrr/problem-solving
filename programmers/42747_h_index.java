// https://school.programmers.co.kr/learn/courses/30/lessons/42747

class Solution {
    public int solution(int[] citations) {
        for (int h = citations.length; h > 0; h--) {
            int hCount = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    ++hCount;
                }
            }
            if (hCount >= h) {
                return h;
            }
        }

        return 0;
    }
}