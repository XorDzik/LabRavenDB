package pl.app.ravendb;

import net.ravendb.client.documents.commands.DeleteDocumentCommand;
import net.ravendb.client.documents.session.IDocumentSession;

import java.util.Scanner;

public class DeleteRavenDB {

    void deleteById(IDocumentSession session) {
        System.out.println("Podaj id rekordu który chcesz usunąć");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();

        DeleteDocumentCommand command = new DeleteDocumentCommand(id, null);
        session.advanced().getRequestExecutor().execute(command);
    }

}
