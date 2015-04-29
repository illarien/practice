package ProfileRenamer;

public class Processor {

	private static Process p;
	private String command;
	
	public Processor (String command) {
		this.command = command;
	}
	
	public void execute() {
		System.out.println(command);
	}
}
