import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) throws IOException {
        ////////////////Wczytanie tablic z plikow///////////////////////////
        Irys[] trening = new Irys[105];
        Irys[] test = new Irys[45];
        wczytywanieZpliku(trening, "train");
        wczytywanieZpliku(test, "");
        //////////////tworzenie kolejnych klasyfikatorow w zaleznosci od ilosci sasiadow i obliczanie dla  nich dokladnosci///////////////

        Pojemnik[] tablicaPojemnikow = new Pojemnik[105];

        Klasyfikator klasyfikator1 = new Klasyfikator(1);
        Klasyfikator klasyfikator3 = new Klasyfikator(3);
        Klasyfikator klasyfikator5 = new Klasyfikator(5);
        Klasyfikator klasyfikator7 = new Klasyfikator(7);
        Klasyfikator klasyfikator9 = new Klasyfikator(9);
        Klasyfikator klasyfikator11 = new Klasyfikator(11);


////////////////Wariant 1////////////////////////////////////////////////////////
        System.out.println("\nWariant 1: dlugosc dzialki kielicha, szerokosc dzialki kielicha, dlugosc platka");
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator1, 1);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator3, 1);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator5, 1);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator7, 1);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator9, 1);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator11, 1);
////////////////Wariant 2////////////////////////////////////////////////////////
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nWariant 2: szerokosc dzialki kielicha, dlugosc platka, szerokosc platka");
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator1, 2);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator3, 2);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator5, 2);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator7, 2);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator9, 2);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator11, 2);
////////////////Wariant 3////////////////////////////////////////////////////////
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nWariant 3: dlugosc dzialki kielicha, szerokosc dzialki kielicha");
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator1, 3);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator3, 3);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator5, 3);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator7, 3);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator9, 3);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator11, 3);
////////////////Wariant 4////////////////////////////////////////////////////////
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nWariant 4: szerokosc dzialki kielich , szerokosc platka");
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator1, 4);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator3, 4);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator5, 4);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator7, 4);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator9, 4);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator11, 4);
/////////////////Wariant 5////////////////////////////////////////////////////////
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("\nWariant 5: wszystkie cechy");
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator1, 5);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator3, 5);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator5, 5);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator7, 5);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator9, 5);
        odleglosci(tablicaPojemnikow, test, trening, klasyfikator11, 5);
    }

    private static void odleglosci(Pojemnik[] tab, Irys[] test, Irys[] trening, Klasyfikator klasyfikator, int wariant)   // tablica z gatunkami i odleglosciami euklidesowymi i, z niej wybiera najmniejsze
    {
        int licznikSetosa, licznikVirginica, licznikVersicolor, k;              //k to ilosc sasiadow ktoa zmieniam w do while jesli jest remis
        double trafione = 0.0, nietrafione = 0.0, dokladnosc = 0.0;
        Irys.Gatunek tmp;
        boolean remis = false;
        k = klasyfikator.getK();

        double[][] macierzPomylek = new double[3][3];     // setosa | versicolor | virginica

        for (int j = 0; j < test.length; j++) {
            licznikSetosa = 0;
            licznikVirginica = 0;
            licznikVersicolor = 0;
            for (int i = 0; i < trening.length; i++) {
                Pojemnik pojemnik = new Pojemnik();
                tab[i] = pojemnik;
                tab[i].setGatunekIrysa(trening[i].getGatunek());
                tab[i].setObliczonaOdleglosc(odlegloscEuklidesowa(trening[i], test[j], wariant));
            }

            Arrays.sort(tab);

            do {
                for (int i = 0; i < k; i++) {
                    if (tab[i].getGatunekIrysa() == Irys.Gatunek.setosa)
                        licznikSetosa++;
                    else if (tab[i].getGatunekIrysa() == Irys.Gatunek.virginica)
                        licznikVirginica++;
                    else if (tab[i].getGatunekIrysa() == Irys.Gatunek.versicolor)
                        licznikVersicolor++;

//                    System.out.print("Gatunek: " + tab[i].getGatunekIrysa() + "  odleglosc: " + tab[i].getObliczonaOdleglosc());

                }
                if (licznikSetosa > licznikVersicolor && licznikSetosa > licznikVirginica) {
//                    System.out.println("Wybrany gatunek irysa: setosa");
                    remis = true;
                    tmp = Irys.Gatunek.setosa;
                } else if (licznikVersicolor > licznikSetosa && licznikVersicolor > licznikVirginica) {
//                    System.out.println("Wybrany gatunek irysa: versicolor");
                    remis = true;
                    tmp = Irys.Gatunek.versicolor;
                } else if (licznikVirginica > licznikSetosa && licznikVirginica > licznikVersicolor) {
//                    System.out.println("Wybrany gatunek irysa: virginica");
                    remis = true;
                    tmp = Irys.Gatunek.virginica;
                } else {
                    //System.out.println("remis");
                    remis = false;
                    k--;
                    tmp = null;
                }
            } while (remis == false);
//            System.out.print("Faktyczny gatunek irysa: ");
//            System.out.println(test[j].getGatunek());
            if (test[j].getGatunek() == tmp) {
                trafione++;
//                System.out.println("TRAFIONE!");
            } else {
                nietrafione++;
//                System.out.println("Nietrafione :(\n");
            }
            obliczMacierzPomylek(macierzPomylek, test[j].getGatunek(), tmp);

        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                macierzPomylek[i][j]*=(100/15.0);
            }
        }
        wyswietlMacierz(macierzPomylek);
        dokladnosc = (trafione / (trafione + nietrafione)) * 100;
        klasyfikator.setDokladnosc(dokladnosc);
        System.out.println("\n" + klasyfikator.toString() + "\n");

    }

    private static void obliczMacierzPomylek(double[][] tab, Irys.Gatunek prawdziwy, Irys.Gatunek wyliczony)
    {
        if (prawdziwy == wyliczony)
        {
            if (wyliczony == Irys.Gatunek.setosa) tab[0][0]++;
            else if (wyliczony == Irys.Gatunek.versicolor) tab[1][1]++;
            else tab[2][2]++;
        } else if (prawdziwy != wyliczony)
        {
            if (prawdziwy == Irys.Gatunek.setosa && wyliczony == Irys.Gatunek.versicolor) tab[0][1]++;
            else if (prawdziwy == Irys.Gatunek.setosa && wyliczony == Irys.Gatunek.virginica) tab[0][2]++;
            else if (prawdziwy == Irys.Gatunek.versicolor && wyliczony == Irys.Gatunek.setosa) tab[1][0]++;
            else if (prawdziwy == Irys.Gatunek.versicolor && wyliczony == Irys.Gatunek.virginica) tab[1][2]++;
            else if (prawdziwy == Irys.Gatunek.virginica && wyliczony == Irys.Gatunek.setosa) tab[2][0]++;
            else if (prawdziwy == Irys.Gatunek.virginica && wyliczony == Irys.Gatunek.versicolor) tab[2][1]++;
            else System.out.println("Niezidentyfikowany blad :)");
        }

    }

    private static void wyswietlMacierz(double[][] tab) {
        System.out.println("\n               setosa  |  versicolor |  virginica");
        for (int i = 0; i < 3; i++) {
            if (i == 0) System.out.print("setosa    ");
            else if (i == 1) System.out.print("\nversicolor");
            else System.out.print("\nvirginica ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("     %.2f", tab[i][j]);
                System.out.print("     ");
            }
        }
        System.out.println("");
    }

    private static void wczytywanieZpliku(Irys[] tab, String ss) throws IOException {
        FileReader tablicaTreningowa;
        if (ss.equals("train")) {
            tablicaTreningowa = new FileReader("data_train.csv");
        } else {
            tablicaTreningowa = new FileReader("data_test.csv");
        }
        BufferedReader br = new BufferedReader(tablicaTreningowa);
        String s;
        char c[] = new char[3];
        double tmp;
        if (br.ready()) {
            for (int k = 0; k < tab.length; k++) {
                Irys irys = new Irys();
                for (int j = 0; j < 5; j++) {
                    br.read(c);
                    if (j % 5 != 4) br.skip(1);
//                    System.out.print(c);
//                    System.out.print("   ");

                    s = "";
                    for (int i = 0; i < 3; i++) {
                        //System.out.println(c[i]);
                        s += Character.toString(c[i]);
                    }

                    tab[k] = irys;
                    if (j == 0) {
                        tab[k].dlugoscDzialki = Double.parseDouble(s);
                    } else if (j == 1) {
                        tab[k].szerokoscDzialki = Double.parseDouble(s);
                    } else if (j == 2) {
                        tab[k].dlugoscPlatka = Double.parseDouble(s);
                    } else if (j == 3) {
                        tab[k].szerokoscPlatka = Double.parseDouble(s);
                    } else {
                        tmp = Double.parseDouble(s);
                        if (tmp == 0)
                            tab[k].gatunek = Irys.Gatunek.setosa;
                        else if (tmp == 1)
                            tab[k].gatunek = Irys.Gatunek.versicolor;
                        else tab[k].gatunek = Irys.Gatunek.virginica;
                    }
                }
            }


        }

    }


    private static double odlegloscEuklidesowa(Irys o1, Irys o2, int wariant) //funkcja z nieokreslona iloscia ar double
    {
        double tmp = 0;
        if (wariant == 1) {
            tmp = pow((o1.getDlugoscDzialki() - o2.getDlugoscDzialki()), 2)
                    + pow((o1.getSzerokoscDzialki() - o2.getSzerokoscDzialki()), 2)
                    + pow((o1.getDlugoscPlatka() - o2.getDlugoscPlatka()), 2);
        } else if (wariant == 2) {
            tmp = pow((o1.getSzerokoscDzialki() - o2.getSzerokoscDzialki()), 2)
                    + pow((o1.getDlugoscPlatka() - o2.getDlugoscPlatka()), 2)
                    + pow((o1.getSzerokoscPlatka() - o2.getSzerokoscPlatka()), 2);
        } else if (wariant == 3) {
            tmp = pow((o1.getDlugoscDzialki() - o2.getDlugoscDzialki()), 2)
                    + pow((o1.getSzerokoscDzialki() - o2.getSzerokoscDzialki()), 2);
        } else if (wariant == 4) {
            tmp = pow((o1.getSzerokoscDzialki() - o2.getSzerokoscDzialki()), 2)
                    + pow((o1.getSzerokoscPlatka() - o2.getSzerokoscPlatka()), 2);
        } else if (wariant == 5) {
            tmp = pow((o1.getDlugoscDzialki() - o2.getDlugoscDzialki()), 2)
                    + pow((o1.getSzerokoscDzialki() - o2.getSzerokoscDzialki()), 2)
                    + pow((o1.getDlugoscPlatka() - o2.getDlugoscPlatka()), 2)
                    + pow((o1.getSzerokoscPlatka() - o2.getSzerokoscPlatka()), 2);
        }
        return tmp;
    }
}

