package DBDS;

import java.util.ArrayList;

public class Results {

	static ArrayList<TestNode> mFeatures = new ArrayList<TestNode>();
	
	
	public static void main(String[] args) {

		mFeatures.add(new TestNode("Feature1"));
		mFeatures.get(0).addChild(new TestNode("Scenario1"));
		mFeatures.get(0).getChild(0).addChild(new TestNode("TestStep1"));
		mFeatures.get(0).getChild(0).addChild(new TestNode("TestStep2"));
		
		// TODO: One Feature - One file, or add parent tag.
		//mFeatures.add(new TestNode("Feature2"));
		
		
		for (TestNode tn: mFeatures) {
			tn.preorderTraverseTree();
		}

	}
	
}
