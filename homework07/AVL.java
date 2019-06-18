import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Your implementation of an AVL Tree.
 *
 * @author Adam Chau
 * @userid achau30 (i.e. gburdell3)
 * @GTID 903197136 (i.e. 900000000)
 * @version 1.0
 */
public class AVL<T extends Comparable<? super T>> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private AVLNode<T> root;
    private int size;

    /**
     * A no-argument constructor that should initialize an empty AVL.
     *
     * Since instance variables are initialized to their default values, there
     * is no need to do anything for this constructor.
     */
    public AVL() {
        // DO NOT IMPLEMENT THIS CONSTRUCTOR!
    }

    /**
     * Initializes the AVL tree with the data in the Collection. The data
     * should be added in the same order it appears in the Collection.
     *
     * Hint: Not all Collections are indexable like Lists, so a regular
     * for loop will not work here. What other type of loop would work?
     *
     * @param data the data to add to the tree
     * @throws IllegalArgumentException if data or any element in data is null
     */
    public AVL(Collection<T> data) {
        if (data == null) {
            throw new IllegalArgumentException("The data passed in is null.");
        }
        for (T item: data) {
            if (item == null) {
                throw new IllegalArgumentException("The element in the data "
                        + "passed in is null.");
            } else {
                add(item);
            }
        }
    }

    /**
     * Add the data to the AVL. Start by adding it as a leaf and rotate the tree
     * as needed. Should traverse the tree to find the appropriate location.
     * If the data is already in the tree, then nothing should be done (the
     * duplicate shouldn't get added, and size should not be incremented).
     *
     * Remember to recalculate heights and balance factors going up the tree,
     * rebalancing if necessary.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @param data the data to be added
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data passed in is null.");
        } else {
            root = addHelper(root, data);
        }
    }

    /**
     * This addHelper helps create the AVLNode to add and then traverses the
     * AVL tree in O(log n) time to find a place to add the AVLNode onto the
     * tree. After adding the node, the size is incremented by 1 and the height
     * and balance factor of the node is updated. Then, the method checks for
     * balancing and uses pointer reinforcement to eventually return the data
     * that sets a node with the highest height as the root.
     *
     * @param node an item in the AVL tree
     * @param data the data to be added to the AVL tree
     * @return the new node added to the rebalanced AVL tree
     */

    private AVLNode<T> addHelper(AVLNode<T> node, T data) {
        AVLNode<T> nodeToAdd = new AVLNode(data);
        if (root == null) {
            size++;
            root = nodeToAdd;
            return nodeToAdd;
        } else if (node == null) {
            size++;
            return nodeToAdd;
        } else if (node.getData().compareTo(data) > 0) {
            node.setLeft(addHelper(node.getLeft(), data));
        } else if (node.getData().compareTo(data) < 0) {
            node.setRight(addHelper(node.getRight(), data));
        }
        AVLNode<T> rotation = checkRotation(node);
        return rotation;
    }

    /**
     * The method checks for if the AVL tree is unbalanced after the height
     * and balance factor are updated. If the AVL tree is unbalanced, then
     * the AVL tree calls on rotations depending on the balance factor of
     * the node and its children.
     *
     * @param node an item in the AVL tree
     * @return the node after the rotation
     */

    private AVLNode<T> checkRotation(AVLNode<T> node) {
        updateNodeHeightBf(node);
        if (node.getBalanceFactor() <= -2) {
            if (node.getRight() != null
                    && node.getRight().getBalanceFactor() <= 0) {
                return rotateLeft(node);
            } else if (node.getRight() != null
                    && node.getRight().getBalanceFactor() > 0)  {
                node.setRight(rotateRight(node.getRight()));
                return rotateLeft(node);
            }
        } else if (node.getBalanceFactor() >= 2) {
            if (node.getLeft() != null
                    && node.getLeft().getBalanceFactor() < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
                return rotateRight(node);
            } else if (node.getLeft() != null
                    && node.getLeft().getBalanceFactor() >= 0)  {
                return rotateRight(node);
            }
        }
        return node;
    }

    /**
     * The method does a right rotation on a subtree in the AVL
     * tree and return the node with the highest height after the
     * subtree has done a right rotation.
     *
     * @param node1 an item in the AVL tree
     * @return the node with the highest height after the
     * subtree has done a right rotation
     */

    private AVLNode<T> rotateRight(AVLNode<T> node1) {
        AVLNode<T> node2 = node1.getLeft();
        node1.setLeft(node2.getRight());
        node2.setRight(node1);
        updateNodeHeightBf(node1);
        updateNodeHeightBf(node2);
        return node2;
    }

    /**
     * The method does a left rotation on a subtree in the AVL
     * tree and return the node with the highest height after the
     * subtree has done a left rotation.
     *
     * @param node1 an item in the AVL tree
     * @return the node with the highest height after the
     * subtree has done a left rotation
     */

    private AVLNode<T> rotateLeft(AVLNode<T> node1) {
        AVLNode<T> node2 = node1.getRight();
        node1.setRight(node2.getLeft());
        node2.setLeft(node1);
        updateNodeHeightBf(node1);
        updateNodeHeightBf(node2);
        return node2;
    }

    /**
     * This method updates the height and balance factor of a node
     * in the AVL tree.
     *
     * @param node an item in the AVL tree
     */

    private void updateNodeHeightBf(AVLNode<T> node) {
        int leftHeight;
        int rightHeight;
        if (node.getLeft() == null) {
            leftHeight = -1;
        } else {
            leftHeight = node.getLeft().getHeight();
        }
        if (node.getRight() == null) {
            rightHeight = -1;
        } else {
            rightHeight = node.getRight().getHeight();
        }
        node.setBalanceFactor(leftHeight - rightHeight);
        node.setHeight(1 + Math.max(leftHeight, rightHeight));
    }

    /**
     * Removes the data from the tree. There are 3 cases to consider:
     *
     * 1: the data is a leaf. In this case, simply remove it.
     * 2: the data has one child. In this case, simply replace it with its
     * child.
     * 3: the data has 2 children. Use the predecessor to replace the data,
     * not the successor.
     * You must use recursion to find and remove the predecessor (you will
     * likely need an additional helper method to handle this case efficiently).
     *
     * Remember to recalculate heights going up the tree, rebalancing if
     * necessary.
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to remove from the tree.
     * @return the data removed from the tree. Do not return the same data
     * that was passed in.  Return the data that was stored in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data passed in is null.");
        } else if (size == 1) {
            T removedData = root.getData();
            root = null;
            size = 0;
            return removedData;
        } else {
            AVLNode<T> nodeToRemove = new AVLNode<>(null);
            root = removeHelper(root, data, nodeToRemove);
            T removedData = nodeToRemove.getData();
            return removedData;
        }
    }

    /**
     * The removeHelper helps remove the data considering the three
     * remove cases. The three cases to consider was:
     *
     * 1: the data is a leaf. In this case, simply remove it.
     *
     * 2: the data has one child. In this case, simply replace it with its
     * child.
     *
     * 3: the data has 2 children. Use the predecessor to replace the data.
     * I must use recursion and a helper method to find and remove the
     * predecessor.
     *
     * The size is decremented by 1 and the height and balance factor are
     * updated. Then, the method checks for balancing and uses
     * pointer reinforcement to eventually return the data that needed to
     * be removed from the AVL tree.
     *
     * @param node an item in the AVL tree
     * @param data the data to remove from the tree
     * @param nodeToRemove a dummy node that stores the node that has the data
     *                     that needs to be removed
     * @throws java.util.NoSuchElementException if the data is not found
     * @return the root node of the rebalanced AVL tree after removing a node
     */

    private AVLNode<T> removeHelper(AVLNode<T> node, T data,
                                    AVLNode<T> nodeToRemove) {
        if (node == null) {
            throw new NoSuchElementException("The data passed in is not found "
                    + "in the AVL tree.");
        } else {
            if (node.getData().compareTo(data) == 0) {
                if (node.getRight() == null && node.getLeft() == null) {
                    nodeToRemove.setData(node.getData());
                    size--;
                    updateNodeHeightBf(node);
                    return null;
                } else if (node.getRight() == null || node.getLeft() == null) {
                    nodeToRemove.setData(node.getData());
                    size--;
                    updateNodeHeightBf(node);
                    if (node.getRight() == null) {
                        return checkRotation(node.getLeft());
                    } else {
                        return checkRotation(node.getRight());
                    }
                } else {
                    AVLNode<T> predecessor = predecessorHelper(node.getLeft());
                    nodeToRemove.setData(node.getData());
                    node.setData(predecessor.getData());
                    AVLNode<T> predNode = new AVLNode<>(null);
                    node.setLeft(removeHelper(node.getLeft(),
                            predecessor.getData(), predNode));
                    updateNodeHeightBf(node);
                    return checkRotation(node);
                }
            } else if (node.getData().compareTo(data) < 0) {
                node.setRight(removeHelper(node.getRight(),
                        data, nodeToRemove));
                updateNodeHeightBf(node);
                return checkRotation(node);
            } else {
                node.setLeft(removeHelper(node.getLeft(),
                        data, nodeToRemove));
                updateNodeHeightBf(node);
                return checkRotation(node);
            }
        }
    }

    /**
     * The predecessorHelper method helps find the predecessor of a subtree and
     * returns the predecessor node for the removeHelper method.
     *
     * @param node the right node of the subtree to find the predecessor
     * @return the predecessor of the subtree
     */

    private AVLNode<T> predecessorHelper(AVLNode<T> node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return predecessorHelper(node.getRight());
        }
    }

    /**
     * Returns the data in the tree matching the parameter passed in (think
     * carefully: should you use value equality or reference equality?).
     *
     * @throws IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data the data to search for in the tree.
     * @return the data in the tree equal to the parameter. Do not return the
     * same data that was passed in.  Return the data that was stored in the
     * tree.
     */
    public T get(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is null.");
        } else {
            T foundData = getHelper(root, data);
            if (foundData == null) {
                throw new NoSuchElementException("The data is not found in the "
                        + "tree.");
            } else {
                return foundData;
            }
        }
    }

    /**
     * The getHelper method helps find the data in the AVL tree and returns
     * the data that was stored in the AVL tree.
     *
     * @param node an item in the AVL tree
     * @param data the data to search for in the AVL tree
     * @return the data if it was found in the AVL tree
     */

    private T getHelper(AVLNode<T> node, T data) {
        if (node == null) {
            return null;
        } else if (data.compareTo(node.getData()) == 0) {
            return node.getData();
        } else if (data.compareTo(node.getData()) > 0) {
            return getHelper(node.getRight(), data);
        } else {
            return getHelper(node.getLeft(), data);
        }
    }

    /**
     * Returns whether or not data equivalent to the given parameter is
     * contained within the tree. The same type of equality should be used as
     * in the get method.
     *
     * @throws IllegalArgumentException if the data is null
     * @param data the data to search for in the tree.
     * @return whether or not the parameter is contained within the tree.
     */
    public boolean contains(T data) {
        if (data == null) {
            throw new IllegalArgumentException("The data is null.");
        }
        boolean dataFound = containsHelper(root, data);
        return dataFound;
    }

    /**
     * The containsHelper uses recursion to show if the data is in the AVL tree
     * or not. The helper method returns true if the data is in the AVL tree and
     * false if the data is not in the AVL tree.
     *
     * @param node an item in the AVL tree
     * @param data the data to search for in the AVL tree
     * @return a boolean that tells whether the data
     * is in or not in the AVL tree
     */

    private boolean containsHelper(AVLNode<T> node, T data) {
        if (node == null) {
            return false;
        } else {
            if (data.compareTo(node.getData()) == 0) {
                return true;
            } else if (data.compareTo(node.getData()) > 0) {
                return containsHelper(node.getRight(), data);
            } else {
                return containsHelper(node.getLeft(), data);
            }
        }
    }

    /**
     * Returns the data in the deepest node. If there are more than one node
     * with the same deepest depth, return the right most node with the
     * deepest depth.
     *
     * Must run in O(log n) for all cases
     *
     * Example
     * Tree:
     *           2
     *        /    \
     *       0      3
     *        \
     *         1
     * Max Deepest Node:
     * 1 because it is the deepest node
     *
     * Example
     * Tree:
     *           2
     *        /    \
     *       0      4
     *        \    /
     *         1  3
     * Max Deepest Node:
     * 3 because it is the maximum deepest node (1 has the same depth but 3 > 1)
     *
     * @return the data in the maximum deepest node or null if the tree is empty
     */

    public T maxDeepestNode() {
        if (root == null) {
            return null;
        } else {
            return maxDeepestNodeHelper(root);
        }
    }

    /**
     * This helper method Returns the data in the deepest node. If there
     * are more than one node with the same deepest depth, return the
     * right most node with the deepest depth.
     *
     * @param node an item in the AVL tree
     * @return the data in the maximum deepest node
     */

    private T maxDeepestNodeHelper(AVLNode<T> node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return node.getData();
        } else if (node.getRight() == null) {
            return maxDeepestNodeHelper(node.getLeft());
        } else if (node.getLeft() == null) {
            return maxDeepestNodeHelper(node.getRight());
        } else {
            if (node.getLeft().getHeight() > node.getRight().getHeight()) {
                return maxDeepestNodeHelper(node.getLeft());
            } else {
                return maxDeepestNodeHelper(node.getRight());
            }
        }
    }

    /**
     * Returns the data of the deepest common ancestor between two nodes with
     * the given data. The deepest common ancestor is the lowest node (i.e.
     * deepest) node that has both data1 and data2 as descendants.
     * If the data are the same, the deepest common ancestor is simply the node
     * that contains the data. You may not assume data1 < data2.
     * (think carefully: should you use value equality or reference equality?).
     *
     * Must run in O(log n) for all cases
     *
     * Example
     * Tree:
     *           2
     *        /    \
     *       0      3
     *        \
     *         1
     * deepestCommonAncestor(3, 1): 2
     *
     * Example
     * Tree:
     *           3
     *        /    \
     *       1      4
     *      / \
     *     0   2
     * deepestCommonAncestor(0, 2): 1
     *
     * @param data1 the first data
     * @param data2 the second data
     * @throws java.lang.IllegalArgumentException if one or more of the data
     *          are null
     * @throws java.util.NoSuchElementException if one or more of the data are
     *          not in the tree
     * @return the data of the deepest common ancestor
     */

    public T deepestCommonAncestor(T data1, T data2) {
        if (data1 == null || data2 == null) {
            throw new IllegalArgumentException("The first or second data "
                    + "passed in is null.");
        } else {
            AVLNode<T> deepCommonAncestor = deepestCommonAncestorHelper(root,
                    data1, data2);
            if (!(containsHelper(deepCommonAncestor, data1))
                    || !(containsHelper(deepCommonAncestor, data2))) {
                throw new NoSuchElementException("The first or second data "
                        + "passed in is not in the AVL tree.");
            } else {
                return deepCommonAncestor.getData();
            }
        }
    }

    /**
     * The helper method helps find and return the deepest common ancestor
     * between two nodes. Throws an NoSuchElement exception if the node
     * passed in is null.
     *
     * @param node an item in the AVL tree
     * @param data1 the first data
     * @param data2 the second data
     * @throws java.util.NoSuchElementException if one or more of the data are
     *         not in the tree
     * @return the node of the deepest common ancestor of both data
     */

    private AVLNode<T> deepestCommonAncestorHelper(AVLNode<T> node,
                                                   T data1, T data2) {
        if (node == null) {
            throw new NoSuchElementException("The first or second data "
                    + "passed in is not in the AVL tree.");
        } else {
            if (node.getData().compareTo(data1) > 0
                    && node.getData().compareTo(data2) > 0) {
                return deepestCommonAncestorHelper(node.getLeft(),
                        data1, data2);
            }
            if (node.getData().compareTo(data1) < 0
                    && node.getData().compareTo(data2) < 0) {
                return deepestCommonAncestorHelper(node.getRight(),
                        data1, data2);
            }
        }
        return node;
    }

    /**
     * Clear the tree.
     */

    public void clear() {
        root = null;
        size = 0;
    }

    /**
     * Return the height of the root of the tree.
     *
     * Since this is an AVL, this method does not need to traverse the tree
     * and should be O(1)
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */

    public int height() {
        if (root == null) {
            return -1;
        } else {
            return root.getHeight();
        }
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     *
     * DO NOT USE THIS METHOD IN YOUR CODE.
     *
     * @return the number of elements in the tree
     */

    public int size() {
        // DO NOT MODIFY THIS METHOD
        return size;
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */

    public AVLNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }
}
