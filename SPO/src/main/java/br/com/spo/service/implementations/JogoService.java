package br.com.spo.service.implementations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.spo.model.beans.Equipe;
import br.com.spo.model.beans.Estadio;
import br.com.spo.model.beans.Jogo;
import br.com.spo.service.interfaces.IJogoService;

public class JogoService implements IJogoService {

	private static final long serialVersionUID = 6119199650878854068L;

	@Override
    public List<Jogo> listarTodos() {
        
        List<Jogo> jogos = new ArrayList<>();

        Equipe equipeMandante = new Equipe();
        equipeMandante.setId(1l);
        equipeMandante.setNome("Internacional");
        equipeMandante.setSigla("INT");
        equipeMandante.setEscudo("http://s.glbimg.com/es/sde/f/equipes/2014/04/14/internacional_30x30.png");
        
        Equipe equipeVisitante = new Equipe();
        equipeVisitante.setId(2l);
        equipeVisitante.setNome("Grêmio");
        equipeVisitante.setSigla("GRE");
        equipeVisitante.setEscudo("http://s.glbimg.com/es/sde/f/equipes/2013/12/16/gremio_30x30.png");

        Estadio beiraRio = new Estadio();
        beiraRio.setId(1l);
        beiraRio.setNome("Beira Rio");

        Jogo jogo1 = new Jogo();
        jogo1.setId(1l);
        jogo1.setEquipeMandante(equipeMandante);
        jogo1.setEquipeVisitante(equipeVisitante);
        jogo1.setEstadio(beiraRio);
        jogo1.setData(new Date());
        jogo1.setHora(Calendar.getInstance().getTime());
        jogo1.setRodada(18);
        
        Equipe equipeMandante2 = new Equipe();
        equipeMandante2.setId(2l);
        equipeMandante2.setNome("Coritiba");
        equipeMandante2.setSigla("COR");
        equipeMandante2.setEscudo("http://s.glbimg.com/es/sde/f/equipes/2013/12/16/coritiba_30x30.png");
        
        Equipe equipeVisitante2 = new Equipe();
        equipeVisitante2.setId(2l);
        equipeVisitante2.setNome("Fluminense");
        equipeVisitante2.setSigla("FLU");
        equipeVisitante2.setEscudo("http://s.glbimg.com/es/sde/f/equipes/2013/12/16/fluminense_30x30.png");
        
        Estadio coutoPereira = new Estadio();
        coutoPereira.setId(2l);
        coutoPereira.setNome("Couro Pereira");

        Jogo jogo2 = new Jogo();
        jogo2.setId(2l);
        jogo2.setEquipeMandante(equipeMandante2);
        jogo2.setEquipeVisitante(equipeVisitante2);
        jogo2.setData(new Date());
        jogo2.setEstadio(coutoPereira);
        jogo2.setHora(Calendar.getInstance().getTime());
        jogo2.setRodada(18);

        jogos.add(jogo1);
        jogos.add(jogo2);

        return jogos;
    }
    
}
