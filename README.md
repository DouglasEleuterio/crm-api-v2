### Build do Docker
* Gerar imagem
````shell
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````shell
docker build -t contabilidade-api:v2.0.0 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````shell
docker tag contabilidade-api:v2.0.0 douglaseleuterioferreira/apps:contabilidade-api
````
### Enviar Dockerhub
````shell
docker push douglaseleuterioferreira/apps:contabilidade-api
````