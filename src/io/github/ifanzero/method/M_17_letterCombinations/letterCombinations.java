package io.github.ifanzero.method.M_17_letterCombinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Ifan
 * @url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class letterCombinations {
    public List<String> letterCombinations(String digits) {
        int dis  = 'a'-'2'-1;

        int length = digits.length();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            strings.add(String.valueOf(++dis+digits.charAt(i)));
            strings.add(String.valueOf(++dis+digits.charAt(i)));
            strings.add(String.valueOf(++dis+digits.charAt(i)));

        }
        return null;
    }

    public List<String> letterCombinations1(String digits) {
       String [] map = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] select = new String[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            int phone = digits.charAt(i)-'0';
            select[i]=map[phone];
        }
        List<String> strings = new ArrayList<>();
        StringBuilder tmp=new StringBuilder();
        recruise(strings,tmp,digits,map,0);
        return strings;
    }
    private void recruise(List<String> strings,StringBuilder tmp,String digits,String[] map,int level){
        if (level==digits.length()){
            if (tmp.length()>0){
                strings.add(tmp.toString());
            }
            return;
        }
        int index = digits.charAt(level)-'0';
        for(int i = 0; i < map[index].length(); ++i)
        {
            tmp.append(map[index].charAt(i));
            recruise(strings,tmp,digits,map,level+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }

    @Test
    public void test(){
        List<String>  strings = letterCombinations1("23");
        System.out.println(strings);
    }
}
