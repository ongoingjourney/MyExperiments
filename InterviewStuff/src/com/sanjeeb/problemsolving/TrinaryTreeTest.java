package com.sanjeeb.problemsolving;
public class TrinaryTreeTest{
    public static void main(String[] args) {
        TrinaryTree<Integer> tree = new TrinaryTree<>();
        int[] arr = new int[] {40, 12, 60, 13, 7, 64, 48, 46, 55, 45, 44, 43, 54, 53};
        for(int i : arr) {
            tree.insert(new Node<Integer>(i));
        }
       
        System.out.print("Before : ");
        tree.breadFirstTraversal();
        tree.delete(new Integer(55));
        System.out.print("\nAfter  : ");
        tree.breadFirstTraversal();

    }
}

class TrinaryTree<T extends Comparable<T>> {
    Node<T> root;
   
    public void insert(Node<T> node) {
        if(root == null)
            root = node;
        else
            insert(root, node);
    }
    /**
     * Method to insert element an element in a Ternary tree
     * @param parentNode - the parent node from where the search begins.
     * @param nodeToBeInserted - Node to be inserted.
     */

    private void insert(Node<T> parentNode, Node<T> nodeToBeInserted) {
        if(parentNode.getNodeValue().compareTo(nodeToBeInserted.getNodeValue()) < 0) { //insert in left subtree

            if(parentNode.getRight() == null) {
                parentNode.setRight(nodeToBeInserted);
            } else {
                insert(parentNode.getRight(),nodeToBeInserted);
            }
        } else if(parentNode.getNodeValue().compareTo(nodeToBeInserted.getNodeValue()) > 0) { //insert in right subtree

            if(parentNode.getLeft() == null) {
                parentNode.setLeft(nodeToBeInserted);
            } else {
                insert(parentNode.getLeft(), nodeToBeInserted);
            }
        } else { // //insert in center

            if(parentNode.getCenter() == null) {
                parentNode.setCenter(nodeToBeInserted);
            } else {
                insert(parentNode.getCenter(), nodeToBeInserted);
            }
        }
    }
   
    /**
     * public method to delete a node.
     *
     * This method uses the helper method searchNodeToDelete which searches for matching node.
     * Since searchNodeToDelete method takes non-deleteable parent node, and which is why root level deletion
     * is handled here.
     *
     * Algorithm
     * If matching node is a root node, proceed in following order
     *         Delete root that does not have any child
     *         Delete root that has center element
     *         Delete root that has either left or right subtree only,
     *             by moving immediate child of respective tree to the root.
     *         Delete root that has both left and right child
     *             by moving smallest element of right subtree
     *
     *  If matching element is not root node, call the generic method searchNodeToDelete
     * 
     * @param nodeValue the node value to be deleted
     */

    public void delete(T nodeValue) {
        if(root == null) {
            System.out.println("Tree is empty");
        }
        if(root.getLeft() == null && root.getCenter() == null && root.getRight() == null && root.getNodeValue().compareTo(nodeValue) == 0) {
            System.out.println("Deleting the root of the tree that has root element only.");
            root = null;
            return;
        }
        if(root.getNodeValue().compareTo(nodeValue) == 0) { //node to be deleted is root node
            if(root.getCenter() != null) { //
                root = root.getCenter();
                return;
            }
            else if (root.getLeft() == null && root.getRight() != null) { //has right subtree only
                root = root.getRight();
            }
            else if(root.getRight() == null && root.getLeft() != null) { //has right subtree only
                root = root.getLeft();
            } else { //has both left and right subtree.
                Node<T> parentOfSmallestInRightSubtree = getParentOfSmallest(root);
                Node<T> smallestNodeInRightSubtree;
                if(parentOfSmallestInRightSubtree.equals(root)) {
                    smallestNodeInRightSubtree = root.getRight();
                    smallestNodeInRightSubtree.setLeft(root.left);
                    smallestNodeInRightSubtree.setCenter(root.center);
                    root = smallestNodeInRightSubtree;
                } else {
                    smallestNodeInRightSubtree = parentOfSmallestInRightSubtree.getLeft();
                    smallestNodeInRightSubtree.setLeft(root.getLeft());
                    smallestNodeInRightSubtree.setCenter(root.getCenter());
                    smallestNodeInRightSubtree.setRight(root.getRight());
                    root = smallestNodeInRightSubtree;
                    parentOfSmallestInRightSubtree.setLeft(null);
                   
                }
            }
        }
        searchNodeToDelete(root, nodeValue);
    }
   
