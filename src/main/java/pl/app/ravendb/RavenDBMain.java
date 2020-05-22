package pl.app.ravendb;

import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Scanner;

public class RavenDBMain {
    public static void main (String [] args) {
        try (IDocumentSession session = RavenDBDocumentStoreHolder.getStore().openSession()) {
            {
                System.out.println("Aplikacja ma za zadanie pokazać działanie składu RavenDB");
                System.out.println("Temat: Policja");

                AddRavenDB addRavenDB = new AddRavenDB();
                GetRavenDB getRavenDB = new GetRavenDB();
                DeleteRavenDB deleteRavenDB = new DeleteRavenDB();
                UpdateRavenDB updateRavenDB = new UpdateRavenDB();

                for (;;) {
                    System.out.println("1 -> Dodaj policjanta");
                    System.out.println("2 -> Zaktualizuj informacje o policjancie");
                    System.out.println("3 -> Usuń policjanta po id");
                    System.out.println("4 -> Znajdź wszystkich policjantów");
                    System.out.println("5 -> Znajdź policjantów po id");
                    System.out.println("6 -> Znajdź policjantów danego stopnia");
                    System.out.println("7 -> Zakończ program");

                    Scanner scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();

                    if (choice.equals("1"))
                        addRavenDB.addData(session);

                    if (choice.equals("2"))
                        updateRavenDB.updateData(session);

                    if (choice.equals("3"))
                        deleteRavenDB.deleteById(session);

                    if (choice.equals("4"))
                        getRavenDB.findAll(session);

                    if (choice.equals("5"))
                        getRavenDB.findById(session);

                    if (choice.equals("6"))
                        getRavenDB.findByDegree(session);

                    if (choice.equals("7"))
                        break;
                }

                session.close();
            }
        }
    }
}
