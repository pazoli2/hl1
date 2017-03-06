package hu.helixlab.simple;

/**
 * Simple class
 * 
 * @author erbalazs
 */
public class Thing {

	private String nameOfTheThing;
	final private long idOfTheThing;

	public Thing(String nameOfTheThing) {
		super();
		this.nameOfTheThing = nameOfTheThing;
		this.idOfTheThing = System.currentTimeMillis();
	}

	public String getNameOfTheThing() {
		return nameOfTheThing;
	}

	public void setNameOfTheThing(String nameOfTheThing) {
		this.nameOfTheThing = nameOfTheThing;
	}

	public long getIdOfTheThing() {
		return idOfTheThing;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idOfTheThing ^ (idOfTheThing >>> 32));
		result = prime * result + ((nameOfTheThing == null) ? 0 : nameOfTheThing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Thing other = (Thing) obj;
		if (idOfTheThing != other.idOfTheThing)
			return false;
		if (nameOfTheThing == null) {
			if (other.nameOfTheThing != null)
				return false;
		} else if (!nameOfTheThing.equals(other.nameOfTheThing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Thing [nameOfTheThing=");
		builder.append(nameOfTheThing);
		builder.append(", idOfTheThing=");
		builder.append(idOfTheThing);
		builder.append("]");
		return builder.toString();
	}

}
