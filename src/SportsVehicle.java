import java.text.MessageFormat;

public class SportsVehicle extends Vehicle{
	
	
	private boolean turbo;
	
	public SportsVehicle(VehicleType vehicleType, int modelNumber, int enginePower,
			int tireSize, boolean turbo) {
		super(vehicleType, modelNumber, EngineType.oil, enginePower, tireSize);
		this.setTurbo(turbo);
	}

	

	@Override
	public void run() {
		System.out.println("Sports car is Running...");
		
	}

	@Override
	public String getName() {
		return getVehicleType().toString();
	}

	@Override
	public String getDetails() {
		String details = "Vehicle Type: {0}, Model Number: {1}, Engine Type: {2}, Engine Power: {3}, Tire Size: {4}, Turbo or not: {5}";
		MessageFormat mf = new MessageFormat(details);
		details = mf.format(new Object[] {VehicleType.sports, getModelNumber(), EngineType.oil, getEnginePower(), getTireSize(), isTurbo()});
		return details;
	}



	public boolean isTurbo() {
		return turbo;
	}



	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

}
