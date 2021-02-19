package leetCode;

public class DefangingAnIPAddress {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.defangIPaddr("1.1.1.1"));
    }

    static class Solution {
        public String defangIPaddr(String address) {
            String[] addrs = address.split("\\.");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < addrs.length; i++){
                if(i == addrs.length-1){
                    sb.append(addrs[i]);
                }else{
                    sb.append(addrs[i]).append("[.]");
                }
            }
            return sb.toString();
        }
    }
}
