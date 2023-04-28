programa {

  inclua biblioteca Calendario

  funcao inicio() {

   inteiro hora_atual, hora_acordar, tempo_restante


  // Definir a hora atual
  hora_atual = Calendario.hora_atual(falso)


  // Definir a hora de acordar
  hora_acordar = 6

  // Calcular o tempo restante para acordar
  tempo_restante = hora_acordar - hora_atual

  // Verificar se já é hora de acordar
  se (tempo_restante <= 0) {
      escreva("Acordei!")
  }
  senao {
      escreva("Ainda estou dormindo. Faltam "+ tempo_restante+" horas para acordar.")
    }
  }
}
