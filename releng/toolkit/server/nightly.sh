# This script is made to promote nightly builds of Papyrus

########### Job parameters ###########
#The specific localization
remoteRoot="/home/data/httpd/download.eclipse.org"
papyrusRoot="modeling/mdt/papyrus"
nightlyRoot="updates/nightly"
jobName=$1
#jobName="Papyrus-Oxygen"
eclipseTarget=$2
#eclipseTarget="oxygen"

#The localization of the local build target
targetResults="archive/repository"
echo "targetResults: $targetResults"


########### Compute local build results using buildNumber ###########
cd ~/.hudson/jobs/$jobName/lastSuccessful
jobDir=$(pwd -P)

echo "last successful build: $jobDir"

localResults=${jobDir}/${targetResults}
echo "localResults: ${localResults}"


########### Promote Nightly ###########
destination=$remoteRoot/$papyrusRoot/$nightlyRoot/$eclipseTarget
echo "Destination: $destination"

#Clean the destination folder if exists, make it if does not
if [ -d $destination ];
	then
		echo "Cleaning the $destination folder"
		rm -rf ${destination}/*
	else
		mkdir -p $destination
fi

#Go to the artifact directory
cd $localResults
echo "Promoting the Nightly to $destination"

#Copy the contents onto the temp folder and change the permissions
cp -a * $destination


########### Set Access Rights ###########

# This function sets the acess rights to allow all members of the group to edit the published files
function setAccessRights() {
	chmod -R 775 "$1"
	chgrp -hR modeling.mdt.papyrus "$1"
}
echo "Set access right -R: $destination"
setAccessRights $destination


echo "publishing done."