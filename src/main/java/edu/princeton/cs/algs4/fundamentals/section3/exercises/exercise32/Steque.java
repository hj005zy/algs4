package edu.princeton.cs.algs4.fundamentals.section3.exercises.exercise32;

import edu.princeton.cs.algs4.fundamentals.section3.exercises.Node;

public class Steque<Item> {

    private int N;

    private Node<Item> first;

    private Node<Item> last;

    public Steque() {
        N = 0;
        first = null;
        last = null;
    }

    public void push(Item item) {
        Node<Item> node = new Node<>();
        node.setItem(item);

        if (N == 0) {
            first = last = node;
        } else {
            node.setNext(first);
            first = node;
        }
        N++;
    }

    public Item pop() {
        if (N == 0) {
            return null;
        }

        Item item = first.getItem();
        if (N == 1) {
            first = last = null;
        } else {
            first = first.getNext();
        }
        N--;

        return item;
    }

    public void enqueue(Item item) {
        Node<Item> node = new Node<>();
        node.setItem(item);

        if (N == 0) {
            first = last = node;
        } else {
            last.setNext(node);
            last = node;
        }
        N++;
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        System.out.println("Pop: " + steque.pop());
        steque.enqueue(1);
        steque.enqueue(2);
        System.out.println("Pop: " + steque.pop());
        System.out.println("Pop: " + steque.pop());

        steque.push(1);
        steque.push(2);
        System.out.println("Pop: " + steque.pop());
        System.out.println("Pop: " + steque.pop());
    }
}
