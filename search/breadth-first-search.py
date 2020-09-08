# Descricao do problema em https://www.thehuxley.com/problem/805?quizId=5243
# Solucao por @OtacilioN

ADJ = "adjacencias"
DST = "distancia"
ANT = "anterior"

vertices, arestas, testes = map(int, input().split())
grafo = {}

for vertice in range(vertices):
    grafo[vertice] = {}
    grafo[vertice][ADJ] = []

for aresta in range(arestas):
    origem, destino = map(int, input().split())
    grafo[origem][ADJ].append(destino)

for vertice in range(vertices):
    grafo[vertice][ADJ].sort()

print("\n--------")
for teste in range(testes):
    origem, destino = map(int, input().split())
    print("\nCaso de Teste #{} - BFS({})\n".format(teste + 1, origem))

    # Reset das distancias
    for vertice in range(vertices):
        if DST in grafo[vertice]:
            del grafo[vertice][DST]
        if ANT in grafo[vertice]:
            del grafo[vertice][ANT]

    fila_visita = []
    fila_visita.append(origem)
    fila_visita.append("FIM_DE_NIVEL")
    grafo[origem][DST] = 0
    distancia = 1
    vertice_visitado = None

    while fila_visita:
        vertice_visitado = fila_visita.pop(0)
        if vertice_visitado == "FIM_DE_NIVEL":
            distancia += 1
            if(fila_visita):
                fila_visita.append("FIM_DE_NIVEL")
        else:
            print("Iniciando busca em largura a partir de {}".format(
                vertice_visitado))
            for vertice_adjacente in grafo[vertice_visitado][ADJ]:
                # Checa se ja foi visitado por ter uma distancia no dict
                if not DST in grafo[vertice_adjacente]:
                    fila_visita.append(vertice_adjacente)
                    grafo[vertice_adjacente][DST] = distancia
                    grafo[vertice_adjacente][ANT] = vertice_visitado

    print()
    for vertice in range(vertices):
        if DST in grafo[vertice]:
            distancia = grafo[vertice][DST]
        else:
            distancia = "-"

        if ANT in grafo[vertice]:
            anterior = grafo[vertice][ANT]
        else:
            anterior = "-"
        print("{} | {} | {}".format(vertice, distancia, anterior))

    if ANT in grafo[destino]:
        anterior = grafo[destino][ANT]
        caminho = [destino]
        while anterior != origem:
            caminho.insert(0, anterior)
            anterior = grafo[anterior][ANT]

        print("\nCaminho entre {} e {}: {}".format(
            origem, destino, origem), end="")

        for passo in caminho:
            print(" => {}".format(passo), end="")

    else:
        print("\nSem caminho entre {} e {}".format(origem, destino), end="")

    print("\n\n--------")
