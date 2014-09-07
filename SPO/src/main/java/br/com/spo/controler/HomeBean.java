package br.com.spo.controler;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import br.com.spo.model.beans.Jogo;
import br.com.spo.service.implementations.JogoService;
import br.com.spo.service.interfaces.IEstadoService;
import br.com.spo.service.interfaces.IJogoService;

@Named
@ViewScoped
public class HomeBean {
    
    private List<Jogo> jogos;
    
    private LineChartModel graficoModel;
    
    @Inject
    private IJogoService jogoService;
    
    @Inject
    private IEstadoService estadoService;
    
    public HomeBean() {
        jogos = new JogoService().listarTodos();
    }
    
    @PostConstruct
    public void init() {
        criarGraficoModel();
    }
    
    private void criarGraficoModel() {
        graficoModel = initModel();
        graficoModel.setTitle("Palpites em Cheio");
        graficoModel.setLegendPosition("e");
        graficoModel.setShowPointLabels(true);
        graficoModel.getAxes().put(AxisType.X, new CategoryAxis("Rodadas"));
        
        Axis yAxis = graficoModel.getAxis(AxisType.Y);
        yAxis = graficoModel.getAxis(AxisType.Y);
        yAxis.setLabel("Acertos");
        yAxis.setMin(0);
        yAxis.setMax(50);
    }
    
    private LineChartModel initModel() {
        LineChartModel model = new LineChartModel();
        
        ChartSeries palpitesCheio = new ChartSeries();
        palpitesCheio.setLabel("Palpites");
        palpitesCheio.set("13°", 2);
        palpitesCheio.set("14°", 4);
        palpitesCheio.set("15°", 5);
        palpitesCheio.set("16°", 5);
        palpitesCheio.set("17°", 8);
        
        model.addSeries(palpitesCheio);
        
        return model;
    }
    
    public List<Jogo> getJogos() {
        return jogos;
    }
    
    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
    
    public LineChartModel getGraficoModel() {
        return graficoModel;
    }
    
}
