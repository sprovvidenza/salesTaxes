package lastminute.com.model;

public enum Genre {
	FOOD("FOOD"), MEDICAL("MEDICAL"), BOOKS("BOOKS"), GENERIC("GENERIC");

	private String value;

	Genre(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return this.getValue();
	}

	public boolean isNotGeneric(){
		return !this.equals(GENERIC);
	}

	public boolean isGeneric(){
		return this.equals(GENERIC);
	}
}
