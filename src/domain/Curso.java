package domain;

public class Curso {
	private String initials;
	   private String name;
	   private int credits;	   
	   
	   public Curso(String initials, String name, int credits) {
		super();
		this.initials = initials;
		this.name = name;
		this.credits = credits;
	   }

	   public String getInitials() {
		   return initials;
	   }

	   public void setInitials(String initials) {
		   this.initials = initials;
	   }

	   public String getName() {
		   return name;
	   }

	   public void setName(String name) {
		   this.name = name;
	   }

	   public int getCredits() {
		   return credits;
	   }

	   public void setCredits(int credits) {
		   this.credits = credits;
	   }

	   @Override
	   public String toString() {
		return "[Sigla= " + initials + ", Nombre= " + name + ", Créditos= " + credits + "]";
	   }
}
