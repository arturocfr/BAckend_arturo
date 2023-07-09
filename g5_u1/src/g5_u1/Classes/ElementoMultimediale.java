package g5_u1.Classes;

public class ElementoMultimediale {
protected String title;
	
	public ElementoMultimediale(String title) {
		this.title = title	;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract void play();


}

