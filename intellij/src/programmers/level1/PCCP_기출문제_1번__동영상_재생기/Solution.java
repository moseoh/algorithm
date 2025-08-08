package src.programmers.level1.PCCP_기출문제_1번__동영상_재생기;

class Solution {
    public static void main(String[] args) {
        String video_len1 = "34:33";
        String pos1 = "13:00";
        String op_start1 = "00:55";
        String op_end1 = "02:55";
        String[] commands1 = new String[]{"next", "prev"};
        String answer1 = "13:00";
        String result1 = new Solution().solution(video_len1, pos1, op_start1, op_end1, commands1);
        PRINT_RESULT(1, result1, answer1);

        String video_len2 = "10:55";
        String pos2 = "00:05";
        String op_start2 = "00:15";
        String op_end2 = "06:55";
        String[] commands2 = new String[]{"prev", "next", "next"};
        String answer2 = "06:55";
        String result2 = new Solution().solution(video_len2, pos2, op_start2, op_end2, commands2);
        PRINT_RESULT(2, result2, answer2);

        String video_len3 = "07:22";
        String pos3 = "04:05";
        String op_start3 = "00:15";
        String op_end3 = "04:07";
        String[] commands3 = new String[]{"next"};
        String answer3 = "04:17";
        String result3 = new Solution().solution(video_len3, pos3, op_start3, op_end3, commands3);
        PRINT_RESULT(3, result3, answer3);
    }

    public static void PRINT_RESULT(int index, String result, String answer) {
        boolean correct = result.equals(answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) {
            System.out.println(sb);
        } else {
            throw new RuntimeException(sb.toString());
        }
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        VideoPlayer videoPlayer = new VideoPlayer("00:00", video_len, op_start, op_end, pos);
        for (String command : commands) {
            videoPlayer.command(command);
        }
        return videoPlayer.getPos().toString();
    }

}

class VideoPlayer {
    private final int   moveSeconds = 10;
    private final Clock videoStart;
    private final Clock videoEnd;
    private final Clock opStart;
    private final Clock opEnd;
    private final Clock pos;

    public VideoPlayer(String videoStartTime, String videoEndTime, String opStartTime, String opEndTime, String pos) {
        this.videoStart = new Clock(videoStartTime);
        this.videoEnd = new Clock(videoEndTime);
        this.opStart = new Clock(opStartTime);
        this.opEnd = new Clock(opEndTime);
        this.pos = new Clock(pos);
        adjust();
    }

    public Clock getPos() {
        return this.pos;
    }

    public void command(String command) {
        switch (command) {
            case "next" -> next();
            case "prev" -> prev();
            default -> throw new RuntimeException("invalid command");
        }
    }

    public void next() {
        this.pos.addSeconds(moveSeconds);
        adjust();
    }

    public void prev() {
        this.pos.minusSeconds(moveSeconds);
        adjust();
    }

    private void adjust() {
        adjustOp();
        adjustVideoLen();
    }

    private void adjustOp() {
        if (this.pos.before(this.opEnd) && this.pos.after(this.opStart)) {
            this.pos.setClock(this.opEnd);
        }
    }

    private void adjustVideoLen() {
        if (this.pos.after(this.videoEnd)) {
            this.pos.setClock(this.videoEnd);
        } else if (this.pos.before(this.videoStart)) {
            this.pos.setClock(this.videoStart);
        }
    }
}

class Clock {
    private int minutes;
    private int seconds;

    public Clock(String time) {
        String[] times = time.split(":");
        this.minutes = Integer.parseInt(times[0]);
        this.seconds = Integer.parseInt(times[1]);
    }

    public void setClock(Clock clock) {
        this.minutes = clock.minutes;
        this.seconds = clock.seconds;
    }

    public void addSeconds(int addSeconds) {
        assert addSeconds >= 0;

        this.seconds += addSeconds;
        if (this.seconds / 60 > 0) {
            this.minutes += this.seconds / 60;
            this.seconds %= 60;
        }
    }

    public void minusSeconds(int minusSeconds) {
        assert minusSeconds < 0;

        this.seconds -= minusSeconds;
        while (this.seconds < 0) {
            this.minutes -= 1;
            this.seconds += 60;
        }

        if (this.minutes < 0) {
            this.minutes = 0;
            this.seconds = 0;
        }
    }

    public boolean before(Clock clock) {
        if (this.minutes < clock.minutes) {
            return true;
        }

        return this.minutes == clock.minutes && this.seconds <= clock.seconds;
    }

    public boolean after(Clock clock) {
        if (this.minutes > clock.minutes) {
            return true;
        }

        return this.minutes == clock.minutes && this.seconds >= clock.seconds;
    }

    public String toString() {
        return String.format("%02d:%02d", this.minutes, this.seconds);
    }
}