package leetcode_july_challenge;

import java.util.Arrays;

public class P3 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells.length == 0) return cells;
        if(cells.length == 1){
            cells[0] = 0;
            return cells;
        }
        if(cells.length == 2){
            cells[0] = 0;
            cells[1] = 0;
            return cells;
        }
        int[] initial = Arrays.copyOf(cells, cells.length);
        int[] c = Arrays.copyOf(cells, cells.length);
        for(int i = 1; i <= N; i++){
            int[] copy = Arrays.copyOf(cells, cells.length);
            copy[0] = 0;
            copy[copy.length - 1] = 0;
            for(int j = 1; j < cells.length - 1; j++){
                if((cells[j - 1] == 0 && cells[j + 1] == 0) ||
                        (cells[j - 1] == 1 && cells[j + 1] == 1)){
                    copy[j] = 1;
                }else {
                    copy[j] = 0;
                }
            }
            for(int j = 0; j < cells.length; j++){
                cells[j] = copy[j];
            }
            boolean same = true;
            for(int j = 0; j < cells.length; j++){
                if(c[j] != cells[j]){
                    same = false;
                    break;
                }
            }
            if(same){
                N = N % i;
            }

            if(i == 1){
                c = Arrays.copyOf(copy, copy.length);
            }
        }

        for(int j = 0; j < cells.length; j++){
            cells[j] = initial[j];
        }

        for(int i = 1; i <= N; i++){
            int[] copy = Arrays.copyOf(cells, cells.length);
            copy[0] = 0;
            copy[copy.length - 1] = 0;
            for(int j = 1; j < cells.length - 1; j++){
                if((cells[j - 1] == 0 && cells[j + 1] == 0) ||
                        (cells[j - 1] == 1 && cells[j + 1] == 1)){
                    copy[j] = 1;
                }else {
                    copy[j] = 0;
                }
            }
            for(int j = 0; j < cells.length; j++){
                cells[j] = copy[j];
            }
        }

        return cells;
    }
}
