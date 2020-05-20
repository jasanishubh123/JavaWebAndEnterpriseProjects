/*
 * Copyright 2009-2014 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.showcase.view.data.datatable;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.showcase.domain.Car;
import org.primefaces.showcase.service.CarService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("dtLazyView")
@ViewScoped
public class LazyView implements Serializable {
    
    private LazyDataModel<Car> lazyModel;
    
    private Car selectedCar;
    
    @Inject
    private CarService service;
    
    @PostConstruct
    public void init() {
        lazyModel = new LazyCarDataModel(service.createCars(200));
    }

    public LazyDataModel<Car> getLazyModel() {
        return lazyModel;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
    
    public void setService(CarService service) {
        this.service = service;
    }
    
    public void onRowSelect(SelectEvent<Car> event) {
        FacesMessage msg = new FacesMessage("Car Selected", event.getObject().getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
