package CalculadoraApp;

/**
* CalculadoraApp/CalculadoraServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcApp.idl
* Quinta-feira, 12 de Setembro de 2019 09h59min30s BRT
*/

public final class CalculadoraServerHolder implements org.omg.CORBA.portable.Streamable
{
  public CalculadoraApp.CalculadoraServer value = null;

  public CalculadoraServerHolder ()
  {
  }

  public CalculadoraServerHolder (CalculadoraApp.CalculadoraServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CalculadoraApp.CalculadoraServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CalculadoraApp.CalculadoraServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CalculadoraApp.CalculadoraServerHelper.type ();
  }

}
