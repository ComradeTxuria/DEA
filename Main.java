public class Main{

    public static void main(String[] args){

        ProbaKasuak probak = ProbaKasuak.getProbaKasuak();
        Nabigatzailea nabigatzailea = Nabigatzailea.getNabigatzailea();
        HitzKlabeak hitzak = HitzKlabeak.getHitzKlabeak();

        //Hiru fitxategiak irakurri.
        System.out.println("Webguneak kargatzen ari dira...");
        System.out.println();
        nabigatzailea.indexIrakurri("index-2024-25");
        hitzak.hitzListaSortu("words.txt");
        nabigatzailea.lotuWebguneak("pld-arcs-1-N-2024-25");

        //Proba kasuei deitu.
        System.out.println("1.INDEXIRAKURRI()");
        System.out.println();
        probak.indexIrakurriTest();
        System.out.println();
        System.out.println("2.LOTUWEBGUNEAK()");
        System.out.println();
        probak.lotuWebguneakTest();
        System.out.println();
        System.out.println("3.BILATUHITZ()");
        System.out.println();
        probak.bilatuHitzTest();
        System.out.println();
        System.out.println("4.WEBGUNEAEZABATU()");
        System.out.println();
        probak.webguneaEzabatuTest();
        System.out.println();
        System.out.println("5.WEBGUNEATXERTATU()");
        System.out.println();
        probak.webguneaTxertatuTest();
        System.out.println();
        System.out.println("6.KANPOWEBESTEKATU()");
        System.out.println();
        probak.kanpoWebEstekatuTest();
    }

}
