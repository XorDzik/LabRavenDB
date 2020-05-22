package pl.app.ravendb;

import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Random;

public class AddRavenDB {
    final private static Random r = new Random(System.currentTimeMillis());

    void addData(IDocumentSession session) {
        Long id = (long) Math.abs(r.nextInt());
        CreatePoliceMan createPoliceMan = new CreatePoliceMan();

        session.store(createPoliceMan.create(id));
        session.saveChanges();

    }
}
