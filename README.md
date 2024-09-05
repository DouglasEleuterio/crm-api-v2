### Build do Docker
* Gerar imagem
````shell
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````shell
docker build -t clinica-api:v1.0.12 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````shell
docker tag clinica-api:v1.0.12 douglaseleuterioferreira/apps:clinica-api-v1.0.12
````
### Enviar Dockerhub
````shell
docker push douglaseleuterioferreira/apps:clinica-api-v1.0.12
````

### Edição de Pagamentos
Após a criação de uma aquisição, caso deseje alterar informações, qual a melhor solução para visualizar histórico de auditoria?
* Ao listar os pagamentos, exibir o id do pedido, para identificar a origem;
* Na listagem, permitir visualização do histórico do pagamento.
* 


``` shell 
docker run --user=oracle --env=ORACLE_PWD=Fox789789@!@! --env=ORACLE_CHARACTERSET=utf8 --env=ORACLE_BASE=/opt/oracle --env=ORACLE_HOME=/opt/oracle/product/21c/dbhomeXE --env=ORACLE_BASE_HOME=/opt/oracle/homes/OraDBHome21cXE --env=INSTALL_FILE_1=https://download.oracle.com/otn-pub/otn_software/db-express/oracle-database-xe-21c-1.0-1.ol7.x86_64.rpm --env=RUN_FILE=runOracle.sh --env=PWD_FILE=setPassword.sh --env=CREATE_DB_FILE=createDB.sh --env=USER_SCRIPTS_FILE=runUserScripts.sh --env=CONF_FILE=oracle-xe-21c.conf --env=CHECK_SPACE_FILE=checkSpace.sh --env=CHECK_DB_FILE=checkDBStatus.sh --env=SETUP_LINUX_FILE=setupLinuxEnv.sh --env=CONFIG_TCPS_FILE=configTcps.sh --env=INSTALL_DIR=/install --env=ORACLE_DOCKER_INSTALL=true --env=CHECKPOINT_FILE_EXTN=.created --env=PATH=/opt/oracle/product/21c/dbhomeXE/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin --env=ENABLE_ARCHIVELOG=false --env=ORACLE_SID=XE --env=ORACLE_PDB= --env=AUTO_MEM_CALCULATION=false --volume=oracle-data:/opt/oracle/oradata --workdir=/home/oracle -p 1521:1521 -p 5500:5500 --restart=no --label='io.buildah.version=1.29.0' --label='issues= https://github.com/oracle/docker-images/issues' --label='port.apex=8080' --label='port.listener=1521' --label='port.oemexpress=5500' --label='provider=Oracle' --label='volume.data=/opt/oracle/oradata' --label='volume.setup.location1=/opt/oracle/scripts/setup' --label='volume.setup.location2=/docker-entrypoint-initdb.d/setup' --label='volume.startup.location1=/opt/oracle/scripts/startup' --label='volume.startup.location2=/docker-entrypoint-initdb.d/startup' --runtime=runc -d container-registry.oracle.com/database/express:21.3.0-xe 