package main.java.boletin2;
import java.util.Scanner;
public class Ejercicio_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hora;
		System.out.println("Dime la hora en este formato (dd-mm-aaaa): ");
		hora=sc.next();
		String[] horaSeparada = hora.split("-");
        int horaDiaInt = Integer.parseInt(horaSeparada[0]);
        int horaMesInt = Integer.parseInt(horaSeparada[1]);
        int horaAnyoInt = Integer.parseInt(horaSeparada[2]);
		if (fechaCorrecta(hora)) {
		    if (pasarMes(hora)) {
                horaMesInt += 1;
                horaDiaInt=1;
                System.out.println("Tu nueva fecha es " + horaDiaInt + "-" + horaMesInt + "-" + horaAnyoInt);
            } else if (pasarAnyo(hora)) {
                horaAnyoInt += 1;
                horaDiaInt=1;
                horaMesInt=1;
                System.out.println("Tu nueva fecha es " + horaDiaInt + "-" + horaMesInt + "-" + horaAnyoInt);
            }else {
            	horaDiaInt+=1;
            }
            System.out.println("Tu nueva fecha es " + horaDiaInt + "-" + horaMesInt + "-" + horaAnyoInt);
        }
	}
	
	public static boolean fechaCorrecta(String hora) {
        String[] horaSeparada=hora.split("-");
        String horaDia=horaSeparada[0];
        String horaMes=horaSeparada[1];
        String horaAnyo=horaSeparada[2];
        int horaDiaInt=Integer.valueOf(horaDia);
        int horaMesInt=Integer.valueOf(horaMes);
        int horaAnyoInt=Integer.valueOf(horaAnyo);
        boolean fechaCorrecta=false;
        if ((horaDiaInt >= 1 && horaDiaInt <= 31) && (horaMesInt==1 || horaMesInt==3 || horaMesInt==5 || horaMesInt==7 || horaMesInt==8 || horaMesInt==10)) {
            fechaCorrecta=true;
        }else if ((horaDiaInt >= 1 && horaDiaInt <= 30) && (horaMesInt==4 || horaMesInt==6 || horaMesInt==9 || horaMesInt==11)) {
            fechaCorrecta=true;
        }else if ((horaDiaInt >= 1 && horaDiaInt <= 28) && (horaMesInt==2) && !anyoBisiesto(hora)) {
            fechaCorrecta=true;
        }else if ((horaDiaInt >= 1 && horaDiaInt <= 29) && (horaMesInt==2) && anyoBisiesto(hora)) {
            fechaCorrecta=true;
        }
        return fechaCorrecta;
    }
	
	 public static boolean anyoBisiesto(String hora) {
	        String[] horaSeparada=hora.split("-");
	        String horaDia=horaSeparada[0];
	        String horaMes=horaSeparada[1];
	        String horaAnyo=horaSeparada[2];
	        int horaDiaInt=Integer.valueOf(horaDia);
	        int horaMesInt=Integer.valueOf(horaMes);
	        int horaAnyoInt=Integer.valueOf(horaAnyo);
	        boolean esBisiesto=false;
	        if ((horaAnyoInt % 4 == 0 && horaAnyoInt % 100 != 0) || (horaAnyoInt % 400 == 0)) {
	            esBisiesto=true;
	        }else {
	            esBisiesto=false;
	        }
	        return esBisiesto;
	    }
	
	public static boolean pasarMes(String hora) {
		String[] horaSeparada=hora.split("-");
		String horaDia=horaSeparada[0];
		String horaMes=horaSeparada[1];
		String horaAnyo=horaSeparada[2];
		int horaDiaInt=Integer.valueOf(horaDia);
		int horaMesInt=Integer.valueOf(horaMes);
		int horaAnyoInt=Integer.valueOf(horaAnyo);
		boolean pasaMes=false;
		if ((horaDiaInt==31) && (horaMesInt==1 || horaMesInt==3 || horaMesInt==5 || horaMesInt==7 || horaMesInt==8 || horaMesInt==10 || horaMesInt==12)) {
			horaDiaInt=1;
			horaMesInt+=1;
			pasaMes=true;
		}else if ((horaDiaInt==30) && (horaMesInt==4 || horaMesInt==6 || horaMesInt==4 || horaMesInt==9 || horaMesInt==11)) {
			horaDiaInt=1;
			horaMesInt+=1;
			pasaMes=true;
		}else if ((horaDiaInt==29) && (horaMesInt==2)) {
			horaDiaInt=1;
			horaMesInt+=1;
			pasaMes=true;
		}else {
			horaDiaInt=1;
			horaMesInt+=1;
		}
		return pasaMes;
	}
	
	public static boolean pasarAnyo(String hora) {
		String[] horaSeparada=hora.split("-");
		String horaDia=horaSeparada[0];
		String horaMes=horaSeparada[1];
		String horaAnyo=horaSeparada[2];
		boolean pasaAnyo=false;
		int horaDiaInt=Integer.valueOf(horaDia);
		int horaMesInt=Integer.valueOf(horaMes);
		int horaAnyoInt=Integer.valueOf(horaAnyo);
		if ((horaDiaInt==31) && (horaMesInt==12)) {
			horaDiaInt=1;
			horaMesInt=1;
			horaAnyoInt+=1;
			pasaAnyo=true;
		}
		return pasaAnyo;
	}
}
