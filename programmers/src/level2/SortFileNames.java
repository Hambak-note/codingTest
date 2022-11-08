package level2;

import java.util.Arrays;
import java.util.Comparator;

public class SortFileNames {

    public static void main(String[] args) {

    }

}

class Solution {

    static class File{
        String fileName;
        String head;
        int number;

        public File(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }
    }


    public String[] solution(String[] files) {
        String[] answer = {};

        File[] fileArr = new File[files.length];

        for(int i = 0; i < files.length; i++){
            String[] splitedFileName = splitFileName(files[i]);
            fileArr[i] = new File(files[i], splitedFileName[0], Integer.parseInt(splitedFileName[1]));
        }

        Arrays.sort(fileArr, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if((o1.head).equals(o2.head)){
                    return o1.number - o2.number;
                } else{
                    return (o1.head).compareTo(o2.head);
                }
            }
        });

        answer = new String[files.length];
        for(int i = 0; i < files.length; i++){
            answer[i] = fileArr[i].fileName;
        }
        return answer;
    }
    public static String[] splitFileName(String file){
        String str[] = new String[3];

        for(int i = 0; i < 3; i++){
            str[i] = "";
        }

        int index = 0;
        for(int i = 0; i < file.length(); i++){

            char c = file.charAt(i);

            if(index == 0 && !Character.isDigit(c)){
                str[index] += c;
                continue;
            }

            if(index==0 && Character.isDigit(c)){
                index++;
            }

            if(index==1 && Character.isDigit(c)){
                str[index] += c;
                continue;
            }

            if(index==1 && !Character.isDigit(c)){
                index++;
            }

            str[index] += c;
        }

        str[0] = str[0].toLowerCase();

        return str;
    }
}
