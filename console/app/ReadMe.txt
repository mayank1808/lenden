Deployment Instructions:

---------- Set-up Commands ---------------

1. Install Node JS (v5.7.1) and Npm (3.6.0)

	#Get node package
	curl -sL https://deb.nodesource.com/setup_5.x | sudo -E bash -

	# Then install with:
	sudo apt-get install -y nodejs

2. Install Gulp (3.9.1)

	sudo npm install -g gulp

3. Go to admin console app folder and install remaining dependencies using
	
	cd /sd_eco_alerts/console/app
	npm install

4. Run gulp, this will clean maven project and compile app source code
	
	cd /sd_eco_alerts/console/app
	--Execute anyone of the below Development Commands (either 1 or 2)

5. Generate war using mvn command at admin console folder
	cd /sd_eco_alerts/console
	mvn clean install
	
NOTE: The war will be generated in /sd_eco_alerts/console/target as ROOT.war


---------- Development Commands ---------------

1. To get compiled code use
	# all compiled code can be found in target folder
	# it can be deployed in any file server or as static content in apache tomcat
	gulp --buildEnv={{dev / ite / stg / prod}}


2. To constantly keep compiling code during development you can use
	gulp dev --buildEnv={{dev / ite / stg / prod}}

	NOTE: To constantly compile and build code, you need to have apache-http-server installed.
	NOTE: Mention the document root folder path of apache-http-server in server-details.json


3. To generate zip for compiled code
	# all compiled and zip code can be found in build folder
	# it can be deployed after extraction in any file server or as static content in apache tomcat
	gulp build-zip --buildversion={{build minor version}}

	NOTE: Major version and build name is controller by build-details.json file

