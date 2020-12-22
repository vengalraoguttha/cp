package round655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        List<Node> nodeList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            nodeList.add(new Node(arr[i]));
        }
        if(n == 1){
            System.out.println(arr[0]);
            return;
        }
        for(int i = 1; i < n - 1;i++){
            nodeList.get(i).left = nodeList.get(i - 1);
            nodeList.get(i).right = nodeList.get(i + 1);
            pq.add(nodeList.get(i));
        }
        if(n >= 2){
            nodeList.get(0).left = nodeList.get(n - 1);
            nodeList.get(0).right = nodeList.get(1);
            nodeList.get(n - 1).right = nodeList.get(0);
            nodeList.get(n - 1).left = nodeList.get(n - 2);
            pq.add(nodeList.get(0));
            pq.add(nodeList.get(n - 1));
        }

        while (pq.size() > 1){
            Node min = pq.poll();
            if(min.left == null && min.right == null) continue;
            Node leftLeft = min.left.left;
            Node rightRight = min.right.right;
            int val = min.left.value + min.right.value;
            min.left.left = null;
            min.left.right = null;
            min.right.left = null;
            min.right.right = null;
            min.value = val;
            min.left = leftLeft;
            min.right = rightRight;
            pq.add(min);
        }
        System.out.println(pq.peek().value);
    }

    static class Node{
        int value;
        Node left, right;
        public Node(int value){
            this.value = value;
        }
    }
}
