/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 * int coefficient, power;
 * PolyNode next = null;
 * 
 * PolyNode() {}
 * PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 * PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y;
 * this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null)
            return poly2;
        if (poly2 == null)
            return poly1;
        PolyNode dummy = new PolyNode(-1, -1);
        PolyNode temp = dummy;
        while (poly1 != null && poly2 != null) {
            if (poly1.power == poly2.power) {
                poly1.coefficient += poly2.coefficient;
                if (poly1.coefficient != 0) {
                    dummy.next = poly1;
                    dummy = dummy.next;
                }
                PolyNode next = poly1.next;
                poly1.next = null;
                poly1 = next;
                poly2 = poly2.next;
            } else if (poly1.power > poly2.power) {
                dummy.next = poly1;
                PolyNode next = poly1.next;
                poly1.next = null;
                poly1 = next;
                dummy = dummy.next;
            } else {
                dummy.next = poly2;
                PolyNode next = poly2.next;
                poly2.next = null;
                poly2 = next;
                dummy = dummy.next;
            }
        }

        if (poly1 != null) {
            dummy.next = poly1;
        }
        if (poly2 != null) {
            dummy.next = poly2;
        }
        return temp.next;
    }
}