public class Pojemnik implements Comparable<Pojemnik>
{
    private Irys.Gatunek gatunekIrysa;
    private double obliczonaOdleglosc;

    public Pojemnik() {}

    public Irys.Gatunek getGatunekIrysa()
    {
        return gatunekIrysa;
    }

    public double getObliczonaOdleglosc()
    {
        return obliczonaOdleglosc;
    }

    public void setGatunekIrysa(Irys.Gatunek gatunekIrysa)
    {
        this.gatunekIrysa = gatunekIrysa;
    }

    public void setObliczonaOdleglosc(double obliczonaOdleglosc)
    {
        this.obliczonaOdleglosc = obliczonaOdleglosc;
    }

    @Override
    public int compareTo(Pojemnik o)
    {
        int tmp = 0;
        if (this.obliczonaOdleglosc > o.obliczonaOdleglosc)
            tmp = 1;
        else if (this.obliczonaOdleglosc < o.obliczonaOdleglosc)
            tmp = -1;
        return tmp;
    }

}
