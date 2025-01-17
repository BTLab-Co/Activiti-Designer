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
import org.activiti.bpmn.model.TerminateEventDefinition;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class PropertyTerminateEndEventSection extends ActivitiPropertySection implements ITabbedPropertyConstants {

    protected Combo terminateAll;
    protected String[] values = new String[]{"true", "false"};

    @Override
    public void createFormControls(TabbedPropertySheetPage aTabbedPropertySheetPage) {
        terminateAll = createCombobox(values, 1);

        createLabel("Terminate All", terminateAll);
    }

    @Override
    protected Object getModelValueForControl(Control control, Object businessObject) {
        EndEvent event = (EndEvent) businessObject;
        if (control == terminateAll) {
            if (event.getEventDefinitions().get(0) != null) {
                TerminateEventDefinition errorDefinition = (TerminateEventDefinition) event.getEventDefinitions().get(0);
                return String.valueOf(errorDefinition.isTerminateAll());
            }
        }
        return null;
    }

    @Override
    protected void storeValueInModel(Control control, Object businessObject) {
        EndEvent event = (EndEvent) businessObject;
        if (control == terminateAll) {
            TerminateEventDefinition errorDefinition = (TerminateEventDefinition) event.getEventDefinitions().get(0);
            errorDefinition.setTerminateAll("true".equalsIgnoreCase(values[terminateAll.getSelectionIndex()]));
        }
    }
}
