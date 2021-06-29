package br.com.testefcamara.backendtestjava.form;

import java.time.LocalDateTime;

/**
 * Classe com intervalo de datas para relatório de veículos em estabelecimento.
 */
public class FlowCompanyVehicleForm {
    private LocalDateTime dhStart;

    private LocalDateTime dhEnd;

    public LocalDateTime getDhStart() {
        return dhStart;
    }

    public void setDhStart(LocalDateTime dhStart) {
        this.dhStart = dhStart;
    }

    public LocalDateTime getDhEnd() {
        return dhEnd;
    }

    public void setDhEnd(LocalDateTime dhEnd) {
        this.dhEnd = dhEnd;
    }
}
