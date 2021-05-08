package array;

import java.util.*;

/**
 * 我们有 N 个与坐标轴对齐的矩形, 其中 N > 0, 判断它们是否能精确地覆盖一个矩形区域。
 * <p>
 * 每个矩形用左下角的点和右上角的点的坐标来表示。例如， 一个单位正方形可以表示为 [1,1,2,2]。 ( 左下角的点的坐标为 (1, 1) 以及右上角的点的坐标为 (2, 2) )。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [3,2,4,4],
 * [1,3,2,4],
 * [2,3,3,4]
 * ]
 * <p>
 * 返回 true。5个矩形一起可以精确地覆盖一个矩形区域。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * rectangles = [
 * [1,1,2,3],
 * [1,3,2,4],
 * [3,1,4,2],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。两个矩形之间有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [3,2,4,4]
 * ]
 * <p>
 * 返回 false。图形顶端留有间隔，无法覆盖成一个矩形。
 *  
 * <p>
 * <p>
 * <p>
 * 示例 4:
 * <p>
 * rectangles = [
 * [1,1,3,3],
 * [3,1,4,2],
 * [1,3,2,4],
 * [2,2,4,4]
 * ]
 * <p>
 * 返回 false。因为中间有相交区域，虽然形成了矩形，但不是精确覆盖。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-rectangle
 */
public class PerfectRectangle {


    public boolean isRectangleCover(int[][] rectangles) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        int actualArea = 0;
        HashSet<Point> points = new HashSet<>();
        for (int i = 0; i <= rectangles.length - 1; i++) {

            int x1 = rectangles[i][0];
            int y1 = rectangles[i][1];
            int x2 = rectangles[i][2];
            int y2 = rectangles[i][3];
            Point point1 = new Point(x1, y1);
            Point point2 = new Point(x1, y2);
            Point point3 = new Point(x2, y1);
            Point point4 = new Point(x2, y2);

            boolean b1 = points.contains(point1);
            if (b1) {
                points.remove(point1);
            } else {
                points.add(point1);
            }

            boolean b2 = points.contains(point2);
            if (b2) {
                points.remove(point2);
            } else {
                points.add(point2);
            }

            boolean b3 = points.contains(point3);
            if (b3) {
                points.remove(point3);
            } else {
                points.add(point3);
            }

            boolean b4 = points.contains(point4);
            if (b4) {
                points.remove(point4);
            } else {
                points.add(point4);
            }

            actualArea += (x2 - x1) * (y2 - y1);

            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);

            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

        }

        int maxArea = (maxX - minX) * (maxY - minY);

        if (maxArea != actualArea) {
            return false;
        }

        if (points.size() != 4) {
            return false;
        }

        Point p1 = new Point(minX, minY);
        Point p2 = new Point(maxX, minY);
        Point p3 = new Point(maxX, maxY);
        Point p4 = new Point(minX, maxY);

        if (!points.contains(p1)) {
            return false;
        }
        if (!points.contains(p2)) {
            return false;
        }

        if (!points.contains(p3)) {
            return false;
        }
        if (!points.contains(p4)) {
            return false;
        }

        //获取最大左下顶点和最大右上顶点

        //获取所有顶点集合

        //根据最大顶点获取最大面积

        //判断最大面积是否等于累加面积

        //判断顶点数是否为4

        //判断最大矩形的每个顶点是否在顶点集合中

        return true;
    }


    class Point implements Comparable<Point> {
        int x;
        int y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return getX() == point.getX() &&
                    getY() == point.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }

        @Override
        public int compareTo(Point o) {
            return o.hashCode() - this.hashCode();
        }
    }


    public static void main(String[] args) {
        PerfectRectangle perfectRectangle = new PerfectRectangle();
        int[][] rectangles =  {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        boolean rectangleCover = perfectRectangle.isRectangleCover(rectangles);
        System.out.println(rectangleCover);
    }
}
