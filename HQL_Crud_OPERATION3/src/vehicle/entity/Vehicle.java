package vehicle.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int car_id;   
	private String model_name;
	private String brand_name;
	private int price;
	private String color;
	
	public Vehicle(int car_id, String model_name, String brand_name, int price, String color) {
		super();
		this.car_id = car_id;
		this.model_name = model_name;
		this.brand_name = brand_name;
		this.price = price;
		this.color = color;
	}
	 
	public Vehicle() {
		
		
	}

	public int getCar_id() {
		return car_id;
	}

	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Vehicle [car_id=" + car_id + ", model_name=" + model_name + ", brand_name=" + brand_name + ", price="
				+ price + ", color=" + color + "]";
	}

	
	
	
	
}

