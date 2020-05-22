package pl.app.ravendb;

import java.util.Scanner;

public class CreatePoliceMan {

    PoliceMan create(Long id) {
        Scanner scanner = new Scanner(System.in);
        PoliceMan policeMan = new PoliceMan();
        policeMan.setId(id.toString());

        System.out.println("Podaj nazwisko policjanta");
        String surname = scanner.nextLine();
        policeMan.setSurname(surname);

        System.out.println("Podaj imię policjanta");
        String name = scanner.nextLine();
        policeMan.setName(name);

        System.out.println("Podaj wiek policjanta");
        String age = scanner.nextLine();
        policeMan.setAge(age);

        System.out.println("Podaj stopień policjanta");
        String degree = scanner.nextLine();
        policeMan.setDegree(degree);

        return policeMan;
    }
}
