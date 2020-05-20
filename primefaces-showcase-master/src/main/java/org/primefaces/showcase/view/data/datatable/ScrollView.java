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

import javax.faces.view.ViewScoped;
import org.primefaces.model.LazyDataModel;
import org.primefaces.showcase.domain.Car;
import org.primefaces.showcase.service.CarService;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("dtScrollView")
@ViewScoped
public class ScrollView implements Serializable {
    
    private List<Car> cars1;
    private List<Car> cars2;
    private List<Car> cars3;
    private List<Car> cars4;
    private List<Car> cars5;
    private List<Car> cars6;
    private LazyDataModel<Car> lazyModel;
    
    @Inject
    private CarService service;

    @PostConstruct
    public void init() {
        cars1 = service.createCars(50);
        cars2 = service.createCars(10);
        cars3 = service.createCars(50);
        cars4 = service.createCars(50);
        cars5 = service.createCars(50);
        cars6 = service.createCars(200);
        lazyModel = new LazyCarDataModel(service.createCars(20000));
    }

    public List<Car> getCars1() {
        return cars1;
    }

    public List<Car> getCars2() {
        return cars2;
    }

    public List<Car> getCars3() {
        return cars3;
    }

    public List<Car> getCars4() {
        return cars4;
    }

    public List<Car> getCars5() {
        return cars5;
    }

    public List<Car> getCars6() {
        return cars6;
    }

    public LazyDataModel<Car> getLazyModel() {
        return lazyModel;
    }

    public void setLazyModel(LazyDataModel<Car> lazyModel) {
        this.lazyModel = lazyModel;
    }

    public void setService(CarService service) {
        this.service = service;
    }
}