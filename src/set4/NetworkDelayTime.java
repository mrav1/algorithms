package set4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    public int networkDelayTime(int[][] times, int N, int K) {
        // Put each node with it's decedents in a map to easy of access later
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        // Create min heap to get node with min weight
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        //Map to store node and delay
        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] nodeWithMinWeight = heap.poll();
            int initialTime = nodeWithMinWeight[0];
            int sourceNode = nodeWithMinWeight[1];

            if (dist.containsKey(sourceNode)) continue;
            dist.put(sourceNode, initialTime);

            if (graph.containsKey(sourceNode)) {
                for (int[] edge : graph.get(sourceNode)) {
                    int targetNode = edge[0];
                    int time = edge[1];
                    if (!dist.containsKey(targetNode)) {
                        heap.offer(new int[]{initialTime + time, targetNode});
                    }
                }
            }
        }

        // If all nodes can't be reached return -1
        if (dist.size() != N) return -1;

        // Get max delay from dist map and return
        int ans = 0;
        for (int cand : dist.values()) {
            ans = Math.max(ans, cand);
        }
        return ans;
    }

}
