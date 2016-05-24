package Validations;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * Validator runner
 */
public class Runner {

	public static void main(String[] args) {
		ArrayList<IValidator> validators = new ArrayList<>();
		validators.add(new ObjRP());
		validators.add(new ObjU());
		for (IValidator validator: validators) {
			validator.isValid();
		}
	}
}