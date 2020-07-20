# Bug 565361: \[ModelExplorer\]\[Architecture Framework\] the Architecture Framework must allows to define the Customization to use in the ModelExplorer
* we must be able to reference the EMFFacet customization to apply for an ArchitectureDescriptionLanguage
     * see classes EMFFacetTreeViewerConfiguration and CustomizationReference
     * see the Ecore metamodel CustomizationConfiguration attached to this plugin + the generated code
* we must be able to define an order of usage of defined EMFFacetTreeViewerConfiguration
     * see field EMFFacetTreeViewerConfiguration#extends
* we must be able to define the order of application or ReferencedCustomization
     * we must be able to define them with an absolute order (see AbsoluteOrder)
     * we must be able to define them with a relative order (before/after) another one (see RelativeOrder)
     * we must be able to define a redefinition of a Customization (see Redefinition)
* we need to be able to validate the defined CustomizationReference 
     * see CustomCustomizationConfigurationValidator and its super class CustomizationConfigurationValidator
     * see the registering of this validator in the Activator
* as we already are able to merge ArchitectureDescriptionLanguage defined on many files, we must be able to merge a set of EMFFacetTreeViewerConfiguration
     * the class CustomizationReferenceMerger is in charge of this merge
     * the class CustomizationMergeErrorCode provides the error codes for this merge
* the merge process must stops when it find an error and must be able to return the last valid list of merged customization (intermediate result).
     * see class CustomizationReferenceMerger
* the merger must be able to provide the list of errors found during the merge process
* quick description of merge process