
public class HeavyVehicle extends Vehicle{
	
	private int weight;
	public HeavyVehicle(VehicleType vehicleType, String modelNumber, int enginePower, int tireSize, int weight) {
		super(vehicleType, modelNumber, EngineType.diesel, enginePower, tireSize);
		this.weight = weight;
	}


	@Override
	public String getDetails() {
		String details = "Vehicle Type: " + getVehicleType() + "\n\t" + "Model Number: " + getModelNumber() + "\n\t" + "Engine Type: " + getEngineType() + "\n\t" + "Engine Power: " + getEnginePower() + "\n\t" + "Tire Size: " + getTireSize() + "\n";
		return details;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
