/*
 * � Copyright IBM Corp. 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.ibm.xsp.extlib.designer.xspprops;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.ibm.designer.domino.ide.resources.extensions.DesignerProject;
import com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension;
import com.ibm.designer.domino.ui.commons.extensions.DesignerFileEditorInput;

/**
 * @author doconnor
 *
 */
public class XSPPropertiesMetaModel extends IDesignElementExtension {

    /**
     * 
     */
    public XSPPropertiesMetaModel() {
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getLargeIcon()
     */
    @Override
    public String getLargeIcon() {
        return "xspProp.png"; // $NON-NLS-1$
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getSmallIcon()
     */
    @Override
    public String getSmallIcon() {
        return "xspProp.png"; // $NON-NLS-1$
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewDialogTitle()
     */
    @Override
    public String getNewDialogTitle() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewDialogMessage()
     */
    @Override
    public String getNewDialogMessage() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewDialogImageName()
     */
    @Override
    public String getNewDialogImageName() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getElementNameWithAccelerator()
     */
    @Override
    public String getElementNameWithAccelerator() {
        return "Xsp Proper&ties"; // $NLX-XSPPropertiesMetaModel.XSPProperties-1$
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getTopContextNewMenuString()
     */
    @Override
    public String getTopContextNewMenuString() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewMenuStringWithAccelerator()
     */
    @Override
    public String getNewMenuStringWithAccelerator() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewActionButtonLabel()
     */
    @Override
    public String getNewActionButtonLabel() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewActionButtonTooltip()
     */
    @Override
    public String getNewActionButtonTooltip() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getNewActionButtonImage()
     */
    @Override
    public String getNewActionButtonImage() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getImageDescriptor(java.lang.String)
     */
    @Override
    public ImageDescriptor getImageDescriptor(String imageName) {
        return Activator.getImageDescriptor(imageName);
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getImage(java.lang.String)
     */
    @Override
    public Image getImage(String imageName) {
        return null;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#openDesign(com.ibm.designer.domino.ide.resources.extensions.DesignerProject)
     */
    @Override
    public boolean openDesign(DesignerProject designerProject) {
        if(designerProject != null){
            IProject project = designerProject.getProject();
            if(project != null){
                
                IFile xspDotProps = project.getFile("WebContent/WEB-INF/xsp.properties"); // $NON-NLS-1$
                if(xspDotProps != null && xspDotProps.exists()){
                    if(PlatformUI.getWorkbench() != null && PlatformUI.getWorkbench().getActiveWorkbenchWindow() != null){
                        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                        if(page != null){
                            try {
                                page.openEditor(new DesignerFileEditorInput(xspDotProps), "com.ibm.xsp.extlib.designer.xspprops.editor"); // $NON-NLS-1$
                                return true;
                            } catch (PartInitException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* (non-Javadoc)
     * @see com.ibm.designer.domino.ide.resources.metamodel.IDesignElementExtension#getSupportedPerspectives()
     */
    @Override
    public String[] getSupportedPerspectives() {
        return new String[] {DD_PERSPECTIVE, XPAGES_PERSPECTIVE};
    }
}