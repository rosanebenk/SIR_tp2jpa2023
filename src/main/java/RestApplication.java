/**
 * JBoss, Home of Professional Open Source
 * Copyright Red Hat, Inc., and individual contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import metier.Personne;
import rest.FicheRessource;
import rest.PersonneRessource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class RestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {

        final Set<Class<?>> clazzes = new HashSet<Class<?>>();

        // SWAGGER endpoints
        clazzes.add(OpenApiResource.class);

        clazzes.add(PersonneRessource.class);
        clazzes.add(FicheRessource.class);
        clazzes.add(OpenApiResource.class);


        return clazzes;
    }

}
