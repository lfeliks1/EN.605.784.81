package app.demo.bean;
public class Faculty {

	private final String name;

	public Faculty(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
}
