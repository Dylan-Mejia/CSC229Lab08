package org.example;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int n = 100;
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertPrimes(n);
        SinglyLinkedList listWithDigitThree = list.findNumbersWith3();
        System.out.println("The prime numbers from 0 to " + n + " with a 3 are:");
        listWithDigitThree.display();
        System.out.println();
        int sumOfListWithDigitThree = listWithDigitThree.sum();
        System.out.println("The sum of prime numbers with a 3 is: " + sumOfListWithDigitThree);
    }
}
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList {
    Node head;
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
    }
    public boolean primeNumTest(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void insertPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if (primeNumTest(i)) {
                insert(i);
            }
        }
    }
    public SinglyLinkedList findNumbersWith3() {
        SinglyLinkedList newList = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            if (findNumber3(current.data)) {
                newList.insert(current.data);
            }
            current = current.next;
        }
        return newList;
    }
    public boolean findNumber3(int num) {
        while (num > 0) {
            if (num % 10 == 3) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
}

