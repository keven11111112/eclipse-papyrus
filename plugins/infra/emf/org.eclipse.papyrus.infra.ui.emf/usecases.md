# Bug 565361: \[ModelExplorer\]\[Architecture Framework\] the Architecture Framework must allows to define the Customization to use in the ModelExplorer
* we must apply the Customizations defined referenced by EMFFacetTreeViewerConfiguration in the current architecture framework
     * see class ArchitectureFrameworkCustomizationManagerUpdater
* we must support erroneous definition of Customization in the architecture framework. In this case, we apply the intermediate resulting list (before meeting the error)
     * see class ArchitectureFrameworkCustomizationManagerUpdater and BadTreeViewerConfigurationException
* the user must be able to change the applied customization for its current model. So we must be able to save these preferences
     * see class ArchitectureFrameworkCustomizationManagerUpdater and WorskpaceCustomizationUpdater
* if there is no Customization defined in the architecture, we must apply the Customization defined by extension point in plugin.xml
     * see class WorskpaceCustomizationUpdater
* the user must be able to reset the applied customization for the current model (from architecture or from extension point)
     * see method org.eclipse.papyrus.infra.ui.emf.internal.facet.WorskpaceCustomizationUpdater.resetToDefaultCustomizations()
* we must be able to listen the switch of Eclipse editor (to update the applied Customization)
     * see class org.eclipse.papyrus.infra.ui.emf.internal.facet.ArchitectureFrameworkCustomizationManagerUpdater.PapyrusEditorListener
* we must be able to listen the swith of Architecture context
     * see class ArchitectureDescriptionLanguageListener
     