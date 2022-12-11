package Service;

import Motocycle.Garage;
import Motocycle.Motorcycle;

import java.util.List;
import java.util.stream.Collectors;

public class GarageService {
	private Garage garage;
	public GarageService(Garage garage){
		this.garage=garage;
	}

	public List<Motorcycle> sortByDrivers(){
		return garage.getMotorcycleList().stream().sorted().collect(Collectors.toList());
	}
	public List<Motorcycle> sortByManufactureYear(){
		return garage.getMotorcycleList().stream().sorted(new ManufactureYearComparator()).collect(Collectors.toList());
	}
	public boolean checkClient (String client){
		return garage.getMotorcycleList().stream().anyMatch(x -> x.getDriver().equals(client));
	}
}
