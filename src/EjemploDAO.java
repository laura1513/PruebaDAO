import dao.sql.SQLiteDAOManagerImpl;
import models.Circuito;
import models.Escuderia;
import dao.sql.SQLiteEscuderiaDAOImpl;
import models.Piloto;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjemploDAO {
    public static void main(String[] args) {

        SQLiteDAOManagerImpl mundial = new SQLiteDAOManagerImpl();

        System.out.println("\nMostrar todas");
        System.out.println("-------------------------------");
        mundial.getEscuderiaDAO().findAll();/*.forEach(System.out::println);

        System.out.println("\nMostrar solo una");
        System.out.println("-------------------------------");
        System.out.println(mundial.getEscuderiaDAO().findById("Mercedes"));

        System.out.println("\nInsertar una escudería");
        System.out.println("-------------------------------");
        Escuderia seat = new Escuderia("Seat", "Seat-2019", "Seat 4 Latas");
        mundial.getEscuderiaDAO().save(seat);
        mundial.getEscuderiaDAO().findAll().forEach(System.out::println);

        System.out.println("\nActualizar una escudería");
        System.out.println("-------------------------------");
        seat.setChasis("Seat-2023");
        seat.setMotor("Seat TDI 2.0");
        mundial.getEscuderiaDAO().update(seat);
        mundial.getEscuderiaDAO().findAll().forEach(System.out::println);

        System.out.println("\nBorrar una escudería");
        System.out.println("-------------------------------");
        mundial.getEscuderiaDAO().deleteById("Seat");
        mundial.getEscuderiaDAO().findAll().forEach(System.out::println);*/

        //.................................................................

        System.out.println("\nMostrar todos");
        System.out.println("-------------------------------");
        mundial.getPilotoDAO().findAll();//.forEach(System.out::println);

        /*System.out.println("\nMostrar solo uno");
        System.out.println("-------------------------------");
        System.out.println(mundial.getPilotoDAO().findById(16));

        System.out.println("\nInsertar un piloto");
        System.out.println("-------------------------------");
        Piloto paco = new Piloto("Paco Ramirez", 50, new Escuderia("Random", "Random-2019", "Random 5 Latas"),LocalDate.parse("2003-01-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mundial.getPilotoDAO().save(paco);
        mundial.getPilotoDAO().findAll().forEach(System.out::println);

        System.out.println("\nActualizar un piloto");
        System.out.println("-------------------------------");
        paco.setNombre("Roberto Martinez");
        mundial.getPilotoDAO().update(paco);
        mundial.getPilotoDAO().findAll().forEach(System.out::println);

        System.out.println("\nBorrar un piloto");
        System.out.println("-------------------------------");
        mundial.getPilotoDAO().deleteById(50);
        mundial.getPilotoDAO().findAll().forEach(System.out::println);*/

        //.................................................................

        System.out.println("\nMostrar todos");
        System.out.println("-------------------------------");
        mundial.getCircuitoDAO().findAll().forEach(System.out::println);

        System.out.println("\nMostrar solo uno");
        System.out.println("-------------------------------");
        System.out.println(mundial.getCircuitoDAO().findById(16));

        System.out.println("\nInsertar un circuito");
        System.out.println("-------------------------------");
        Circuito andorra = new Circuito("Andorra", 22,LocalDate.parse("2003-01-15 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mundial.getCircuitoDAO().save(andorra);
        mundial.getCircuitoDAO().findAll().forEach(System.out::println);

        System.out.println("\nActualizar un circuito");
        System.out.println("-------------------------------");
        andorra.setNombre("A");
        mundial.getCircuitoDAO().update(andorra);
        mundial.getCircuitoDAO().findAll().forEach(System.out::println);

        System.out.println("\nBorrar un circuito");
        System.out.println("-------------------------------");
        mundial.getCircuitoDAO().deleteById(22);
        mundial.getCircuitoDAO().findAll().forEach(System.out::println);

        mundial.close();

    }
}