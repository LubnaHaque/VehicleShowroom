
public class NormalVehicle extends Vehicle {

	
	public NormalVehicle(VehicleType vehicleType, String modelNumber, EngineType engineType, int enginePower,
			int tireSize) {
		super(vehicleType, modelNumber, engineType, enginePower, tireSize);
	}


	@Override
	public String getDetails() {
		String details = "Vehicle Type: " + getVehicleType() + "\n\t" + "Model Number: " + getModelNumber() + "\n\t" + "Engine Type: " + getEngineType() + "\n\t" + "Engine Power: " + getEnginePower() + "\n\t" + "Tire Size: " + getTireSize() + "\n";
		return details;
	}

}


