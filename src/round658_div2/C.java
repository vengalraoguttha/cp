package round658_div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder ss = new StringBuilder();
        // code goes here
        int t = nextInt(br);
        while (t-- > 0){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            int n = nextInt(br);
            StringBuilder a = new StringBuilder(br.readLine());
            StringBuilder b = new StringBuilder(br.readLine());
            boolean same = true;

            Node head = new Node();
            head.ch = a.charAt(0);
            head.index = 0;
            Node ptr = head;
            for(int i = 1; i < n; i++){
                Node current = new Node();
                current.ch = a.charAt(i);
                current.index = i;
                ptr.next = current;
                current.previous = ptr;
                ptr = current;
            }

            Node end = ptr;

            boolean backward = true;

            for(int i = n - 1; i >= 0; i--){
                if((b.charAt(i) == end.ch && same) || (!same && b.charAt(i) != end.ch)) {
                    if(backward) end = end.previous;
                    else end = end.next;
                    continue;
                }
                if((b.charAt(i) == head.ch && same) || (!same && b.charAt(i) != head.ch)){
                    if(b.charAt(i) == '1'){
                        a.setCharAt(0, '0');
                    }else {
                        a.setCharAt(0, '1');
                    }
                    count++;
                    sb.append(1).append(" ");
                }
                // flip the sub string from 0 to index i in string a
                if(backward)
                head = head.next;
                else head = head.previous;
                same = !same;
                Node tmp = head;
                head = end;
                end = tmp;
                backward = !backward;

                count++;
                sb.append(i + 1).append(" ");
            }
            sb.insert(0, count+" ");
            sb.append("\n");
            ss.append(sb);
        }
        System.out.print(ss.toString());
    }

    private static int nextInt(BufferedReader br) throws IOException{
        return Integer.parseInt(br.readLine());
    }

    private static int[] nextIntArray(BufferedReader br, int n) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    static class Pair<A, B>{
        A first;
        B second;
        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }

    static class Node{
        char ch;
        int index;
        Node next, previous;
    }
}

