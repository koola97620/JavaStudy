package interview_builder;

import java.util.Date;

import org.junit.Test;

class Animal {
	
	
}

public class Pet {
	public static class Builder {
		private Animal animal;
		private String petName;
		private Date dateOfBirth;
		
		public Builder withAnimal(final Animal animal) {
			this.animal = animal;
			return this;
		}
		
		public Builder withPetName(final String petName) {
			this.petName = petName;
			return this;
		}
		
		public Builder withDateOfBirth(final Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			return this;
		}
		
		public Pet Build() {
			if(animal == null || petName ==null || dateOfBirth==null) {
				throw new IllegalStateException("Cannot create pet");
			}
			return new Pet(animal,petName,dateOfBirth);
		}
		
	}  //빌더 끝
	
	private final Animal animal;
	private final String petName;
	private final Date dateOfBirth;
	
	private Pet(final Animal animal, final String petName, final Date dateOfBirth) {
		this.animal = animal;
		this.petName = petName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
	@Test(expected = IllegalStateException.class)
	public static void main(String[] args) {
		Pet.Builder builder = new Pet.Builder();
		Pet pet = builder.withPetName("Fido").Build();
		System.out.println(pet);
	}

}
