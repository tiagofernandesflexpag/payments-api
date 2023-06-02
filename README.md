
# Documentação da API de Pagamentos

Este repositório contém a API de Pagamentos Flexpag. A coleção oferece um conjunto de endpoints para interagir com vários aspectos do sistema de pagamentos.

## Uso
Para utilizar a API de Pagamentos, siga as instruções abaixo:

Clone o repositório em sua máquina local.
Importe a coleção do Postman para a sua aplicação do Postman.
Verifique se as dependências, variáveis de ambiente e o banco de dados estão configurados corretamente.
Faça requisições para os endpoints desejados.
## Endpoints
A API de Pagamentos disponibiliza os seguintes endpoints:

### Usuário:
Criar Usuário: Cria uma nova conta de usuário.
### Autenticação:
Login: Autentica um usuário e obtém um token de acesso.
### Consulta de CEP:
Consultar CEP: Obtém informações de endereço com base em um CEP fornecido.
### Cliente:
Registrar Cliente: Registra um novo cliente com informações de usuário e endereço associadas.
Obter Cliente: Obtém informações sobre um cliente específico.
### Fatura:
Criar Fatura: Cria uma nova fatura.
Obter Faturas: Obtém as faturas para um número de contrato específico.
### Pedido:
Persistir Compra: Persiste uma transação de compra.
### Transação:
Persistir Transação: Persiste uma transação.
Variáveis de Ambiente
A coleção do Postman utiliza as seguintes variáveis de ambiente:

### Observações: 

token: Um token de acesso para autenticação, você conseguirá esse token realizando login na rota de autenticação. Alguns endpoints na coleção requerem autenticação.

URL Base da API
A URL base da API de Pagamentos é http://localhost:8080/.

### Postman collection:
Uma collection do postman está disponível na raíz do projeto.
