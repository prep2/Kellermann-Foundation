# Instructions to run HMIS database 

## Programs needed ##
Latest stable version of [Tomcat](https://tomcat.apache.org/download-80.cgi)
Latest version of [MariaDB](https://mariadb.org/download/).
An IDE with Java and server capabilities, you can use [Intellij Ultimate](https://www.jetbrains.com/idea/) or [Visual Studio Code](https://code.visualstudio.com/) with [Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug) and [Tomcat](https://marketplace.visualstudio.com/items?itemName=adashen.vscode-tomcat) extentions. 
[Java Development Kit](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) is also needed but you likely already have installed on your system.

## Installing Tomcat and MariaDB ##
### Tomcat ### 
Using the .exe install method will prompt you for component selection and server configuration. 
In component selection, make sure you install the Host Manager, it makes troubleshooting much easier and can be helpful later in the install process. 
In server configuration, set your username and password. 
### MariaDB ###
Install all components.

## Setting up environment ##
In order for your system to see these Tomcat and MariaDB in your terminal, you need to add your programs to your system environment varaibles. 
