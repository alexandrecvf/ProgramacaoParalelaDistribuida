package CalculadoraApp;


/**
* CalculadoraApp/_CalculadoraServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from CalcApp.idl
* Quinta-feira, 12 de Setembro de 2019 09h59min30s BRT
*/

public class _CalculadoraServerStub extends org.omg.CORBA.portable.ObjectImpl implements CalculadoraApp.CalculadoraServer
{

  public int somar (int a, int b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("somar", true);
                $out.write_long (a);
                $out.write_long (b);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return somar (a, b        );
            } finally {
                _releaseReply ($in);
            }
  } // somar

  public int subtrair (int a, int b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subtrair", true);
                $out.write_long (a);
                $out.write_long (b);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return subtrair (a, b        );
            } finally {
                _releaseReply ($in);
            }
  } // subtrair

  public int multiplicar (int a, int b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("multiplicar", true);
                $out.write_long (a);
                $out.write_long (b);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return multiplicar (a, b        );
            } finally {
                _releaseReply ($in);
            }
  } // multiplicar

  public double dividir (int a, int b)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("dividir", true);
                $out.write_long (a);
                $out.write_long (b);
                $in = _invoke ($out);
                double $result = $in.read_double ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return dividir (a, b        );
            } finally {
                _releaseReply ($in);
            }
  } // dividir

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalculadoraApp/CalculadoraServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _CalculadoraServerStub
