package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import model.data_structures.noExisteObjetoException;
import model.logic.Model;
import model.logic.Multa;
import view.View;


public class Controller {


	// -------------------------------------------------------------
	// Attributes
	// -------------------------------------------------------------

	/**
	 * A model.
	 */
	private Model modelo;

	/**
	 * A view.
	 */
	private View view;

	// -------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------

	/**
	 * Creates the project view and the project model
	 */
	public Controller() {
		modelo = new Model();
		view = new View();
	}

	// -------------------------------------------------------------
	// Methods
	// -------------------------------------------------------------

	/**
	 * Prints the user options and updates the view using the model.
	 *
	 * @throws InputMismatchException If the user inputs an incorrect number sequence.
	 * @throws noExisteObjetoException 
	 */
	public void run() throws InputMismatchException, noExisteObjetoException {
		try {
			Scanner reader = new Scanner(System.in);
			boolean end = false;

			while (!end) {
				view.displayMenu();

				int option = reader.nextInt();
				switch (option) {

				case 0:

					view.displayOp0Menu(modelo.darInfoCargaDatos());

					break;
				case 1:

					view.displayOp1Menu();
					int m = reader.nextInt();
					view.displayOp1Data(modelo.mayorGravedad(m));

					break;
				case 2:
					view.displayOp2Menu();
					int mes = reader.nextInt();
					view.displayOp21Menu();
					String dia = reader.next();
					view.displayOp2Data(modelo.mesDia(mes, dia));
					break;
				case 3:
					view.displayOp3Menu();
					String fMin = reader.next();
					
					view.displayOp31Menu();
					String fMax = reader.next();
					
					view.displayOp32Menu();
					String loc = reader.next();


					
					try {
						String msj = modelo.fechaHoraLoc(fMin, fMax, loc);
						view.displayOp3Data(msj);
						
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						System.out.println("Escriba bien la fecha \n");
					}
					
					
					break;
				case 4:
					view.displayOp4Menu();
					int n = reader.nextInt();
					view.displayOp4Data(modelo.comparendosMasCercanos(n));

					break;
				case 5: 
					view.displayOp5Menu();
					String medioDete = reader.next();
					view.displayOp51Menu();
					String vehiculo = reader.next();
					view.displayOp52Menu();
					String servicio = reader.next();
					view.displayOp53Menu();
					String localidad = reader.next();
					
					String msj = modelo.reque2B(medioDete, vehiculo, servicio, localidad);
					view.displayOp5Data(medioDete, vehiculo, servicio, localidad, msj);
					break;
				case 6:
					view.displayOp6Menu();
					double min = reader.nextDouble();
					view.displayOp61Menu();
					double max = reader.nextDouble();
					view.displayOp62Menu();
					String veh = reader.next();
				
					String mesj = modelo.darMultasLatitudMinMax(min, max, veh);
					view.displayOpData6(min, max, veh, mesj);
				
					break;
				
				default:
					view.badOption();
					end = true;
					break;
				}
			}
		} 
		catch (InputMismatchException e)
		{
			run();
		}
	}

}
