Requirements
===========
-- Jdk 8
-- Gradle


Download JDK
------------

Gradle
------
Step 1. Download the latest Gradle distribution [https://services.gradle.org/distributions/gradle-4.6-bin.zip?_ga=2.258256707.81490840.1521333305-1041446971.1516719000]  
Step 2. Unpack the distribution  
 
 Linux & MacOS
```shell
$ mkdir /opt/gradle
$ unzip -d /opt/gradle gradle-4.6-bin.zip
$ ls /opt/gradle/gradle-4.6
```
Windows
Create a new directory C:\Gradle with File Explorer. Open a second File Explorer window and go to the directory where the Gradle distribution was downloaded. Double-click the ZIP archive to expose the content. Drag the content folder gradle-4.6 to your newly created C:\Gradle folder.
  
Step 3. Configure your system environment  
Linux & MacOS
Configure your PATH environment variable to include the bin directory of the unzipped distribution, e.g.:
```Shell
$ export PATH=$PATH:/opt/gradle/gradle-4.6/bin
```

Microsoft Windows
In File Explorer right-click on the This PC (or Computer) icon, then click Properties -> Advanced System Settings -> Environmental Variables.

Under System Variables select Path, then click Edit. Add an entry for C:\Gradle\gradle-4.6\bin. Click OK to save.

 Step 4. Verify your installation  
 Open a console (or a Windows command prompt) and run gradle -v to run gradle and display the version, e.g.:
```Shell
$ gradle -v
```
Upgrade with the Gradle Wrapper
If your existing Gradle-based build uses the Gradle Wrapper, you can easily upgrade by running the wrapper task, specifying the desired Gradle version

```Shell
$ ./gradlew wrapper --gradle-version=4.6 --distribution-type=bin
```


How to run
==========
```shell
./gradle bootRun
```

