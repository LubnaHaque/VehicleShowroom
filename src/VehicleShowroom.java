
import java.util.ArrayList;
import java.util.List;

public class VehicleShowroom {
	private int expectedVisitors;
	private List<Vehicle> vehicleList;
	
	public VehicleShowroom() {
		super();
		expectedVisitors = 30;
		setVehicleList(new ArrayList<>());
	}

	public int getExpectedVisitors() {
		return expectedVisitors;
	}

	public void setExpectedVisitors(int expectedVisitors) {
		this.expectedVisitors = expectedVisitors;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
}
