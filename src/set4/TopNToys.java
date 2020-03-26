package set4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TopNToys {

    public static void main(String[] args) {
        String[] quotes = new String[]{
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };

        String[] toys = new String[]{"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        List<String> toysList = topToys(6, 2, toys, 6, quotes);
        System.out.println(toysList);
    }

    private static List<String> topToys(int numOfToys, int topNToys, String[] toys, int numOfQuotes, String[] quotes) {

        // Initialize the frequency map for each toy
        Map<String, int[]> frequency = new HashMap<>();
        for (String toy : toys) {
            frequency.put(toy, new int[]{0, 0});
        }

        // Iterate over each word of every quote and update frequency map
        for (String quote : quotes) {
            Set<String> used = new HashSet<>(); // Handle unique occurrence of words
            String[] words = quote.toLowerCase().split("\\W+");
            for (String word : words) {
                if (!frequency.containsKey(word)) {
                    continue;
                }

                int[] nums = frequency.get(word);
                nums[0]++;
                if (!used.contains(word)) {
                    nums[1]++;
                }

                used.add(word);
            }
        }

        // Create a priority queue based on frequency map
        PriorityQueue<String> queue = new PriorityQueue<>((t1, t2) -> {
            int info1[] = frequency.get(t1);
            int info2[] = frequency.get(t2);

            if (info1[0] != info2[0]) {
                return info1[0] - info2[0];
            }

            if (info1[1] != info2[1]) {
                return info1[1] - info2[1];
            }

            return t1.compareTo(t2);
        });

        if (topNToys > numOfToys) { // Add every toy with frequency > 0 to queue
            for (String toy : toys) {
                if (frequency.get(toy)[0] > 0) {
                    queue.add(toy);
                }
            }
        } else {
            for (String toy : toys) { // Add every toy to queue
                queue.add(toy);

                if (queue.size() > topNToys) { // Remove from queue when size > TopNToys
                    queue.poll();
                }
            }
        }

        List<String> list = new ArrayList<>(); // Add to list and sort and return
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }

        Collections.reverse(list);

        return list;
    }

}