    /**
     * This method scans the tree and finds the immediate parent node of node to be deleted.
     * @param parentNode the parent node where the search begins.
     * @param nodeValue node value that needs to match the node to be deleted.
     */

    private void searchNodeToDelete(Node<T> parentNode, T nodeValue) {
        if(nodeValue.compareTo(parentNode.getNodeValue()) < 0) { // search left-subtree.
            if(parentNode.getLeft() != null) { // if left subtree is not null
                if(parentNode.getLeft().getNodeValue().compareTo(nodeValue) == 0) { // match found on left subtree
                    deleteNode(parentNode, "left"); // node to be deleted is the left child.
                } else {
                    searchNodeToDelete(parentNode.getLeft(), nodeValue); // match not found, keep looking on left subtree

                }
            }
        } else if(nodeValue.compareTo(parentNode.getNodeValue()) > 0) { // search right-subtree.
            if(parentNode.getRight() != null) {
                if(parentNode.getRight().getNodeValue().compareTo(nodeValue) == 0) { 
                    deleteNode(parentNode, "right"); // node to be deleted is the right child.
                } else {
                    searchNodeToDelete(parentNode.getRight(), nodeValue); // match not found, keep looking on right subtree
                }
            }
        } else {
            deleteNode(parentNode, "center"); // node to be deleted is a child in the center.
        }
    }
   
    /**
     * Worker method to delete node.
     * @param parentNode - The immediate parent node of element to be deleted
     * @param nodePosition - This is a string (can be deprecated) to indicate positioning 
     *  of element to be deleted.
     */
    private void deleteNode(Node<T> parentNode, String nodePosition) {

       
        switch(nodePosition.toLowerCase()) {
            case "left" :
            {
                if (parentNode.getLeft().getLeft() == null && parentNode.getLeft().getCenter() == null && parentNode.getLeft().getRight() == null) { // node to be deleted is leaf
                    parentNode.setLeft(null);
                }
                if (parentNode.getLeft().getLeft() == null) {// has right subtree only
                    parentNode.setLeft(parentNode.getLeft().getRight());
                }
                if (parentNode.getLeft().getRight() == null) {// has left subtree only
                    parentNode.setLeft(parentNode.getLeft().getLeft());
                } else if (parentNode.getLeft().getCenter() != null){ // has center node.

                    parentNode.setLeft(parentNode.getLeft().getCenter());
                } else if(parentNode.getLeft() != null && parentNode.getRight() != null){//has both left and right.
                    Node<T> parentNodeOfSmallest = getParentOfSmallest(parentNode.getLeft());
                    Node<T> smallestNode;
                    if(parentNodeOfSmallest.equals(parentNode.getLeft())) { // the root of right subtree is the smallest element.
                        smallestNode = parentNodeOfSmallest.getRight();
                        smallestNode.setLeft(parentNode.getLeft().getLeft());
                        parentNode.setLeft(smallestNode);
                    } else {
                        smallestNode = parentNodeOfSmallest.getLeft();
                        Node<T> leftChildOfNodeBeingReplaced = parentNode.getLeft().getLeft();
                        if(leftChildOfNodeBeingReplaced != smallestNode)
                            smallestNode.setLeft(leftChildOfNodeBeingReplaced);
                        smallestNode.setCenter(parentNode.getLeft().getCenter());
                        smallestNode.setRight(parentNode.getLeft().getRight());
                        parentNode.setLeft(smallestNode);
                        parentNodeOfSmallest.setLeft(null);
                    }
                }
                break;
            }
            case "center" :
            {
                if(parentNode.getCenter().getCenter() != null) { // center child exists, move it up.
                    parentNode.setCenter(parentNode.getCenter().getCenter());
                } else {
                    parentNode.setCenter(null); //set center to null since there is only one child.
                }
                break;

            }
            case "right" :
            {
                if(parentNode.getRight().getLeft() == null && parentNode.getRight().getCenter() == null && parentNode.getRight() == null) { // node to be deleted is a leaf node.
                    parentNode.setRight(null);
                } else if (parentNode.getRight().getLeft() == null ) { // has right subtree only
                    parentNode.setRight(parentNode.getRight().getRight());
                } else if (parentNode.getRight().getRight() == null) { // has left subtree only
                    parentNode.setRight(parentNode.getRight().getLeft());
                } else if(parentNode.getRight().getCenter() != null) { //has center subtree.
                    parentNode.setCenter(parentNode.getRight().getCenter());
                } else if(parentNode.getLeft() != null && parentNode.getRight() != null){ //has both left and right subtree.
                    Node<T> parentNodeOfSmallest = getParentOfSmallest(parentNode.getRight());
                    Node<T> smallestNode;
                    if(parentNodeOfSmallest.equals(parentNode.getLeft())) { // the root of right subtree is the smallest element.
                        smallestNode = parentNodeOfSmallest.getRight();
                        smallestNode.setLeft(parentNode.getLeft().getLeft());
                        parentNode.setLeft(smallestNode);
                    } else {
                        smallestNode = parentNodeOfSmallest.getLeft();
                        Node<T> leftChildOfNodeBeingReplaced = parentNode.getLeft().getLeft();
                   
                        if(leftChildOfNodeBeingReplaced != smallestNode)
                            smallestNode.setLeft(leftChildOfNodeBeingReplaced);
                       
                        smallestNode.setCenter(parentNode.getLeft().getCenter());
                        smallestNode.setRight(parentNode.getLeft().getRight());
                       
                        parentNode.setRight(smallestNode);
                        parentNodeOfSmallest.setLeft(null);

                    }
                } else {
                    System.out.println("Don't handle this case in right");
                }
                break;

            }
            default :
            {
                System.out.println("Thanks for that unsupported node position. Go take a hike.");
                break;
            }
        }
    }
   
