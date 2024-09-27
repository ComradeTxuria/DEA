import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Nabigatzailea nabigatzailea = Nabigatzailea.getNabigatzailea();
        nabigatzailea.indexIrakurri("index-2024-25");

        Scanner input = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.print("\033[H\033[2J");   
            System.out.flush();
            System.out.println("___________________________________");
            System.out.println();
            System.out.println("Ongi etorri nabigatzailera.");
            System.out.println();
            System.out.println("1. Web-orri bat bilatu.");
            System.out.println("2. Web-orri bat txertatu. (WIP)");
            System.out.println("3. Web-orri bat ezabatu. (WIP)");
            System.out.println();
            System.out.print("Aukeratu nahi duzun eragiketa: ");
            int eragiketa = input.nextInt();
            System.out.print("\033[H\033[2J");   
            System.out.flush(); 

            switch (eragiketa) {
                case 1 -> {
                    System.out.println("___________________________________");
                    System.out.println();
                    System.out.println("Nola bilatu nahi duzu web-orria?");
                    System.out.println();
                    System.out.println("1. Zenbakiaren bitartez.");
                    System.out.println("2. Gako-hitz baten bitartez.");
                    System.out.println();
                    System.out.print("Aukeratu nahi duzun prozesua: ");
                    int bilatzeProzesua = input.nextInt();
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();   


                    switch (bilatzeProzesua) {
                        case 1 -> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("Zenbakia idatzi: ");
                            String id = input.next();
                            System.out.print("\033[H\033[2J");   
                            System.out.flush();
                            nabigatzailea.webguneaBilatuId(id);
                        }
                        case 2 -> {
                            System.out.println("___________________________________");
                            System.out.println();
                            System.out.print("Hitz-gakoa idatzi: ");
                            String bilatuHitzGakoa = input.next();
                            System.out.print("\033[H\033[2J");   
                            System.out.flush();
                            nabigatzailea.webguneakBilatu(bilatuHitzGakoa);
                        }

                    }

                }
                case 2 -> {
                }
                case 3 -> {
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
                case 2 -> {
                }

            }
        }

        input.close();
    }

}
