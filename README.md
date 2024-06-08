### Build do Docker
* Gerar imagem
````shell
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````shell
docker build -t clinica-api:v1.0.0 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````shell
docker tag clinica-api:v1.0.0 douglaseleuterioferreira/apps:clinica-api
````
### Enviar Dockerhub
````shell
docker push douglaseleuterioferreira/apps:clinica-api
````