package in.railworld.app.Exceptions;

public class ResourceNotFoundEception extends RuntimeException{
	
	String resourceName;
	String fieldName;
	long fieldValue;
	public ResourceNotFoundEception(String resourceName, String fieldName, int fieldValue) {
		super(String.format("%s not found with %s : %1 ", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	

}
