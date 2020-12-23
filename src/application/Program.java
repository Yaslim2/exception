package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Número do quarto: ");
		int num = sc.nextInt();
		System.out.print("Data de Check-in (DD/MM/YYYY): ");
		String ci = sc.next();
		System.out.print("Data de Check-out (DD/MM/YYYY): ");
		String co = sc.next();
		Date checkIn = sdf.parse(ci);
		Date checkOut = sdf.parse(co);
		
		if(!(checkOut.after(checkIn))) {
			System.out.println("Erro na reserva: A data de check-out deve ser posterior à data de check-in.");
		} else {
			Reservation reserve = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reserve);
			
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva: ");
			
			System.out.print("Data de Check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			
			String error = reserve.updateDates(checkIn, checkOut);
			if(error == null) {
				System.out.println("Reserva: " + reserve);
			} else {
				System.out.println(error);
			}
			
		}
		
		sc.close();
	}

}
