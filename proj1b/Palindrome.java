public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char[] a = word.toCharArray();
        Deque<Character> wordToDeque = new LinkedListDeque<>();
        for (var w : a) {
            wordToDeque.addLast(w);
        }
        return wordToDeque;
    }
}
