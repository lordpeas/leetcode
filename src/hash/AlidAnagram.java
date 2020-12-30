package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class AlidAnagram {


    class Solution {

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] table = new int[26];
            for (int i = 0; i < s.length(); i++) {
                table[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                table[t.charAt(i) - 'a']--;
                if (table[t.charAt(i) - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] tables = new int[58];
        for (int i = 0; i < s.length(); i++) {
            tables[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tables[t.charAt(i) - 'A']--;
            if (tables[t.charAt(i) - 'A'] < 0) {
                return false;
            }
        }

        return true;
    }


    public boolean isAnagramByArray(String s, String t) {
        if (null == s || null == t) {
            return false;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] ss = s.toCharArray();

        char[] ts = t.toCharArray();

        Arrays.sort(ss);
        Arrays.sort(ts);

        if (Arrays.equals(ss, ts)) {
            return true;
        }
        return false;
    }

    public boolean isAnagramByArrayHash(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> table = new HashMap<>();
        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();
        for (int i = 0; i < ss.length; i++) {
            table.put(ss[i], table.getOrDefault(ss[i], 0) + 1);
        }

        for (int i = 0; i < ts.length; i++) {
            Integer c = table.get(ts[i]);
            if (c != null) {
                table.put(ts[i],--c);
                if (c < 0) {
                    return false;
                }
            } else {
                return false;
            }


        }
        return true;
    }


    public static void main(String[] args) {
        int i = 'a' - 0;
        System.out.println(i);
    }
}
