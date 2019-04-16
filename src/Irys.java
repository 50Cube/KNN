public class Irys
{

    public enum Gatunek
    {
        setosa,
        versicolor,
        virginica;
    }

    Gatunek gatunek;
    double dlugoscDzialki;
    double szerokoscDzialki;
    double dlugoscPlatka;
    double szerokoscPlatka;

    public Irys() {}

    public void setGatunek(Gatunek gatunek)
    {
        this.gatunek = gatunek;
    }

    public Gatunek getGatunek()
    {
        return gatunek;
    }

    public void setDlugoscDzialki(double dlugoscDzialki)
    {
        this.dlugoscDzialki = dlugoscDzialki;
    }

    public double getDlugoscDzialki()
    {
        return dlugoscDzialki;
    }

    public void setSzerokoscDzialki(double szerokoscDzialki)
    {
        this.szerokoscDzialki = szerokoscDzialki;
    }

    public double getSzerokoscDzialki()
    {
        return szerokoscDzialki;
    }

    public void setDlugoscPlatka(double dlugoscPlatka)
    {
        this.dlugoscPlatka = dlugoscPlatka;
    }

    public double getDlugoscPlatka()
    {
        return dlugoscPlatka;
    }

    public void setSzerokoscPlatka(double szerokoscPlatka)
    {
        this.szerokoscPlatka = szerokoscPlatka;
    }

    public double getSzerokoscPlatka()
    {
        return szerokoscPlatka;
    }

    @Override
    public String toString()
    {
        return "Irys{" +
                "gatunek='" + gatunek + '\'' +
                ", dlugoscDzialki=" + dlugoscDzialki +
                ", szerokoscDzialki=" + szerokoscDzialki +
                ", dlugoscPlatka=" + dlugoscPlatka +
                ", szerokoscPlatka=" + szerokoscPlatka +
                '}';
    }


}
