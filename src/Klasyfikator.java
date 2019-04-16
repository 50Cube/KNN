public class Klasyfikator
{
    int k;
    double dokladnosc;     //w procentach 1-100

    public Klasyfikator(int k)                { this.k = k; }

    public int getK()                         { return k;}

    public double getDokladnosc()             { return dokladnosc;}

    public void setK(int k)                   { this.k = k;}

    public void setDokladnosc(double dokladnosc) { this.dokladnosc = dokladnosc; }

    @Override
    public String toString() {
        return "Klasyfikator (" +
                "k=" + k +
                ") ma dokladnosc= " + dokladnosc;
    }
}
