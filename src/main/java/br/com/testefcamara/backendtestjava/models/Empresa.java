package br.com.testefcamara.backendtestjava.models;

public class Empresa {

    private Long idEmpresa;

    private String nmEmpresa;

    private String cdCnpj;

    private String nmEndereco;

    private String nrTelefone;

    private int qtVagasMoto;

    private int qtVagasCarro;

    public String getNmEmpresa() {
        return nmEmpresa;
    }

    public void setNmEmpresa(String nmEmpresa) {
        this.nmEmpresa = nmEmpresa;
    }

    public String getCdCnpj() {
        return cdCnpj;
    }

    public void setCdCnpj(String cdCnpj) {
        this.cdCnpj = cdCnpj;
    }

    public String getNmEndereco() {
        return nmEndereco;
    }

    public void setNmEndereco(String nmEndereco) {
        this.nmEndereco = nmEndereco;
    }

    public String getNrTelefone() {
        return nrTelefone;
    }

    public void setNrTelefone(String nrTelefone) {
        this.nrTelefone = nrTelefone;
    }

    public int getQtVagasMoto() {
        return qtVagasMoto;
    }

    public void setQtVagasMoto(int qtVagasMoto) {
        this.qtVagasMoto = qtVagasMoto;
    }

    public int getQtVagasCarro() {
        return qtVagasCarro;
    }

    public void setQtVagasCarro(int qtVagasCarro) {
        this.qtVagasCarro = qtVagasCarro;
    }
}
