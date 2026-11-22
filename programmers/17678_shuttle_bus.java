// https://school.programmers.co.kr/learn/courses/30/lessons/17678

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);

        List<List<Integer>> shuttles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            shuttles.add(new ArrayList<>());
        }

        int defaultMin = timeToMin("09:00");
        for (String time : timetable) {
            int no = Math.max((timeToMin(time) - defaultMin + t - 1) / t, 0);

            for (int j = no; j < n; j++) {
                if (shuttles.get(j).size() < m) {
                    shuttles.get(j).add(timeToMin(time));
                    break;
                }
            }
        }

        List<Integer> lastShuttle = shuttles.get(n - 1);
        if (lastShuttle.size() == m) {
            return minToTime(lastShuttle.get(lastShuttle.size() - 1) - 1);
        } else {
            return minToTime(defaultMin + (n - 1) * t);
        }
    }

    private int timeToMin(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60
            + Integer.parseInt(time.substring(3,5));
    }

    private String minToTime(int min) {
        return String.format("%02d", (min / 60)) + ":" + String.format("%02d", (min % 60));
    }
}