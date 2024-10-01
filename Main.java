import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Nabigatzailea nabigatzailea = Nabigatzailea.getNabigatzailea();
        System.out.println();
        System.out.println("Webguneak kargatzen ari dira...");
        nabigatzailea.indexIrakurri("index-2024-25");
        nabigatzailea.lotuWebguneak("pld-arcs-1-N-2024-25");

        Scanner input = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) { 
            System.out.println();
            System.out.println("___________________________________");
            System.out.println();
            System.out.println("Ongi etorri nabigatzailera.");
            System.out.println();
            System.out.println("1. Web-orri bat bilatu.");
            System.out.println("2. Web-orri bat txertatu.");
            System.out.println("3. Web-orri bat ezabatu.");
            System.out.println("4. Web-orri baten lotutako webguneak ikusi.");
            System.out.println();
            System.out.print("Aukeratu nahi duzun eragiketa: ");
            int eragiketa = input.nextInt();


            switch (eragiketa) {
                case 1 -> {
                    System.out.println("___________________________________");
                    System.out.println();
                    System.out.println("Nola bilatu nahi duzu web-orria?");
                    System.out.println();
                    System.out.println("1. ID baten bitartez.");
                    System.out.println("2. Gako-hitz baten bitartez.");
                    System.out.println();
                    System.out.print("Aukeratu nahi duzun prozesua: ");
                    int bilatzeProzesua = input.nextInt();
            

                    switch (bilatzeProzesua) {
                        case 1 -> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("ID-a idatzi: ");
                            String id = input.next();
                            nabigatzailea.webguneaBilatuId(id);
                        }
                        case 2 -> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("Hitz-gakoa idatzi: ");
                            String bilatuHitzGakoa = input.next();
                            nabigatzailea.webguneakBilatu(bilatuHitzGakoa);
                        }

                    }

                }
                case 2 -> {
                    System.out.println("___________________________________");
                    System.out.println();
                    System.out.print("Web-orriaren URL-a idatzi: ");
                    String url = input.next();
                    System.out.println();
                    System.out.print("Zer Id erabili nahi duzu?: ");
                    String ida = input.next();
                    nabigatzailea.webguneaTxertatu(url, ida);
                }
                case 3 -> {
                    System.out.println("___________________________________");
                    System.out.println();
                    System.out.println("Nola ezabatu nahi duzu web-orria?");
                    System.out.println();
                    System.out.println("1. ID baten bitartez.");
                    System.out.println("2. URL baten bitartez.");
                    System.out.println();
                    System.out.print("Aukeratu nahi duzun prozesua: ");
                    int ezabatuProzesua = input.nextInt();

                    switch (ezabatuProzesua) {

                        case 1-> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("ID-a idatzi: ");
                            String id = input.next();
                            nabigatzailea.webguneaEzabatu(id);

                        }
                        case 2 -> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("URL-a idatzi: ");
                            String ezabatuUrl = input.next();
                            nabigatzailea.webguneaEzabatuUrl(ezabatuUrl);
                        }
                    }
                }
                case 4 -> {
                    System.out.println("___________________________________");
                    System.out.println();
                    System.out.print("Idatzi web-orriaren URL-a: ");
                    String url = input.next();
                    nabigatzailea.webguneLoturikoak(url);

                }
            }

            System.out.println("___________________________________");
            System.out.println();
            System.out.println("Nahi duzu programa amaitu ala menura bueltatu?");
            System.out.println();
            System.out.println("1. Amaitu programa.");
            System.out.println("2. Menura bueltatu.");
            System.out.println();
            System.out.print("Aukera idatzi: ");
            int bueltatu = input.nextInt();

            switch (bueltatu) {
                case 1 -> continueProgram = false;
            }
        }
        input.close();
    }

}
