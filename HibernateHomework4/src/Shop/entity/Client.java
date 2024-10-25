package Shop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	int id;
	String name;
	long mobile_number;
	String Address;

	public Client(int id, String name, long mobile_number, String address) {
		super();
		this.id = id;
		this.name = name;
		this.mobile_number = mobile_number;
		Address = address;
	}
	
	public Client() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", mobile_number=" + mobile_number + ", Address=" + Address
				+ "]";
	}
	

}
