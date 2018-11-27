package leetcode;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public List<Integer> getRow(int rowIndex) {
        int[] olds = new int[]{1};
        int[] news;
        while(rowIndex > 0) {
            news = new int[olds.length + 1];
            news[0] = 1;
            news[news.length - 1] = 1;
            for(int i = 1; i < news.length - 2; i++) {
                news[i] = olds[i] + olds[i - 1];
            }
            olds = news;
            rowIndex--;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < olds.length; i++) {
            list.add(olds[i]);
        }
        return list;
    }
}
