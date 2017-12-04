package telalogin.telalogin.object;

/**
 * Created by vitor on 03/10/2017.
 */
public class RestauranteImp {

    private final String[] descricao;
    private final String[] nome;
    private final String[] imageId;

    public RestauranteImp(String[] descricao, String[] nome, String[] imageId) {
        this.descricao = descricao;
        this.nome = nome;
        this.imageId = imageId;
    }

    public String[] getImageId() {
        return imageId;
    }

    public String[] getDescricao() {
        return descricao;
    }

    public String[] getTexto() {
        return nome;
    }

}
