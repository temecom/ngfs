# ngfs
Full stack samples for Angular with GraphQL, JsonAPI, SpringBoot  and other technologies


# Conventions
The README steps in the various sub projects reference certain environmental variables in the form: $VARIABLE_NAME. We recommend that you assign the variables as follows:

```bash
# .bashrc
# GitBash/Linux example
# Adjust for your setup

# GitBash(Windows)
export TOOLS_HOME=/c/DevelopmentTools
export DEV_HOME=/c/Development
# Linux
#export TOOLS_HOME=~/DevelopmentTools
#export DEV_HOME=~/Development

# WSL 
#export TOOLS_HOME=~/DevelopmentTools
# Shared with Windows
#export DEV_HOME=/mnt/c/Development

export NGFS=$DEV_HOME/ngfs
export GIT_HOME=$TOOLS_HOME/Git
export NODE_HOME=$TOOLS_HOME/node-v10.15.0-win-x64
export MAVEN_HOME=$TOOLS_HOME/apache-maven-3.6.0
export JAVA_HOME=$TOOLS_HOME/jdk-11.0.2
export PATH=$GIT_HOME/bin:$NODE_HOME:$MAVEN_HOME/bin:$JAVA_HOME/bin:$PATH

```

# Installation Prerequisites:

- [Java SDK  ^1.7](https://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven ^3.5](https://maven.apache.org/download.cgi)
- [Node ^10.0](https://nodejs.org/en/)
- [Angular ^7.0](https://angular.io/)
- [GitBash (Optional for Windows)](https://gitforwindows.org/)
- [Yarn (Optional)](https://yarnpkg.com/en/)
- [Eclipse STS (Optional)](https://spring.io/tools)

# Setup

In preparation for running the code samples:

- Clone this repo
```
cd $DEV_HOME
git clone https://github.com/temecom/ngfs.git
```
- Build the Java/SpringBoot projects
```
cd $DEV_HOME/ngfs
mvn clean install -DskipTests
```

- See individual sub project README's for installation instructions
