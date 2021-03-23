package src.기출;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

class Temp4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        Double[] score = new Double[temp.length];
        for(int i = 0; i < temp.length; i++){
            score[i] = Double.parseDouble(temp[i]);
        }
        temp = br.readLine().split(" ");
        int x = Integer.parseInt(temp[0]);
        int y = Integer.parseInt(temp[1]);
        Content[] contents = new Content[x*y];

        int num = 0;
        for(int i = 0; i < x; i++) {
            temp = br.readLine().split("");
            for(int k = 0; k <y; k++){
                contents[num] = new Content();
                contents[num].contentState = temp[k].charAt(0);
                contents[num].x = i;
                contents[num].y = k;
                num++;
            }
        }

        num = 0;
        for(int i = 0; i < x; i++) {
            temp = br.readLine().split("");
            for(int k = 0; k <y; k++){
                contents[num].contentScore = temp[k].charAt(0);
                num++;
            }
        }

        for(Content content: contents) {
            content.score = score[content.contentScore-65];
        }

        Arrays.sort(contents);
        StringBuilder sb = new StringBuilder();
        for (Content content: contents) {
            if(content.contentState != 'W') sb.append(content.toStringBuilder()).append("\n");
        }
        System.out.println(sb);
    }
    static class Content implements Comparable<Content> {
        Character contentState;
        Character contentScore;
        Double score;
        int x;
        int y;

        String toStringBuilder() {
            return contentScore + " " + score + " " + x + " " + y;
        }

        public int compareTo(Content content) {
            if (this.contentState > content.contentState) {
                return -1;
            } else if (this.contentState == content.contentState) {
                if(this.score > content.score){
                    return -1;
                } else if(Objects.equals(this.score, content.score)){
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

}