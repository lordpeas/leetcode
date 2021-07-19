/**
 * Description: leetcode
 * Created by : Tianqi Cui
 * Create Date: 2021年7月16日 21:36
 */
public class Version {

    public int compareVersion(String version1, String version2) {
        String[] v1s =  version1.split("\\.");
        String[] v2s =  version2.split("\\.");
        int maxLenth = Math.max(v1s.length,v2s.length);
        System.out.println(v1s);
        System.out.println(v2s);
        for(int i =0;i<=maxLenth-1;i++){
            int num1 =0;
            int num2 = 0;
            if(i<v1s.length){
                num1 = Integer.parseInt(v1s[i]);
            }

            if(i<v2s.length){
                num2 = Integer.parseInt(v2s[i]);
            }

            System.out.println("num1"+num1);

            System.out.println("num2"+num2);

            int sub =   num1-num2;
            if(sub ==0){
                continue;
            }else if(sub>0){
                return 1;
            }else{
                return -1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Version version = new Version();
        int i = version.compareVersion("0.1", "1.1");
    }
}
