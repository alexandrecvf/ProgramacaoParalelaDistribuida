package cadastroPessoa;


/**
* cadastroPessoa/PessoaPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Cadastro.idl
* Quinta-feira, 19 de Setembro de 2019 08h21min34s BRT
*/

public abstract class PessoaPOA extends org.omg.PortableServer.Servant
 implements cadastroPessoa.PessoaOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("Pessoa", new java.lang.Integer (0));
    _methods.put ("getId", new java.lang.Integer (1));
    _methods.put ("setId", new java.lang.Integer (2));
    _methods.put ("getNome", new java.lang.Integer (3));
    _methods.put ("setNome", new java.lang.Integer (4));
    _methods.put ("getEmail", new java.lang.Integer (5));
    _methods.put ("setEmail", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // cadastroPessoa/Pessoa/Pessoa
       {
         this.Pessoa ();
         out = $rh.createReply();
         break;
       }

       case 1:  // cadastroPessoa/Pessoa/getId
       {
         int $result = (int)0;
         $result = this.getId ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 2:  // cadastroPessoa/Pessoa/setId
       {
         int id = in.read_long ();
         this.setId (id);
         out = $rh.createReply();
         break;
       }

       case 3:  // cadastroPessoa/Pessoa/getNome
       {
         String $result = null;
         $result = this.getNome ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // cadastroPessoa/Pessoa/setNome
       {
         String nome = in.read_string ();
         this.setNome (nome);
         out = $rh.createReply();
         break;
       }

       case 5:  // cadastroPessoa/Pessoa/getEmail
       {
         String $result = null;
         $result = this.getEmail ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 6:  // cadastroPessoa/Pessoa/setEmail
       {
         String email = in.read_string ();
         this.setEmail (email);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:cadastroPessoa/Pessoa:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Pessoa _this() 
  {
    return PessoaHelper.narrow(
    super._this_object());
  }

  public Pessoa _this(org.omg.CORBA.ORB orb) 
  {
    return PessoaHelper.narrow(
    super._this_object(orb));
  }


} // class PessoaPOA