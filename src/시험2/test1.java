package src.시험2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * test1
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-09
 */
public class test1 {
    public static void main(String[] args) {
        String code = "012345";
        String day = "20190620";
        String[] data = {"price=80 code=987654 time=2019062113", "price=90 code=012345 time=2019062014", "price=120 code=987654 time=2019062010", "price=110 code=012345 time=2019062009", "price=95 code=012345 time=2019062111"};
        System.out.println(Arrays.toString(new Solution().solution(code, day, data)));
    }

    static class Solution {
        class Stock implements Comparable<Stock> {
            String price;
            String time;

            @Override
            public int compareTo(Stock o) {
                return (this.time.compareTo(o.time));
            }

            public Stock(String price, String time) {
                this.price = price;
                this.time = time;
            }
        }

        public int[] solution(String code, String day, String[] data) {
            List<Stock> list = new ArrayList<>();

            for (String datum : data) {
                String[] item = datum.split(" ");
                String itemPrice = item[0].substring(item[0].indexOf("=") + 1);
                String itemCode = item[1].substring(item[1].indexOf("=") + 1);
                String itemTime = item[2].substring(item[2].indexOf("=") + 1);

                if (code.equals(itemCode) && day.equals(itemTime.substring(0, 8))) {
                    list.add(new Stock(itemPrice, itemTime));
                }
            }

            Collections.sort(list);
            int size = list.size();
            int[] answer = new int[size];

            for (int i = 0; i < size; i++)
                answer[i] = Integer.parseInt(list.get(i).price);

            return answer;
        }
    }
}
