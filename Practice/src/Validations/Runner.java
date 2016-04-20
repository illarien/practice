package Validations;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class Runner {

	public static void main(String[] args) {
		
		ArrayList<IValidator> items = new ArrayList<>();
		items.add(new ObjRP());
		items.add(new ObjU());
		for (int i = 0; i < items.size(); i++) {
			items.get(i).isValid();
		}
		
		
	}

}
