// https://school.programmers.co.kr/learn/courses/30/lessons/12927

class Solution {
    public long solution(int n, int[] works) {
        int[] w = new int[50001];
        int max = 0;

        for (int work : works) {
            w[work] += 1;
            max = Math.max(max, work);
        }

        int p = max;
        while (n > 0) {
            if (p > 0) {
                if (w[p] > 0) {
                    --w[p];
                    ++w[p - 1];
                    --n;
                } else {
                    --p;
                }
            } else {
                break;
            }
        }

        long answer = 0;
        for (int i = 1; i <= max; i++) {
            if (w[i] > 0) {
                answer += w[i] * ((long) i * i);
            }
        }

        return answer;
    }
}