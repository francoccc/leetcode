package leetcode.shape;

import java.util.HashMap;
import java.util.Set;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnLine {

    private int maxs = 0;
    private HashMap<Double, Integer> record = new HashMap<>();

    public int maxPoints(Point[] points) {
        for(int i = 0; i < points.length - 1; i++) {
            record.clear();
            int curNum = 1;
            for(int j = i + 1; j < points.length; j++) {
                if(Points.isEqual(points[i], points[j])) {
                    curNum++;
                    continue;
                }
                double curSlope = Points.slope(points[i], points[j]);
                if(record.containsKey(curSlope)) {
                    record.replace(curSlope, record.get(curSlope) + 1);
                } else {
                    record.put(curSlope, 1);
                }
            }
            Set<Double> keys = record.keySet();
            if(keys.size() == 0) {
                maxs = Math.max(maxs, curNum);
            }
            for(Double key : keys) {
                maxs = Math.max(maxs, curNum + record.get(key));
            }
        }
        return maxs;
    }

    static class Points {

        public static double slope(Point a, Point b) {
            if(a.x - b.x != 0) {
                return (double) (b.y - a.y) / (b.x - a.x);
            } else {
                return Double.MAX_VALUE;
            }
        }

        public static boolean isEqual(Point a, Point b) {
            return a.x == b.x && a.y == b.y;
        }
    }
}
