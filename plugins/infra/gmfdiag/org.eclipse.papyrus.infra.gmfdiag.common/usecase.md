IModel is used to represent EMF Resource
IModel classes are in charge to manage the save of these resources



AbstractModelWithSharedResource
This class must be used when several elements (Diagram and Table for example) are saved in the same EMF Resource.

I suppose that the AbstractModelWithSharedResource must be defined as master and the others must be slave (see enumeration org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource.ModelKind).
This is the purpose of the patch for the bug 551057.

The method resource#save is called with the null parameter. It is not a problem, because during the loading each resource is configured with default load and save options. So if this configuration is well done, all will work fine.



