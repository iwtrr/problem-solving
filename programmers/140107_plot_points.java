// https://school.programmers.co.kr/learn/courses/30/lessons/140107

class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        for (int a = 0; a * k <= d; a++) {
            answer += Math.floor(Math.sqrt((long) (d + a*k) * (d - a*k))) / k + 1;
        }

        return answer;
    }
}