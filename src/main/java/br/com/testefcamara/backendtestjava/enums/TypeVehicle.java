package br.com.testefcamara.backendtestjava.enums;

import br.com.testefcamara.backendtestjava.strategyInterfaces.VehicleStrategy;
import br.com.testefcamara.backendtestjava.strategy.CarStrategy;
import br.com.testefcamara.backendtestjava.strategy.MotorcycleStrategy;

public enum TypeVehicle {
    MOTORCYCLE {
        @Override
        public VehicleStrategy getInstance() {
            return new MotorcycleStrategy();
        }
    },
    CAR {
        @Override
        public VehicleStrategy getInstance() {
            return new CarStrategy();
        }
    };

    public abstract VehicleStrategy getInstance();
}
