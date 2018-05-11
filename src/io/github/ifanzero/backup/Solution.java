package io.github.ifanzero.backup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{1, 2};
                }
            }
        }
        return new int[2];
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = new ListNode(5);
//            l1.next = new ListNode(4);
//            l1.next.next = new ListNode(3);
        l2 = new ListNode(5);
//            l2.next = new ListNode(6);
//            l2.next.next = new ListNode(4);

        ListNode result = null;
        ListNode nextNode = null;

        int sum = l1.val + l2.val;
        int promotion = sum / 10;
        sum = sum - promotion * 10;
        result = new ListNode(sum);


        int i = 0;
        int j = 0;
        while (l1.next != null || l2.next != null || promotion > 0) {
            if (l1.next == null) {
                i = 0;
            } else {
                l1 = l1.next;
                i = l1.val;
            }
            if (l2.next == null) {
                j = 0;
            } else {
                l2 = l2.next;
                j = l2.val;
            }
            sum = i + j + promotion;
            promotion = sum / 10;
            sum = sum - promotion * 10;
            if (nextNode == null) {
                nextNode = new ListNode(sum);
                result.next = nextNode;
            } else {
                nextNode.next = new ListNode(sum);
                nextNode = nextNode.next;
            }
        }
        return result;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[] lengthMax = new int[length];
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            int lastPositionOfChar = map[s.charAt(i)];
            if (lastPositionOfChar == -1) {
                lengthMax[i] = i == 0 ? 1 : lengthMax[i - 1] + 1;
                map[s.charAt(i)] = i;
            } else {
                int aPos = lastPositionOfChar + 1;
                int unRepeatLen = lengthMax[i - 1];
                int bPos = i - unRepeatLen;
                if (aPos >= bPos) {
                    lengthMax[i] = i - aPos + 1;
                } else {
                    lengthMax[i] = i - bPos + 1;
                }
                map[s.charAt(i)] = i;
            }
        }
        int max = lengthMax[0];
        for (int i : lengthMax) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int[] list = new int[256];
        int previous = -1, right = 0, max_len = 0;
        for (int i = 0; i < list.length; i++) {
            list[i] = -1;
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (list[(int) c] > previous)
                previous = list[(int) c];
            max_len = Math.max(max_len, right - previous);
            list[(int) c] = right++;
        }
        return max_len;
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] nums3 = new int[length3];
//        int[] longer;
//        int length=0;
//        if (length1 >= length2) {
//            length = length2;
//            longer = nums1;
//        }else{
//            length = length1;
//            longer = nums2;
//        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < length3; i++) {
            if (a >= length1) {
                for (int v = b, x = 0; v < length2; v++, x++) {
                    nums3[i + x] = nums2[v];
                }
                break;
            }
            if (b >= length2) {
                for (int v = a, x = 0; v < length1; v++, x++) {
                    nums3[i + x] = nums1[v];
                }
                continue;
            }
            if (nums1[a] >= nums2[b]) {
                nums3[i] = nums2[b];
                b++;
            } else {
                nums3[i] = nums1[a];
                a++;
            }
        }
