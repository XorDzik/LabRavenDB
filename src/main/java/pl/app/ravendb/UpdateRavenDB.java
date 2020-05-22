package pl.app.ravendb;

import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Scanner;

public class UpdateRavenDB {

    void updateData (IDocumentSession session) {
        System.out.println("Podaj id rekordu który chcesz zaktualizować");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        CreatePoliceMan createPoliceMan = new CreatePoliceMan();

        PoliceMan policeMan = session.load(PoliceMan.class, id);
        PoliceMan policeManFromCreate = createPoliceMan.create(Long.parseLong(id));

        policeMan.setId(policeManFromCreate.getId());
        policeMan.setName(policeManFromCreate.getName());
        policeMan.setSurname(policeManFromCreate.getSurname());
        policeMan.setAge(policeManFromCreate.getAge());
        policeMan.setDegree(policeManFromCreate.getDegree());

        session.saveChanges();
    }
}
