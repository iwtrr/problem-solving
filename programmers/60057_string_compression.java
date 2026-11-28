// https://school.programmers.co.kr/learn/courses/30/lessons/60057

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for (int i = (s.length() + 1) / 2; i > 0; i--) {
            answer = Math.min(answer, compress(s, i).length());
        }

        return answer;
    }

    private String compress(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for (; i + k <= s.length(); i += k) {
            String str = s.substring(i, i + k);
            int count = 1;

            for (int j = i + k; j + k <= s.length(); j += k) {
                if (!str.equals(s.substring(j, j + k))) {
                    break;
                }
                ++count;
            }

            if (count > 1) {
                sb.append(count);
                i += (count - 1) * k;
            }
            sb.append(str);
        }

        return sb.append(s, i, s.length()).toString();
    }
}