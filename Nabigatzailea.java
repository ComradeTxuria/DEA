import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Nabigatzailea{
    private static Nabigatzailea NireNabigatzailea;
    private final ArrayList<Webgunea> wLista;
 
    private Nabigatzailea(){
      this.wLista = new ArrayList<>();
    }
    
    public static Nabigatzailea getNabigatzailea() {
		if (NireNabigatzailea == null) {
			NireNabigatzailea = new Nabigatzailea();
		}
		return NireNabigatzailea;
	}

    public ArrayList<Webgunea> getwLista() {
        return wLista;
    }

    public void indexIrakurri(String dokumentuIzena) {
        try (BufferedReader br = new BufferedReader(new FileReader(dokumentuIzena))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ::: ");
                if (parts.length == 2) {
                    String id = parts[0].trim();
                    String url = parts[1].trim();
                    Webgunea webgunea = new Webgunea(url, id);
                    webgunea.setWebguneZerrenda(new ArrayList<>()); 
                    wLista.add(webgunea);
                }
            }
        } catch (IOException e) {
            System.err.println("Errore bat artxiboa irakurtzean:" + e.getMessage());
        }
    }

    public void lotuWebguneak(String dokumentuIzena) {
        Map<String, Webgunea> webguneaMap = new HashMap<>();
        for (Webgunea webgunea : wLista) {
            webguneaMap.put(webgunea.getId(), webgunea);
        }

        try (BufferedReader br = new BufferedReader(new FileReader(dokumentuIzena))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" >>>> ");
                if (parts.length > 1) {
                    String id = parts[0].trim();
                    String[] connectedIds = parts[1].trim().split(" ### ");
                    Webgunea webgunea = webguneaMap.get(id);
                    if (webgunea != null) {
                        for (String connectedId : connectedIds) {
                            Webgunea connectedWebgunea = webguneaMap.get(connectedId);
                            if (connectedWebgunea != null) {
                                webgunea.getWebguneZerrenda().add(connectedWebgunea);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {      
            System.err.println("Errore bat artxiboa irakurtzean:" + e.getMessage());
        }
    }

    public void webguneLoturikoak(String id) {
        System.out.println("Loturiko web-orriak:");
        System.out.println();
        boolean found = false;
        for (Webgunea webgunea : wLista) {
            if (webgunea.getId().equals(id)) {
                for (Webgunea lotutakoWebgunea : webgunea.getWebguneZerrenda()) {
                    System.out.println("ID:" + lotutakoWebgunea.getId() + "   " + " URL:" + lotutakoWebgunea.getUrl());
                }
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Ez da aurkitu bilatu nahi duzun web-orria.");
        }
    }

    public void webguneakBilatu(String hitza) {
        ArrayList<Webgunea> results = new ArrayList<>();
        for (Webgunea webgunea : wLista) {
            if (webgunea.getUrl().contains(hitza)) {
                results.add(webgunea);
            }
        }
        results = (ArrayList<Webgunea>) webOrdenatua(results);
        if (results.isEmpty()) {
            System.out.println("Ez da aurkitu bilatu nahi duzun web-orria.");
        } else {
            System.out.println("Aurkitutako web-orriak (Alfabetikoki ordenatuak):");
            System.out.println();
            for (Webgunea webgunea : results) {
                System.out.println("ID:" + webgunea.getId() + "   " + " URL:" + webgunea.getUrl());
            }
        }
    }

    public List<Webgunea> webOrdenatua(List<Webgunea> webguneaList) {
        List<Webgunea> sortedList = new ArrayList<>(webguneaList);
        sortedList.sort(Comparator.comparing(Webgunea::getUrl));
        return sortedList;
    }

    public void webguneaBilatuId(String id) {
        for (Webgunea webgunea : wLista) {
            if (webgunea.getId().equals(id)) {
                System.out.println("ID hori duen web-orria:");
                System.out.println();
                System.out.println("ID:" + webgunea.getId() + "   " + " URL:" + webgunea.getUrl());
                return;
            }
        }
        System.out.println("Ez da aurkitu bilatu nahi duzun web-orria, edo zenbakia handiegia da.");
    }
    
    public void webguneaTxertatu(String url, String id) {
        for (Webgunea webgunea : wLista){ 
            if (webgunea.getId().equals(id)) {
                System.out.println("Id hori best webgune batek erabiltzen du (URL:" + (webgunea.getUrl()) + "). Webgune hori ezabatu edo 2039804 baino balio handiagoa duen IDa sartu.");
                return;
            }
        }
        Webgunea webgunea = new Webgunea(url, id);
        wLista.add(webgunea);   
        System.out.println("Web-orria txertatu da. (ID: " + (webgunea.getId()) + ")");
    }
    
    public void webguneaEzabatu(String id) {
        for (Webgunea webgunea : wLista) {
            if (webgunea.getId().equals(id)) {
                wLista.remove(webgunea);
                System.out.println("Web-orria ezabatu da. (URL: " + (webgunea.getUrl()) + ")");
                return;
            }
        }
        System.out.println("Ez da aurkitu ezabatu nahi duzun web-orria.");
    }
    
    
    public void webguneaEzabatuUrl(String url) {
        for (Webgunea webgunea : wLista) {
            if (webgunea.getUrl().equals(url)) {
                wLista.remove(webgunea);
                System.out.println("Web-orria ezabatu da. (ID: " + (webgunea.getId()) + ")");
                return;
            }
        }
        System.out.println("Ez da aurkitu ezabatu nahi duzun web-orria.");
    }

    public void kanpoWebEstekatu(String url, String lotuUrl) {
        Webgunea webgunea = getWebguneaByUrl(url);
        Webgunea lotuWebgunea = getWebguneaByUrl(lotuUrl);
        if (webgunea != null && lotuWebgunea != null) {
            webgunea.getWebguneZerrenda().add(lotuWebgunea);
            System.out.println("Web-orria lotu da.");
        } else {
            System.out.println("Ez da aurkitu lotu nahi duzun web-orria.");
        }
    }
    
    private Webgunea getWebguneaByUrl(String url) {
        for (Webgunea webgunea : wLista) {
            if (webgunea.getUrl().equals(url)) {
                return webgunea;
            }
        }
        return null;
    }
}

