package dominio;

public abstract class  Casta {
protected double probabilidadGolpeCritico;
protected double probabilidadEvitarDa�o;
protected double da�oCritico; // es el porcentaje que hace el critico
//falta minimo un metodo abstracto :/

public Casta(double prob_crit,double evasion,double da�o_crit)
{
	this.probabilidadGolpeCritico=prob_crit;
	this.probabilidadEvitarDa�o=evasion;
	this.da�oCritico=da�o_crit;
}

public double getProbabilidadGolpeCritico() {
	return probabilidadGolpeCritico;
}
public void setProbabilidadGolpeCritico(double probabilidadGolpeCritico) {
	this.probabilidadGolpeCritico = probabilidadGolpeCritico;
}
public double getProbabilidadEvitarDa�o() {
	return probabilidadEvitarDa�o;
}
public void setProbabilidadEvitarDa�o(double probabilidadEvitarDa�o) {
	this.probabilidadEvitarDa�o = probabilidadEvitarDa�o;
}
public double getDa�oCritico() {
	return da�oCritico;
}
public void setDa�oCritico(double da�oCritico) {
	this.da�oCritico = da�oCritico;
}


}