    /**
     * Helper to find smallest element in the right subtree - assumes that right child exists.
     * @param parentNode - The parent node where the search begins
     * @return parent of the smallest node.
     */
    private Node<T> getParentOfSmallest(Node<T> parentNode) {
        if(parentNode.getRight().getLeft() == null)
            return parentNode;
       
        parentNode = parentNode.getRight();
       
        while(parentNode.getLeft().getLeft() != null) {
            parentNode = parentNode.getLeft();
        }
        return parentNode;
    }
   
    public void breadFirstTraversal() {
        if(root == null ) {
            return;
        }
        System.out.print(root.getNodeValue() + "\t");
        breadthFirstTraversal(root);
    }
   
    private void breadthFirstTraversal(Node<T> parentNode) {
        if(parentNode != null && parentNode.getLeft() != null)
            System.out.print(parentNode.getLeft().getNodeValue() + "\t");
        if(parentNode != null && parentNode.getCenter() != null)
            System.out.print(parentNode.getCenter().getNodeValue() + "\t");
        if(parentNode != null && parentNode.getRight() != null)
            System.out.print(parentNode.getRight().getNodeValue() + "\t");
       
        if(parentNode != null && parentNode.getLeft() != null)
            breadthFirstTraversal(parentNode.getLeft());
        if (parentNode != null && parentNode.getCenter() != null)
            breadthFirstTraversal(parentNode.getCenter());
        if(parentNode != null && parentNode.getRight() != null)
            breadthFirstTraversal(parentNode.getRight());

    }
   
}

class Node<T>
{
    T nodeValue;
    Node<T> left;
    Node<T> center;
    Node<T> right;
    Node(T aNodeVal) {
        this.nodeValue = aNodeVal;
    }
    public T getNodeValue() {
        return nodeValue;
    }
    public void setNodeValue(T nodeValue) {
        this.nodeValue = nodeValue;
    }
    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getCenter() {
        return center;
    }
    public void setCenter(Node<T> center) {
        this.center = center;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
}