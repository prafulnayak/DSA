import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DictonaryContacts {

    private static TrieNode rootElement;

    public static void inputDataForContacts(){
        Scanner scanner = new Scanner(System.in);
        String[][] contacts = new String[4][2];
        int x =contacts.length;
        int i = 0;
        while (i<x){
            String[] inputs = scanner.nextLine().split(" ");
            contacts[i][0] = inputs[0];
            contacts[i][1] = inputs[1];
            i++;
        }
        scanner.close();
        ArrayList<Integer> xX = findNamesStartsWith(contacts);
        xX.forEach(a-> System.out.println(String.valueOf(a)));
    }

    public static ArrayList<Integer> findNamesStartsWith(String[][] queries){
        rootElement = new TrieNode();
        ArrayList<Integer> ans = new ArrayList<>();
        for(String[] operation:queries){
            switch (operation[0]) {
                case "add" :
                    insert(operation[1]);
                    break;
                case "find" :
                    ans.add(find(operation[1]));
                    break;
                default:
                    break;
            }
        }
        return ans;
    }

    private static int find(String s) {
        TrieNode root = rootElement;
        System.out.println(s);
        int countX =0;
        for(int i=0; i<s.length();i++){
            int index = s.charAt(i)- 'a';
            if(root.children[index] == null){
                return 0;
            }
            countX = root.count[index];
            if(i<=s.length()-1)
                root = root.children[index];
        }
        return countX;
    }

    private static void insert(String s) {
        TrieNode root = rootElement;
        for(int i=0;i<s.length();i++) {
            int index = s.charAt(i) - 'a';

            if(root.children[index] == null){
                root.children[index] = new TrieNode();
                root.count[index]++;
            }else {
                root.count[index]++;
            }
            root = root.children[index];
        }
        root.isEnd = true;
    }

    public static class TrieNode{
        TrieNode[] children= new TrieNode[26];
        int[] count = new int[26];
        boolean isEnd;

        public TrieNode() {
            Arrays.fill(children,null);
            Arrays.fill(count,0);
            isEnd = false;
        }
    }
}
