package array;



import sun.jvmstat.perfdata.monitor.PerfStringVariableMonitor;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在座位 p 上。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/exam-room
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ExamRoom {

    private Map<Integer,int[]> startMap;

    private Map<Integer,int[]> endMap;

    private TreeSet<int[]> pd;

    private int N;

    public ExamRoom(int N) {
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        this.N = N;
        pd = new TreeSet<>((a,b)->{
           int d1 = distance(a);
           int d2 = distance(b);
           if (d1==d2){
               return b[0]-a[0];//索引小的在后面
           }
           return d1-d2;//长度大的线段在后面
        });
        addInterval(new int[]{-1,N});
    }

    public int seat() {
        int seat;
        int[] last = pd.last();
        int a = last[0];
        int b = last[1];
        System.out.println("=====last:"+a+","+b);
        if (a==-1){
           seat = 0;
        }else if(b ==N){
            seat = N-1;
        }else {
           seat =  a+(b-a)/2;
        }

        pd.remove(last);
        int[] inter1 =   new int[]{a,seat};
        int[] inter2 =   new int[]{seat,b};
        addInterval(inter1);
        addInterval(inter2);
        System.out.println("seat:"+seat);
        return seat;
    }

    public void leave(int p) {
        int[] start = startMap.get(p);
        int[] end = endMap.get(p);
        int[] newInterval =   new int[]{end[0],start[1]};
       removeInterval(start);
       removeInterval(end);
       addInterval(newInterval);
       System.out.println("leave:"+p);
    }


    private void removeInterval(int[] interval){
        startMap.remove(interval[0]);
        endMap.remove((interval[1]));
        pd.remove(interval);
    }

    private void addInterval(int[] interval){
        pd.add(interval);
        startMap.put(interval[0],interval);
        endMap.put(interval[1],interval);
    }

    private int distance(int[] interval){
       int x =  interval[0] ;
       int y =  interval[1] ;
       if(x==-1) return y;
       if(y==N) return N-1-x;
       return (y-x)/2;
    }

    public static void main(String[] args) {
        ExamRoom examRoom = new ExamRoom(10);
        int seat1 = examRoom.seat();

        int seat2 = examRoom.seat();
        int seat3 = examRoom.seat();
        int seat4 = examRoom.seat();
         examRoom.leave(4);
        TreeSet<int[]> set = examRoom.pd;
        set.forEach((s)->{
            System.out.println("###"+s[0]+","+s[1]);
        });

        int seat5 = examRoom.seat();

    }


}
