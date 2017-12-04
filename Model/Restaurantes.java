package telalogin.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import telalogin.rest.RestConnection;
import telalogin.telalogin.object.Restaurante;
import telalogin.telalogin.object.RestauranteImp;

/**
 * Created by vitor on 19/09/2017.
 */
public class Restaurantes {

    private String[] nome;
    private String[] imagens;
    private String[] descricao;

    public RestauranteImp retornarRestaurantes() {

        String url = "http\\:teste.com";

        try {
            JSONArray resposta = RestConnection.sendGetArray(url);

            int tamanho = resposta.length();

            for (int i = 0; i < tamanho; i++) {

                JSONObject o = resposta.getJSONObject(i);

                nome[i] = o.getString("nome");
                descricao[i] = o.getString("descricao");
                imagens[i] = o.getString("imagem");

            }

            RestauranteImp restaurante = new RestauranteImp(descricao, nome, imagens);
            return restaurante;

        } catch (IOException | JSONException e) {

        }

        return null;
    }
}
