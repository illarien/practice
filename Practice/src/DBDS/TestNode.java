package DBDS;

import java.util.ArrayList;

import org.junit.runner.Description;

public class TestNode {
	
	private Description mDescription;
	private String mTestName;
	
	ArrayList<TestNode> children = new ArrayList<TestNode>();
	
	public TestNode (Description description) {
		mDescription = description;
	}
	
	public TestNode (String text) {
		mTestName = text;
	}
	
	public void addChild (TestNode child) {
		children.add(child);
	}

	public TestNode getChild(int i) {
		return children.get(i);
	}
	
	public void writeXml() {
		
	}



	public void preorderTraverseTree() { //TestNode focusNode) {
		System.out.println("<" + mTestName + ">");
		if (children.size() > 0) {

			for (int i = 0; i < children.size(); i++) {
				children.get(i).preorderTraverseTree(); //preorderTraverseTree(children.get(i));
			}

//			preorderTraverseTree(focusNode.leftChild);
//			preorderTraverseTree(focusNode.rightChild);
		}
		System.out.println("</" + mTestName + ">");
	}

}
