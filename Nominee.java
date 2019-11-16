package first;

import java.io.Serializable;

import first.Functions.ageNotValid;

@SuppressWarnings("serial")
public class Nominee implements Serializable {
	private int nomId;
	private String nomName;
	private String nomPosition;
	private int nomAge;
	private String nomState;
	private String nomTelanganaDistrict;
	private String nomAndhraDistrict;
	private String nomMaharastraDistrict;
	

	public Nominee() {
		super();
		
	}

	public Nominee(int nomId, String nomName, String nomPosition, int nomAge, String nomState, String nomTelanganaDistrict, String nomAndhraDistrict, String nomMaharastraDistrict) {
		super();
		this.nomId = nomId;
		this.nomName = nomName;
		this.nomPosition = nomPosition;
		this.nomAge = nomAge;
		this.nomState = nomState;
		this.nomTelanganaDistrict = nomTelanganaDistrict;
		this.nomAndhraDistrict = nomAndhraDistrict;
		this.nomMaharastraDistrict = nomMaharastraDistrict;
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
	protected String getNomTelanganaDistrict() {
		return nomTelanganaDistrict;
	}

	protected void setNomTelanganaDistrict(String nomTelanganaDistrict) {
		this.nomTelanganaDistrict = nomTelanganaDistrict;
	}
	protected String getNomAndhraDistrict() {
		return nomAndhraDistrict;
	}

	protected void setNomAndhraDistrict(String nomAndhraDistrict) {
		this.nomAndhraDistrict = nomAndhraDistrict;
	}
	protected String getNomMaharastraDistrict() {
		return nomMaharastraDistrict;
	}

	protected void setNomMaharastraDistrict(String nomMaharastraDistrict) {
		this.nomMaharastraDistrict = nomMaharastraDistrict;
	}
	

	@Override
	public String toString() {
		
		return "Nominee [Id=" + nomId + ", Name=" + nomName + ", Position=" + nomPosition + ", Age="
				+ nomAge + ", State=" + nomState + ", Telangana District=" + nomTelanganaDistrict
				+ ", Andhra District=" + nomAndhraDistrict + ", Maharastra District=" + nomMaharastraDistrict + "]";
	}
}






