package spring.STS.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "color")
public class MyColor extends BaseEntity {

	private String name;

	public MyColor() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
