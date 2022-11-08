package level2;

public class BinaryTransformRepeat {

    public static void main(String[] args) {

        Solution s = new Solution();
        int[] answer = s.solution("110010101001");

        System.out.println(answer[0] + ", " + answer[1]);
    }

    static class Solution {
        public int[] solution(String s) {
            int[] answer;

            int totalRemovedCount = 0;
            int currentRemovedCount = 0;
            int stringLengthAfterRemoving = 0;
            int numberOfBinaryConversions = 0;
            String currentStr = s;


            while(!currentStr.equals("1")){
                numberOfBinaryConversions++;
                currentRemovedCount = countTheNumberOfZerosRemoved(currentStr);
                totalRemovedCount += currentRemovedCount;

                stringLengthAfterRemoving = currentStr.length() - currentRemovedCount;
                currentStr = numberOfZerosRemovedConvertToBinary(stringLengthAfterRemoving);
            }

            answer = new int[]{numberOfBinaryConversions, totalRemovedCount};

            return answer;
        }


        public int countTheNumberOfZerosRemoved(String str){
            String zerosRemovedStr = str.replaceAll("0", "");
            int count = str.length() - zerosRemovedStr.length();

            return count;
        }

        public String numberOfZerosRemovedConvertToBinary(int num){
            String convertedBinaryStr = Integer.toBinaryString(num);

            return convertedBinaryStr;
        }



    }
}
