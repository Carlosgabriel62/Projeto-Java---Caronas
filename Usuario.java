public class Usuario{
  protected String nome;
  protected String email;
  protected String senha;
  protected int id;
  protected float nota;


  //Construtor

  public Usuario(String email,String senha,String nome){
     this.email = email;
      this.senha = senha;
      this.nome = nome;
      this.nota=0;
  }

  public Usuario(String email,String senha,String nome,int id){
     this.email = email;
      this.senha = senha;
      this.nome = nome;
      this.nota=0;
      this.id=id;
  }

  // Getters and Setters
  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getEmail(){
    return email;
  }

  public void setEmail(String email){
    this.email = email;
  }

  public String getSenha(){
    return this.senha;
  }

  public void setSenha(String senha){
    this.senha = senha;
  }

  public int getId(){
    return this.id;
  }

  public void setId(int id){
    this.id = id;
  }

  public float getNota(){
    return nota;
  }

  public void setNota(float nota){
    this.nota=nota;
  }

  //MÉTODOS

  public String infosUsuario(){
    String txt= "\t\t\tNome: "+this.nome+"\n";
    txt+="\t\t\tEmail: "+this.email+"\n";
    txt+="\t\t\tSenha: "+this.senha+"\n";
    txt+="\t\t\tId: "+this.id+"\n";
    return txt;
  }

  public String infosUsuarioPublico(){
    String txt= "\t\t\tNome: "+this.nome+"\n";
    txt+="\t\t\tId: "+this.id+"\n";
    return txt;
  }

  public Usuario avaliar(Usuario usuario){
    System.out.println("Avaliando usuário "+usuario.getNome());
    return usuario;
  }
  
}