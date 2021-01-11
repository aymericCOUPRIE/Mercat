# Mercat

Projet SE IG4 2020/2021

## Authors
AUDIGER Florian COUPRIE Aymeric MASANTE Anna TEROITIN Marine

## Instructions to launch the project

 You need to create in the folder Resources a file named "database.properties" with:
  •url=....  
  •user=......  
  •password=......
  
  
 Please read this file closely.

## Install and run

Project can be installed and runned either from sources or from the provided pre-built image.
The pre-built image embeds a jre compatible with the project allowing you not to download a java distribution
compatible with this project on your own (image was built for windows only).

### Install and run from sources

```
git clone https://github.com/BrokenSwing/Comixaire/
cd Comixaire
```

> Note: On Windows, following commands are meant to be typed in Powershell

> Note: This project can be compiled with both java 8 et java 15. If you're using java 15, please run `git checkout java15`

Copy `database.properties` file into project resources folder :

* Windows: `Copy-Item "../config/database.properties" -Destination "src/main/resources"`
* Unix: `cp ../config/database.properties src/main/resources`

To run the project, run the command `./gradlew run`

### Install and run from provided image

> Note: This image was built on Windows

Unzip the archive `comixaire.zip` present in this directory then run the bat file `image/bin/comixaire.bat`.

## Test the software

Here are correct credentials to login as staff members:
* Username: `Florent`
* Password: `Flo`

Here are correct credentials to login as client:
* Client ID: `015a01`

## Javadoc

You can find the javadoc of the project here: [https://brokenswing.github.io/Comixaire/](https://brokenswing.github.io/Comixaire/)
