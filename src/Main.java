import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		VehicleShowroom vehicleShowroom = new VehicleShowroom();
		
		Scanner scan = new Scanner(System.in);
		
		boolean isFirstTime = true;
		while(true) {
			int nextStep = 1;
			if(isFirstTime == false) {
				System.out.println("===============================================");;
				System.out.println("Continue the process or exit?");
				System.out.println("\t1. Continue\t 2. Exit");
				
				boolean innerFirstTime = true;
				int innerNextStep = 0;
				while(innerNextStep < 1 || innerNextStep > 2) {
					if(innerFirstTime == false) {
						System.out.println("Entered input is invalid");
					}
					innerFirstTime = false;
					System.out.print("Please enter a valid option: ");
					innerNextStep = scan.nextInt();
				}
				nextStep = innerNextStep;
				
			}
			isFirstTime = false;
			if(nextStep == 2) {
				System.out.println("Terminating...");
				System.out.println("Terminated!");
				break;
			}
			else if(nextStep == 1) {
				System.out.println("Please choose your action from the following:");
				System.out.println("\t1. Add Vehicle");
				System.out.println("\t2. Remove Vehicle");
				System.out.println("\t3. Show vehicle list with expected visitors");
				System.out.println("\t4. Show vehicle list in details");
				System.out.println("\t5. Exit");
				System.out.println();
				System.out.print("Enter an action number: ");
				int option = 0;
				while(option == 0) {
					option = scan.nextInt();
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
					else if(option == 5) {
						System.out.println("Terminating...");
						System.out.println("Terminated!");
						break;
					}
					else {
						System.out.print("Please give a valid input for choosing action: ");
						option = 0;
					}
				}
			}
		}
	}

	private static void showVehicleListWithDetails(VehicleShowroom vehicleShowroom) {
		List<Vehicle> vehicleList = vehicleShowroom.getVehicleList();
		if(vehicleList.size() == 0) {
			System.out.println("No vehicles are added yet");
			System.out.println();
		}
		else {
			System.out.println("The vehicles are: ");
			for(int i=0;i<vehicleList.size();i++) {
				Vehicle vehicle = vehicleList.get(i);
				System.out.println("Index: " + i);
				System.out.println("\t" +vehicle.getDetails());
			}
		}
	}

	private static void showVehicleListWithVisitors(VehicleShowroom vehicleShowroom) {

		List<Vehicle> vehicles = vehicleShowroom.getVehicleList();
		System.out.println("\tExpected visitors : " + vehicleShowroom.getExpectedVisitors());
		System.out.println();
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
			boolean isFirstTime = true;
			while(index < 0 || index >= vehicles.size()) {
				showVehicleListWithDetails(vehicleShowroom);
				if(isFirstTime == false) {
					System.out.println("Entered input is invalid");
				}
				isFirstTime = false;
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
		String modelNumber = null;
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
		System.out.print("Enter the option number: ");
		
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
				System.out.print("Invalid input please Input again for vehicle type: ");
				option = 0;
			}
		}
		
		//taking input for model number
		System.out.print("Please enter the model number: ");
		scan.nextLine();
		modelNumber = scan.nextLine();
		
		//taking input for engine type
		
		if(vehicleType == VehicleType.normal) {
			int engineTypeOption = 0;
			System.out.println("Choose the Engine type from following:");
			System.out.println("\t1. "+ EngineType.diesel);
			System.out.println("\t2. "+ EngineType.gas);
			System.out.println("\t3. "+ EngineType.oil);
			System.out.print("Enter the option's number: ");
			while(engineTypeOption == 0) {
				engineTypeOption = scan.nextInt();
				
				if(engineTypeOption == 1) {
					engineType = EngineType.diesel;
				}
				else if(engineTypeOption == 2) {
					engineType = EngineType.gas;
				}
				else if(engineTypeOption == 3) {
					engineType = EngineType.oil;
				}
				else {
					System.out.print("Invalid input please Input again for engine type: ");
					engineTypeOption = 0;
				}
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
			System.out.print("Enter the option number: ");
			int turboOption = -1;
			while(turboOption == -1) {
				turboOption = scan.nextInt();
				if(turboOption == 0) {
					turbo = false;
				}
				else if(turboOption == 1){
					turbo = true;
				}
				else {
					System.out.print("Please give a valid input for turbo or not: ");
					turboOption = -1;
				}
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
		System.out.println("The Vehicle is added successfully...");
	}
}