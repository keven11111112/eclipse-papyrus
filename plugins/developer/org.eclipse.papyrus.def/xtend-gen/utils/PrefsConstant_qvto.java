/**
 * Copyright (c) 2008 Atos Origin
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Thibault Landre (Atos Origin) - initial API and implementation
 * modified by Patrick Tessier(CEA LIST)
 */
package utils;

import com.google.inject.Singleton;

@Singleton
@SuppressWarnings("all")
public class PrefsConstant_qvto {
  public String getDiagramPreferencePageCategory() {
    return "org.eclipse.papyrus.infra.gmfdiag.preferences.diagrams";
  }
  
  public String getPreferenceConstant() {
    return "_PREF_";
  }
  
  public String getPreferenceGradientPolicyConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "GRADIENT_POLICY");
  }
  
  public String getPreferenceGradientColorConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "GRADIENT_COLOR");
  }
  
  public String getPreferenceFillColorConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "FILL_COLOR");
  }
  
  public String getPreferenceFontColorConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "FONT_COLOR");
  }
  
  public String getPreferenceFontConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "FONT");
  }
  
  public String getPreferenceLineColorConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "LINE_COLOR");
  }
  
  public String getPreferenceJumpLinkConstant() {
    String _preferenceConstant = this.getPreferenceConstant();
    return (_preferenceConstant + "JUMPLINK_");
  }
  
  public String getPreferenceJumpLinkReverseConstant(final String _element) {
    String _preferenceJumpLinkConstant = this.getPreferenceJumpLinkConstant();
    String _plus = (_element + _preferenceJumpLinkConstant);
    return (_plus + "REVERSE");
  }
  
  public String getPreferenceJumpLinkStatusConstant(final String _element) {
    String _preferenceJumpLinkConstant = this.getPreferenceJumpLinkConstant();
    String _plus = (_element + _preferenceJumpLinkConstant);
    return (_plus + "STATUS");
  }
  
  public String getPreferenceJumpLinkTypeConstant(final String _element) {
    String _preferenceJumpLinkConstant = this.getPreferenceJumpLinkConstant();
    String _plus = (_element + _preferenceJumpLinkConstant);
    return (_plus + "TYPE");
  }
  
  public String getPreferenceRoutingConstant() {
    String _preferenceConstant = this.getPreferenceConstant();
    return (_preferenceConstant + "ROUTING_");
  }
  
  public String getPreferenceRoutingDistancePolicyConstant(final String _element) {
    String _preferenceRoutingConstant = this.getPreferenceRoutingConstant();
    String _plus = (_element + _preferenceRoutingConstant);
    return (_plus + "DISTANCE_POLICY");
  }
  
  public String getPreferenceRoutingObstructionPolicyConstant(final String _element) {
    String _preferenceRoutingConstant = this.getPreferenceRoutingConstant();
    String _plus = (_element + _preferenceRoutingConstant);
    return (_plus + "OBSTRUCTION_POLICY");
  }
  
  public String getPreferenceRoutingStyleConstant(final String _element) {
    String _preferenceRoutingConstant = this.getPreferenceRoutingConstant();
    String _plus = (_element + _preferenceRoutingConstant);
    return (_plus + "STYLE");
  }
  
  public String getPreferenceSmoothnessConstant(final String _element) {
    String _preferenceConstant = this.getPreferenceConstant();
    String _plus = (_element + _preferenceConstant);
    return (_plus + "SMOOTHNESS");
  }
  
  public String getPreferencePageSuffix() {
    return "PreferencePage";
  }
}
