package level2;

public class JustThatSong {

    public static void main(String[] args) {
        Solution s = new Solution();
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer;
        answer = s.solution(m, musicinfos);
        System.out.println(answer);

        m = "CC#BCC#BCC#BCC#B";
        musicinfos = new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        answer = s.solution(m, musicinfos);
        System.out.println(answer);



    }

    static class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "(None)";

            String changedM = changeSheetMusic(m);

            int longestPlayTIme = -1;

            for(int i = 0; i < musicinfos.length; i++){

                String startTime;
                String endTime;
                int playTime;
                String title;
                String sheetMusic;
                String playedMusic;
                boolean matched;

                String[] musicInfo;

                musicInfo = musicinfos[i].split(",");
                startTime = musicInfo[0];
                endTime = musicInfo[1];
                title = musicInfo[2];

                playTime = calculatePlayTime(startTime, endTime);

                sheetMusic = changeSheetMusic(musicInfo[3]);

                playedMusic = makePlayedMusic(playTime, sheetMusic);

                matched = playedMusic.contains(changedM);

                if(matched && playTime > longestPlayTIme){
                    longestPlayTIme = playTime;
                    answer = title;
                }
            }

            return answer;
        }

        public String changeSheetMusic(String SheetMusic){

            String changedSheetMusic;

            changedSheetMusic = SheetMusic.replace("C#", "c");
            changedSheetMusic = changedSheetMusic.replace("D#", "d");
            changedSheetMusic = changedSheetMusic.replace("F#", "f");
            changedSheetMusic = changedSheetMusic.replace("G#", "g");
            changedSheetMusic = changedSheetMusic.replace("A#", "a");

            return changedSheetMusic;
        }

        public String makePlayedMusic(int playTime, String sheetMusic) {

            String playedMusic = "";
            int remainPlayTime;

            if(playTime == sheetMusic.length()) return sheetMusic;
            else if(playTime > sheetMusic.length()){
                remainPlayTime = playTime - sheetMusic.length();
                playedMusic = sheetMusic + makePlayedMusic(remainPlayTime, sheetMusic);
            }
            else if(playTime < sheetMusic.length()){
                playedMusic =  sheetMusic.substring(0, playTime);
            }

            return playedMusic;
        }

        public int calculatePlayTime(String startTime, String endTime){

            int startHour;
            int startMin;
            int endHour;
            int endMin;
            int playTime;

            String[] time = startTime.split(":");
            startHour = Integer.parseInt(time[0]);
            startMin = Integer.parseInt(time[1]);

            time = endTime.split(":");
            endHour = Integer.parseInt(time[0]);
            endMin = Integer.parseInt(time[1]);


            playTime = (endHour * 60 +endMin) - (startHour*60 + startMin);
            return playTime;
        }
    }
}
