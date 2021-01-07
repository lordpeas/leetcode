import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses2 {


        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generateAll(new StringBuilder(),0,0,n,result);
            return result;
        }


        public void generateAll(StringBuilder builder,int open,int close,int max, List<String> result) {
            if(builder.length()==2*max){
                result.add(builder.toString());
            }

            if(open<max){
                builder.append("(");
                generateAll(builder,open+1,close,max,result);
                builder.deleteCharAt(builder.length()-1);
            }

            if(close<open){
                builder.append(")");
                generateAll(builder,open,close+1,max,result);
                builder.deleteCharAt(builder.length()-1);
            }
        }


    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        if(n<1) return res;
        backtrack("",n,n,res);
        return res;
    }

    public void backtrack(String curStr,int left,int right,List<String> res){
        if(left==0 && right==0){
            res.add(curStr);
            return ;
        }
        if(left>0){
            //left--; 注意一定不能这么写，如果这么写的话，后面还要写left++，否则递归回来的时候，已经不是当时的现场了。
            backtrack(curStr+"(",left-1,right,res);
        }
        if(right>left){
            backtrack(curStr+")",left,right-1,res);
        }
    }



    public static void main(String[] args) {
        List<String> strings = new GenerateParentheses2().generateParenthesis2(2);
        System.out.println(strings);
    }

}
