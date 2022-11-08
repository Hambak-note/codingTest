package level2;

import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution("CBD", new String[]{"CED"});
        System.out.println(answer);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            boolean availability = false;

            Queue<Character> skillQueue = new LinkedList<Character>();

            for(String treesValue : skill_trees){

                for(int i = 0; i < skill.length(); i++){
                    skillQueue.add(skill.charAt(i));
                }

                availability = true;
                for(int i = 0; i < treesValue.length(); i++){
                    char temp = treesValue.charAt(i);

                    if(skillQueue.contains(temp)
                            && skillQueue.peek() != temp){
                        availability = false;
                        break;
                    }

                    if(skillQueue.contains(temp)
                            && skillQueue.peek() == temp){
                        skillQueue.remove();
                    }
                }

                skillQueue.clear();

                if(availability) answer++;
            }

            return answer;
        }
    }
}

