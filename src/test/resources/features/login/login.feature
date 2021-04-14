# language: pt
# encoding: UTF-8

Funcionalidade: Requisicoes Post para Login

  Contexto: Possuir a uri da requisicao
    Dado que possuo a uri da API

  Esquema do Cenario: Autenticar Usuario
    E envio a requisicao com "<email>" e "<senha>"
    Entao valido que o usuario existe

    Exemplos:
      | email         | senha |
      | fulano@qa.com | teste |

  Esquema do Cenario: Validar email incorreto
    E envio a requisicao com "<email>" e "<senha>"
    Entao valido que o email esta incorreto

    Exemplos:
      | email          | senha |
      | nadaver@qa.com | teste |

  Esquema do Cenario: Validar a senha incorreta
    E envio a requisicao com "<email>" e "<senha>"
    Entao valido que a senha esta incorreta

    Exemplos:
      | email         | senha  |
      | fulano@qa.com | 112233 |