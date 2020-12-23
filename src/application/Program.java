package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Número do quarto: ");
			int num = sc.nextInt();
			System.out.print("Data de Check-in (DD/MM/YYYY): ");
			String ci = sc.next();
			System.out.print("Data de Check-out (DD/MM/YYYY): ");
			String co = sc.next();
			Date checkIn = sdf.parse(ci);
			Date checkOut = sdf.parse(co);
			
			
			Reservation reserve = new Reservation(num, checkIn, checkOut);
			System.out.println("Reservation: " + reserve);
			
			System.out.println();
			System.out.println("Entre com as datas para atualizar a reserva: ");
			
			System.out.print("Data de Check-in (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de Check-out (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
				
			reserve.updateDates(checkIn, checkOut);
		}
		catch (ParseException e) {
			System.out.println("Formato de data inválida!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		sc.close();
	}
}

