import java.text.MessageFormat;

public class NormalVehicle extends Vehicle {

	
	public NormalVehicle(VehicleType vehicleType, int modelNumber, EngineType engineType, int enginePower,
			int tireSize) {
		super(vehicleType, modelNumber, engineType, enginePower, tireSize);
	}

	@Override
	public void run() {
		System.out.println("Normal vehicle is running..");

	}

	@Override
	public String getName() {
		return getVehicleType().toString();
	}

	@Override
	public String getDetails() {
		String details = "Vehicle Type: {0}, Model Number; {1}, Engine Type: {2}, Engine Power: {3}, Tire Size: {4}";

		MessageFormat mf = new MessageFormat(details);
		details = mf.format(new Object[] { getVehicleType(), getModelNumber(), getEngineType(), getEnginePower(), getTireSize() });

		return details;
	}

}


