import java.util.*;

class Solution {

    Stack<Character> text = new Stack<>();
    Stack<Character> redo = new Stack<>();

    // Append character x
    void append(char x) {
        text.push(x);
        redo.clear(); // clear redo on new append
    }

    // Undo last append
    void undo() {
        if (!text.isEmpty()) {
            redo.push(text.pop());
        }
    }

    // Redo last undone operation
    void redo() {
        if (!redo.isEmpty()) {
            text.push(redo.pop());
        }
    }

    // Read current document
    String read() {
        StringBuilder sb = new StringBuilder();
        for (char c : text) {
            sb.append(c);
        }
        return sb.toString();
    }
}
