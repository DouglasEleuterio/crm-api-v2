### Build do Docker
* Gerar imagem
````shell
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````shell
docker build -t clinica-api:v1.0.15 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````shell
docker tag clinica-api:v1.0.15 douglaseleuterioferreira/apps:clinica-api-v1.0.15
````
### Enviar Dockerhub
````shell
docker push douglaseleuterioferreira/apps:clinica-api-v1.0.15
````

### Edição de Pagamentos
Após a criação de uma aquisição, caso deseje alterar informações, qual a melhor solução para visualizar histórico de auditoria?
* Ao listar os pagamentos, exibir o id do pedido, para identificar a origem;
* Na listagem, permitir visualização do histórico do pagamento.
* 


``` shell 
docker run --user=oracle --env=ORACLE_PWD=Fox789789@!@! --env=ORACLE_CHARACTERSET=utf8 --env=ORACLE_BASE=/opt/oracle --env=ORACLE_HOME=/opt/oracle/product/21c/dbhomeXE --env=ORACLE_BASE_HOME=/opt/oracle/homes/OraDBHome21cXE --env=INSTALL_FILE_1=https://download.oracle.com/otn-pub/otn_software/db-express/oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm --env=RUN_FILE=runOracle.sh --env=PWD_FILE=setPassword.sh --env=CREATE_DB_FILE=createDB.sh --env=USER_SCRIPTS_FILE=runUserScripts.sh --env=CONF_FILE=oracle-xe-21c.conf --env=CHECK_SPACE_FILE=checkSpace.sh --env=CHECK_DB_FILE=checkDBStatus.sh --env=SETUP_LINUX_FILE=setupLinuxEnv.sh --env=CONFIG_TCPS_FILE=configTcps.sh --env=INSTALL_DIR=/install --env=ORACLE_DOCKER_INSTALL=true --env=CHECKPOINT_FILE_EXTN=.created --env=PATH=/opt/oracle/product/21c/dbhomeXE/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --env=ENABLE_ARCHIVELOG=false --env=ORACLE_SID=XE --env=ORACLE_PDB= --env=AUTO_MEM_CALCULATION=false --volume=oracle-data:/opt/oracle/oradata --workdir=/home/oracle -p 1521:1521 -p 5500:5500 --restart=no --label='io.buildah.version=1.29.0' --label='issues= https://github.com/oracle/docker-images/issues' --label='port.apex=8080' --label='port.listener=1521' --label='port.oemexpress=5500' --label='provider=Oracle' --label='volume.data=/opt/oracle/oradata' --label='volume.setup.location1=/opt/oracle/scripts/setup' --label='volume.setup.location2=/docker-entrypoint-initdb.d/setup' --label='volume.startup.location1=/opt/oracle/scripts/startup' --label='volume.startup.location2=/docker-entrypoint-initdb.d/startup' --runtime=runc -d container-registry.oracle.com/database/express:21.3.0-xe 
```

## Referencia (https://www.thomasvitale.com/https-spring-boot-ssl-certificate/)

##Gerar certificado
``` shell
keytool -genkeypair -alias clinicaapi -keyalg RSA -keysize 4096 -storetype PKCS12 -keystore springboot.p12 -validity 3650 -storepass Skia@#Nn89s
````

keytool -genkeypair -alias clinicaapi -keyalg RSA -keysize 4096 -storetype JKS -keystore clinicaapi.jks -validity 3650 -storepass Skia@#Nn89s

### Verify the keystore content

To check the content of the keystore following the JKS format, we can use keytool again:

``` shell
keytool -list -v -keystore clinicaapi.jks
````
Password: Skia@#Nn89s

### Convert a JKS keystore into PKCS12

Should we have already a JKS keystore, we have the option to migrate it to PKCS12; keytool has a convenient command for that:

keytool -importkeystore -srckeystore clinicaapi.jks -destkeystore clinicaapi.p12 -deststoretype pkcs12
Password: Skia@#Nn89s

Enter destination keystore password: Skia@#Nn89s
Re-enter new password: Skia@#Nn89s

Enter source keystore password: Skia@#Nn89s

Enter key password for <clinicaapi>: Skia@#Nn89s

Import command completed:  1 entries successfully imported, 0 entries failed or cancelled


4. Distribute the SSL certificate to clients

When using a self-signed SSL certificate, our browser won't trust our application and will warn the user that it's not secure. And that'll be the same with any other client.

It's possible to make a client trust our application by providing it with our certificate.
Extract an SSL certificate from a keystore

We have stored our certificate inside a keystore, so we need to extract it. Again, keytool supports us very well:
keytool -export -keystore clinicaapi.p12 -alias clinicaapi -file clinicaapi.crt

Enter keystore password: Skia@#Nn89s

Será exportado para o path do terminal o arquivo clinicaapi.crt


### Importar certificado .crt para cacerts
### Para importação no container, foi realizado na construção da imagem, no arquivo Dockerfile.
keytool -importcert -file clinicaapi.crt -alias clinicaapi -keystore "C:\Program Files\Java\jdk-17\lib\security\cacerts"
