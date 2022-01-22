def call(credId,tomcatIp,tomcatUser){
  sshagent([credId]) {
    // copy war file to tomcat server
    sh """
        sudo scp -o StrictHostKeyChecking=no target/myweb*.war ${tomcatUser}@${tomcatIp}:/opt/tomcat8/webapps/myweb.war
        sudo ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/shutdown.sh
        sudo ssh ${tomcatUser}@${tomcatIp} /opt/tomcat8/bin/startup.sh
    """
  }
}
