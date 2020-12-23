import java.util.Arrays;
import java.util.Scanner;

public class NoPrefixSet {
    static TrieNode rootElement;
    public static void goodOrBadSet(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        int x =0;
        while (x<n){
            words[x] = scanner.nextLine();
            x++;
        }
        scanner.close();
        String goodOrBadSet = "GOOD SET";
        rootElement = new TrieNode();
        for (String word : words) {
            goodOrBadSet = insert(word);
            if (!goodOrBadSet.equals("GOOD SET")) {
                System.out.println("BAD SET");
                System.out.println(goodOrBadSet);
                break;
            }
        }
        if(goodOrBadSet.equals("GOOD SET")){
            System.out.println("GOOD SET");
        }

    }

    private static String insert(String s) {
        TrieNode root = rootElement;
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';
            if(root.children[index] == null){
                root.children[index] = new TrieNode();
            }
            if(root.isEnd){
                return s;
            }
            root = root.children[index];
        }
        root.isEnd = true;
        return "GOOD SET";
    }

    public static class TrieNode{
        TrieNode[] children= new TrieNode[26];
        boolean isEnd;

        public TrieNode() {
            Arrays.fill(children,null);
            isEnd = false;
        }
    }
}
