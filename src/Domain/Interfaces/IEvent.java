package Domain.Interfaces;

import Domain.AsymtoticCostsTypes;
import Domain.DTO.Point;

import java.awt.event.ActionListener;

public interface IEvent extends ActionListener {
    abstract public void notifyWindow(Point points) ;
    abstract public void notifyAlgorithm(AsymtoticCostsTypes type) ;
}
