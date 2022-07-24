package com.BinaryTreeSum.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	static ArrayList<Integer> nodeArrList = new ArrayList<Integer>();

	static class Node {
		int key;
		Node left, right;
	};

	static Node newNode(int data) {
		Node temp = new Node();
		temp.key = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;
		while (x != null) {
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
		// If the root is null, the tree is empty.
		if (current_parent == null)
			current_parent = newnode;
		// assign new node node to the left child
		else if (key < current_parent.key)
			current_parent.left = newnode;
		// assign the new node to the right child
		else
			current_parent.right = newnode;
		// return pointer to new node
		return current_parent;
	}

	static void Inorder(Node root) {
		if (root == null)
			return;
		else {
			Inorder(root.left);
			System.out.print(root.key + " ");
			nodeArrList.add(root.key);
			Inorder(root.right);
		}
	}

	static void findPairNode(int sum) {
		boolean sumFoundFlag = false;
		for (int i = 0; i < nodeArrList.size(); i++) {
			for (int j = i + 1; j < nodeArrList.size(); j++) {
				if ((nodeArrList.get(i) + nodeArrList.get(j)) == sum) {
					System.out.println("Pair is (" + nodeArrList.get(i) + "," + nodeArrList.get(j) + ")");
					sumFoundFlag = true;
					break;
				}
			}

			if (sumFoundFlag) {
				break;
			}
		}
		if (!sumFoundFlag) {
			System.out.println("nodes are not found");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value;
		Node root = null;
		int[] arr = { 40, 20, 60, 10, 30, 50, 70 };
		for (int i = 0; i < arr.length; i++) {
			value = arr[i];
			if (root == null) {
				root = insert(root, value);
			} else {
				insert(root, value);
			}
		}
		System.out.println("Inorder of Binary Treee!!\n");
		Inorder(root);
		System.out.println("");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sum!!");
		int sum = sc.nextInt();
		findPairNode(sum);
	}

}
