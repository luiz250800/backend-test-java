package br.com.testefcamara.backendtestjava.models;

import br.com.testefcamara.backendtestjava.enums.TipoVeiculo;

public class Veiculo {

    private Long idVeiculo;

    private String nmMarca;

    private String nmModelo;

    private String nmCor;

    private String nrPlaca;

    private TipoVeiculo tpVeiculo;

    private Empresa empresa;

    public Long getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(Long idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public String getNmMarca() {
        return nmMarca;
    }

    public void setNmMarca(String nmMarca) {
        this.nmMarca = nmMarca;
    }

    public String getNmModelo() {
        return nmModelo;
    }

    public void setNmModelo(String nmModelo) {
        this.nmModelo = nmModelo;
    }

    public String getNmCor() {
        return nmCor;
    }

    public void setNmCor(String nmCor) {
        this.nmCor = nmCor;
    }

    public String getNrPlaca() {
        return nrPlaca;
    }

    public void setNrPlaca(String nrPlaca) {
        this.nrPlaca = nrPlaca;
    }

    public TipoVeiculo getTpVeiculo() {
        return tpVeiculo;
    }

    public void setTpVeiculo(TipoVeiculo tpVeiculo) {
        this.tpVeiculo = tpVeiculo;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
