package dev.luan.data.binaryTree;

import lombok.Data;

@Data
public class BinaryTreeNode<T extends Comparable> {
    /**
     * Represents the value stored in a BinaryTreeNode.
     */
    private final T value;
    /**
     * Represents the right child node in a binary tree node.
     */
    private BinaryTreeNode<T> rightNode;
    /**
     * Represents the left child node of a binary tree node.
     */
    private BinaryTreeNode<T> leftNode;

    public boolean isLeave() {
        return rightNode == null && leftNode == null;
    }
}