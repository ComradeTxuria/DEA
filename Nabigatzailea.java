public class Nabigatzailea
  {
    private static Nabigatzailea NireNabigatzailea
    private ArrayList<Webgunea> wLista;

    private Nabigatzailea()
    {
      this.wLista = new ArrayList<Webgunea>();
    }
    

    public static Nabigatzailea getNabigatzailea() 
    {
		  if (NireNabigatzailea == null) 
      {
			  NireNabigatzailea = new Nabigatzailea();
		  }
		  return NireNabigatzailea;
	  }




    
  }
