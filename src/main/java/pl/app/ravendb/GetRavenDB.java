package pl.app.ravendb;

import net.ravendb.client.documents.session.IDocumentSession;

import java.util.List;
import java.util.Scanner;

public class GetRavenDB {

    void findAll (IDocumentSession session) {
        List<PoliceMan> policeManList = session.query(PoliceMan.class).toList();
        System.out.println("Wszyscy policjanci w składzie: ");
        displayFoundedPoliceMans(policeManList);
    }

    void findById (IDocumentSession session) {
        System.out.println("Podaj id policjanta");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        List<PoliceMan> policeManList = session.query(PoliceMan.class).whereEquals("id", id).toList();
        displayFoundedPoliceMans(policeManList);
    }

    void findByDegree (IDocumentSession session) {
        System.out.println("Podaj id policjanta");
        Scanner scanner = new Scanner(System.in);
        String degree = scanner.nextLine();

        List<PoliceMan> policeManList = session.query(PoliceMan.class).whereEquals("degree", degree).toList();
        displayFoundedPoliceMans(policeManList);
    }

    private void displayFoundedPoliceMans(List<PoliceMan> policeManList) {
        for (PoliceMan policeMan : policeManList) {
            System.out.println(policeMan.getId());
            System.out.println(policeMan.getName());
            System.out.println(policeMan.getSurname());
            System.out.println(policeMan.getAge());
            System.out.println(policeMan.getDegree());
            System.out.println();
        }
    }
}
