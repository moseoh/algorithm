package programmers.코딩테스트_고득점_Kit.해시;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        Solution s = new Solution();
        System.out.println(s.solution(genres, plays));
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            Map<String, Genre> map = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                Genre temp = map.getOrDefault(genres[i], new Genre());
                temp.plays += plays[i];
                temp.musics.add(new Music(i, plays[i]));
                map.put(genres[i], temp);
            }

            List<Map.Entry<String, Genre>> genreList = new ArrayList<Map.Entry<String, Genre>>(map.entrySet());
            Collections.sort(genreList, new Comparator<Map.Entry<String, Genre>>() {
                @Override
                public int compare(Map.Entry<String, Genre> o1, Map.Entry<String, Genre> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }

            });
            for (Genre genre : map.values()) {
                Collections.sort(genre.musics);
            }

            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < genreList.size(); i++) {
                for (int j = 0; j < genreList.get(i).getValue().musics.size(); j++) {
                    if (j == 2) {
                        break;
                    }
                    answer.add(genreList.get(i).getValue().musics.get(j).index);
                }
            }
            return answer.stream().mapToInt(i -> i).toArray();
        }

        class Genre implements Comparable<Genre> {
            int plays;
            List<Music> musics;

            Genre() {
                this.plays = 0;
                this.musics = new ArrayList<>();
            }

            @Override
            public int compareTo(Genre o) {
                return o.plays - this.plays;
            }
        }

        class Music implements Comparable<Music> {
            int index;
            int plays;

            Music(int index, int plays) {
                this.index = index;
                this.plays = plays;
            }

            @Override
            public int compareTo(Music o) {
                return o.plays - this.plays;
            }

            @Override
            public String toString() {
                return index + " " + plays;
            }
        }
    }
}