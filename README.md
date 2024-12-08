# Pedidos da Cantina

Este projeto é um sistema de pedidos para uma cantina, desenvolvido em Java.

## Classes

- `Main`: Classe principal, onde será usado as classes `Sistema` e `Entrada`.
- `Sistema`: Classe que armazena informações de todos os objetos criados no sistema.
- `Entrada`: Classe que possui os menus de interface com o usuário e que coleta os inputs.
- `Usuario`: Classe que possui informações dos usuários cadastrados no sistema.
- `Admin`: Herança de `Usuario`. Possui informações dos administradores cadastrados no sistema.
- `Aluno`: Herança de `Usuario`. Possui informações dos alunos cadastrados no sistema.
- `Produto`: Classe que possui informações dos produtos cadastrados no sistema.
- `Item`: Classe que possui informações de um item de determinado pedido.
- `Pedido`: Classe que possui informações dos pedidos cadastrados no sistema.
- `Sala`: Classe que possui informações das salas cadastradas no sistema.

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

1. O sistema pode ler comandos do arquivo `input.txt`. Certifique-se de que o arquivo `input.txt` está no diretório raiz do projeto e contém os comandos necessários para testar o sistema.
2. O sistema também funciona via input manual, caso não encontre o arquivo `input.txt` no diretório raiz do projeto.
