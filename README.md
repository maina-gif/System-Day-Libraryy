# SystemDay — Library of the Great Magician

Projeto academico feito com **Java 21** e **Spring Boot**. É um sistema web com dois módulos: um **sistema de biblioteca** (empréstimo de livros) e uma **loja on-line** (carrinho, frete e pagamento simulado). Todo o conteúdo tem tema de anime e fantasia.

## Por que um sistema de biblioteca temático?

A atividade pedia regras de negócio comuns: validar aluno, bloquear multa, limitar empréstimos, controlar estoque, calcular frete. Em vez de usar exemplos genéricos como "Livro 1" e "Aluno A", escolhi um tema, por alguns motivos:

- **Fica mais fácil de testar.** Livros com nome próprio (e o código logo abaixo, como `L003`) são fáceis de reconhecer e de lembrar na hora de testar cada cenário.
- **Dá identidade ao projeto.** Cada página tem seu personagem e sua paleta de cores, o que deixa a navegação mais clara e o resultado mais agradável de apresentar.
- **Mantém o foco nas regras.** O tema só muda a "roupa" do sistema. A lógica por trás (validações, limites, frete, persistência) é a mesma de uma biblioteca e de uma loja reais.
- **Torna o estudo mais divertido.** Trabalhar com algo de que eu gosto me motivou a caprichar nos detalhes, como mensagens, validações e visual.

## Funcionalidades

### Biblioteca
- Página inicial com o acervo de 10 livros, mostrando título, código e se está disponível.
- Empréstimo por matrícula e código do livro.
- Regras aplicadas:
  - matrícula inexistente → "Student not found.";
  - aluno com multa pendente → empréstimo bloqueado;
  - limite de **3 empréstimos** por aluno;
  - livro já emprestado → "Unavailable book.".

### Loja on-line
- Escolha de produtos, dados do cliente e pagamento com cartão **simulado** (aprovado ou recusado).
- Frete de **R$ 25**, grátis quando o subtotal é **maior que R$ 500**.
- Pedido aprovado recebe um número (`ORD-1001`, `ORD-1002`...) e fica salvo.
- Pagamento recusado não gera pedido.
- Depois da compra, a página redireciona para o pedido, então atualizar a página não duplica nada.

### Registros
- A página `/records` mostra o que está salvo no banco: empréstimos, estoque e pedidos.

## Tecnologias

- Java 21
- Spring Boot (Web MVC, Thymeleaf, Spring Data JPA)
- H2 Database (em arquivo, os dados continuam depois de reiniciar)
- HTML e CSS (variáveis de cor por tema)
- Maven

## Como executar

Pré-requisito: **JDK 21** instalado.

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux / macOS
./mvnw spring-boot:run
```

Depois, abra <http://localhost:8080>.

Também é possível rodar pela IDE, executando a classe `SystemDayApplication`.

## Dados de teste

| Matrícula | Situação |
|---|---|
| `1001` | Aluno normal |
| `1002` | Possui multa pendente |
| `1003` | Aluno normal |

Livros de `L001` a `L010`.

Na loja, o resultado do cartão é escolhido no formulário (*Approved* ou *Declined*). Nenhum cartão real é usado.

| Produto | Preço |
|---|---|
| Zeri's Magic Book | R$ 30 |
| Kazuma's Power | R$ 80 |
| Summon Goddess Aqua | R$ 150 |
| Stark's Outfit | R$ 240 |
| Frieren's Staff | R$ 300 |

## Banco de dados

Os dados ficam no arquivo `data/systemday.mv.db`, criado automaticamente na primeira execução. Para voltar ao estado inicial, pare a aplicação e apague a pasta `data/`.

## Estrutura

```
src/main/java/br/school/com/systemday/
├── Beginningcontroller.java   # rotas e validações
├── LibraryService.java        # regras da biblioteca
├── PurchaseService.java       # catálogo, frete e pedidos
├── DataInitializer.java       # alunos e livros iniciais
├── Student, Book, Loan, PurchaseOrder        # entidades
└── *Repository.java           # acesso ao banco
src/main/resources/
├── templates/                 # páginas HTML (Thymeleaf)
└── static/                    # CSS e imagens
```

## Imagens de fundo

As imagens de fundo **não estão incluídas** neste repositório, porque são artes de terceiros. Para ver o visual completo, coloque suas próprias imagens em `src/main/resources/static/images/` com estes nomes:

- `frieren-bg.jfif`
- `merlin-bg.webp`
- `madoka-bg.webp`
- `megumin-bg.webp`

Sem elas, o sistema funciona normalmente, só que com fundo escuro liso.

## Aviso

Este é um projeto academico. Todos os dados (alunos, livros, pedidos, CPF) são **fictícios**, e o pagamento é apenas uma simulação. Os personagens e nomes citados pertencem aos seus respectivos criadores e aparecem aqui apenas como tema, sem fins comerciais.

## Autor

[maina lindo] — [professor: paulo]
