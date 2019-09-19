package cadastroPessoa;


/**
* cadastroPessoa/_PessoaDAOStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Cadastro.idl
* Quinta-feira, 19 de Setembro de 2019 08h52min01s BRT
*/

public class _PessoaDAOStub extends org.omg.CORBA.portable.ObjectImpl implements cadastroPessoa.PessoaDAO
{

  public void PessoaDAO ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("PessoaDAO", true);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                PessoaDAO (        );
            } finally {
                _releaseReply ($in);
            }
  } // PessoaDAO

  public void adicionar (cadastroPessoa.Pessoa pessoa)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("adicionar", true);
                cadastroPessoa.PessoaHelper.write ($out, pessoa);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                adicionar (pessoa        );
            } finally {
                _releaseReply ($in);
            }
  } // adicionar

  public void remover (String nomePessoa)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("remover", true);
                $out.write_string (nomePessoa);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                remover (nomePessoa        );
            } finally {
                _releaseReply ($in);
            }
  } // remover

  public cadastroPessoa.PessoaDAOPackage.PessoaRetorno pesquisar (String nomePessoa)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("pesquisar", true);
                $out.write_string (nomePessoa);
                $in = _invoke ($out);
                cadastroPessoa.PessoaDAOPackage.PessoaRetorno $result = cadastroPessoa.PessoaDAOPackage.PessoaRetornoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return pesquisar (nomePessoa        );
            } finally {
                _releaseReply ($in);
            }
  } // pesquisar

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:cadastroPessoa/PessoaDAO:1.0"};

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
} // class _PessoaDAOStub
