import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static void clearConsole() throws InterruptedException {
		try {
			new ProcessBuilder("clear").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		VehicleShowroom vehicleShowroom = new VehicleShowroom();
		
		Scanner scan = new Scanner(System.in);
		boolean starting = true;
		int again = 1;
		while(true) {
			
			try {
				clearConsole();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(starting == false) {
				System.out.println("\t1. Continue\t 2. Exit");
				again = scan.nextInt();
			}
			starting = false;
			if(again == 2) {
				break;
			}
			else {
				System.out.println("Please choose your action from the following:");
				System.out.println("\t1. Add Vehicle");
				System.out.println("\t2. Remove Vehicle");
				System.out.println("\t3. Show expected visitors");
				System.out.println("\t4. Show vehicle list in details");
				System.out.println();
				System.out.print("Enter the option's number:");
				
				int option = scan.nextInt();
				
				if(option == 1) {
					addVehicle(vehicleShowroom);
				}
				else if(option == 2) {
					removeVehicle(vehicleShowroom);
				}
				else if(option == 3) {
					showVehicleListWithVisitors(vehicleShowroom);
				}
				else if(option == 4) {
					showVehicleListWithDetails(vehicleShowroom);
				}
				else {
					System.out.println("Please input again...");
					continue;
				}
			}
			
		}
	}

	private static void showVehicleListWithDetails(VehicleShowroom vehicleShowroom) {
//		System.out.println("Details will be shown here");
		List<Vehicle> vehicleList = vehicleShowroom.getVehicleList();
		if(vehicleList.size() == 0) {
			System.out.println("No vehicles are added yet");
			System.out.println();
		}
		else {
			for(int i=0;i<vehicleList.size();i++) {
				Vehicle vehicle = vehicleList.get(i);
				System.out.println("Index: " + i);
				System.out.println("\t" +vehicle.getDetails());
			}
		}
	}

	private static void showVehicleListWithVisitors(VehicleShowroom vehicleShowroom) {

		List<Vehicle> vehicles = vehicleShowroom.getVehicleList();
		if(vehicles.size() == 0) {
			System.out.println("No vehicles are added yet");
			System.out.println();
		}
		else {
			for(int i=0;i<vehicles.size();i++) {
				Vehicle vehicle = vehicles.get(i);
				System.out.println("Index: " + i);
				System.out.println("\tModel number: " + vehicle.getModelNumber());
				System.out.println(" \tVehicle Type: " + vehicle.getVehicleType());
				
			}
		}
		
		System.out.println("\tExpected visitors : " + vehicleShowroom.getExpectedVisitors());
		System.out.println();
	}

	private static void removeVehicle(VehicleShowroom vehicleShowroom) {
		Scanner scan = new Scanner(System.in);
		List <Vehicle> vehicles = vehicleShowroom.getVehicleList();
		if(vehicles.size() == 0) {
			System.out.println("No vehicles are added yet");
			System.out.println();
		}
		else {
			int index = -1;
			boolean start = true;
			while(index < 0 || index >= vehicles.size()) {
				showVehicleListWithDetails(vehicleShowroom);
				if(start == false) {
					System.out.println("Entered input is invalid");
				}
				start = false;
				System.out.println("Please enter a valid index to remove: ");
				index = scan.nextInt();
			}
			Vehicle vehicle = vehicles.get(index);
			if(vehicle.getVehicleType() == VehicleType.sports) {
				int visitors = vehicleShowroom.getExpectedVisitors();
				vehicleShowroom.setExpectedVisitors(visitors - 20);
			}
			vehicles.remove(index);
		}
		
	}

	private static void addVehicle(VehicleShowroom vehicleShowroom) {
		VehicleType vehicleType = null;
		int modelNumber;
		EngineType engineType = null;
		int enginePower;
		int tireSize;
		int weight = 0;
		boolean turbo = false;
		
		
		//taking input for vehicle type
		System.out.println("Choose the Vehicle type from following:");
		System.out.println("\t1. "+ VehicleType.normal);
		System.out.println("\t2. "+ VehicleType.heavy);
		System.out.println("\t3. "+VehicleType.sports);
		System.out.print("Enter the option's number: ");
		
		int option = 0;
		Scanner scan = new Scanner(System.in);
		
		while(option == 0) {
			option = scan.nextInt();
			
			if(option == 1) {
				vehicleType = VehicleType.normal;
			}
			else if(option == 2) {
				vehicleType = VehicleType.heavy;
			}
			else if(option == 3) {
				vehicleType = VehicleType.sports;
			}
			else {
				System.out.println("Please Input again.");
				option = 0;
			}
		}
	
		//taking input for model number
		System.out.print("Please enter the model number: ");
		modelNumber = scan.nextInt();
		
		//taking input for engine type
		
		if(vehicleType == VehicleType.normal) {
			System.out.println("Choose the Engine type from following:");
			System.out.println("\t1. "+ EngineType.diesel);
			System.out.println("\t2. "+ EngineType.gas);
			System.out.println("\t3. "+ EngineType.oil);
			System.out.print("Enter the option's number: ");
			
			int engineOption;
			engineOption = scan.nextInt();
			if(engineOption == 1) {
				engineType = EngineType.diesel;
			}
			else if(engineOption == 2) {
				engineType = EngineType.gas;
			}
			else if(engineOption == 3) {
				engineType = EngineType.oil;
			}
			else {
				System.out.println("Please Input again.");
			}
		}
		else if(vehicleType == VehicleType.heavy) {
			engineType = EngineType.diesel;
			System.out.print("Please enter the weight: ");
			weight = scan.nextInt();
		}
		
		else if(vehicleType == VehicleType.sports) {
			engineType = EngineType.oil;
			System.out.println("Please enter turbo or not");
			System.out.println("\t0. If no");
			System.out.println("\t1. If yes");
			int turboOption = scan.nextInt();
			if(turboOption == 0) {
				turbo = false;
			}
			else {
				turbo = true;
			}
			
			
			int numOfVisitors = vehicleShowroom.getExpectedVisitors();
			vehicleShowroom.setExpectedVisitors(numOfVisitors +20); 
		}
		
		//taking input for engine power
		System.out.print("Please enter the engine's power: ");
		enginePower = scan.nextInt();
		
		//taking input for tire size
		System.out.print("Please enter the tire's size: ");
		tireSize = scan.nextInt();
		
		
		//object create
		List<Vehicle> vehicles = vehicleShowroom.getVehicleList();
		if(vehicleType == VehicleType.normal) {
			NormalVehicle car1 = new NormalVehicle(vehicleType, modelNumber, engineType, enginePower, tireSize);
			vehicles.add(car1);
		}
		else if(vehicleType == VehicleType.heavy) {
			HeavyVehicle car1 = new HeavyVehicle(vehicleType,modelNumber,enginePower,tireSize,weight);
			vehicles.add(car1);
		}
		else if(vehicleType == VehicleType.sports) {
			SportsVehicle car1 = new SportsVehicle(vehicleType, modelNumber,enginePower,tireSize,turbo);
			vehicles.add(car1);
		}
	}
}