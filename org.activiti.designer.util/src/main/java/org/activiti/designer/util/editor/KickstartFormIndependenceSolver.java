/**
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
package org.activiti.designer.util.editor;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.impl.IIndependenceSolver;

/**
 * @author Frederik Heremans
 *
 */
public class KickstartFormIndependenceSolver implements IIndependenceSolver {
	
  private IDiagramTypeProvider diagramTypeProvider;
    
  public KickstartFormIndependenceSolver(IDiagramTypeProvider diagramTypeProvider) {
    this.diagramTypeProvider = diagramTypeProvider;
  }
    
	@Override
	public String getKeyForBusinessObject(Object bo) {
	  return ensureKickstartFormMemoryModel().getKeyForBusinessObject(bo);
	}

	@Override
	public Object getBusinessObjectForKey(String key) {
	  return ensureKickstartFormMemoryModel().getBusinessObjectForKey(key);
	}

	public Map<String, Object> getObjectMap() {
	  return ensureKickstartFormMemoryModel().getObjectMap();
	}

	public void setObjectMap(Map<String, Object> objectMap) {
	  ensureKickstartFormMemoryModel().setObjectMap(objectMap);
	}
	
	protected KickstartFormMemoryModel ensureKickstartFormMemoryModel() {
	  if(diagramTypeProvider.getDiagram() == null) {
	    throw new IllegalStateException("No diagram is currently active");
	  }
	  
	  KickstartFormMemoryModel model = ModelHandler.getKickstartFormMemoryModel(EcoreUtil.getURI(diagramTypeProvider.getDiagram()));
	  if(model == null) {
	    throw new IllegalStateException("No diagram model is currently available for diagram: " + EcoreUtil.getURI(diagramTypeProvider.getDiagram()));
	  }
	  return model;
	}

}
