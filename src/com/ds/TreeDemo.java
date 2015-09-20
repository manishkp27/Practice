package com.ds;
import java.util.*;
public class TreeDemo {

	public static void main(String[] arg){
		/*TreeSet tree=new TreeSet();
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		System.out.println(tree.iterator().next());*/
		
		MyTree tree = new MyTree();
		tree.add(4);
		tree.add(3);
		tree.add(2);
		tree.add(8);
		tree.add(1);
		tree.add(12);
		tree.add(6);
		//System.out.println(tree.countNodes());
		
		//tree.remove(3);
		//tree.inoderTraverse();
		tree.preoderTraverse();
		System.out.println("");
		tree.postoderTraverse();
		//System.out.println(tree.search(4));
	}
}
class MyTree {
	Node root;
	
	MyTree(){
		root=null;
	}

	void postoderTraverse(){
		postoderTraverse(root);
	}
	void postoderTraverse(Node node){
		if(node!=null){
			postoderTraverse(node.left);
			postoderTraverse(node.right);
			System.out.println(node.data);
		}
	}
	
	void preoderTraverse(){
		preoderTraverse(root);
	}
	void preoderTraverse(Node node){
		if(node!=null){
			System.out.println(node.data);
			preoderTraverse(node.left);
			preoderTraverse(node.right);
		}
	}
	
	void inoderTraverse(){
		inoderTraverse(root);
	}
	void inoderTraverse(Node node){
		if(node!=null){
			inoderTraverse(node.left);
			System.out.println(node.data);
			inoderTraverse(node.right);
		}
	}
	
	boolean search(int data){
		return search(root,data);
	}
	boolean search(Node node, int data){
		boolean found=false;
		while(node!=null && found==false){
			int d=node.data;
			if(data<d){
				node=node.left;
			}
			else if(data>d){
				node=node.right;
			}
			else{
				found=true;
				break;
			}
			found=search(node,data);
		}
		return found;
	}
	
	void remove(int data){
		if(root==null){
			return;
		}
		else{
			root = remove(root,data);
		}
	}
	Node remove(Node node, int data){
		Node p,p2,n;
		if(node.data==data){
			Node lt,rt;
			
			lt=node.left;
			rt=node.right;
			if(lt==null && rt==null)
				return null;
			else if(lt==null){
				p=rt;
				return p;
			}
			else if(rt==null){
				p=lt;
				return p;
			}
			else{
				p2=rt;
				p=rt;
				while(p.left!=null)
					p=p.left;
				p.left=lt;
				return p2;
			}
		}
		if(data<node.data){
			n=remove(node.left,data);
			node.left=n;
		}
		else{
			n=remove(node.right,data);
			node.right=n;
		}
		
		return n;
		
	}
	
	void add(int data){
		this.root=add(root,data);
	}
	
	Node add(Node node, int data){
		if(node==null){
			node=new Node(data);
		}
		else
		{	if(data<=node.data){
				node.left= add(node.left,data);
			}
			else if(data>node.data){
				node.right= add(node.right,data);
			}
		}
		
		return node;
	}

	int countNodes(){
		return countNodes(root);
	}
	int countNodes(Node node){
		if(node==null){
			return 0;
		}
		else{
			int l=1;
			l += countNodes(node.left);
			l += countNodes(node.right);
			return l;
		}
	}
	
}

class Node {
	Integer data;
	Node left,right;
	
	public Node(int data){
		this.data=data;
		left=null;
		right=null;
	}
}
