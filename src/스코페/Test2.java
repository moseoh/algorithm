package src.스코페;

import java.io.*;

class Map {
    String from;
    String to;
    int resource;

    public Map(String from, String to, int resource) {
        this.from = from;
        this.to = to;
        this.resource = resource;
    }
}

class Main2 {
    static int N;
    static Map[] maps;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new Map[N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            maps[i] = new Map(temp[0], temp[1], Integer.parseInt(temp[2]));
        }


        for (int i = 0; i < N; i++) {
            System.out.println(maps[i].from + " " + maps[i].to + " " + maps[i].resource);
        }
    }
}