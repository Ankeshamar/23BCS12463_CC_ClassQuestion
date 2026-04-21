import java.util.*;
class trie{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }  
        TrieNode root = new TrieNode();
        for(String word : arr){
            insert(root, word);
        }
        String prefix = sc.next();
        if(search(root, prefix)){
            System.out.println("Prefix found in trie");
        } else {
            System.out.println("Prefix not found in trie");
        }
    }
}