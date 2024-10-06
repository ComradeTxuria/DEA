import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HitzKlabeak {
	private final ArrayList<String> hLista;
	private static HitzKlabeak nireHitzKlabeak = null;
	Nabigatzailea nabigatzailea = Nabigatzailea.getNabigatzailea();

	private HitzKlabeak() {
		this.hLista = new ArrayList<>();
	}

	public static HitzKlabeak getHitzKlabeak() {
		if (nireHitzKlabeak == null) {
			nireHitzKlabeak = new HitzKlabeak();
		} 
	    return nireHitzKlabeak;
	}

	public void hitzListaSortu(String filename) {
		hLista.clear();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			Set<String> processedWords = new HashSet<>();
			while ((line = br.readLine()) != null) {
				String word = line.trim();
				if (!processedWords.contains(word)) {
					hLista.add(word);
					processedWords.add(word);
				}
			}
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		}
	}

	public void bilatuHitz(String word) {
		boolean aurkituta = false;
		for (String w : hLista) {
			if (w.contains(word)) {
				nabigatzailea.webguneakBilatu(word);
				aurkituta = true;
				break;
			}
		}
		if (!aurkituta) {
			System.out.println("Ez da aurkitu emandako Gako-Hitza.");
		}
	}
	
}
