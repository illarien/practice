package Validations;

/**
 * Object#2 that implements IValidator
 */
public class ObjU implements IValidator {

	@Override
	public boolean isValid() {
		System.out.println("ObjU-true");
		return true;
	}
}