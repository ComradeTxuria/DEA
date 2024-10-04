import java.util.ArrayList;

public class HitzKlabeak {
	private ArrayList<Hitza> hLista;
	private static HitzKlabeak nireHitzKlabeak = null;

	private HitzKlabeak() {
		this.hLista = new ArrayList<>();
	}

	public static HitzKlabeak getHitzKlabeak() {
		if (nireHitzKlabeak == null) {
			nireHitzKlabeak = new HitzKlabeak();
		} 
	    return nireHitzKlabeak;
	}
}
