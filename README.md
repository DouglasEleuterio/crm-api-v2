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

### Edição de Pagamentos
Após a criação de uma aquisição, caso deseje alterar informações, qual a melhor solução para visualizar histórico de auditoria?
* Ao listar os pagamentos, exibir o id do pedido, para identificar a origem;
* Na listagem, permitir visualização do histórico do pagamento.
* 
