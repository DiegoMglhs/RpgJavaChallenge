# Desafio Capacitação em Java
## API Rest usando Java SpringBoot com banco de dados H2

------------
##### Estrutura criada ao estilo Advanced Dangeous & Dragons (AD&D)
###### Como todo bom RPG (Role Playing Game), será duelado em turnos.


<h3 style="text-align: center;"> Informações sobre o jogo:</h3>

------------

* **Você deverá escolhe o seu nome e personagem favorito (herói ou monstro).**
* **O seu oponente sempre será um monstro, você pode escolher ou deixar aleatório.**
* **As classes são pre-definidas assim como seus atributos.**
* **Você é livre para editar seu personagem, mas as classes são equilibradas para promover mais emoção.**

<h3 style="text-align: center;"> Fluxo do Jogo: </h3>

------------

* **Ao iniciar deverá criar seu personagem**
* **Antes de começar qualquer combate um monstro deve ser localizado, seja aleatoriamente ou em uma caçada específica**
* **O combate se inicia com uma rodada de iniciativa, onde é rolado 1 dado d20(20 lados) pelo jogador e um pelo Monstro oponente**
* **O vencedor da iniciativa começará a rodada atacando e o perdedor defendendo**

<h3 style="text-align: center;"> Informações sobre o turno:</h3>

------------

* **Todo turno se inicia com um ataque.**
* **O valor do Ataque será calculado por 1d12(um dado de 12 lados) somado com a força e agilidade do atacante**
* **O valor da Defesa será calculada por 1d12 somado com a defesa e agilidade do defensor**
  <h5> O Dano:</h5>

* **O dano é causado se o valor do Ataque for maior que o valor da Defesa**
* **Se mesmo com o valor do Ataque sendo inferior ou igual da Defesa você tentar infligir dano naquele turno ele não será computado calculado nem computado**
* **Após o calculo do dano será verificado se o defensor possui condições de continuar a luta ou seja Seus pontos de vida são maiores que 0.**
* **Caso o defensor não tenha mais condições de lutar o combate é finalizado.**
* **Caso o defensor ainda tenha condições de lutar, o turno é finalizado e um novo turno se inicia com o defensor agora atacando**
* **Os turnos continuam sequencialmente e alternadamente até um dos lutadores ser finalizado (Vida = 0)**

<h3 style="text-align: center;"> Tutorial para jogar:</h3>

------------

* **Sempre que você jogar uma iniciativa o ID dela será usada para o fluxo do turno.**
* **Caso se esqueça qual foi a sua você pode procurar utilizando *pesquisar iniciativas***
* **O historico completo de cada luta pode ser acessado utilizado o IdIniciativa**
* **O ataque tambem precisa do IdIniciativa assim como o Identificador de quem está atacando M (monstro) ou P (Personagem)**
* **Obs.: Mesmo que tenha escolhido uma classe monstro seu personagem nuncá será identificado como monstro**
* **A defesa precisa do IdTurno que é conseguido após um ataque assim como Identificador de quem está defendendo M (monstro) ou P (Personagem)**
* **Para o calculo do Dano precisa-se tambem do IdTurno assim como o identificador de quem está atacando M (monstro) ou P (Personagem)**

<h5> Turno Automatico:</h5>

* **Turno automatico foi desenvolvido como uma função mais rapida**
* **Para o Turno Automatico é necessário passar o IdIniciativa assim como o Identificador de quem está atacando M (monstro) ou P (Personagem).**
* **Todo o turno é calculado de uma vez só, ataque, defesa e dano.**
* **Pode-se iniciar uma luta com turno "normal" e posteriormente optar pelo turno Automatico, porem o turno Automatico é um evento fechado ele inicia e termina um turno por completo!**

------------

* **Bom Jogo!**
* **Ass. Diego Magalhães**
