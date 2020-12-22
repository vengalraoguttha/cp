package leetcode_june_callenge;

import java.util.*;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> input = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<String> x = new ArrayList<>();
            x.add(sc.next());
            x.add(sc.next());
            input.add(x);
        }
        ReconstructItinerary r = new ReconstructItinerary();
        r.findItinerary(input);
    }

    HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    LinkedList<String> result = new LinkedList<String>();

    public List<String> findItinerary( List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                PriorityQueue<String> q = new PriorityQueue<String>();
                map.put(ticket.get(0), q);
            }
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    public void dfs(String s) {
        PriorityQueue<String> q = map.get(s);

        while (q != null && !q.isEmpty()) {
            dfs(q.poll());
        }

        result.addFirst(s);
    }
}
