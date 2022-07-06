package vicdron.com.cantosdogalo;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class HomeFragment extends Fragment {

    private String[] itens = {
            "1 - Hino do Atlético Mineiro \n     -Clube Atlético Mineiro",
            "2 - Hino do Atlético Mineiro \n     -Rogério Flausino e Tianastácia",
            "3 - Hino do Atlético Mineiro \n     -Clube Atlético Mineiro - Versão Globo",
            "4 - Hino do Atlético Mineiro\n     -Torcida do Atlético Mineiro",
            "5 - Galo, a razão do meu viver\n     -Torcida do Atlético Mineiro",
            "6 - Ao Atlético\n     -DDG",
            "7 - Maria, eu sei que você treme\n     -Torcida do Atlético Mineiro",
            "8 - Tá ligado \n     -Torcida do Atlético Mineiro",
            "9 - Aquarela do Galo \n     -Torcida do Atlético Mineiro",
            "10 - Garoto Eu Sou da Galoucura \n     -Torcida do Atlético Mineiro",
            "11 - Ôba, Ôba, Ôba, Ôba, Ô... \n    -Torcida do Atlético Mineiro",
            "12 - A T.O.G vai te pegar  \n    -Torcida do Atlético Mineiro",
            "13 - Vou Festejar  \n    -Torcida do Atlético Mineiro",
            "14 - Galoucura é rei  \n    -Torcida do Atlético Mineiro",
            "15 - Viemos Agitar  \n    -Torcida do Atlético Mineiro",
            "16 - Domingo eu vou no Mineirão  \n    -Torcida do Atlético Mineiro"
    };
    private ListView listadeCantos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle   savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        ((AdView) view.findViewById(R.id.adView)).loadAd(new AdRequest.Builder().build());
        this.listadeCantos = (ListView)  view.findViewById(R.id.listViewid);
        this.listadeCantos.setAdapter((ListAdapter) new ArrayAdapter(getActivity().getApplicationContext(), (int) R.layout.list_text,  16908308, this.itens));
        this.listadeCantos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                HomeFragment.this.listadeCantos.getItemAtPosition(i).toString();
                if (i == 0) {
                    Intent intent = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent.putExtra("letra", "Nós somos,\ndo Clube Atlético Mineiro.\nJogamos com muita raça e amor.\nVibramos com alegria nas vitórias.\nClube Atlético Mineiro,\nGalo forte vingador.\n\nVencer, vencer, vencer,\nEsse é o nosso ideal.\nHonramos o nome de Minas,\nno cenário esportivo mundial.\n\nLutar, lutar, lutar,\npelos gramados, do mundo pra vencer.\nClube Atlético Mineiro,\nUma vez, até morrer.\n\nNós somos campeões do gelo,\nO nosso time é imortal.\nNós somos campeões dos Campeões,\nsomos o orgulho do esporte nacional.\n\nLutar, lutar, lutar,\ncom toda nossa raça pra vencer.\nClube Atlético Mineiro,\numa vez até morrer.");
                    intent.putExtra("titulo", "Hino Do Atlético Mineiro");
                    intent.putExtra("completo", R.raw.hino_oficial);
                    intent.putExtra("ringtone", "hino_oficial");
                    HomeFragment.this.startActivity(intent);
                } else if (i == 1) {
                    Intent intent2 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent2.putExtra("letra", "Nós somos,\ndo Clube Atlético Mineiro.\nJogamos com muita raça e amor.\nVibramos com alegria nas vitórias.\nClube Atlético Mineiro,\nGalo forte vingador.\n\nVencer, vencer, vencer,\nEsse é o nosso ideal.\nHonramos o nome de Minas,\nno cenário esportivo mundial.\n\nLutar, lutar, lutar,\npelos gramados, do mundo pra vencer.\nClube Atlético Mineiro,\nUma vez, até morrer.\n\nNós somos campeões do gelo,\nO nosso time é imortal.\nNós somos campeões dos Campeões,\nsomos o orgulho do esporte nacional.\n\nLutar, lutar, lutar,\ncom toda nossa raça pra vencer.\nClube Atlético Mineiro,\numa vez até morrer.");
                    intent2.putExtra("titulo", "Hino Do Atlético Mineiro");
                    intent2.putExtra("completo", R.raw.hino_tianastacia);
                    intent2.putExtra("ringtone", "hino_tianastacia");
                    HomeFragment.this.startActivity(intent2);
                } else if (i == 2) {
                    Intent intent3 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent3.putExtra("letra", "Nós somos,\ndo Clube Atlético Mineiro.\nJogamos com muita raça e amor.\nVibramos com alegria nas vitórias.\nClube Atlético Mineiro,\nGalo forte vingador.\n\nVencer, vencer, vencer,\nEsse é o nosso ideal.\nHonramos o nome de Minas,\nno cenário esportivo mundial.\n\nLutar, lutar, lutar,\npelos gramados, do mundo pra vencer.\nClube Atlético Mineiro,\nUma vez, até morrer.\n\nNós somos campeões do gelo,\nO nosso time é imortal.\nNós somos campeões dos Campeões,\nsomos o orgulho do esporte nacional.\n\nLutar, lutar, lutar,\ncom toda nossa raça pra vencer.\nClube Atlético Mineiro,\numa vez até morrer.");
                    intent3.putExtra("titulo", "Hino Do Atlético Mineiro");
                    intent3.putExtra("completo", R.raw.hino_globo);
                    intent3.putExtra("ringtone", "hino_globo");
                    HomeFragment.this.startActivity(intent3);
                } else if (i == 3) {
                    Intent intent4 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent4.putExtra("letra", "Nós somos,\ndo Clube Atlético Mineiro.\nJogamos com muita raça e amor.\nVibramos com alegria nas vitórias.\nClube Atlético Mineiro,\nGalo forte vingador.\n\nVencer, vencer, vencer,\nEsse é o nosso ideal.\nHonramos o nome de Minas,\nno cenário esportivo mundial.\n\nLutar, lutar, lutar,\npelos gramados, do mundo pra vencer.\nClube Atlético Mineiro,\nUma vez, até morrer.\n\nNós somos campeões do gelo,\nO nosso time é imortal.\nNós somos campeões dos Campeões,\nsomos o orgulho do esporte nacional.\n\nLutar, lutar, lutar,\ncom toda nossa raça pra vencer.\nClube Atlético Mineiro,\numa vez até morrer.");
                    intent4.putExtra("titulo", "Hino Do Atlético Mineiro");
                    intent4.putExtra("completo", R.raw.hino_torcida);
                    intent4.putExtra("ringtone", "hino_torcida");
                    HomeFragment.this.startActivity(intent4);
                }
                if (i == 4) {
                    Intent intent5 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent5.putExtra("letra", "Primeiro campeão brasileiro\nClube Atlético Mineiro\nGalo!\nSinônimo de raça\n\nUma torcida apaixonada\nMinas Gerais está tomada\nGalo!\nÉ um time de massa\n\nGalo!\nA razão do meu viver!\nGalo!\nNosso lema é vencer\nTe apoiarei até morrer");
                    intent5.putExtra("titulo", "Galo, a razão do meu viver");
                    intent5.putExtra("completo", R.raw.galo_a_razao_do_viver);
                    intent5.putExtra("ringtone", "galo_a_razao_do_viver");
                    HomeFragment.this.startActivity(intent5);
                } else if (i == 5) {
                    Intent intent6 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent6.putExtra("letra", "Ao atlético dedico essa canção\nA Galoucura faz tremer o Mineirão\nA cada gol , cada grito o show da massa\nA emoção que contagia a arquibancada.\n\nA TOG pula sai do chão a maior do Mineirão\nGarra , Respeito e Determinação\nApoiar o galo esse é nosso lema\nEstou na pista maluco sem nenhum problema\n\nAtendendo aos pedidos\nVou fazendo a homenagem\nO Amor é alvinegro\nÉ real não miragem\n[REFRÃO]2x\nAo Atlético , Ao Atlético\nAo Atlético mineiro dedico essa canção\n\nNas derrotas nas batalhas ,\nEstamos sempre unidos torcemos para o galo\nCombatemos os inimigos , nas derrotas nas vitorias\nVamos estar com você , clube atlético mineiro\nForça raça pra vencer , é bonito ver quando essa massa canta\n\nDedico essa canção com emoção glorioso\nQue é time de preto, time de favelado\nMas quando o galo joga , o Mineirão fica lotado\nOs Maria tu vê , mas tem que ficar em casa\nSó bicando a TV.\n[REFRÃO]2x\n\nAo Atlético , Ao Atlético\nAo Atlético mineiro dedico essa canção\n\nAbram passagem o terror chegou\nAo Atlético mineiro dedico essa canção\nQuando a Galoucura canta\nFaz tremer o Mineirão\n\nTorcida não tem igual\nNão adianta copiar que Xerox\nNão sai igual , pode sair parecido\nMas não é o original\nAqui eu vou seguindo, fazendo da rima minha vida\nObrigado Deus por abençoa minha corrida\nDesde 1992 ,22 de fevereiro\nAqui vulgo Lukinha Clube Atlético Mineiro .\n[Refrão]2x\nAo Atlético , Ao Atlético\nAo Atlético mineiro dedico essa canção");
                    intent6.putExtra("titulo", "Ao Atlético");
                    intent6.putExtra("completo", R.raw.lukinha);
                    intent6.putExtra("ringtone", "lukinha");
                    HomeFragment.this.startActivity(intent6);
                } else if (i == 6) {
                    Intent intent7 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent7.putExtra("letra", "Maria, eu sei que você treme\nSempre que o Galo vai jogar\nEu vi Riascos ir pra bola\nE o Victor de bico isolar\n\n9×2 eu já ganhei\nVi o gol do Vanderlei\nE o Fábio lá de costas a chorar\n\nDo Verón eu vou lembrar\nMineirão se fez calar\nE o Galo para sempre eu vou te amar\n\n—\n\nMaria, eu sei que você treme\nSempre que o Galo vai jogar\nEu vi Riascos ir pra bola\nE o Victor de bico isolar\n\n9×2 eu já ganhei\nVi o gol do Vanderlei\nE o Fábio lá de costas a chorar\n\nDo Verón eu vou lembrar\nMineirão se fez calar\nE o Galo para sempre eu vou te amar");
                    intent7.putExtra("titulo", "Maria, eu sei que você treme");
                    intent7.putExtra("completo", R.raw.maria);
                    intent7.putExtra("ringtone", "maria");
                    HomeFragment.this.startActivity(intent7);
                } else if (i == 7) {
                    Intent intent8 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent8.putExtra("letra", "Tá ligado\nEu vou cantar um funk pra ninguém ficar parado\nCarrego no meu peito o meu time apaixonado\nEu sou da Galoucura a maior do meu estado\nE quem ficar parado vai tomar um tá ligado!\n\nQuem ficar parado vai tomar um tá ligado!\nQuem ficar parado vai tomar um tá ligado!\nQuem ficar parado vai tomar um tá ligado!\nQuem ficar parado vai tomar um tá ligado!\n\nô ôo ôoo somos sinistros!\nô ôo ôoo somos sinistros!");
                    intent8.putExtra("titulo", "Tá ligado");
                    intent8.putExtra("completo", R.raw.quem_ficar_parado);
                    intent8.putExtra("ringtone", "quem_ficar_parado");
                    HomeFragment.this.startActivity(intent8);
                } else if (i == 8) {
                    Intent intent9 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent9.putExtra("letra", "Eu, te amarei por toda vida,\nnão há no mundo quem duvida,\no quanto eu amo essa torcida.\n\nSou, atleticano alvinegro,\nMinas Gerais é o meu terreiro,\nte apoiarei até morrer\n\nGalo! Galo!\nGalo! Galo!");
                    intent9.putExtra("titulo", "Aquarela do Galo");
                    intent9.putExtra("completo", R.raw.aquarela);
                    intent9.putExtra("ringtone", "aquarela");
                    HomeFragment.this.startActivity(intent9);
                } else if (i == 9) {
                    Intent intent10 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent10.putExtra("letra", "Garoto eu sou da Galoucura\nEu levo a vida sem frescura\nEu tomo todas numa boa\nE vou torcer para o Galôôô\nEu dou a volta, eu picho muro, eu fumo bagulho\nEu cheiro um branco\nNa minha vida ninguém manda não\nEu vou onde vai o Galo\nEu dou porrada pra caralho\nEu boto a mafia pra correr\nA Mancha Azul é que vai ver\nO pau quebrar para valer...");
                    intent10.putExtra("titulo", "Garoto Eu Sou da Galoucura");
                    intent10.putExtra("completo", R.raw.garoto_eu_sou_galocura);
                    intent10.putExtra("ringtone", "garoto_eu_sou_galocura");
                    HomeFragment.this.startActivity(intent10);
                } else if (i == 10) {
                    Intent intent11 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent11.putExtra("letra", "Tente entender, tente de coração,\nE não há tempo pra briga, guerra ou discussão,\nA vida é curta amigo, põe a mão na consciência,\nCom a Galoucura vem, sem violência,\nPorquê tanta briga, tanta desunião,\nSe o Galo tem, pra dar, muita paz no coração,\nE é com isso que eu canto, sem medo de errar,\nVem com a Galoucura que a festa vai começar,\nÔbaaaa, lálálálálá,\nVem pro Minera agitar, lálálálálá,\nQue você vai se amarrar, lálálálálá, ôba,\nÔba, ôba, ôba, ôba, ôoooo...\nÔoooooo, Galoucura é um terror,\nÔoooooo, Mineirão é do Galo,\nÔoooooo, Ôô, ôba, ôba, ôba, ôba, ô...");
                    intent11.putExtra("titulo", "Ôba, Ôba, Ôba, Ôba, Ô...");
                    intent11.putExtra("completo", R.raw.oba);
                    intent11.putExtra("ringtone", "oba");
                    HomeFragment.this.startActivity(intent11);
                } else if (i == 11) {
                    Intent intent12 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent12.putExtra("letra", "Não sei porquê que foi assim\nDeus levou minha mãe e os manos de mim\nMó choradeira naquele velório...\nTu levanta daí eu digo, peço te imploro!\nÚltima reza pra fechar o caixão\nBateu a neurose, perda e depressão\nEstamos indo rumo ao cemitério, o barato, agora, vai ficar meio sério..\nVai de que lá pro baile?\nE avisa os manos da comunidade\nQue nóis já tamo tudo de luto\nTamo de fita preta no braço e tudo\nNa quebrada vai ter festa quando os oportunista tudo levar na testa\nAí então, é que vem a resposta, que tudo isso não traz os manos de volta!!!\nLalaia laialaia a T.O.G vai te pegar (3X)\nE naquele dia tudo prometia\nHomenagearam na de sétimo dia\nNa Aparecida,a de frente à praia\nSem namoro, sem bermuda, sem gandaia\nJá tava tudo bem esclarecido\nHomenagearam a missa dos falecidos\nGanhei lembrança com a sua foto e disse a sua familia que atras eu não volto\nVô cobrar, vai ser assim\nPorque a revolta já tomou conta de mim\nOs aliados não estão atoa\nTão tudo de fuzil, pistola e metralhadora\nTá ligado....a vida continua.....\nMano,tamo protegendo a família sua\nE os que foram lá pro céu na porra de um caixão e debaixo de um véu...");
                    intent12.putExtra("titulo", "A T.O.G vai te pegar");
                    intent12.putExtra("completo", R.raw.atog_vai_te_pegar);
                    intent12.putExtra("ringtone", "atog_vai_te_pegar");
                    HomeFragment.this.startActivity(intent12);
                } else if (i == 12) {
                    Intent intent13 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent13.putExtra("letra", "É, o teu castigo,\n" +
                            "Brigou comigo,\n" +
                            "Sem ter porquê,\n" +
                            "Vou festejar, vou festejar,\n" +
                            "O teu sofrer, o teu penar Você pagou com traição,\n" +
                            "A quem sempre lhe deu a mão,\n" +
                            "Você pagou com traição\n" +
                            "A quem sempre lhe deu a mão Chora, não vou ligar,\n" +
                            "Chegou a hora,\n" +
                            "Vais me pagar,\n" +
                            "Pode chorar, pode chorar\n" +
                            "É, o teu castigo,\n" +
                            "Brigou comigo,\n" +
                            "Sem ter porquê,\n" +
                            "Vou festejar, vou festejar,\n" +
                            "O teu sofrer, o teu penar,\n" +
                            "Você pagou com traição,\n" +
                            "A quem sempre lhe deu a mão\n" +
                            "Você pagou com traição,\n" +
                            "A quem sempre lhe deu a mão...");
                    intent13.putExtra("titulo", "Vou Festejar");
                    intent13.putExtra("completo", R.raw.vou_festejar);
                    intent13.putExtra("ringtone", "vou_festejar");
                    HomeFragment.this.startActivity(intent13);

                } else if (i == 13) {
                    Intent intent14 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent14.putExtra("letra", "Galoucura é rei\n" +
                            "Galoucura é rei\n" +
                            "Galoucura é rei…");
                    intent14.putExtra("titulo", "Galoucura é rei");
                    intent14.putExtra("completo", R.raw.galoucura);
                    intent14.putExtra("ringtone", "galoucura");
                    HomeFragment.this.startActivity(intent14);

                } else if (i == 14) {
                    Intent intent15 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent15.putExtra("letra", "Bota a cara alemão,\n" +
                            "Bota a cara alemão,\n" +
                            "Bota a cara porra!\n" +
                            "Viemos para agitar,\n" +
                            "Nao importa se o pau quebrar,\n" +
                            "Em qualquer lugar, não importa onde for,\n" +
                            "Galoucura é o terror,\n" +
                            "(Ôôôôôô) Galoucura é o terror...viegal\n");
                    intent15.putExtra("titulo", "Viemos Agitar");
                    intent15.putExtra("completo", R.raw.viemos_agitar);
                    intent15.putExtra("ringtone", "viemos_agitar");
                    HomeFragment.this.startActivity(intent15);

                } else if (i == 15) {
                    Intent intent16 = new Intent(getActivity().getApplicationContext(), Cantos.class);
                    intent16.putExtra("letra", "Bota a cara alemão,\n" +
                            "Bota a cara alemão,\n" +
                            "Bota a cara porra!\n" +
                            "Viemos para agitar,\n" +
                            "Nao importa se o pau quebrar,\n" +
                            "Em qualquer lugar, não importa onde for,\n" +
                            "Galoucura é o terror,\n" +
                            "(Ôôôôôô) Galoucura é o terror...viegal\n");
                    intent16.putExtra("titulo", "Domingo eu vou no Mineirão.");
                    intent16.putExtra("completo", R.raw.domingo);
                    intent16.putExtra("ringtone", "domingo");
                    HomeFragment.this.startActivity(intent16);
                }
            }
        });
        return view;
    }
}