
/**
 * Write a description of class Acceso here.
 *
 * @author (Aitor Diez)
 * @version (Version 1.0)
 */
public class Acceso
{
    private int anho;
    private int mes;
    private int dia;
    private int hora;
    private int minutos;
    /**
     * Constructor for objects of class Acceso
     * @param anho El año en el que el usuario a accedido al servidor
     * @param mes El mes en el que el usuario a accedido al servidor
     * @param dia El dia en el que el usuario a accedido al servidor
     * @param hora La hora en el que el usuario a accedido al servidor
     * @param minutos Los minutos en el que el usuario a accedido al servidor
     */
    public Acceso(int anho, int mes, int dia, int hora, int minutos)
    {
        this.anho=anho;
        this.mes=mes;
        this.dia=dia;
        this.hora=hora;
        this.minutos=minutos;
    }

    /**
     * método getter que informa la hora del acceso.
     * @return hora La hora en la que el usuario ha accedido al servidor
     */
    public int getHora()
    {
        return hora;
    }
}
