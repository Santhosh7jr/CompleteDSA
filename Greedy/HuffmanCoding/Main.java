package Greedy.HuffmanCoding;
import java.util.*;

public class Main {

    public static class Node {

        Character ch;
        int freq;
        Node left;
        Node right;

        public Node(Character ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the data string: ");
        String data = scanner.nextLine();

        HashMap<Character, Integer> freqTable = new HashMap<>();
        fillFreqTable(data, freqTable);

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.freq - b.freq
        );

        fillPriorityQueue(freqTable, pq);

        constructTree(pq);

        HashMap<Character, String> encoder = new HashMap<>();
        encodeTree(pq.peek(), encoder, "");

        String encodedString = encodeString(data, encoder);

        HashMap<String, Character> decoder = decodeMap(encoder);

        System.out.println("Decoded Data: " + decodeData(encodedString, decoder));

    }

    public static String decodeData(String encodedString, HashMap<String, Character> decoder) {

        int startingIdx = 0;
        int endingIdx = 0;
        StringBuilder decodedData = new StringBuilder();

        while (endingIdx < encodedString.length()) {

            while (! decoder.containsKey(encodedString.substring(startingIdx, endingIdx + 1))) endingIdx++;

            decodedData.append(decoder.get(encodedString.substring(startingIdx, endingIdx + 1)));

            startingIdx = endingIdx + 1;
            endingIdx++;

        }

        return decodedData.toString();

    }

    public static HashMap<String, Character> decodeMap(HashMap<Character, String > map) {

        HashMap<String, Character> decoder = new HashMap<>();

        for (Map.Entry<Character, String> entry : map.entrySet()) decoder.put(entry.getValue(), entry.getKey());

        return decoder;

    }

    public static String encodeString(String data, HashMap<Character, String> encoder) {

        StringBuilder encodedData = new StringBuilder();

        for (int i = 0; i < data.length(); i++) encodedData.append(encoder.get(data.charAt(i)));

        return encodedData.toString();

    }

    public static void encodeTree(Node node, HashMap<Character, String> encoder, String path) {

        if (node == null) return;

        encodeTree(node.left, encoder, path + "0");
        encodeTree(node.right, encoder, path + "1");

        if (node.ch != null) encoder.put(node.ch, path);

    }

    public static void constructTree(PriorityQueue<Node> priorityQueue) {

        if (priorityQueue.size() <= 1) return;

        while (priorityQueue.size() > 1) {

            Node node1 = priorityQueue.poll();
            Node node2 = priorityQueue.poll();

            Node parent = new Node(null, node1.freq + node2.freq);
            parent.left = node1;
            parent.right = node2;

            priorityQueue.offer(parent);

        }

    }

    public static void fillPriorityQueue(HashMap<Character, Integer> freqMap, PriorityQueue<Node> priorityQueue) {

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {

            priorityQueue.offer(new Node(entry.getKey(), entry.getValue()));

        }

    }

    public static void fillFreqTable(String data, HashMap<Character, Integer> freqMap) {

        for (int i = 0; i < data.length(); i++) {

            char ch = data.charAt(i);

            if (! freqMap.containsKey(ch)) freqMap.put(ch, 1);
            else freqMap.put(ch, freqMap.get(ch) + 1);

        }

    }

}
