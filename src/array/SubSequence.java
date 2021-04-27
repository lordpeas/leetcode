package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubSequence {

    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     *
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     *
     * 进阶：
     *
     * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/is-subsequence
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j< t.length()){
            if(s.charAt(i)==s.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }

    public int numMatchingSubseq(String s, String[] words) {
        int n = s.length();
        int total = 0;
        Map<Character,List<Integer>> dict = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            List<Integer> arras = dict.getOrDefault(c, new ArrayList<>());
            arras.add(i);
            dict.put(c, arras);
        }

        for (String sub : words) {
            boolean bol = isSequence(sub, dict);
            if(bol){
                total+=1;
            }
        }
        return total;
    }




    private boolean isSequence(String s,Map<Character,List<Integer>> dict){
        int m = s.length();
        int j = 0;
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            List<Integer> list = dict.get(c);
            if (null ==list||list.isEmpty()) return false;
            int pos =leftBonund(list,j);
            if (pos ==list.size()) return false;
            j =dict.get(c).get(pos)+1;
        }

        return true;
    }





    private int leftBonund(List<Integer> arrs, int tar){
        int l = 0;int r = arrs.size();
        while(l<r){
            int mid = l+(r-l)/2;
            if(tar> arrs.get(mid)){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }

    /**
     * "abcde"
     * ["a","bb","acd","ace"]
     * @param args
     */
    public static void main(String[] args) {
        SubSequence subSequence = new SubSequence();
        String s = "abcde";
        String[] arr = {"acd"};
        int i = subSequence.numMatchingSubseq(s, arr);
        System.out.println(i);
    }
}
