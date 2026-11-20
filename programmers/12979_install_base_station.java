// https://school.programmers.co.kr/learn/courses/30/lessons/12979

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prevRight = 0;
        int len = 2 * w + 1;

        for (int station : stations) {
            int gap = station - w - prevRight - 1;
            answer += (gap + len - 1) / len;
            prevRight = station + w;
        }

        if (prevRight < n) {
            answer += (n - prevRight + len - 1) / len;
        }

        return answer;
    }
}