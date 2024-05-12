### Build do Docker
* Gerar imagem
````
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````
docker build -t contabilidade:v2.0.0 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````
docker tag contabilidade:v2.0.0 douglaseleuterioferreira/apps:contabilidade
````
### Enviar Dockerhub
````
docker push douglaseleuterioferreira/apps:contabilidade
````