package level2;

public class TwoOrLessDifferentBits {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new long[]{2,7});
    }

    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] % 4 == 3){
                    answer[i] = f(numbers[i]);
                }
                else{
                    answer[i] = numbers[i]+1;
                }
            }

            return answer;
        }

        public long f(long x){

            long total=0;
            String temp="";
            boolean flag=false;

            while(x!=0){
                if(x%2==0){
                    temp+='0';
                    flag=true;
                }
                else{
                    temp+='1';
                }
                x/=2;
            }
            if(flag==false){
                temp+='0';
            }
            temp=temp.replaceFirst("10","01");


            for(int i=0;i<temp.length();i++){
                if(temp.charAt(i)=='1'){
                    total+=(long)Math.pow(2,i);
                }
            }

            return total;
        }
    }

}

