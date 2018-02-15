/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */


public class KClosest {
    /*
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        if (k == 0) {
            return new Point[0];
        }
        
        Queue<Point> pq = new PriorityQueue<Point>(k, new Comparator<Point>() {
           @Override
           public int compare(Point p1, Point p2) {
               int diff = getDistance(p2, origin) - getDistance(p1, origin);
               if (diff == 0) {
                   diff = p2.x - p1.x;
               }
               if (diff == 0) {
                   diff = p2.y - p1.y;
               }
               return diff;
           }
        });
        
        for (Point p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        Point[] res = new Point[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
    
    private int getDistance(Point p1, Point origin) {
        return (p1.x - origin.x) * (p1.x - origin.x) + (p1.y - origin.y) * (p1.y - origin.y);
    }
}