//        System.arraycopy(longer, length, nums3, length + length, longer.length - length);

        if (length3 % 2 == 0) {
            return (nums3[length3 / 2] + nums3[length3 / 2 - 1]) / 2.0;
        } else {
            return nums3[length3 / 2] * 1.0;
        }
    }

    public String longestPalindrome(String str) {
        s = str;
        preprocess();
        p = new int[t.length];

        int mid = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * mid - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                mid = i;
                right = i + p[i];
            }
        }

        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    private void preprocess() {
        t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
    }

    private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
    private String s;  // original string
    private char[] t;  // transformed


    public String longestPalindrome1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] range = new int[]{0, 1};
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            i = helper(c, i, range);
        }
        return s.substring(range[0], range[1]);
    }

    public int helper(char[] c, int index, int[] range) {
        int low = index, hi = index;
        while (hi < c.length - 1 && c[hi] == c[hi + 1]) hi++;
        int reset = hi;
        while (low - 1 >= 0 && hi + 1 < c.length && c[hi + 1] == c[low - 1]) {
            hi++;
            low--;
        }
        if (hi - low + 1 > range[1] - range[0]) {
            range[0] = low;
            range[1] = hi + 1;
        }
        return reset;
    }


    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        Map<Integer, Integer> sumsMap = new HashMap<>();
        sumsMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += sumsMap.get(sum - k) == null ? 0 : sumsMap.get(sum - k);
            sumsMap.put(sum, sumsMap.get(sum) == null ? 1 : sumsMap.get(sum) + 1);
        }
        int result = 0;
       /* for (int i=0;i<sums.length;i++){
          *//*  if (sums[i]-k<0){
                continue;
            }*//*

            if (sums[i]-k==0||(sumsMap.get(sums[i]-k)!=null&&sumsMap.get(sums[i]-k)<i)){
                result++;
            }
        }*/
        return res;

    }

    public String convert(String s, int numRows) {
        int[][] nums = new int[numRows][s.length() / numRows + numRows * 10];
        boolean downFlag = true;
        int j = 0;
        int m = 0;
        int col = 0;
        if (numRows == 1) {
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            if (downFlag || numRows == 2) {
                if (j < numRows) {
                    nums[j][m] = s.charAt(i);
                }
                j++;
                if (j == numRows) {
                    if (numRows > 2) {
                        downFlag = false;
                        col = m + 1;
                    } else {
                        j = 0;
                    }
                    m += numRows - 1;
                }
            } else {
                j--;
                nums[j - 1][col++] = s.charAt(i);
                if (j == 2) {
                    j = 0;
                    downFlag = true;
                }
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        for (int p = 0; p < numRows; p++) {
            for (int i = 0; i < s.length() / numRows + numRows + 1; i++) {
                System.out.print((char) nums[p][i]);
                if (nums[p][i] != 0) {
                    stringBuffer.append((char) nums[p][i]);
                }
            }
            System.out.println("");
        }
        return stringBuffer.toString();
    }


    public String convert1(String s, int numRows) {
        int len = s.length();
        int nodeLen = 2 * numRows - 2;//两整列之间的差 也就是等差数列中的d
        String result = "";

        if (len == 0 || numRows == 0 || numRows == 1)//特殊情况特殊处理
            return s;

        for (int i = 0; i < numRows; i++)//从第一行遍历到最后一行
            for (int j = i; j < len; j += nodeLen) {
                result += s.charAt(j);//第一行和最后一行 还有普通行的整列数字
                if (i != 0 && i != numRows - 1 && j - 2 * i + nodeLen < len)
                    result += s.charAt(j - 2 * i + nodeLen);//单列行的数字
            }

        return result;
    }

    public int reverse(int x) {
        boolean negtive = false;
        if (x < 0) {
            x = 0 - x;
        }

        String xStr = Integer.toString(x);
        char[] result = new char[xStr.length()];
        for (int i = 0, j = xStr.length() - 1; i < xStr.length() && j >= 0; i++, j--) {
            result[i] = xStr.charAt(j);
        }
        int offset = 0;
        for (int i = 0; i < xStr.length(); i++) {
            if (result[i] != 0) {
                offset = i;
                break;
            }
        }
        char[] finalre = Arrays.copyOfRange(result, offset, xStr.length());
        String finalStr = new String(finalre);
        int y;
        try {
            y = Integer.parseInt(finalStr);
        } catch (NumberFormatException e) {
            y = 0;
        }

        if (negtive) {
            y = 0 - y;
        }

        return y;
    }

    public int reverse1(int x) {
        boolean negative = x < 0;
        if (negative) {
            x = -x;
        }
        long r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (negative) {
            r = -r;
        }
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) r;
    }

    public int myAtoi(String str) {

        int len = str.length();
        int st = 0;

        while ((st < len) && (str.charAt(st) <= ' ')) {
            st++;
        }
        if (st>=len){
            return 0;
        }
        boolean negative = str.charAt(st) == '-';
        if ((str.charAt(st) >= '0' && str.charAt(st) <= '9') || str.charAt(st) == '+' || str.charAt(st) == '-') {

            int i = st;
            if ((str.charAt(i) >= '0' && str.charAt(i) <= '9')){

            }else {
                i++;
            }
            long  r=0;
            int firstNo0 = -1;
            while ((i < len) && (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                r=r*10+(int)str.charAt(i)-48;
                if (firstNo0==-1&&str.charAt(i)!='0'){
                    firstNo0=i;
                }
                i++;
            }
            if (firstNo0!=-1&&i-firstNo0>10){
                if (negative){
                    return Integer.MIN_VALUE;
                }else {
                    return Integer.MAX_VALUE;
                }
            }
            if (negative){
                r=-r;
            }
            if (r > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (r < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            return (int) r;
        } else {
            return 0;
        }


    }
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        long r = 0;
        int temp = x;
        while (x > 0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        return (int) r == temp;
    }

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if (slen == 0 && plen == 0) return true;

        char c0 = getChar(s, 0);
        char p0 = getChar(p, 0), p1 = getChar(p, 1);

        if (match(c0, p0) || p1 == '*') {
            if (p1 != '*') {
                if (slen == 0) return false;
                return isMatch(s.substring(1), p.substring(1));
            }
            // if p1 is *, * means 0 ~ n
            int i = 0;
            boolean ret = isMatch(s.substring(0), p.substring(2)); // try 0
            if (ret) return ret;
            while (i < slen && match(getChar(s, i), p0)) {
                ret = isMatch(s.substring(i+1), p.substring(2)); // try for every available position
                if (ret) return ret;
                i++;
            }
        }

        return false;
    }

    private boolean match(char a, char b) {
        return a == b || b == '.';
    }

    private char getChar(String s, int p) {
        if (s.length() > p) {
            return s.charAt(p);
        }
        return 0;
    }

    public String intToRoman(int num) {
        int z;
        String single;
        String result="";
        int weight=0;
        while(num>0){
            z=num%10;
            weight++;
            single=singelIntToRoman(z,weight);
            result=single+result;
            num=num/10;
        }
        return result;
    }

    private String singelIntToRoman(int z,int weight) {
        if (weight==1){
            if (z==1){
                return "I";
            }if (z==2){
                return "II";
            }if (z==3){
                return "III";
            }
            if (z==4){
                return "IV";
            }
            if (z==5){
                return "V";
            }
            if (z==6){
                return "VI";
            }
            if (z==7){
                return "VII";
            }
            if (z==8){
                return "VIII";
            }
            if (z==9){
                return "IX";
            }
        }
        if (weight==2){
            if (z==1){
                return "X";
            }
            if (z==2){
                return "XX";
            }
            if (z==3){
                return "XXX";
            }
            if (z==4){
                return "XL";
            }
            if (z==5){
                return "L";
            }
            if (z==6){
                return "LX";
            }
            if (z==7){
                return "LXX";
            }
            if (z==8){
                return "LXXX";
            }
            if (z==9){
                return "XC";
            }
        }
        if (weight==3){
            if (z==1){
                return "C";
            }
            if (z==2){
                return "CC";
            }
            if (z==3){
                return "CCC";
            }
            if (z==4){
                return "CD";
            }
            if (z==5){
                return "D";
            }
            if (z==6){
                return "DC";
            }
            if (z==7){
                return "DCC";
            }
            if (z==8){
                return "DCCC";
            }
            if (z==9){
                return "CM";
            }
        }
        if (weight==4){
            if (z==1){
                return "M";
            }
            if (z==2){
                return "MM";
            }
            if (z==3){
                return "MMM";
            }
            if (z==4){
                return "MV";
            }
            if (z==5){
                return "V";
            }
        }
        return "";
    }

    public static void main(String[] args) {
        /*[2,4,3]
        [5,6,4]*/
        Solution solution = new Solution();
        solution.intToRoman( 3);
//        solution.reverse1(555555559);
//        solution.convert1("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",3);
//        solution.longestPalindrome1("babad");
//        solution.subarraySum(new int[]{1, 1, 1}, 2);
//        solution.findMedianSortedArrays(new int[]{1,2},new int[]{3,4});
//        solution.addTwoNumbers(null, null);
    }
   /* public void newZ(){
        new Z();
    }
    class X{
        Y y = new Y();
        public X(){
            System.out.print("X");
        }
    }
    class Y{
        public Y(){
            System.out.print("Y");
        }
    }
    class Z extends X{
        Y y = new Y();
        public Z(){
            System.out.print("Z");
        }
    }*/
}
