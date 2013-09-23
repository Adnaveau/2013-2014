class Carre
{
    float cote;
    
    public Carre(float cote)
    {
            this.cote = cote;
    }

    public float perimetre()
    {
        return(this.cote * 4);
    }

    public float aire()
    {
        return(this.cote * this.cote);
    }

    public String toString()
    {
        return("Perimetre : "+  perimetre() + "/nAire : " + aire());
    }   
}