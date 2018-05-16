package io.github.ifanzero.method;

public class longest_common_prefix_14_S {
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length==0){
            return "";
        }
        if (length==1){
            return strs[0];
        }
        int[] keymap = new int[1000];
        int longestCommon = 0;
        int[] count = new int[1000];
        for (int i = 0; i <length; i++) {
            String str = strs[i];
            for (int j = 0; j <str.length() ; j++) {
                if (i==0){
                    keymap[j]=str.charAt(j);
                }else {
                    if ( keymap[j]==str.charAt(j)){
                        count[j]++;
                    }else {
                        continue;
                    }
                }
            }
        }
        String str = strs[0];
        for (int i = 0; i <str.length(); i++){
            if (count[i]==length-1){
                longestCommon++;
            }else {
                break;
            }
        }

        return str.substring(0,longestCommon);
    }

    public static String longestCommonPrefix1(String[] strs) {
        if(strs.length==0)return "";
        String pre=strs[0];
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(pre)!=0){
                pre=pre.substring(0,pre.length()-1);
                if(pre.isEmpty())return "";
            }

        }
        return pre;
    }


}
