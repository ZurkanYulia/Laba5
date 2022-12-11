package Service;

import Motocycle.Garage;
import Motocycle.Motorcycle;
import Motocycle.TransmissionType;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Garage garage = new Garage();
		Motorcycle moto1 = new Motorcycle.Builder( "BMW G 310 R",
				"AC2345BO",
				313,
				TransmissionType.MANUAL,
				2017,
				"Roman Mel'nyk")
				.setColor("red")
				.buidl();
		Motorcycle moto2 = new Motorcycle.Builder( "Yamaha XJ6",
				"AC6776BM",
				600,
				TransmissionType.AUTO,
				2013,
				"Olga Yakubiv")
				.setColor("yellow")
				.buidl();
		Motorcycle moto3 = new Motorcycle.Builder( "Honda CBR 250R",
				"AA9326BB",
				250,
				TransmissionType.MANUAL,
				2014,
				"Nazar Todoruk")
				.setColor("black")
				.buidl();
		garage.addMotorcycle(moto1);
		garage.addMotorcycle(moto2);
		garage.addMotorcycle(moto3);
		List<Motorcycle> ourMotorcycles = garage.getMotorcycleList();
		for(Motorcycle motorcycle : ourMotorcycles){
			System.out.println(motorcycle.toString());
		}
		System.out.println();
		GarageService garageService = new GarageService(garage);
		// сортування по водіям
		for(Motorcycle motorcycle : garageService.sortByDrivers()){
			System.out.println(motorcycle.toString());
		}
		System.out.println();

		// сортування по рокам виробництва
		for(Motorcycle motorcycle : garageService.sortByManufactureYear()){
			System.out.println(motorcycle.toString());
		}
		System.out.println();

		// перевірка клієнта
		String client1 = "Nazar Todoruk";
		String client2 = "Roman Starovskiy";
		System.out.println(client1 + " is client: " + (garageService.checkClient(client1) ? "Yes" : "No"));
		System.out.println(client2 + " is client: " + (garageService.checkClient(client2) ? "Yes" : "No"));
	}
}
