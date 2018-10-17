
#usecase1
We must be able to override the open/close actions. By Override, I mean add additional action before/after the standart behavior, or replace it.

Currently, we are able to add additional action after a open, registring a listener (IContentChangeListener) on the IContentChangeProvider. This one uses the ContentEvent to notify the changes or (since bug 540218), the NotificationContentEvent class. 

The notification must provides the previous value, the new value, the notifier, and the type of notification (as implemented by the EMF Notification). 


#usecase2 
(not done by this plugin)
the user must be able to change the page name and the page label (internationlization)

#usecase3
the user must be able to how the Papyrus editors must be displayed: as tab in the Papyrus Editor or as self editor in Eclipse IDE.