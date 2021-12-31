package entity.bike;

public class Bike {
	private int id;

	private String name;
	private String type;
	private int weight;
	private String license;
	private String createdAt;
	private String producer;
	private int cost;
	private int parkId;
	
	public Bike() {}

	public Bike(String name, String type,String license, String producer) {
		this.name = name;
		this.type = type;
		this.license = license;
		this.producer = producer;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
   	

}
