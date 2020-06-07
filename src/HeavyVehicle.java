import java.text.MessageFormat;

public class HeavyVehicle extends Vehicle{
	
	private int weight;
	public HeavyVehicle(VehicleType vehicleType, int modelNumber, int enginePower, int tireSize, int weight) {
		super(vehicleType, modelNumber, EngineType.diesel, enginePower, tireSize);
		this.weight = weight;
	}


	@Override
	public void run() {
		System.out.println("Heavy Vehicle is running...");
	}

	@Override
	public String getName() {
		return getVehicleType().toString();
	}

	@Override
	public String getDetails() {
		String details = "Vehicle Type: {0}, Model Number: {1}, Engine Type: {2}, Engine Power: {3}, Tire Size: {4}, Weight: {5}";
		MessageFormat mf = new MessageFormat(details);
		details = mf.format(new Object[] {VehicleType.heavy, getModelNumber(), EngineType.diesel, getEnginePower(), getTireSize(),getWeight()});
		
		return details;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
