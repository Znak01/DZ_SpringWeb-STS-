package spring.STS.web.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import spring.STS.web.validation.annotation.UniqueCarModel;

@Entity
@Table(name = "car")
@Getter
@Setter
@UniqueCarModel({"make", "model"})
public class Car extends BaseEntity {

	
	
	private String make;
	
	
	
	
	private String model;
	
	@OneToOne
	@JoinColumn(name = "color_id")
	@NotNull(message = "Cant be empty")
	private MyColor color;

	public Car() {
	}
	
	
	
}
