class Solution {
    public boolean isPalindrome(String s) {
        StringBuffer str = new StringBuffer();
        for(char ch : s.toCharArray()){
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
                str.append(ch);
            }
        }
        s = str.toString().toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}