package hello;

/**
* hello/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hello.idl
* Quarta-feira, 11 de Setembro de 2019 08h24min08s BRT
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public hello.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (hello.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = hello.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    hello.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return hello.HelloHelper.type ();
  }

}
