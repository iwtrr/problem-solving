// https://school.programmers.co.kr/learn/courses/30/lessons/92335

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String baseK = Integer.toString(n, k);

        for (int l = 0, r = 0; l < baseK.length(); ++r, l = r) {
            while (r < baseK.length() && baseK.charAt(r) != '0') {
                ++r;
            }

            String numStr = baseK.substring(l, r);
            if (numStr.matches("[1-9]+") && isPrime(Long.parseLong(numStr))) {
                ++answer;
            }
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}