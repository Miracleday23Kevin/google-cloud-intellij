package com.intellij.appengine.facet;

import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.ui.FacetEditorContext;
import com.intellij.facet.ui.FacetEditorTab;
import com.intellij.facet.ui.FacetValidatorsManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jdom.Element;
import org.jetbrains.jps.appengine.model.PersistenceApi;
import org.jetbrains.jps.appengine.model.impl.AppEngineModuleExtensionProperties;

import java.util.List;

/**
 * @author nik
 */
public class AppEngineFacetConfiguration implements FacetConfiguration, PersistentStateComponent<AppEngineModuleExtensionProperties> {
  private AppEngineModuleExtensionProperties myProperties = new AppEngineModuleExtensionProperties();

  public FacetEditorTab[] createEditorTabs(FacetEditorContext editorContext, FacetValidatorsManager validatorsManager) {
    return new FacetEditorTab[] {
       new AppEngineFacetEditor(this, editorContext, validatorsManager)
    };
  }

  public void readExternal(Element element) throws InvalidDataException {
  }

  public void writeExternal(Element element) throws WriteExternalException {
  }

  public AppEngineModuleExtensionProperties getState() {
    return myProperties;
  }

  public void loadState(AppEngineModuleExtensionProperties state) {
    myProperties = state;
  }

  public String getSdkHomePath() {
    return myProperties.mySdkHomePath;
  }

  public boolean isRunEnhancerOnMake() {
    return myProperties.myRunEnhancerOnMake;
  }

  public List<String> getFilesToEnhance() {
    return myProperties.myFilesToEnhance;
  }

  public PersistenceApi getPersistenceApi() {
    return myProperties.myPersistenceApi;
  }

  public void setSdkHomePath(String sdkHomePath) {
    myProperties.mySdkHomePath = sdkHomePath;
  }

  public void setPersistenceApi(PersistenceApi persistenceApi) {
    myProperties.myPersistenceApi = persistenceApi;
  }

  public void setFilesToEnhance(List<String> filesToEnhance) {
    myProperties.myFilesToEnhance = filesToEnhance;
  }

  public void setRunEnhancerOnMake(boolean runEnhancerOnMake) {
    myProperties.myRunEnhancerOnMake = runEnhancerOnMake;
  }
}
