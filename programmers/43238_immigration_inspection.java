// https://school.programmers.co.kr/learn/courses/30/lessons/43238

class Solution {
    public long solution(int n, int[] times) {
        long right = Long.MAX_VALUE;
        for (int time : times) {
            right = Math.min(right, (long) time);
        }
        right *= n;

        long left = 1;

        while (left < right) {
            long time = (left + right) / 2;

            if (n <= capacity(time, times)) {
                right = time;
            } else {
                left = time + 1;
            }
        }

        return left;
    }

    private long capacity(long time, int[] times) {
        long sum = 0;

        for (int t : times) {
            sum += time / t;
        }

        return sum;
    }
}