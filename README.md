# Pedidos da Cantina

Este projeto é um sistema de pedidos para uma cantina, desenvolvido em Java.

## Classes

- `Main`: Classe principal, onde será usado as classes `Sistema` e `Entrada`.
- `Sistema`: Classe que armazena informações de todos os objetos criados no sistema.
- `Entrada`: Classe que possui os menus de interface com o usuário e que coleta os inputs.
- `Usuario`: Classe abstrata que possui informações dos usuários cadastrados no sistema.
- `Admin`: Herança de `Usuario`. Possui informações dos administradores cadastrados no sistema.
- `Aluno`: Herança de `Usuario`. Possui informações dos alunos cadastrados no sistema.
- `Produto`: Classe que possui informações dos produtos cadastrados no sistema.
- `Item`: Classe que possui informações de um item de determinado pedido.
- `Pedido`: Classe que possui informações dos pedidos cadastrados no sistema.
- `Sala`: Classe que possui informações das salas cadastradas no sistema.

## Interfaces

- `Salvavel`: Interface que define o método para salvar dados em um arquivo.

## Exceções

- `EstoqueInsuficienteException`: Exceção lançada quando o estoque de um produto é insuficiente.
- `PedidoNaoEncontradoException`: Exceção lançada quando um pedido não é encontrado.
- `PedidoVazioException`: Exceção lançada quando um pedido está vazio.
- `ProdutoNaoEncontradoException`: Exceção lançada quando um produto não é encontrado.
- `SalaNaoEncontradaException`: Exceção lançada quando uma sala não é encontrada.
- `SaldoInsuficienteException`: Exceção lançada quando o saldo de um aluno é insuficiente.
- `SaldoNegativoException`: Exceção lançada quando o valor do saldo é negativo.
- `SenhaInvalidaException`: Exceção lançada quando a senha é inválida.
- `UsuarioInexistenteException`: Exceção lançada quando um usuário não é encontrado.

## Estrutura do Projeto

- `src/`: Diretório contendo os arquivos fonte do projeto.
- `compiled/`: Diretório onde os arquivos compilados serão armazenados.
- `input.txt`: Arquivo de entrada contendo comandos para testar o sistema.
- `compile_run.bat`: Script para compilar e executar o projeto no Windows.
- `compile_run.sh`: Script para compilar e executar o projeto no Linux.

## Requisitos

- Java Development Kit (JDK) 8 ou superior.

## Compilação e Execução

### Windows

1. Abra o Prompt de Comando.
2. Navegue até o diretório raiz do projeto.
3. Execute o script `compile_run.bat`:

    ```sh
    ./compile_run.bat
    ```

4. O script irá compilar os arquivos Java e executar o programa.

### Linux

1. Abra o terminal.
2. Navegue até o diretório raiz do projeto.
3. Dê permissão de execução ao script `compile_run.sh` (se ainda não tiver feito isso):

    ```sh
    chmod +x compile_run.sh
    ```

4. Execute o script `compile_run.sh`:

    ```sh
    ./compile_run.sh
    ```

5. O script irá compilar os arquivos Java e executar o programa.

## Uso

- O sistema pode ler comandos do arquivo `input.txt`. Certifique-se de que o arquivo `input.txt` está no diretório raiz do projeto e contém os comandos necessários para testar o sistema.
- O sistema também funciona via input manual, caso não encontre o arquivo `input.txt` no diretório raiz do projeto.
- O sistema irá ler, caso exista, o arquivo `dados.txt` e cadastrar os usuários contidos neles.
- Também, ao final da execução, o sistema salvará os usuários dentro do arquivo `dados.txt` para que possam ser acessados na próxima execução.
