package Validations;

/**
 * Object#1 that implements IValidator
 */
public class ObjRP implements IValidator{

	@Override
	public boolean isValid() {
		System.out.println("RP-true");
		return true;
	}
}
