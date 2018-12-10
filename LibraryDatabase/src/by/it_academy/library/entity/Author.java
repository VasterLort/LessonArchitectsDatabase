package by.it_academy.library.entity;

public class Author {
	private int id;
	private String name;
	private String surName;
	private int age;

	public Author(int id, String name, String surName, int age) {
		super();
		this.id = id;
		this.name = name;
		this.surName = surName;
		this.age = age;
	}
	
	public Author() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getSurName() {
		return surName;
	}

	public int getAge() {
		return age;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surName == null) ? 0 : surName.hashCode());
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
		Author other = (Author) obj;
		if (age != other.age)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surName == null) {
			if (other.surName != null)
				return false;
		} else if (!surName.equals(other.surName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Author [id = " + id + ", name = " + name + ", surName = " + surName + ", age = " + age + "]" + "\n";
	}


}
