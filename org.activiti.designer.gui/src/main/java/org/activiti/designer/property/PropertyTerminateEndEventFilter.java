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
package org.activiti.designer.property;

import org.activiti.bpmn.model.EndEvent;
import org.activiti.bpmn.model.EventDefinition;
import org.activiti.bpmn.model.TerminateEventDefinition;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class PropertyTerminateEndEventFilter extends ActivitiPropertyFilter {

    @Override
    protected boolean accept(PictogramElement pe) {
        Object bo = getBusinessObject(pe);
        if (bo instanceof EndEvent) {
            EndEvent endEvent = (EndEvent) bo;
            if (endEvent.getEventDefinitions() != null) {
                for (EventDefinition eventDefinition : endEvent.getEventDefinitions()) {
                    if (eventDefinition instanceof TerminateEventDefinition) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
