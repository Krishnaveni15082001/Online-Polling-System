package first;

import java.io.Serializable;

public class Nominee implements Serializable {
	private int nomId;
	private String nomName;
	private String nomPosition;
	private int nomAge;
	private String nomState;	
	

	public Nominee() {
		super();
		
	}

	public Nominee(int nomId, String nomName, String nomPosition, int nomAge, String nomState) {
		super();
		this.nomId = nomId;
		this.nomName = nomName;
		this.nomPosition = nomPosition;
		this.nomAge = nomAge;
		this.nomState = nomState;
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
	
	public void setNomId(int nomId) {
		this.nomId = nomId;
	}
	public int getNomId() {
		return nomId;
	}
	

	protected String getNomState() {
		return nomState;
	}

	protected void setNomState(String nomState) {
		this.nomState = nomState;
	}

	@Override
	public String toString() {
		return "[Id:" + nomId + ", Name:" + nomName + ", Position:" + nomPosition + ", State:" + nomState + "]";
	}

	

}