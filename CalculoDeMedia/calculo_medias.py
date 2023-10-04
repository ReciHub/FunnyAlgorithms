def main():
    contador = 0
    divisor_media = 0
    nota_media = 0

    print("Diga o Nome do Aluno:")
    nome = input()

    while contador < 4:
        contador += 1
        print(f'Digite a nota {contador}:')
        nota = float(input())

        if nota >= 0:
            divisor_media += 1
            nota_media += nota

    if divisor_media > 0:
        media = nota_media / divisor_media
        print(f'A Média de {nome} é {media}.')
    else:
        print(f'O aluno {nome} não possui notas válidas.')

if __name__ == "__main__":
    main()
