### Build do Docker
* Gerar imagem
````
docker login -u douglaseleuterioferreira -p Fox789789@!
````
````
docker build -t api:v2.0.0 --build-arg REVISION=1.0.0 --build-arg PROFILE=dev --build-arg PROJECT=api --build-arg AMBIENTE=dev --progress=plain .
````
````
docker tag api:v2.0.0 douglaseleuterioferreira/apps:api
````
### Enviar Dockerhub
````
docker push douglaseleuterioferreira/apps:api
````