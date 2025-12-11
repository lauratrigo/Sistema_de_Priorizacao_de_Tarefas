# 📋 Sistema de Priorização de Tarefas (AED)

Este repositório contém o projeto final da disciplina de **Algoritmos e Estruturas de Dados (AED)** do curso de Engenharia da Computação, referente ao **Sistema de Priorização de Tarefas em Tempo Real (SPT)**.  
O sistema permite gerenciar um **backlog de tarefas** com prioridade de 1 a 10, garantindo que a lista esteja sempre **ordenada da tarefa mais crítica para a menos crítica**.

🎯 O objetivo é aplicar estruturas de dados (Pilhas, Filas e Listas) e algoritmos de ordenação (Insertion Sort) em uma aplicação prática com interface gráfica em Java.

---

## 🛠 Tecnologias Usadas

- **Java 8 ou superior**
- **Swing** para interface gráfica
- Estruturas de dados: **Listas e Filas**
- Algoritmo de ordenação: **Insertion Sort**

![Java Badge](https://img.shields.io/badge/Java-17-orange?logo=java&logoColor=white)

---

## 📂 Estrutura do Projeto

```bash
Projeto Final AED/
├── BacklogFila.java
├── Dados.java
├── Fila.java
├── JanelaSPT.java
├── Lista.java
├── Apresentação em Slides/
│ ├── Apresentação Projeto AED I.pdf
│ └── Apresentação Projeto AED I.pptx
├── images/
│ └── programa.png
└── README.md
```


---

## 🎥 Link do Vídeo

Assista à apresentação do projeto no YouTube:  
[Apresentação SPT - AED](https://youtu.be/zL71Pg2_JzI)

---

## 🖥 Interface do Programa

![Interface do SPT](images/programa.png)

---

## ⚙️ Como Executar

1. Clone o repositório:

```bash
git clone https://github.com/lauratrigo/Sistema_de_Priorizacao_de_Tarefas.git
cd Projeto_Final_AED
```

2. Abra os arquivos `.java` no seu **IDE Java preferida** (Eclipse, IntelliJ, NetBeans).

3. Compile e execute `JanelaSPT.java`. A interface gráfica será exibida e permitirá:

- Visualizar o backlog de tarefas.
- Adicionar novas tarefas com prioridade.
- O sistema organiza automaticamente o backlog usando **Insertion Sort**.

---

## 📌 Lógica do Algoritmo de Inserção

A função principal `adicionar_tarefa(backlog, nova_tarefa)` segue a lógica do **Insertion Sort**:

1. Compara a nova tarefa com os elementos existentes da direita para a esquerda.
2. Desloca elementos com prioridade menor (número maior) uma posição para a direita.
3. Insere a nova tarefa na posição correta para manter a lista ordenada.

**Exemplo:**  
Backlog atual: `[Prio 1, Prio 3, Prio 5, Prio 8]`  
Nova tarefa: `Prio 4`  
Novo backlog: `[Prio 1, Prio 3, Prio 4, Prio 5, Prio 8]`

---

## 🤝 Agradecimentos

Projeto desenvolvido para a disciplina de **AED** com orientação do **Prof. Wagner Santos**.

---

## 📜 Licença

Este repositório está licenciado sob MIT License. Consulte o arquivo LICENSE para mais informações.
