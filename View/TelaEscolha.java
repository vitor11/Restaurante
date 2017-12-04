package telalogin.telas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableRow;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import fatec.telalogin.R;
import telalogin.Model.Restaurantes;
import telalogin.telalogin.object.Restaurante;
import telalogin.telalogin.object.RestauranteImp;

public class TelaEscolha extends AppCompatActivity {

    private Restaurantes conexao;
    private ListView list;
    private TableRow escolha;
    private String[] texto = {
            "Restaurante \n",
            "Restaurante \n",
            "Restaurante \n",
            "Restaurante \n",
            "Restaurante \n",
            "Restaurante \n",
            "Restaurante \n",
        } ;
    private String[] descricao = {
            "1 - O restaurante Almeida foi aberto em 1932, é um dos mais antigos da cidade de Santos, um misto de bar e restaurante.Completando 82 anos de atividade nas mesas já passaram políticos, pessoas famosas, jogadores de futebol, artistas como Jamelão, Alcione e antonio Fagundes. \n",
            "2 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
            "3 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
            "4 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
            "5 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
            "6 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
            "7 - O Restaurante Tia Aninhas é uma casa rústica influenciada pela gastronomia portuense e pela proximidade do mar. Situado na frequesia de Lordelo do Ouro, é um dos mais emblemáticos restaurantes da freguesia. ... Paulo Tavares, é o restaurante ideal para quem quer comer bem, barato e depressa. \n",
    } ;
    private String[] imagem = {
            "http://i.imgur.com/DvpvklR.png",
            "https://media-cdn.tripadvisor.com/media/photo-s/0b/c1/2d/c4/logo-cabana.jpg",
            "http://www.sebraemercados.com.br/wp-content/uploads/2017/05/restaurante-sebrae-2-e1494853241838.jpg",
            "http://hotelteatro.pt/wp-content/uploads/2015/12/hotel-teatro-restaurante-palco.jpg",
            "http://www.restauranteskylab.com.br/wp-content/uploads/2016/06/restaurante-skylab-o-restaurante-capa.jpg",
            "http://www.allurechocolathotel.com/wp-content/uploads/2015/06/restaurante05.jpg",
            "http://bompratomanaus.com.br/wp-content/uploads/2015/08/LOGO-01.png",

    };

    public Bitmap getBitmapfromUrl(String imageUrl)
    {
        try
        {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(input);
            return bitmap;
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_tela_escolha);

     escolha = (TableRow)findViewById(R.id.viewChoose);

    //RestauranteImp r = conexao.retornarRestaurantes();
    final Restaurante restaurantes = new Restaurante(this, descricao,imagem , texto);

    list=(ListView)findViewById(R.id.list);
    list.setAdapter(restaurantes);
    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            Toast.makeText(TelaEscolha.this, "Você clicou em " + restaurantes.getTexto()[+ position], Toast.LENGTH_SHORT).show();

        }

    });


    escolha.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            try {
                choose();
            } catch (NullPointerException e) {
                Toast toast = Toast.makeText(getApplicationContext(), "Sem conexão com o servidor", Toast.LENGTH_SHORT);
                toast.show();
            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }
    });
}
    public void choose() throws IOException, JSONException {
        Intent trocaTela = new Intent(this, TelaEscolha.class);
        startActivity(trocaTela);
    }
}
