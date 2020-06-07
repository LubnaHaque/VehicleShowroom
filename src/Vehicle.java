
public abstract class Vehicle {
	
	protected VehicleType vehicleType;
	protected int modelNumber;
	
	protected EngineType engineType;
	protected int enginePower;
	protected int tireSize;
	
	
	public Vehicle(VehicleType vehicleType, int modelNumber, EngineType engineType, int enginePower, int tireSize) {
		super();
		this.vehicleType = vehicleType;
		this.modelNumber = modelNumber;
		this.engineType = engineType;
		this.enginePower = enginePower;
		this.tireSize = tireSize;
	}
	
	
	public abstract void run();
	public abstract String getName();
	public abstract String getDetails();
	
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public int getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	public EngineType getEngineType() {
		return engineType;
	}
	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}
	public int getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(int enginePower) {
		this.enginePower = enginePower;
	}
	public int getTireSize() {
		return tireSize;
	}
	public void setTireSize(int tireSize) {
		this.tireSize = tireSize;
	}
	
	
	
}
