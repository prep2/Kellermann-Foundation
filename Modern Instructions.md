# Instructions to run HMIS database

## Programs needed ##
Latest stable version of [Tomcat](https://tomcat.apache.org/download-80.cgi).
Latest version of [MariaDB](https://mariadb.org/download/).
An IDE with Java and server capabilities, you can use [Intellij IDEA Ultimate](https://www.jetbrains.com/idea/) or [Visual Studio Code](https://code.visualstudio.com/) with [Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug) and [Tomcat](https://marketplace.visualstudio.com/items?itemName=adashen.vscode-tomcat) extentions.
[Java Development Kit](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) is also needed but you likely already have installed on your system.

>Make sure you use the Ultimate edition as that is the only way to interact with databases in Intellij. It is [free for students](https://www.jetbrains.com/student/).

## Installing Tomcat and MariaDB ##
### Tomcat ###
Using the .exe install method will prompt you for component selection and server configuration.
In component selection, make sure you install the Host Manager, it makes troubleshooting **much** easier and can be helpful later in the install process.
In server configuration, set a username and password.
### MariaDB ###
Install all components.
It will walk you through the setup and ask you for a password. Remember it as you will need it everytime you update the database.

## Setting up environment ##
In order for your system to see these Tomcat and MariaDB in your terminal, you need to add your programs to your system environment varaibles.
First, open **System Properties**, then open **Environment Variables**. Click the **Edit** button for system variables (make sure you're not editing your user variables just above). Then hit the **New** button and add the PATH variables for your programs. You want to use the **/bin** folder inside the program folder.
![](https://i.imgur.com/vArAOqn.jpg)
>My PATH variables for MariaDB and Tomcat are marked by the yellow arrows.

You will be able to run "mysql" in your terminal after a restart of your computer. If there is an error reading "access denied for user...", then you have set up MariaDB successfully.

## Running Tomcat inside an IDE ##
We will be using Intellij IDEA Ultimate for this documentation. Using VS Code instead will be fairly straight forward provided you understand how to run Tomcat inside Intellij, and know how VS Code is structured.

Launch Intellij and open the **hospital_maternity_hmis_project** folder inside the **Kellermann-Foundation** folder. This is where Tomcat will set its starting directory when you start up the server.

>Make sure your Project SDK is **Java 1.8** inside Project Structure (located in the File tab or the grid icon in the top left of the IDE).

Next we need to add a Tomcat configuration. There is a configuration dropdown between the build and run icons in the toolbar, click it and open the **Edit Configurations** link.
Click **Add New Configuration** and select Tomcat Server. You may need to hit a "Show more" button of some kind. It will ask you if you want a local or a remote configuration, select **local**.
Intellij should auto-populate the default settings which *may* work out of the box.

In the Tomcat folder, there will be a file called server.xml, search for and open it and change the shutdown port from -1 to 82.

Try running the program using the Build & Run buttons, it should open the login page at http://localhost:8080/BHMS/

If it doesn't work, try changing the port and URL in the Edit Configurations panel and the server.xml file. For example, change http://localhost:8080/BHMS/ to http://localhost:8082/BHMS/

Make sure the HTTP and the URL match if you make any port changes.
Other issues can come up, Google may help you resolve those.

## Populating the Database ##
To populate the database, you need to run commands inside the MariaDB shell. Search for MariaDB on your computer, you should see a shell with the name **Command Prompt (MariaDB 10.4 (x64))**. Open it, and note that the shell opens to your *\Windows\system32* folder. You need to change the directory to the folder containing the database SQL scripts located in **\Kellermann-Foundation\sql**.

Use the cd function to change your directory. You can simply copy the address of your SQL folder in Windows Explorer and paste it into the MariaDB command prompt (use right click to paste).

My command was: `cd C:\Users\zarro\OneDrive\Documents\Visual Studio Code\Projects\Kellermann-Foundation\sql`
>Note that my username and location for my folder will be different than yours.

Or you can cd your way through your whole filesystem:

![](https://i.imgur.com/tr58MjZ.png)

Now you can run the log-in command:

`mysql -u root -p`

It will ask you for a password, enter the one you used to setup MariaDB.

MariaDB will load so you can run MySQL commands, we will use the source command.

The syntax is:

`source filename.fileextention`

so our commands will be:

`source bwindihospital_reduced.sql`

`source HMIS_Script.sql`

Run `bwindihospital_reduced.sql` first, `then HMIS_Script.sql`. You will need to do this anytime there are changes to the database.


## Database Authentification ##

Open the UsersDAO.java file located in **Kellermann-Foundation\hospital_maternity_hmis_project\WEB-INF\classes\dao**
The UsersDAO file is what authenticates users, you must change your credentials inside to be able to log in to the HMIS database.
Inside the file, there are multiple password fields however the default password does not match the password you set for Tomcat so use the find function and replace all instances of the default password (t00r) with the password you set for for Tomcat.

>If you don't remember your password, you can edit your **users.xml** file inside your **\Tomcat\conf** folder. Mine was located at **C:\Program Files\Apache Software Foundation\Tomcat 9.0\conf**

## Launching the Database ##

Build & Run the program and this time, you will be able to log in with the credentials:
> **Username:** emmanual
> **Password:** *tomcat password*

Congratulations, you're finished, you will never have to do this ever again! (hopefully)

## Miscellaneous ##

If you decide to use Visual Studio Code, note that you will need to use the **.war** file inside the **midVer1Build** folder to run the database using the Tomcat extention. If you do not have a **.war** file, run the database using IntelliJ, it will create it for you.

