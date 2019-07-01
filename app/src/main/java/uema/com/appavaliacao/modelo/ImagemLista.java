package uema.com.appavaliacao.modelo;


public class ImagemLista {

    //Valor pra imagem(int por causa do id res), e pro nome que aparecerá do lado de cada uma
    int imagem;
    String nome;

//Construtor da Classe, que receberá o id da imagem e o nome que será do lado

    public ImagemLista(int imagem, String nome) {
        this.imagem = imagem;
        this.nome = nome;
    }

    //Getters e setters

    public int getImagem() {
        return imagem;
    }

    public String getName() {
        return nome;
    }


}