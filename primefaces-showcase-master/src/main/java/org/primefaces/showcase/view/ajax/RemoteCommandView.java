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
package org.primefaces.showcase.view.ajax;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named
@RequestScoped
public class RemoteCommandView {

    public void execute() {
        String param1 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param1");
        String param2 = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("param2");
        if (param1 != null || param2 != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "param1: " + param1 + ", param2: " + param2));
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Using RemoteCommand."));
        }

        PrimeFaces.current().ajax().addCallbackParam("serverTime", System.currentTimeMillis());
    }
}
