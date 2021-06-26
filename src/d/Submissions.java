package d;



public class Submissions {
//
//    public int findMinArrowShots(int[][] points) {
//        if(points.length==0) return 0;
//        Arrays.sort(points,(a, b)->{
//           return Integer.compare(a[1],b[1]);
//        });
//
//        for(int[] point:points){
//            Arrays.toString(point);
//        }
//        int count =1;
//        int end = points[0][1];
//        for(int i=0;i<=points.length-1;i++){
//            int start = points[i][0];
//            if(start>end){
//                count++;
//                end = points[i][1];
//            }
//        }
//        return count;
//    }
//    //[[-2147483646,-2147483645],[2147483646,2147483647]]
//    public static void main(String[] args) {
//        int[][] points = new int[2][2];
//        points[0] =new int[]{-2147483646,-2147483645};
//        points[1] =new int[]{2147483646,2147483647};
//        Submissions submissions = new Submissions();
//        int i = submissions.findMinArrowShots(points);
//        System.out.println(i);
//    }i


    public static void main(String[] args) {
       User a = new User();
       a.setAge(10);

        User b = new User();
        a.setAge(20);

        User c = new User();
        a.setAge(30);

        a=c;
        b=c;

        a.setAge(200);
        try {
            Thread.currentThread().wait();
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getAge());
        System.out.println(b.getAge());
        System.out.println(c.getAge());
        System.out.println("hah");


    }


}
class User{

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
