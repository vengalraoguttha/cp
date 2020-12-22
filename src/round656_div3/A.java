package round656_div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if(x != y && x != z && y != z){
                sb.append("NO\n");
                continue;
            }
            Map<Integer, Integer> map = new HashMap<>();
            map.put(x, 1);
            map.put(y, map.getOrDefault(y, 0) + 1);
            map.put(z, map.getOrDefault(z, 0) + 1);
            if(x != y || y != z || x != z){
                if(x != y){
                    if(x > y && map.get(x) < map.get(y)){
                        sb.append("NO\n");
                        continue;
                    }
                    if(x < y && map.get(x) > map.get(y)){
                        sb.append("NO\n");
                        continue;
                    }
                }
                if(y != z){
                    if(y > z && map.get(y) < map.get(z)){
                        sb.append("NO\n");
                        continue;
                    }
                    if(y < z && map.get(y) > map.get(z)){
                        sb.append("NO\n");
                        continue;
                    }
                }
                if(x != z){
                    if(x > z && map.get(x) < map.get(z)){
                        sb.append("NO\n");
                        continue;
                    }
                    if(x < z && map.get(x) > map.get(z)){
                        sb.append("NO\n");
                        continue;
                    }
                }
            }
            sb.append("YES\n");
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            list.add(z);
            list.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            sb.append(list.get(0)).append(" ").append(list.get(2)).append(" ").append(list.get(2)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
