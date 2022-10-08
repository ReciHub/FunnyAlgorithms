import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Josephus {
    public static String solve(int N, int K){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder("<");

        while(!queue.isEmpty()){
            for(int i=0; i<K; i++){
                if(i == K-1){
                    result.append(queue.poll()+", ");
                }else{
                    queue.offer(queue.poll());
                }
            }
        }

        return result.substring(0, result.length()-2)+">";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter N and K: ");
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        bw.write(solve(N, K));
        bw.flush();
        bw.close();
    }
}
