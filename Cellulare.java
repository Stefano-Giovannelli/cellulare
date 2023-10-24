package esercitazione;

import java.util.Scanner;

public class Cellulare {

    public double creditoDisponibile = 0.0;
    public int chiamateEffettuate = 0;
    public double tariffa = 0.0;
    public int minuti = 0;
    public boolean menu = true;

    Scanner input = new Scanner(System.in);

    public void visualizzaMenu() {
        System.out.println("Digita 1 per effettuare una ricarica");
            System.out.println("Digita 2 per inserire la tua tariffa");
            System.out.println("Digita 3 per effettuare una chiamata");
            System.out.println("Digita 4 per visualizzare il credito disponibie");
            System.out.println("Digita 5 per visualizzare i numero di chiamate effettuate");
            System.out.println("Digita 6 per azzerare il numero di chiamate effettuate");
            System.out.println("Digita 7 per spengere il telefono");
            System.out.println("Digita qualunque altro numero per spengere il telefono");
        while (menu == true) {
            

            int display = input.nextInt();

            switch (display) {
                case 1:
                    System.out.println("Inserisci l'importo della ricarica");
                    double importoRicarica = input.nextDouble();
                    ricaricaCredito(importoRicarica);
                    break;

                case 2:
                    inserisciTariffa();
                    break;

                case 3:
                    System.out.println("Imposta la durata della tua chiamata");
                    minuti = input.nextInt();
                    chiamata();
                    break;

                case 4:
                    System.out.println("Il tuo credito disponibile é: " + creditoDisponibile);
                    break;

                case 5:
                    System.out.println("Hai effettuato: " + chiamateEffettuate);
                    break;

                case 6:
                    System.out.println("Le tue chiamate sono state azzerate");
                    chiamateEffettuate = 0;
                    break;

                case 7: 
                    System.out.println("Telefono spento");
                    menu = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("Il numero inserito non è valido");
                    break;

            }

        }

    }

    public void ricaricaCredito(double ricarica) {
        double creditoAttuale = creditoDisponibile + ricarica;
        System.out.println("Hai effettuato una ricarica di: " + ricarica + " euro");
        creditoDisponibile = creditoAttuale;
    }

    public void inserisciTariffa() {
        System.out.println("Inserisci la tua tariffa");
        double tariffaCliente = input.nextDouble();
        tariffa = tariffaCliente;
        System.out.println("La tua tariffa è: " + tariffa + " euro");

    }

    public void chiamata() {
        
        if (tariffa <= 0.0) {
            inserisciTariffa();
            double costo = tariffa * minuti;
            if (costo <= creditoDisponibile) {
                creditoDisponibile -= costo;
                chiamateEffettuate++;
                System.out.println(
                        "Chiamata effettuata. Durata " + minuti + " minuti. Credito residuo: " + creditoDisponibile);

            } else if (costo > creditoDisponibile) {
                Double chiamataMassima = creditoDisponibile / tariffa;
                creditoDisponibile = 0.0;
                chiamateEffettuate++;
                System.out.println(
                        "La chiamata è durata " + chiamataMassima + " minuti, poiché il tuo credito è esaurito");

            } else {
                System.out.println("Non puoi effettuare chiamate poiché il tuo credito è esaurito.");
            }

        } else {
            double costo = tariffa * minuti;
            if (costo <= creditoDisponibile) {
                creditoDisponibile -= costo;
                chiamateEffettuate++;
                System.out.println(
                        "Chiamata effettuata. Durata " + minuti + " minuti. Credito residuo: " + creditoDisponibile);

            } else if (costo > creditoDisponibile && creditoDisponibile != 0) {
                Double chiamataMassima = creditoDisponibile / tariffa;
                creditoDisponibile = 0.0;
                chiamateEffettuate++;
                System.out.println(
                        "La chiamata è durata " + chiamataMassima + " minuti, poiché il tuo credito è esaurito");

            } else {
                System.out.println("Non puoi effettuare chiamate poiché il tuo credito è esaurito.");
            }
        }

    }
}
