import re
from botTeste import wppbot

bot = wppbot('M.I.S.U.S')
bot.treina('treino')
bot.inicia('Tonin')
#bot.saudacao(['M.I.S.U.S: Oi, sou o M.I.S.U.S!','M.I.S.U.S: Use :: no início para falar comigo'])
ultimo_texto = ''

while True:
    nao_lida = browser.find_elements_by_class_name("OUeyt")
    name,message  = '',''
    texto = bot.escuta()

    if len(nao_lida) > 0:
        ele = nao_lida[-1]
        acao = webdriver.common.action_chains.ActionChains(browser)
        acao.move_to_element_with_offset(ele, 0, -20) # move a bit to the left from the green dot
    # Clicking couple of times because sometimes whatsapp web responds after two clicks
        try:
            action.click()
            action.perform()
            action.click()
            action.perform()
        except Exception as e:
            pass
        try:
            if texto != ultimo_texto and re.match(r'^::', texto):

                ultimo_texto = texto
                texto = texto.replace('::', '')
                texto = texto.lower()
                if (texto == 'aprender' or texto == ' aprender' or texto == 'ensinar' or texto == ' ensinar'):
                    bot.aprender(texto,'bot: Escreva a pergunta e após o ? a resposta.','bot: Obrigado por ensinar! Agora já sei!','bot: Você escreveu algo errado! Comece novamente..')
                elif (texto == 'noticias' or texto == ' noticias' or texto == 'noticia' or texto == ' noticia' or texto == 'notícias' or texto == ' notícias' or texto == 'notícia' or texto == ' notícia'):
                    bot.noticias()
                else:
                    bot.responde(texto)

                name = browser.find_element_by_class_name("_1wjpf").text  # Contact name
                message = browser.find_elements_by_class_name("vW7d1")[-1]  # the message content
                if 'activate bot' in message.text.lower():
                    if name not in bot_users:
                        bot_users[name] = True
                        text_box = browser.find_element_by_class_name("_2S1VP")
                        response = "Hi "+name+". I'm M.I.S.U.S :). Now I am activated for you\n" 
                        text_box.send_keys(response)
                    
                if 'deactivate' in message.text.lower():
                    if name in bot_users:
                        text_box = browser.find_element_by_class_name("_2S1VP")
                        response = "Bye "+name+".\n"
                        text_box.send_keys(response)
                        del bot_users[name]
        except Exception as e:
            print(e)
            pass
        sleep(1) # A 2 second pause so that the program doesn't run too fast


    



        