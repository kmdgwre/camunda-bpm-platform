/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.bpm.engine.impl.dmn.cmd;

import java.io.InputStream;
import java.io.Serializable;
import java.util.concurrent.Callable;
import org.camunda.bpm.engine.impl.cmd.GetDeploymentResourceCmd;
import org.camunda.bpm.engine.impl.interceptor.Command;
import org.camunda.bpm.engine.impl.interceptor.CommandContext;
import org.camunda.bpm.engine.repository.DecisionDefinition;


/**
 * Gives access to a deployed decision diagram, e.g., a PNG image, through a stream of bytes.
 */
public class GetDeploymentDecisionDiagramCmd implements Command<InputStream>, Serializable {

  private static final long serialVersionUID = 1L;

  protected String decisionDefinitionId;

  public GetDeploymentDecisionDiagramCmd(String decisionDefinitionId) {
    this.decisionDefinitionId = decisionDefinitionId;
  }

  public InputStream execute(final CommandContext commandContext) {
    DecisionDefinition decisionDefinition = new GetDeploymentDecisionDefinitionCmd(decisionDefinitionId).execute(commandContext);

    final String deploymentId = decisionDefinition.getDeploymentId();
    final String resourceName = decisionDefinition.getDiagramResourceName();

    if (resourceName != null ) {
      return commandContext.runWithoutAuthorization(new Callable<InputStream>() {
        public InputStream call() throws Exception {
          return new GetDeploymentResourceCmd(deploymentId, resourceName).execute(commandContext);
        }
      });
    }
    else {
      return null;
    }
  }

}