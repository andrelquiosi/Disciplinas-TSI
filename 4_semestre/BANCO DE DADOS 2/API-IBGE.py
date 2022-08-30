from ast import For
import requests as rq
import os

#método para gerar arquivo json
def geraArquivoJson(dados):
    try:
        os.remove("dadosibge.json")
    except:
        print()


    # for i in dados['series']:
    #     print(i)

    f=open('dadosibge.json', 'w')
    f.write(dados.decode('utf-8'))
    f.close()

#bloco para extração de dados
link='https://servicodados.ibge.gov.br/api/v1/paises/BR%7CRU%7CIN%7CCN%7CZA/indicadores/77850'
dados = rq.get(url=link)
geraArquivoJson(dados.content)


