package dev.luan.data.binaryTree;

import java.util.Stack;
import java.util.StringJoiner;

public class BinaryTree<T extends Comparable> {
    /**
     *
     * Represents the starting node of a binary tree.
     */
    private BinaryTreeNode<T> startNode;

    /**
     * Constructs a new BinaryTree with a null starting node.
     */
    public BinaryTree() {
        this.startNode = null;
    }

    /**
     * Adds a new node with the specified value to the binary tree.
     *
     * @param value the value to be added to the binary tree
     * @return the BinaryTree instance after adding the value
     */
    public BinaryTree<T> add(T value) {
        startNode = addNode(startNode, value);
        return this;
    }

    /**
     * Adds a new node with the specified value to the binary tree.
     *
     * @param node the BinaryTreeNode to start adding from
     * @param value the value to be added to the binary tree
     * @return the BinaryTreeNode instance after adding the value
     */
    private BinaryTreeNode<T> addNode(BinaryTreeNode<T> node, T value) {
        if (node == null) {
            node = new BinaryTreeNode<>(value);
        } else {
            if (value.compareTo(node.getValue()) <= 0) {
                node.setLeftNode(addNode(node.getLeftNode(), value));
            } else {
                node.setRightNode(addNode(node.getRightNode(), value));
            }
        }
        return node;
    }

    /**
     * Prints the values of the binary tree in sorted order.
     */
    public void printTree() {
        final StringJoiner joiner = new StringJoiner(", ");
        printTree(this.startNode, joiner);
        System.out.println(joiner);
    }

    /**
     * Recursively prints the values of the binary tree in sorted order.
     *
     * @param node the BinaryTreeNode to start printing from
     * @param joiner the StringJoiner used to concatenate the values
     */
    private void printTree(BinaryTreeNode<T> node, StringJoiner joiner) {
        if (node != null) {
            printTree(node.getLeftNode(), joiner);
            joiner.add(String.valueOf(node.getValue()));
            printTree(node.getRightNode(), joiner);
        }
    }

    /**
     * Checks if a specified value is present in the binary tree.
     *
     * @param value the value to search for in the binary tree
     * @return true if the value is found, false otherwise
     */
    public boolean isInTree(T value) {
        Stack<BinaryTreeNode> nodes = new Stack<>();
        nodes.push(this.startNode);
        while (!nodes.isEmpty()) {
            final BinaryTreeNode topNode = nodes.pop();
            if (!topNode.isLeave()) {
                if (topNode.getRightNode() != null) nodes.push(topNode.getRightNode());
                if (topNode.getLeftNode() != null) nodes.push(topNode.getLeftNode());
            }
            if (topNode.getValue().compareTo(value) == 0) {
                return true;
            }
        }
        return false;
    }
}