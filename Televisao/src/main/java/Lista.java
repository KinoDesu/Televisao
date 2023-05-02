public class Lista {

    private Elemento inicio;
    private Elemento atual;
    private Elemento aux;
    private int cont = 1;

    public Lista(){}

    public boolean verificar(){
        return this.inicio==null;
    }

    public void inserir(Object objeto){
        Canal canal = (Canal) objeto;
        if(this.verificar()){
            this.inicio=new Elemento(objeto,(Elemento) null,(Elemento) null);
            this.aux=this.inicio;
        }else{
            this.atual=new Elemento(objeto,this.aux,(Elemento) null);
            this.aux.setProx(this.atual);
            this.aux=this.atual;
        }
    }

    public void exibir(){
        Elemento i = this.inicio;
        System.out.println("=====");

        for(; i!=null;i=i.getProx()){
            System.out.println(i.getObjeto());
        }

        System.out.println("=====");
    }

    public Object[] pesquisarID(int id){
        Object[] v= new Object[4];
        Elemento e = this.inicio;

        for (Elemento auxRem=null;e!=null;e=e.getProx()){
            Canal canal=(Canal) e.getObjeto();
            if(id==canal.getId()){
                v[0]=e;
                v[1]=auxRem;
                v[2]=canal;
                v[3]=canal.getNome();
                return v;
            }
            auxRem=e;
        }
        return null;
    }

    public int contador(){
        Elemento i = this.inicio;
        int contador=0;
        for(; i!=null;i=i.getProx()){
            contador=contador+1;
        }

        return contador;
    }

}
