package pl.app.ravendb;


import net.ravendb.client.documents.DocumentStore;
import net.ravendb.client.documents.IDocumentStore;

public class RavenDBDocumentStoreHolder {
    private static class DocumentStoreContainer {
        public static final IDocumentStore store =
                new DocumentStore("http://localhost:8080", "RavenDB");

        static {
            store.initialize();
        }
    }

    public static IDocumentStore getStore() {
        return DocumentStoreContainer.store;
    }
}
