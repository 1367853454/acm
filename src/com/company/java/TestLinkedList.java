package com.company.java;

public class TestLinkedList {

    private Node first;

    private Node last;

    private int size;

    public Object get(int index){

        if (index < 0 || index > size - 1){
            throw new RuntimeException("索引数字不合法" + index);
        }

        Node temp = null;

        if (index <= (size >> 1)){
            temp = first;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else {
            temp = last;
            for (int i = size -1; i > index; i--){
                temp = temp.previous;
            }
        }
        return temp.element;
    }

    public void add(Object obj){

        Node node = new Node(obj);

        if (null == first){
            first = node;
            last = node;
        }else {
            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }

        size++;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Node temp = first;
        while(null != temp){
            stringBuilder.append(temp.element + ",");
            temp = temp.next;
        }
        stringBuilder.setCharAt(stringBuilder.length()-1, ']');
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        TestLinkedList linkedList = new TestLinkedList();

        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
    }

}
