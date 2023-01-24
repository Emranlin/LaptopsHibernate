package peaksoft;

import peaksoft.enums.OperationSystem;
import peaksoft.models.Laptop;
import peaksoft.services.LaptopService;
import peaksoft.services.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Laptop> laptops = new ArrayList<>(Arrays.asList(new Laptop( OperationSystem.WINDOW,20,18999, LocalDate.of(2020,2,2)),
                new Laptop(OperationSystem.DELL,32,390000,LocalDate.of(2000,1,1))));

        LaptopService laptopService = new LaptopServiceImpl();
//        System.out.println(laptopService.saveLaptop(new Laptop( OperationSystem.Windows,18,55000, LocalDate.of(2001,1,1))));
//        System.out.println(laptopService.saveLaptop(new Laptop( OperationSystem.Linux,19,22000, LocalDate.of(2022,1,1))));
//        System.out.println(laptopService.saveLaptop(new Laptop( OperationSystem.MacOs,20,40000, LocalDate.of(2023,1,1))));
//          laptopService.saveAll(laptops).forEach(System.out::println);
//        System.out.println(laptopService.deleteById(1L));
//        laptopService.deleteAll();
//        laptopService.findAll().forEach(System.out::println);
 //       System.out.println(laptopService.update(12L, new Laptop( OperationSystem.MACOS 22, 398880, LocalDate.of(2000, 2, 2))));
    }
}
