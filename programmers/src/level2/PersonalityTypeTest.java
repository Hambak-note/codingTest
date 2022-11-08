package level2;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTypeTest {

    public static void main(String[] args) {
        Solution s= new Solution();

        s.solution(new String[]{"ab", "cd"}, new int[]{1, 2, 3});
    }


}

class Solution {

    private final int veryDisagree = 1;
    private final int disagree = 2;
    private final int slightlyDisagree = 3;
    private final int notKnow = 4;
    private final int slightlyAgree = 5;
    private final int agree = 6;
    private final int veryAgree = 7;

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<Character, Integer> personalityTypeMap = initializePersonalityTypeMap();

        for(int i = 0; i < survey.length; i++){

            char disagreeChar = survey[i].charAt(0);
            char agreeChar = survey[i].charAt(1);

            if(choices[i] == veryDisagree){
                personalityTypeMap.put(disagreeChar, personalityTypeMap.getOrDefault(disagreeChar, 0)+3);
            }
            if(choices[i] == disagree){
                personalityTypeMap.put(disagreeChar, personalityTypeMap.getOrDefault(disagreeChar, 0)+2);
            }
            if(choices[i] == slightlyDisagree){
                personalityTypeMap.put(disagreeChar, personalityTypeMap.getOrDefault(disagreeChar, 0)+1);
            }
            if(choices[i] == slightlyAgree){
                personalityTypeMap.put(agreeChar, personalityTypeMap.getOrDefault(agreeChar, 0)+1);
            }
            if(choices[i] == agree){
                personalityTypeMap.put(agreeChar, personalityTypeMap.getOrDefault(agreeChar, 0)+2);
            }
            if(choices[i] == veryAgree){
                personalityTypeMap.put(agreeChar, personalityTypeMap.getOrDefault(agreeChar, 0)+3);
            }
        }

        answer = calculateTestResult(personalityTypeMap);


        return answer;
    }

    public Map<Character, Integer> initializePersonalityTypeMap(){
        Map<Character, Integer> personalityTypeMap = new HashMap<>();

        personalityTypeMap.put('R', 0);
        personalityTypeMap.put('T', 0);
        personalityTypeMap.put('C', 0);
        personalityTypeMap.put('F', 0);
        personalityTypeMap.put('J', 0);
        personalityTypeMap.put('M', 0);
        personalityTypeMap.put('A', 0);
        personalityTypeMap.put('N', 0);

        return personalityTypeMap;
    }

    public String calculateTestResult(Map<Character, Integer> personalityTypeMap){
        String testResult = "";
        int rScore = personalityTypeMap.get('R');
        int tScore = personalityTypeMap.get('T');
        int cScore = personalityTypeMap.get('C');
        int fScore = personalityTypeMap.get('F');
        int jScore = personalityTypeMap.get('J');
        int mScore = personalityTypeMap.get('M');
        int aScore = personalityTypeMap.get('A');
        int nScore = personalityTypeMap.get('N');

        if(rScore >= tScore) {
            testResult += 'R';
        }else{
            testResult += 'T';
        }

        if(cScore >= fScore) {
            testResult += 'C';
        }else{
            testResult += 'F';
        }

        if(jScore >= mScore) {
            testResult += 'J';
        }else{
            testResult += 'M';
        }

        if(aScore >= nScore) {
            testResult += 'A';
        }else{
            testResult += 'N';
        }

        return testResult;
    }
}