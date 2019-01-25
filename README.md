# ngfs
Full stack samples for Angular with GraphQL, JsonAPI, SpringBoot  and other technologies


# Conventions
The README steps in the various sub projects reference certain environmental variables in the form: $VARIABLE_NAME. We recommend that you assign the variables as follows:

`# .bashrc
# GitBash example
# Adjust for your setup

#GitBash
export TOOLS_HOME=/c/DevelopmentTools
export DEV_HOME=/c/Development
# Linux
#export TOOLS_HOME=~/DevelopmentTools
#export DEV_HOME=~/Development

export NGFS=$DEV_HOME/ngfs
export GIT_HOME=$TOOLS_HOME/Git
export NODE_HOME=$TOOLS_HOME/node-v10.15.0-win-x64
export MAVEN_HOME=$TOOLS_HOME/apache-maven-3.6.0
export JAVA_HOME=$TOOLS_HOME/jdk-11.0.2
export PATH=$GIT_HOME/bin:$NODE_HOME:$MAVEN_HOME/bin:$JAVA_HOME/bin:$PATH`

#Installation Prerequisites:

- Java SDK  ^1.7
- Maven ^3.5
- Node ^10.0
- Angular ^7.0
- GitBash (Optional for Windows)
- Yarn (Optional)
- Eclipse STS (Optional)
- Postman (Optional)

# Setup

In preparation for running the code samples:

- Clone this repo
`cd $DEV_HOME
git clone https://github.com/temecom/ngfs.git
`
- Build the Java/SpringBoot projects
`cd ngfs
mvn clean install -DskipTests`
