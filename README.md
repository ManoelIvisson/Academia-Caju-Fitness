# Academia-Caju-Fitness
Projeto de API Rest representando uma academia escolar fictícia.

# Diagrama de classes

```mermaid
classDiagram
  class Instrutor {
    - String nome
    - String email
    - String senha
  }
  class Aluno {
    - String nome
    - String email
    - String matricula
    - String data_cadastro
    - int idade
    - String estado
    - String turno
  }
  class Medidas {
    - float peso
    - float altura
    - float braco
    - float cintura
    - float quadril
    - float coxa
  }
  class Vagas {
    - int matutino
    - int vespertino
  }
  
  Aluno -- Medidas : possui
```
