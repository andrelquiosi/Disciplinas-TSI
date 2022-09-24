import requests as rq

#bloco para extração de dados
link='https://servicodados.ibge.gov.br/api/v1/paises/BR%7CRU%7CIN%7CCN%7CZA/indicadores/77850'
dados = rq.get(url=link).json()[0]

taxas = []

for dados_paises in dados['series']:
        
        for dados_anos in dados_paises['serie']:

                ano, taxa = list(dados_anos.items())[0]
                if(taxa != None):
                        taxas.append({ 'pais': dados_paises['pais']['nome'], 'ano': ano, 'taxa': taxa })


taxas.sort(key=lambda x: float(x.get('taxa')), reverse=True)

print('"População - Taxa bruta de mortalidade:', *taxas[:10], sep='\n')
