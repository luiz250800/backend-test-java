package br.com.testefcamara.backendtestjava.enums;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.strategy.CarStrategy;
import br.com.testefcamara.backendtestjava.strategy.MotorcycleStrategy;

/**
 * Enum de tipo veículo.
 */
public enum TypeVehicle {
    MOTORCYCLE {
        /**
         * Método para retornar instância de strategy motorcycle.
         * @return
         */
        @Override
        public VehicleStrategy getInstance() {
            return new MotorcycleStrategy();
        }
    },
    CAR {
        /**
         * @return Método para retornar instância de strategy car.
         */
        @Override
        public VehicleStrategy getInstance() {
            return new CarStrategy();
        }
    };

    /**
     * Método abstrato para implementar em todas as opções de veículos sua instancia strategy.
     * @return
     */
    public abstract VehicleStrategy getInstance();
}
