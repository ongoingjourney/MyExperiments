CURRENT_PROJECT=SpringDictionaryService
CATALINA_HOME=/d/Tomcat/tomcat
ECLIPSE_WS=/d/Eclipse/workspace

PROJECT_WS=$ECLIPSE_WS/$CURRENT_PROJECT
DEPLOYMENT_DIR=$CATALINA_HOME/webapps/$CURRENT_PROJECT/WEB-INF

$CATALINA_HOME/bin/catalina.sh stop

rm -rf $DEPLOYMENT_DIR/classes
mkdir -p $DEPLOYMENT_DIR/classes/com

cp -rf $PROJECT_WS/bin/com $DEPLOYMENT_DIR/classes
cp -r $PROJECT_WS/WEB-INF/*.xml $DEPLOYMENT_DIR 
cp -r $PROJECT_WS/bin/resources/* $DEPLOYMENT_DIR

$CATALINA_HOME/bin/catalina.sh start


