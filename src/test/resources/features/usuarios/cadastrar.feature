# language: pt
# encoding: UTF-8


Funcionalidade: Realizar requisicoes para cadastro

  Contexto: possui a uri de usuarios
    Dado que possuo a uri da API com endpoint de usuarios

  Esquema do Cenario: Cadstrar um Usuario
    E preencho o body para a requisicao com os parametros "<nome>" "<password>" "<administrador>"
    Entao valido que o cadstro ocorreu com sucesso

    Exemplos:
      | nome     | password | administrador |
      | testando | asdfas   | false         |

  Cenario: Validacao de campos obrigatorios
    E envio uma requisicao sem nenhum parametro
    Entao valido todos os campos obrigatorios

  Cenario: Validacao de tratamento de erros dos campos
    E envio uma requisicao com parametros invalidos
    Entao valido todos os tratamentos dos campos