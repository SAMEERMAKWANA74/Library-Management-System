FROM payara/server-full:latest
COPY LibraryMS.war $DEPLOY_DIR
EXPOSE 8080
