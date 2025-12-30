class Solution {

    // Reverse a linked list
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Remove leading zeros
    static Node removeLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }

    static Node addTwoLists(Node head1, Node head2) {

        // Step 1: Remove leading zeros
        head1 = removeLeadingZeros(head1);
        head2 = removeLeadingZeros(head2);

        // If both lists become empty
        if (head1 == null && head2 == null) {
            return new Node(0);
        }

        // Step 2: Reverse both lists
        head1 = reverse(head1);
        head2 = reverse(head2);

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        // Step 3: Add digits
        while (head1 != null || head2 != null || carry != 0) {
            int sum = carry;

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
        }

        // Step 4: Reverse result
        return reverse(dummy.next);
    }
}
