package br.com.spo.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.PieChartModel;

import br.com.spo.model.beans.Estatistica;
import br.com.spo.model.beans.Jogo;
import br.com.spo.service.implementations.EstatisticaService;
import br.com.spo.service.implementations.JogoService;
import br.com.spo.util.FacesUtil;

@ManagedBean
@ViewScoped
public class HomeBean {

    private List<Jogo> jogos;

    private PieChartModel pieModel;
    
    @Inject
    private JogoService jogoService;
    
    @Inject
    private EstatisticaService estatisticaService;

    public HomeBean() {
        jogos = getJogoService().listarTodos();
    }

    @PostConstruct
    public void init() {
        criarPieModel();
    }

    private void criarPieModel() {

        // TODO Futuramente substituir os valores fixos pelas estatísticas do
        // usuário logado
        
        Estatistica estatisticaUsuario = getEstatisticaService().findByUsuario(FacesUtil.getUsuarioLogado().getId());

        pieModel = new PieChartModel();
        pieModel.set("Placar em cheio", estatisticaUsuario.getPlacarCheio());
        pieModel.set("Placar do perdedor", estatisticaUsuario.getPlacarPerdedor());
        pieModel.set("Diferença de gols", estatisticaUsuario.getDiferencaGols());

        pieModel.setShowDataLabels(true);
        pieModel.setTitle("Estatística dos Palpites");
        pieModel.setLegendPosition("w");
    }
    
    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    public PieChartModel getPieModel() {
        return pieModel;
    }
    
    public EstatisticaService getEstatisticaService() {
        if (estatisticaService == null) {
            estatisticaService = new EstatisticaService();
        }
        return estatisticaService;
    }

    public JogoService getJogoService() {
        if (jogoService == null) {
            jogoService = new JogoService();
        }
        return jogoService;
    }
}
