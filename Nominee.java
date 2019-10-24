public class Nominee {
	private int nomId;
	private String nomName;
	private String nomPosition;
	private int nomAge;
	
	static int counter = 10000;

	public Nominee() {
		super();
		this.nomId = counter++;
	}

	public Nominee(String nomName, String nomPosition, int nomAge) {
		super();
		this.nomId = counter++;
		this.nomName = nomName;
		this.nomPosition = nomPosition;
		this.nomAge = nomAge;
	}

	public String getNomName() {
		return nomName;
	}

	public void setNomName(String nomName) {
		this.nomName = nomName;
	}
	
	public String getNomPosition() {
		return nomPosition;
	}

	public void setNomPosition(String nomPosition) {
		this.nomPosition = nomPosition;
	}	

	public int getNomAge() {
		return nomAge;
	}

	public void setNomAge(int nomAge) {
		this.nomAge = nomAge;
	}
	
	public int getNomId() {
		return nomId;
	}

	@Override
	public String toString() {
		return "Nominee [ Id=" + nomId + ", Name=" + nomName + ", Position=" + nomPosition + "]";
	}

}