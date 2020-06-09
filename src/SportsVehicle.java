import java.text.MessageFormat;

public class SportsVehicle extends Vehicle{
	
	
	private boolean turbo;
	
	public SportsVehicle(VehicleType vehicleType, String modelNumber, int enginePower,
			int tireSize, boolean turbo) {
		super(vehicleType, modelNumber, EngineType.oil, enginePower, tireSize);
		this.setTurbo(turbo);
	}

	

	@Override
	public String getDetails() {
		String details = "Vehicle Type: " + getVehicleType() + "\n\t" + "Model Number: " + getModelNumber() + "\n\t" + "Engine Type: " + getEngineType() + "\n\t" + "Engine Power: " + getEnginePower() + "\n\t" + "Tire Size: " + getTireSize() + "\n";
		return details;
	}

	public boolean isTurbo() {
		return turbo;
	}

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

}
