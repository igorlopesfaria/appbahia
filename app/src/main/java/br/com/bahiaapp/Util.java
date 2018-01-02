package br.com.bahiaapp;

import java.util.ArrayList;
import java.util.List;

import br.com.bahiaapp.model.Feed;
import br.com.bahiaapp.model.Match;
import br.com.bahiaapp.model.MatchAction;
import br.com.bahiaapp.model.MatchActionType;
import br.com.bahiaapp.model.Team;

/**
 * Created by Igor Faria on 01/01/17.
 */

public class Util {


    public static List<Feed> mockFeed(){
        List<Feed> feeds = new ArrayList<>();

        feeds.add(new Feed(1l,
                "De volta",
                "Guto Ferreira é o novo técnico do Esquadrão",
                "Comandante do acesso à Série A do Campeonato Brasileiro em 2016 e da conquista da Copa do Nordeste em 2017, título mais importante do clube nos últimos 15 anos, Guto Ferreira está de volta ao Esquadrão. <br><br> " +
                        "A primeira passagem do treinador pelo Bahia contou com 56 partidas oficiais, 30 triunfos, 15 empates e apenas 11 derrotas. Os números renderam um aproveitamento de 62,5% dos pontos disputados. <br><br>" +
                        "O mais recente trabalho de Guto foi no Internacional, quando deixou o time gaúcho na segunda posição da Série B. Lá, o técnico obteve 60% de aproveitamento e conquistou 17 triunfos em 33 confrontos. <br><br>" +
                        "Paulista de Piracicaba, Augusto Sérgio Ferreira, de 51 anos, realizou outros dois conhecidos trabalhos: na Chapecoense, de setembro de 2015 a junho de 2016, e na Ponte Preta, onde teve duas passagens (2012-2013 e 2014-2015). Na Macaca, aparece como um dos 10 que mais dirigiram o time de Campinas, com 107 jogos. <br><br>" +
                        "Ao lado de Guto Ferreira, que assinou contrato até o final de 2018, mais três profissionais retornam ao Fazendão: os auxiliares André Luis e Alexandre Faganello e o preparador físico Juninho.",
                "26/12/2017",
                "https://s2.glbimg.com/VRq3cklC2oeWYDNZFb3JFWLXO08=/0x0:2500x1667/1000x0/smart/filters:strip_icc()/s.glbimg.com/es/ge/f/original/2017/05/26/34765444071_656cf532af_o.jpg",
                "http://www.esporteclubebahia.com.br/de-volta-6/",
                true));
        feeds.add(new Feed(2l,
                "Régis",
                "Números da temporada 2017 do camisa 20 no Bahia",
                "Com a saída do goleiro Jean, oficialmente negociado para o São Paulo, o Tricolor de Aço confirmou como parte da negociação a permanência, por mais três anos, do apoiador Régis. <br><br> " +
                        "Meia de origem, mas com o viés pra lá de ofensivo, o camisa 20 do Esquadrão encerrou a temporada de 2017 entre os melhores dos rankings de gols e assistências. Artilheiro da Copa do Nordeste, com 6 gols, o paulista de Turmalina fechou o ano com 13 gols marcados. O líder foi Edigar Junio, com 15 tentos. <br><br>" +
                        "O destaque dele, porém, não ficou apenas em balançar a rede adversária. Régis, com 9 assistências, foi o segundo do ranking de passes diretos para gol do Bahia no ano, atrás apenas do argentino Allione (11). Só no Brasileirão, por exemplo, foram cinco. <br><br>" +
                        "Em 2016, seu primeiro ano de Tricolor, o meia chegou para disputar posição com Renato Cajá, camisa 10 da época. Entre jogos como titular e reserva, Régis colaborou com o acesso do Esquadrão à primeira divisão do futebol brasileiro. Foram 26 apresentações, com 4 gols e 4 assistências. Destaque especial para a partida contra o Ceará, na Fonte Nova, em outubro. Régis, opção para o decorrer do jogo, entrou quando o placar era adverso, fez um gol, deu passe para outro e ajudou o Tricolor no triunfo por 3 a 1. <br><br>" +
                        "Se lembrarmos de 2017, além de gols pelo Brasileirão e Copa do Brasil, o camisa 20 carimbou o ‘selo de artilheiro’ no segundo jogo da semifinal do Nordestão, contra o Vitória. No segundo tempo, depois de cruzamento de Eduardo, deixou um zagueiro no chão e tocou com categoria, na saída do goleiro.",
                "26/12/2017",
                "http://www.esporteclubebahia.com.br/wp-content/uploads/2017/11/WhatsApp-Image-2017-11-22-at-17.25.13-570x350.jpeg",
                "http://www.esporteclubebahia.com.br/regis-numeros/",
                false));
        feeds.add(new Feed(3l,
                "Comunicado",
                "Transferência de Jean + Régis",
                "O Esporte Clube Bahia comunica à Nação Tricolor que finalizou os entendimentos com o São Paulo Futebol Clube relativos à transferência do goleiro Jean. A notícia foi anunciada pelo presidente Guilherme Bellintani, em primeira mão, durante o Programa do Esquadrão desta sexta-feira (22). <br><br> " +
                        "A operação envolve o pagamento de cerca de R$ 9 milhões ao Bahia, além da cessão definitiva do meia Régis, com contrato de três anos, e também a de um segundo atleta do SPFC a ser anunciado. <br><br>" +
                        "O valor corresponde aos 70% dos direitos econômicos que o Tricolor possuía de Jean. <br><br>",
                "25/12/2017",
                "http://www.esporteclubebahia.com.br/wp-content/uploads/2016/07/IFR_BAHIA-FC1463-570x350.jpg",
                "http://www.esporteclubebahia.com.br/comunicado-62/",
                false));
        feeds.add(new Feed(4l,
                "Sul-Americana",
                "Tricolor conhece adversário da 1ª fase",
                "Em sorteio realizado nesta quarta-feira (20), em Luque, no Paraguai, o Tricolor conheceu seu adversário na primeira fase da Copa Sul-Americana. <br><br> " +
                        "O adversário do Esquadrão na competição internacional será o Blooming, da Bolívia. O primeiro duelo será realizado em Santa Cruz de La Sierra, enquanto o jogo de volta terá mando de campo do Bahia, na Arena Fonte Nova. Será a primeira vez que uma equipe boliviana será oponente do Esquadrão na Sul-Americana. <br><br>" +
                        "Os jogos da primeira fase serão distribuídos em cinco datas diferentes: 14 e 21 de fevereiro, 7 de março, 11 de abril e 9 de maio. <br><br>" +
                        "O ganhador disputará a Recopa Sul-Americana 2019 contra o campeão da Libertadores 2018 e a Copa Suruga 2019 ante o campeão japonês. Além disso, garantirá vaga na fase de grupos da Libertadores 2019. <br><br>" +
                        " O Club Social, Cultural y Deportivo Blooming é sediado na cidade de Santa Cruz de la Sierra, a maior e mais populosa cidade da Bolívia, a apenas 416 metros de altitude. Fundado em 1º de maio de 1946, manda seus jogos no Estádio Ramon Tauhichi Aguilera, com capacidade para 38 mil pessoas. No último nacional, o adversário do Tricolor de Aço encerrou a competição na quinta posição.",
                "20/12/2017",
                "http://www.esporteclubebahia.com.br/wp-content/uploads/2017/11/copasul-americana715-570x350.jpg",
                "http://www.esporteclubebahia.com.br/sorteio-sula/",
                false));
        feeds.add(new Feed(5l,
                "Nova mesa",
                "Conselho Deliberativo escolhe presidente, vice e secretário",
                "O novo Conselho Deliberativo do Esporte Clube Bahia, escolhido para o próximo triênio (2018-2020), se reuniu pela primeira vez na noite desta quarta-feira (20), na Arena Fonte Nova. <br><br> " +
                        "No primeiro encontro, ainda sob comando da mesa provisória, os conselheiros elegeram os novos responsáveis pelo órgão. Com apenas uma chapa apresentada, o advogado Carlos Eduardo Guimarães Araújo foi nomeado o novo presidente do Conselho Deliberativo. <br><br>" +
                        "Thiago Dorea Moreira será o vice-presidente, enquanto Lucas Maia Costa foi escolhido para desempenhar o papel de secretário. <br><br>" +
                        "Na segunda reunião do dia, como determina o estatuto do clube, a Diretoria Executiva realizou a apresentação oficial do orçamento para temporada 2018.",
                "20/12/2017",
                "http://www.esporteclubebahia.com.br/wp-content/uploads/2017/12/IMG-20171220-WA0045-570x350.jpg",
                "http://www.esporteclubebahia.com.br/nova-mesa/",
                false));
        feeds.add(new Feed(6l,
                "Empossados",
                "Diretoria e Conselho Deliberativo iniciam nova etapa.",
                "Com a saída do goleiro Jean, oficialmente negociado para o São Paulo, o Tricolor de Aço confirmou como parte da negociação a permanência, por mais três anos, do apoiador Régis. <br><br> " +
                        "Meia de origem, mas com o viés pra lá de ofensivo, o camisa 20 do Esquadrão encerrou a temporada de 2017 entre os melhores dos rankings de gols e assistências. Artilheiro da Copa do Nordeste, com 6 gols, o paulista de Turmalina fechou o ano com 13 gols marcados. O líder foi Edigar Junio, com 15 tentos. <br><br>" +
                        "O destaque dele, porém, não ficou apenas em balançar a rede adversária. Régis, com 9 assistências, foi o segundo do ranking de passes diretos para gol do Bahia no ano, atrás apenas do argentino Allione (11). Só no Brasileirão, por exemplo, foram cinco. <br><br>" +
                        "Em 2016, seu primeiro ano de Tricolor, o meia chegou para disputar posição com Renato Cajá, camisa 10 da época. Entre jogos como titular e reserva, Régis colaborou com o acesso do Esquadrão à primeira divisão do futebol brasileiro. Foram 26 apresentações, com 4 gols e 4 assistências. Destaque especial para a partida contra o Ceará, na Fonte Nova, em outubro. Régis, opção para o decorrer do jogo, entrou quando o placar era adverso, fez um gol, deu passe para outro e ajudou o Tricolor no triunfo por 3 a 1. <br><br>" +
                        "Se lembrarmos de 2017, além de gols pelo Brasileirão e Copa do Brasil, o camisa 20 carimbou o ‘selo de artilheiro’ no segundo jogo da semifinal do Nordestão, contra o Vitória. No segundo tempo, depois de cruzamento de Eduardo, deixou um zagueiro no chão e tocou com categoria, na saída do goleiro.",
                "19/12/2017",
                "http://www.esporteclubebahia.com.br/wp-content/uploads/2017/12/38436155574_45f8540d52_k-570x350.jpg",
                "http://www.esporteclubebahia.com.br/posse-oficial/",
                false));

        return feeds;
    }


