import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Nabigatzailea{
    private static Nabigatzailea NireNabigatzailea;
    private ArrayList<Webgunea> wLista;

    private Nabigatzailea(){
      this.wLista = new ArrayList<>();
    }
    
    public static Nabigatzailea getNabigatzailea() {
		if (NireNabigatzailea == null) {
			NireNabigatzailea = new Nabigatzailea();
		}
		return NireNabigatzailea;
	}

    public void indexIrakurri(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ::: ");
                if (parts.length == 2) {
                    String id = parts[0].trim();
                    String url = parts[1].trim();
                    Webgunea webgunea = new Webgunea(url, id);
                    wLista.add(webgunea);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore bat artxiboa irakurtzean:" + e.getMessage());
        }
    }

    public void webguneakBilatu(String searchQuery) {
        ArrayList<Webgunea> results = new ArrayList<>();
        for (Webgunea webgunea : wLista) {
            if (webgunea.getUrl().contains(searchQuery)) {
                results.add(webgunea);
            }
        }

        if (results.isEmpty()) {
            System.out.println("___________________________________");
            System.out.println();
            System.out.println("Ez da aurkitu bilatu nahi duzun web-orria.");
        } else {
            System.out.println("___________________________________");
            System.out.println();
            System.out.println("Aurkitutako web-orriak:");
            System.out.println();
            for (Webgunea webgunea : results) {
                System.out.println("ID:" + webgunea.getId() + "   " + " URL:" + webgunea.getUrl());
            }
        }
    }

    public void webguneaBilatuId(String id) {
        for (Webgunea webgunea : wLista) {
            if (webgunea.getId().equals(id)) {
                System.out.println("___________________________________");
                System.out.println();
                System.out.println("Aurkitutako web-orriak:");
                System.out.println();
                System.out.println("ID:" + webgunea.getId() + "   " + " URL:" + webgunea.getUrl());
                return;
            }
        }
        System.out.println("___________________________________");
        System.out.println();
        System.out.println("Ez da aurkitu bilatu nahi duzun web-orria, edo zenbakia handiegia da.");
    }

}
