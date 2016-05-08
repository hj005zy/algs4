package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise30;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;

public class Exercise30 {

    public static <Item> Node<Item> reverseLinkedListIter(Node<Item> node) {

        Node<Item> first = node;
        Node<Item> reverse = null;
        while (first != null) {
            Node<Item> second = first.getNext();
            first.setNext(reverse);
            reverse = first;
            first = second;
        }
        return reverse;
    }

    public static <Item> Node<Item> reverseLinkedListRecursive(Node<Item> first) {
        if (first == null) {
            return null;
        }
        if (first.getNext() == null) {
            return first;
        }

        Node<Item> second = first.getNext();
        Node<Item> rest = reverseLinkedListRecursive(second);
        second.setNext(first);
        first.setNext(null);
        return rest;
    }

    public static void main(String[] args) {
        Node<Integer> list = Node.createLinkedList(1, 2, 3, 4, 5);
        Node<Integer> reverse = reverseLinkedListIter(list);
        assert reverse.getItem() == 5;

        list = Node.createLinkedList(1, 2, 3, 4, 5);
        reverse = reverseLinkedListRecursive(list);
        assert reverse.getItem() == 5;
    }
}
