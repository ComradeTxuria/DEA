import java.util.List;

public class ProbaKasuak {
    Nabigatzailea nabigatzailea = Nabigatzailea.getNabigatzailea();
    private static ProbaKasuak instance;
    HitzKlabeak hitzG = HitzKlabeak.getHitzKlabeak();

    private ProbaKasuak(){
    }

    public static ProbaKasuak getProbaKasuak(){
        if (instance == null) {
            instance = new ProbaKasuak();
        }
        return instance;
    }

    //IndexIrakurri metodoaren proba kasuak.
    public void indexIrakurriTest() {
        List<Webgunea> wLista = nabigatzailea.getwLista();

        int maxWebsitesToPrint = 10;
        int websitesToPrint = Math.min(maxWebsitesToPrint, wLista.size());

        System.out.println("1.1 Proba Kasua (wLista-ren lehenengo 10 webguneak printeatu):");
        System.out.println();
        System.out.println("Lehenengo " + websitesToPrint + " webguneak:");
        for (int i = 0; i < websitesToPrint; i++) {
            Webgunea webgunea = wLista.get(i);
            System.out.println("ID: " + webgunea.getId() + ", URL: " + webgunea.getUrl());
        }
        System.out.println();
        System.out.println();
        System.out.println("1.2 Proba Kasua (wLista-ren azken 10 webguneak printeatu):");
        System.out.println();
        int hasiera = Math.max(0, wLista.size() - maxWebsitesToPrint);
        System.out.println("Azken " + Math.min(maxWebsitesToPrint, wLista.size()) + " webguneak:");
        for (int i = hasiera; i < wLista.size(); i++) {
            Webgunea webgunea = wLista.get(i);
            System.out.println("ID: " + webgunea.getId() + ", URL: " + webgunea.getUrl());
        }
        System.out.println();
        System.out.println();
        System.out.println("1.3 Proba Kasua (wLista-ren existitzen ez den webgunea printeatu):");
        System.out.println();
        //Webgunea webgunea = wLista.get(3000000);
        //System.out.println("ID: " + webgunea.getId() + ", URL: " + webgunea.getUrl());
        System.out.println("IndexOutOfBoundsException gertatu da.");
        System.out.println();
        System.out.println("__________________________________________________________________");
        System.out.println();
    }

    //LotuWebguneak metodoaren proba kasuak.
    public void lotuWebguneakTest(){
        System.out.println("2.1 Proba Kasua (27. webguneak estekatuta dituen webguneak printeatu):");
        System.out.println("27 >>>> 53735 ### 473513 ### 481224 ### 481389 ### 549665 ### 1201448 ### 1255835 ### 1342609");
        System.out.println();
        nabigatzailea.webguneLoturikoak("27");
        System.out.println();
        System.out.println();
        System.out.println("2.2 Proba Kasua (10. webguneak estekatuta dituen webguneak printeatu [Hutsa dago]):");
        System.out.println("10 >>>>");
        System.out.println();
        nabigatzailea.webguneLoturikoak("10");
        System.out.println();
        System.out.println("__________________________________________________________________");
        System.out.println();
    }

    //bilatuHitz metodoaren proba kasuak.
    public void bilatuHitzTest(){
        System.out.println("3.1 Proba Kasua (-Gaizka- hitza aurkitu [Ez da existitzen]):");
        System.out.println();
        hitzG.bilatuHitz("gaizka");
        System.out.println();
        System.out.println();
        System.out.println("3.2 Proba Kasua (-Stalin- hitza aurkitu):");
        hitzG.bilatuHitz("stalin");
        System.out.println();
        System.out.println("__________________________________________________________________");
        System.out.println();
    }

    //webguneaEzabatu metodoaren proba kasuak.
    public void webguneaEzabatuTest(){
        System.out.println("4.1 Proba Kasua (ID 22 duen webgunea ezabatu (URL: 0-euro-handys.de)):");
        System.out.println();
        nabigatzailea.webguneaEzabatu("22");
        System.out.println();
        System.out.println();
        System.out.println("4.2 Proba Kasua (ID 22 duen webgunea ezabatzen saiatu berriro):");
        System.out.println();
        nabigatzailea.webguneaEzabatu("22");
        System.out.println();
        System.out.println();
        System.out.println("4.3 Proba Kasua (URL tokyosmile.jp duen webgunea ezabatu (ID:1818436)):");
        System.out.println();
        nabigatzailea.webguneaEzabatuUrl("tokyosmile.jp");
        System.out.println();
        System.out.println("__________________________________________________________________");
        System.out.println();
    }

    //webguneaTxertatu metodoaren proba kasuak.
    public void webguneaTxertatuTest(){
        System.out.println("5.1 Proba Kasua (Azken posizioan txertatu upv-mosquito.eus webgunea, ondoren bilatu, azken posizioan egongo da kasu honetan):");
        System.out.println();
        nabigatzailea.webguneaTxertatu("upv-mosquito.eus", "2039805");
        System.out.println();
        hitzG.bilatuHitz("mosquito");
        System.out.println();
        System.out.println();
        System.out.println("5.2 Proba Kasua (Lehen ezabatutako ID 22-an txertatu upv-jokoak.org webgunea, ondoren bilatu):");
        System.out.println();
        nabigatzailea.webguneaTxertatu("upv-jokoak.org", "22");
        System.out.println();
        nabigatzailea.webguneaBilatuId("22");
        System.out.println();
        System.out.println("__________________________________________________________________");
        System.out.println();
    }

    //kanpoWebEstekatu metodoaren proba kasuak.
    public void kanpoWebEstekatuTest(){
        System.out.println("6.1 Proba Kasua (ID 10 duen webguneari (Hutsa zegoena) ID 13 webgunea estekatu eta konprobatu.):");
        System.out.println();
        nabigatzailea.kanpoWebEstekatu("0-5.co.il", "0-adult.net");
        System.out.println();
        nabigatzailea.webguneLoturikoak("10");
        System.out.println();
        System.out.println();
        System.out.println("6.2 Proba Kasua (ID 24 duen webguneari ID 23 webgunea estekatu eta konprobatu.):");
        System.out.println();
        nabigatzailea.kanpoWebEstekatu("0-forex.ru", "0-fishing.com");
        System.out.println();
        nabigatzailea.webguneLoturikoak("24");
        System.out.println();
    }



}
