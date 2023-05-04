# Como executar a aplicação NotaApp

A aplicação NotaApp é uma ferramenta simples para criar, pesquisar, deletar e alterar notas em um arquivo de texto. 

Para executar a aplicação, siga as instruções abaixo:

## Pré-requisitos

- Java Development Kit (JDK) 17 ou superior
- Arquivo JAR da aplicação NotaApp

## Instruções

1. Abra o terminal ou prompt de comando no diretório onde está o arquivo JAR da aplicação NotaApp.

2. Para criar uma nova nota, execute o seguinte comando:

   ```
   java -jar NotaApp.jar --criar <nome da nota> <conteúdo>
   ```

   Ou usando a opção abreviada:

   ```
   java -jar NotaApp.jar -c <nome da nota> <conteúdo>
   ```

   Por exemplo:

   ```
   java -jar NotaApp.jar --criar nota1 "Esta é a minha primeira nota"
   ```

   Isso criará uma nova nota com o nome "nota1" e o conteúdo "Esta é a minha primeira nota".

3. Para pesquisar uma nota existente, execute o seguinte comando:

   ```
   java -jar NotaApp.jar --pesquisar <nome da nota>
   ```

   Ou usando a opção abreviada:

   ```
   java -jar NotaApp.jar -p <nome da nota>
   ```

   Por exemplo:

   ```
   java -jar NotaApp.jar --pesquisar nota1
   ```

   Isso exibirá o conteúdo da nota com o nome "nota1", se ela existir.

4. Para deletar uma nota existente, execute o seguinte comando:

   ```
   java -jar NotaApp.jar --deletar <nome da nota>
   ```

   Ou usando a opção abreviada:

   ```
   java -jar NotaApp.jar -d <nome da nota>
   ```

   Por exemplo:

   ```
   java -jar NotaApp.jar --deletar nota1
   ```

   Isso deletará a nota com o nome "nota1", se ela existir.

5. Para alterar o conteúdo de uma nota existente, execute o seguinte comando:

   ```
   java -jar NotaApp.jar --alterar <nome da nota> <novo conteúdo>
   ```

   Ou usando a opção abreviada:

   ```
   java -jar NotaApp.jar -a <nome da nota> <novo conteúdo>
   ```

   Por exemplo:

   ```
   java -jar NotaApp.jar --alterar nota1 "Este é o novo conteúdo da nota1"
   ```

   Isso atualizará o conteúdo da nota com o nome "nota1", se ela existir.

## Observações

- O arquivo de notas será criado na pasta raiz do projeto se ainda não existir.
- Os conteúdos das notas são gravados em formato Base64 no arquivo de notas. Ao pesquisar uma nota, o conteúdo será decodificado automaticamente para exibição.
- O nome da nota não pode conter espaços em branco ou caracteres especiais.
