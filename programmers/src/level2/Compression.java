package level2;

import java.util.ArrayList;

public class Compression {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("KAKAO");
        s.solution("ABABABABABABABAB");
    }

    static class Solution {

        ArrayList<String> dictionary;
        ArrayList<Integer> answerList;

        public ArrayList<Integer> solution(String msg) {

            answerList = new ArrayList<>();

            initializeDictionary();
            searchDictionary(msg);

            return answerList;
        }

        public void initializeDictionary(){
            dictionary = new ArrayList<>();
            dictionary.add("더미");
            for(char c = 'A'; c <= 'Z'; c++){
                dictionary.add(String.valueOf(c));
            }
        }

        public void searchDictionary(String msg){
            if(dictionary.contains(msg)){
                answerList.add(dictionary.indexOf(msg));
                return;
            }

            String currentStr = msg.substring(0, 1);
            String nextStr;
            int index = dictionary.indexOf(currentStr);
            for(int i = 2; i <= msg.length(); i++){
                nextStr = msg.substring(0, i);

                if(dictionary.contains(nextStr)){
                    currentStr = nextStr;
                    index = dictionary.indexOf(nextStr);
                    continue;
                }
                dictionary.add(nextStr);
                answerList.add(index);
                String nextMsg = msg.substring(i-1, msg.length());
                searchDictionary(nextMsg);
                break;
            }
        }

    }


}


