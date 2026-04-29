Projeto Minas Aquáticas
======================

Descrição
---------
Este projeto simula o monitoramento de minas aquáticas usando leituras de sensores (profundidade e proximidade). O sistema gera leituras por mina, imprime relatórios, ordena leituras por critério (profundidade ou proximidade) e detecta objetos em trânsito entre minas com base em leituras simultâneas.

Complexidade (notação Big O)
----------------------------
Observação importante: seja N = número de minas e M = número de leituras por mina.

- `SensoriamentoImpl.obterDados(quantidade)` — Complexidade: O(M)
	- Justificativa: percorre um loop de 0..quantidade-1 gerando e adicionando cada leitura a uma lista; cada iteração faz operações O(1).
	- Consequências: tempo e memória crescem linearmente com `quantidade`. Para valores muito grandes, a geração e retenção das leituras pode consumir muita memória e tempo de CPU; prefira streaming ou geração sob demanda.

- `OperacoesImpl.imprimirMonitorado(List<Mina>)` — Complexidade: O(N)
	- Justificativa: imprime cada mina com um único laço sobre a lista de minas.
	- Consequências: custo proporcional ao número de minas; para N muito grande, saída de console/IO será o gargalo (latência e volume de logs).

- `OperacoesImpl.imprimir(Map<Mina, List<Leitura>>)` — Complexidade: O(N * M)
	- Justificativa: para cada mina (N) itera sobre suas M leituras para imprimir cada uma.
	- Consequências: tempo e saída de IO aumentam linearmente com N*M; imprimir todos os dados em grandes volumes pode ser inviável — considerar amostragem, paginação ou escrever em arquivos ao invés de console.

- `OrdenadorImpl.ordenar()` (HeapSort) — Complexidade: O(M log M) por lista
	- Justificativa: a implementação constrói um heap (fase O(M)) e depois extrai elementos com operações de heapify (M extrações × O(log M) cada), resultando em O(M log M) no pior caso. O método `heapify` tem custo O(log M) por chamada.
	- Consequências: ordenar grandes listas de leituras por mina pode consumir tempo considerável; para muitas minas, o custo total é O(N * M log M). Se M é grande, considerar algoritmos adaptativos, ordenação parcial (k-melhores), ou manter dados incrementalmente ordenados.

- `OperacoesImpl.ordenar(Map<...>)` — Complexidade: O(N * M log M)
	- Justificativa: iterar sobre N minas e ordenar cada lista de tamanho M.
	- Consequências: escalonamento custoso quando tanto N quanto M crescem; uso de paralelismo (ordenar listas em threads separadas) pode ajudar, desde que haja CPU e memória disponíveis.

- `OperacoesImpl.detectarObjetoEmTransito(Map<...>, limite)` — Complexidade: O(N^2 * M)
	- Justificativa: compara cada par de minas (O(N^2) pares) e para cada par percorre até M leituras sincronizadas (ou seja, compara leituras por índice em um loop de tamanho m ≤ M).
	- Consequências: comportamento quadrático em N torna este método rapidamente impraticável quando o número de minas cresce (por exemplo, 1000 minas → ~500k pares). Para grandes N, a detecção deve ser reestruturada (ex.: indexação temporal/spacial, janelas deslizantes, hashing por intervalo de tempo, estruturas de espaço de busca como R-tree, técnicas de aproximação ou processamento distribuído).

- Operações de acesso/compare (getters, `Mina.compareTo`) — Complexidade: O(1)
	- Justificativa: operações simples de acesso ou comparação entre inteiros.

Complexidade de espaço
----------------------
- Estrutura `Map<Mina, List<Leitura>>`: O(N * M) memória para reter todas as leituras em memória.
	- Consequências: manter todos os dados em memória não escala para entradas muito grandes; usar armazenamento em disco, bases de dados, ou processamento por stream pode ser necessário.

Recomendações práticas para grandes entradas
-----------------------------------------
- Reduzir M quando possível (amostragem ou agregação dos dados).
- Processar leituras em streaming em vez de armazenar tudo em memória.
- Paralelizar ordenações por mina quando houver núcleos de CPU disponíveis.
- Reestruturar a detecção de objetos para evitar comparações O(N^2): usar indexação temporal, estruturas espaciais, janelas deslizantes ou algoritmos aproximados.
- Evitar impressão massiva no console; preferir logs com nível apropriado, arquivos ou visualização paginada.

Conclusão
---------
O projeto contém operações com complexidades que variam de O(1) a O(N^2 * M). Para entradas pequenas a moderadas, o comportamento é previsível; para conjuntos grandes (muitas minas ou muitas leituras por mina), é necessário adotar técnicas de streaming, amostragem, paralelismo e algoritmos/estruturas de dados mais adequados para manter desempenho e evitar esgotamento de recursos.