    public static List<Match> mockMatch() {
        List<Match> matches = new ArrayList<>();

       matches.add(new Match(4,0,new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png"),
               new Team("Jacuipense", "JAC", "https://www.escudosfc.com.br/images/jacuipense_ba.jpg")));

        matches.add(new Match(1,3,new Team("Paraná", "PAR","https://www.escudosfc.com.br/images/parana.png"),
                new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png")));
        matches.add(new Match(3,0,new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png"),
                new Team("Juventude", "JUV", "https://www.escudosfc.com.br/images/juventude.png")));
        matches.add(new Match(1,1, new Team("Atlético PR", "CAP", "https://www.escudosfc.com.br/images/atlpr.png"),
                new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png")));
        matches.add(new Match(2,0, new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png"),
                new Team("Ceará", "CEA", "https://www.escudosfc.com.br/images/ceara.png")));
        matches.add(new Match(0,1,new Team("Sport", "SPT", "https://www.escudosfc.com.br/images/sport.gif"),
                new Team("Bahia", "BAH", "https://www.escudosfc.com.br/images/bahia.png")));
        return matches;

    }

    public static List<MatchAction> mockMatchAction() {
        List<MatchAction> matchAction = new ArrayList<>();
        matchAction.add(new MatchAction(MatchActionType.FINISH_MATHC, "Fim de jogo na Fonte Nova... Estreantes roubam a cena e tricolor inicia com pé direito 2018.", "FIM DO 2° TEMPO",
                "48' 2°T",  false, false, true));

        matchAction.add(new MatchAction(MatchActionType.GOAL, "Mais um Bahêa. Em escanteio cobrado, zagueiro estreante Maidana sobe sozinho e marca para o esquadrão.", "GOOOL DO BAHÊA!",
                "42' 2°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.REDCARD, "Lateral Rodinei mete a mão na bola para parar contraataque tricolor e vai para o chuveiro mais cedo.", "AMARELÔ",
                "37' 2°T",  false, true, false));

        matchAction.add(new MatchAction(MatchActionType.GOAL, "Tá virando goleada. Lindo lançamento de Nilton para Élber, atacante limpa goleiro e marca o segundo em sua estreia.", "GOOOL DO BAHÊA!",
                "26' 2°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.LINEMAN, "Mais um impedimento marcado, dessa vez o volante Nilton lança Mendoza que está fora de jogo.", "TÁ NA BANHEIRA",
                "14' 2°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.LINEMAN, "Jacuipense no seu primeiro ataque é marcado impedimento do atacante Caça Rato", "TÁ NA BANHEIRA",
                "07' 2°T",  false, true, false));

        matchAction.add(new MatchAction(MatchActionType.START_MATCH, "Reinicia partida na Fonte Nova...", "RECOMEÇA O JOGO",
                "00' 2°T",  false, false, true));

        matchAction.add(new MatchAction(MatchActionType.FINISH_MATHC, "Fim de papo no primeiro tempo na Fonte Nova...", "FIM DO 1° TEMPO",
                "47' 1°T",  false, false, true));

        matchAction.add(new MatchAction(MatchActionType.YELLOW_CARD, "Lateral Rodinei da Jacuipense dá entrada dura no lateral esquerdo Moisés do Bahia e recebe chapinha amarela.", "AMARELÔ",
                "37' 1°T",  false, true, false));

        matchAction.add(new MatchAction(MatchActionType.NORMAL_ACTION, "Time do interior chega pela primeira vez com perigo na área do Bahia em bola lançada na árae com defesa em dois tempos do goleiro estreante Douglas.", "LANCE PERIGOSO",
                "29' 1°T",  false, true, false));

        matchAction.add(new MatchAction(MatchActionType.GOAL, "Nino Paraíba cruza a zaga afasta e Elber marca bonito gol de fora da área.", "GOOOL DO BAHÊA!",
                "19' 1°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.GOAL_KEEPER, "Pontapé de Edgar Junio faz o goleiro da Jacuipense fazer uma linda defesa.", "DEFESA DA PORRA",
                "11' 1°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.GOAL, "Primeira jogada de ataque Zé Rafael faz linda jogada individual e marca.", "GOOOL DO BAHÊA!",
                "05' 1°T",  true, false, false));

        matchAction.add(new MatchAction(MatchActionType.START_MATCH, "E rola a bola na Fonte Nova...", "COMEÇA O JOGO",
        "00' 1°T",  false, false, true));













        return matchAction;
    }

}
//(String description, String title, Integer time, String half,
//        Boolean homeAction, Boolean awayAction, Boolean matchAction)