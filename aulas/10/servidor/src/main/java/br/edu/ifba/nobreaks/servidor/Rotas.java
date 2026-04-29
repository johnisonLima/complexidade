package br.edu.ifba.nobreaks.servidor;

import br.edu.ifba.nobreaks.servidor.operacoes.Operacoes;
import br.edu.ifba.nobreaks.servidor.impl.Leitura;
import br.edu.ifba.nobreaks.servidor.impl.Nobreak;
import br.edu.ifba.nobreaks.servidor.impl.OperacoesImpl;
import jakarta.annotation.Generated;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("nobreaks")
@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
public class Rotas {

    private static final int LIMITE_OSCILACAO_TEMPERATURA = 15;
    private static final int LIMITE_OSCILACAO_CARGA_BATERIA = 20;

        
    private static Operacoes<Nobreak, Leitura> operacoes = null;
    private static Operacoes<Nobreak, Leitura> getOperacoes(){
        if (operacoes == null){
            operacoes = new OperacoesImpl();
        }
        return operacoes;
    }

    private static final String INFORMACOES = "Serviços de atendimento a nobreaks v1.0";

    @GET
    @Path("/")
    public Response getInfomacoes(){
        return Response.ok(INFORMACOES, MediaType.TEXT_PLAIN + "; charset=UTF-8").build();
    }

    @Path("{id}/{temperatura}/{carga}")
    public Response gravarLeitura(@PathParam("id") String idNoBreak, @PathParam("temperatura") int temperatura, @PathParam("carga") int cargaBateria){
        Nobreak noBreak = new Nobreak(idNoBreak, "único");
        Leitura leitura = new Leitura(temperatura, cargaBateria);

        getOperacoes().gravar(noBreak, leitura);

        return Response.ok().build();
    }

    @GET
    @Path("oscilaoes")
    public Response detectarResponse(){
        int oscilacoes = getOperacoes().detectarAltasTemperaturas(LIMITE_OSCILACAO_TEMPERATURA, LIMITE_OSCILACAO_CARGA_BATERIA);
        
        return Response.ok(oscilacoes + "", MediaType.TEXT_PLAIN + "; charset=UTF-8").build();
    }

}