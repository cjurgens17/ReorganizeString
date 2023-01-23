import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    public static void main(String[] args) {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("aaab"));
    }
    //767. Reorganize String
    //Medium
    //5.8K
    //196
    //Companies
    //Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
    //
    //Return any possible rearrangement of s or return "" if not possible.
    //
    //
    //
    //Example 1:
    //
    //Input: s = "aab"
    //Output: "aba"
    //Example 2:
    //
    //Input: s = "aaab"
    //Output: ""
    //
    //
    //Constraints:
    //
    //1 <= s.length <= 500
    //s consists of lowercase English letters.
    public static String reorganizeString(String str){
        //Time Complexity = O(n * logn)
        //Space Complexity = O(2n) = O(n)
        //Map all frequencies
        Map<Character,Integer> map = new HashMap<>();

        for(char ch: str.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        //Sort characters based on their frequencies
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));

        //add to the heap for sorting to take place
        maxHeap.addAll(map.keySet());

        StringBuilder sb = new StringBuilder();
        //used to store most frequent after we take a value from it and it to our sb
        char cached = 0;

        //Start building String based on most frequent first
        while(!maxHeap.isEmpty()){
            char ch = maxHeap.poll();
            int freq = map.get(ch) - 1;
            //update freq in hashmap
            map.put(ch, freq);

            sb.append(ch);
            //if still remaining freq, we readd the character back to heap
            //This ensures we are appending every other character to sb
            if(cached != 0){
                maxHeap.add(cached);
            }
            //update our char if need be
            if(freq > 0){
                cached = ch;
            }else{
                cached = 0;
            }
        }
        //if we pop last value from heap and are left with freq still, we will have an adjacency
        //Here we check and if true we return an empty string, because it is not possible to reorganize
        if(cached != 0) return "";

        //final string
        return sb.toString();
    }
}
